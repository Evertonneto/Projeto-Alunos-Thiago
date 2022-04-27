package br.edu.unipe.domain;

import java.util.LinkedList;

import br.edu.unipe.models.Aluno;
import br.edu.unipe.models.Disciplina;
import br.edu.unipe.models.Ponteiro;

public class ListaEncadeada {
	
	public Ponteiro primeiro;
	Ponteiro ultimo;
	private Ponteiro posiscaoAtual;
	
	
	public void createList() {
		primeiro = null;
	}
	
	public void add(Disciplina disciplina) {
		Ponteiro novo = new Ponteiro();
		novo.setDisciplina(disciplina);
		novo.proximo  = primeiro;
		primeiro = novo;
	}
	
	public Disciplina searchDisciplina(ListaEncadeada listaEncadeada, String nomeDaDisciplina) {
		
		Disciplina disciplinaEncontrada = null;
		for (Ponteiro n = listaEncadeada.primeiro; n != null; n = n.getProximo()) {
				
				if(nomeDaDisciplina == n.getDisciplina().getNomeDaDisciplina()) {
					disciplinaEncontrada = n.getDisciplina();
				}
		}
		
		return disciplinaEncontrada;
	}

	public boolean checkEmptyListDisciplinas(ListaEncadeada listaEncadeada) {
		return listaEncadeada.primeiro == null;
	}

}
