package br.edu.insper.desagil.EngajamentoMarketing;

import java.util.ArrayList;
import java.util.List;
import java.lang.Math;

public class Usuario {
	private String nome;
	private List<Video> videos;
	
	
	public Usuario(String nome) {
		this.nome = nome;
		this.videos = new ArrayList<>();
	}
	
	public String getNome() {
		return nome;
	}

	public Video postaVideo(int id, Produto produto) {
		Video novoVideo = new Video(id,this,produto);
		this.videos.add(novoVideo);
		return novoVideo;

	}
	
	public double totalAvaliacoes(){
		double soma = 0;
		for (Video video: this.videos) {
			soma+=video.mediaAvaliacoes();
		}
		return Math.round(soma);
	}
}
