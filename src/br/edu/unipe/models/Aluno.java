package br.edu.unipe.models;

import java.util.LinkedList;

public class Aluno {
	
	private String nome;
	private int RGM;
	private LinkedList<Disciplina> disciplinas;
	
	public Aluno(String nome, int rGM, LinkedList<Disciplina> disciplinas) {
		super();
		this.nome = nome;
		RGM = rGM;
		this.disciplinas = disciplinas;
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

	public LinkedList<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(LinkedList<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	
}
