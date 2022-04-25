package br.edu.unipe.models;

public class Node {
	
	public Node proximo;
	private Disciplina disciplina;

	
	public Node getProximo() {
		return proximo;
	}
	public void setProximo(Node proximo) {
		this.proximo = proximo;
	}
	public Disciplina getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	
	
	
}
