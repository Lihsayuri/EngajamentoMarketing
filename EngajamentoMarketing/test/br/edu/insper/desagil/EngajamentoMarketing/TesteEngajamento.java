package br.edu.insper.desagil.EngajamentoMarketing;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class TesteEngajamento {
	private Usuario usuario;
	private Produto produto;

	@BeforeEach 
	public void setUp() {
		produto = new Produto("sanduiche",10);
	}
	
	@Test
	public void DuasAvaliacoesInvalida() {
		usuario = new Usuario("Joao");
		Video video = new Video(0, usuario, produto);
		usuario.postaVideo(0, produto);
		video.adicionaAvaliacao(usuario, -2);
		video.adicionaAvaliacao(usuario, 6);
		video.mediaAvaliacoes();
		assertEquals(0, usuario.totalAvaliacoes());
	}
	
	@Test
	public void UmaAvaliacaoValida() {
		usuario = new Usuario("Joao");
		Usuario usuario2 = new Usuario("Joana");
		Video video = new Video(0, usuario, produto);
		usuario2.postaVideo(0, produto);
		video.adicionaAvaliacao(usuario, 3);
		video.mediaAvaliacoes();
		assertEquals(3, usuario.totalAvaliacoes());
	}
	
	@Test
	public void TresAvaliacoesValidas() {
		usuario = new Usuario("Joao");
		Usuario usuario2 = new Usuario("Joana");
		Video video = new Video(0, usuario, produto);
		usuario2.postaVideo(0, produto);
		video.adicionaAvaliacao(usuario, 3);
		video.adicionaAvaliacao(usuario, 4);
		video.adicionaAvaliacao(usuario, 5);
		video.mediaAvaliacoes();
		assertEquals(4, usuario.totalAvaliacoes());
	}
	
	@Test
	public void AvaliacoesDoisVideos() {
		usuario = new Usuario("Joao");
		Usuario usuario2 = new Usuario("Joana");
		Video video1 = new Video(0, usuario, produto);
		usuario2.postaVideo(0, produto);
		video1.adicionaAvaliacao(usuario, 3);
		video1.adicionaAvaliacao(usuario, 4);
		video1.mediaAvaliacoes();
		
		Video video2 = new Video(1, usuario, produto);
		video2.adicionaAvaliacao(usuario, 5);
		video2.mediaAvaliacoes();
		
		assertEquals(8.5, usuario.totalAvaliacoes());
	}

}


