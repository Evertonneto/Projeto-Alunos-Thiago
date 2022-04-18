package br.edu.unipe.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.edu.unipe.domain.ActionsAlunos;
import br.edu.unipe.models.Aluno;
import br.edu.unipe.models.Disciplina;

class ActionsAlunosTest{
	
	private ActionsAlunos actionsAlunos;
	private Disciplina disciplina;
	private LinkedList<Disciplina> disciplinas;
	private Aluno aluno;
	private List<Aluno> alunos, mockListAlunos;
	
	@BeforeEach
	void setUp() {
		
		actionsAlunos = new ActionsAlunos();
		disciplina = new Disciplina("ED",80);
		disciplinas = new LinkedList<Disciplina>();
		disciplinas.add(disciplina);
		aluno = new Aluno("Matheus",2134, disciplinas);
		alunos = new ArrayList<Aluno>();
		
		mockListAlunos = actionsAlunos.insertAlunoInList(alunos, aluno);
		//alunos.add(aluno);
	}
	
	@Test
	@DisplayName("Alunos: Inserindo aluno a lista")
	void insertAlunoInList() {
		
		List <Aluno> mockAlunos = actionsAlunos.insertAlunoInList(alunos, aluno);
		
		boolean isListEmpty = actionsAlunos.checkEmptyListAlunos(mockAlunos);
		assertEquals(false, isListEmpty);
	}
	
	@Test
	@DisplayName("Alunos: inserindo 3 alunos")
	void inserindo3Alunos() {
		
		Aluno mockAluno1,mockAluno2,mockAluno3;
		
		mockAluno1 = new Aluno("Matheus",2143,disciplinas);
		mockAluno1 = new Aluno("Danilo",2154,disciplinas);
		mockAluno1 = new Aluno("Josemilson",2167,disciplinas);
		
		List <Aluno> mockListAlunos = actionsAlunos.insertAlunoInList(alunos, aluno);
		
		for(int i = 0 ; i < 4; i++) {
			actionsAlunos.insertAlunoInList(mockListAlunos, mockAluno1);
		}
		
		boolean result = actionsAlunos.checkEmptyListAlunos(alunos);
		
		assertEquals(false,result);
	}

	@Test
	@DisplayName("Verificando se lista de aluno é vazia")
	void test() {
		
		boolean result = actionsAlunos.checkEmptyListAlunos(mockListAlunos);
		
		assertEquals(false,result);
	}
	
	@Test
	@DisplayName("Aluno: Buscando um aluno pelo RGM")
	void searchAluno() {
		
	
		Aluno alunoEncontrado = actionsAlunos.searchStudent(2134, mockListAlunos);
		
		assertEquals(2134, alunoEncontrado.getRGM());
	}
	
	
	@Test
	@DisplayName("Disciplina: Buscar disciplina")
	void searchDisciplina() {
		
		Disciplina disciplina = actionsAlunos.searchDisciplina("ED",aluno);
	    
		assertEquals("ED", disciplina.getNomeDaDisciplina());
	}
	
	@Test
	@DisplayName("Disciplina: Removendo uma disciplina")
	void removeDisciplina() {
		
		boolean result = actionsAlunos.removeDisciplina("ED",aluno);
	    
		assertEquals(true, result);
	}
	
	
	
	@Test
	@DisplayName("Disciplina: Verificando se lista de disciplinas é vazia")
	void isEmptyListDisciplinas() {
		boolean result = actionsAlunos.checkEmptyListDisciplinas(disciplinas);
		assertEquals(false, result);
	}
	
	
	
	
}
