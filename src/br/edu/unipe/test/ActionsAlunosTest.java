package br.edu.unipe.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.edu.unipe.domain.ActionsAlunos;
import br.edu.unipe.domain.ListaEncadeada;
import br.edu.unipe.models.Aluno;
import br.edu.unipe.models.Disciplina;

class ActionsAlunosTest{
	
	private ActionsAlunos actionsAlunos;
	private Disciplina disciplina;
	private Aluno aluno;
	private ListaEncadeada listaDisciplinas;
	
	private Aluno[] alunos;
	
	
	@BeforeEach
	void setUp() {
		
		actionsAlunos = new ActionsAlunos();
		disciplina = new Disciplina("ED",80);
		listaDisciplinas = new ListaEncadeada();
		
		listaDisciplinas.createList();
		listaDisciplinas.add(disciplina);
		aluno = new Aluno("Matheus",2134, listaDisciplinas);
		
		
		alunos = new Aluno[3];
		
		alunos = actionsAlunos.insertAlunoInList(alunos, aluno,0);
		
		//alunos.add(aluno);
	}
	
	@Test
	@DisplayName("Alunos: verificando se a lista é vazia")
	void verificarSeListaVazia() {
		
		
		Aluno[] alunos = new Aluno[3];
		
		boolean isListNotEmpty  = actionsAlunos.checkEmptyListAlunos(alunos);
	
		assertEquals(false, isListNotEmpty);
	}
	
	@Test
	@DisplayName("Alunos: inserindo 3 alunos")
	void inserindo3Alunos() {
		
		Aluno mockAluno1,mockAluno2,mockAluno3;
		
		mockAluno1 = new Aluno("Matheus",2143,listaDisciplinas);
		mockAluno2 = new Aluno("Danilo",2154,listaDisciplinas);
		mockAluno3 = new Aluno("Josemilson",2167,listaDisciplinas);
		
		Aluno mockListAlunos[] = actionsAlunos.insertAlunoInList(alunos, aluno, 0);
	
		boolean result = actionsAlunos.checkEmptyListAlunos(alunos);
		
		assertEquals(true,result);
	}

	
	@Test
	@DisplayName("Aluno: Buscando um aluno pelo RGM")
	void searchAluno() {
		
	
		Aluno alunoEncontrado = actionsAlunos.searchStudent(2134, alunos);
		
		assertEquals(2134, alunoEncontrado.getRGM());
	}
	
	
	@Test
	@DisplayName("Disciplina: Buscar disciplina")
	void searchDisciplina() {
		
		ListaEncadeada listaEncadeada = new ListaEncadeada();
		
		listaEncadeada.add(disciplina);
		
		Disciplina disciplina = listaEncadeada.searchDisciplina(listaEncadeada,"ED");
	    
		assertEquals("ED", disciplina.getNomeDaDisciplina());
	}
	
	
	
	
	@Test
	@DisplayName("Disciplina: Verificando se lista de disciplinas é vazia")
	void isEmptyListDisciplinas() {
		ListaEncadeada listaEncadeada = new ListaEncadeada();
		ListaEncadeada listaEncadeada2 = new ListaEncadeada();
		
		boolean result = listaEncadeada.checkEmptyListDisciplinas(listaEncadeada2);
		assertEquals(true, result);
	}
	
	@Test
	@DisplayName("Aluno: remover um aluno pelo RGM")
	void removeAluno() {
	
		Aluno[] result = actionsAlunos.removeStudent(2134, alunos);
		
		assertEquals(1234, result[0].getRGM());
	}
	
	
	
}
