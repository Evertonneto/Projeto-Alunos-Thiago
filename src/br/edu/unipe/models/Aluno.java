package br.edu.unipe.models;

import br.edu.unipe.domain.ListaEncadeada;

public class Aluno {
	
	private String nome;
	private int RGM;
	private ListaEncadeada listaDeDisciplinas;
	
	
	
	public Aluno() {
		super();
	}


	public Aluno(String nome, int rGM, ListaEncadeada listaDeDisciplinas) {
		super();
		this.nome = nome;
		RGM = rGM;
		this.listaDeDisciplinas = listaDeDisciplinas;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public int getRGM() {
		return RGM;
	}


	public void setRGM(int rGM) {
		RGM = rGM;
	}


	public ListaEncadeada getListaDeDisciplinas() {
		return listaDeDisciplinas;
	}


	public void setListaDeDisciplinas(ListaEncadeada listaDeDisciplinas) {
		this.listaDeDisciplinas = listaDeDisciplinas;
	}
	
	
	
	
}
