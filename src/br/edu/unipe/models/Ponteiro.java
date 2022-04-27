package br.edu.unipe.models;

public class Ponteiro {
	
	public Ponteiro proximo;
	private Disciplina disciplina;

	
	public Ponteiro getProximo() {
		return proximo;
	}
	public void setProximo(Ponteiro proximo) {
		this.proximo = proximo;
	}
	public Disciplina getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	
	
	
}
