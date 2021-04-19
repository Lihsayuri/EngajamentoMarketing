package br.edu.insper.desagil.EngajamentoMarketing;

import java.util.HashMap;
import java.util.Map;

public class Video {
	private int id;
	private Usuario usuario;
	private Produto produto;
	private Map<Usuario, Integer> avaliacoes;
	
	
	public Video(int id, Usuario usuario, Produto produto) {
		this.id = id;
		this.usuario = usuario;
		this.produto = produto;
		this.avaliacoes = new HashMap<>();
	}

	public int getId() {
		return id;
	}

	public Produto getProduto() {
		return produto;
	}
	
	public void adicionaAvaliacao(Usuario usuario, int i) {
		if (!usuario.getNome().equals(this.usuario.getNome()) && (i <= 5 && i >=1)){
			this.avaliacoes.put(usuario, i);
		}
	}
	
	public double mediaAvaliacoes() {
		double soma = 0;
		double media;
		for (int avaliacao : this.avaliacoes.values()) {
			soma+= avaliacao;
		} media = soma/this.avaliacoes.size();
		return Math.round(media);
	}

}
