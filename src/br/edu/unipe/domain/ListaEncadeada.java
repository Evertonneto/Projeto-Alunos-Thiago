package br.edu.unipe.domain;

import java.util.LinkedList;

import br.edu.unipe.models.Aluno;
import br.edu.unipe.models.Disciplina;
import br.edu.unipe.models.Node;

public class ListaEncadeada {
	
	public Node primeiro;
	Node ultimo;
	private Node posiscaoAtual;
	
	
	public void createList() {
		primeiro = null;
	}
	
	public void add(Disciplina disciplina) {
		Node novo = new Node();
		novo.setDisciplina(disciplina);
		novo.proximo  = primeiro;
		primeiro = novo;
	}
	
	public Disciplina searchDisciplina(ListaEncadeada listaEncadeada, String nomeDaDisciplina) {
		
		Disciplina disciplinaEncontrada = null;
		for (Node n = listaEncadeada.primeiro; n != null; n = n.getProximo()) {
				
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
