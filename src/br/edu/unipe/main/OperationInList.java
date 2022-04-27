package br.edu.unipe.main;

import java.util.Map;

import br.edu.unipe.domain.ActionsAlunos;
import br.edu.unipe.domain.Arquivo;
import br.edu.unipe.domain.ListaEncadeada;
import br.edu.unipe.models.Aluno;
import br.edu.unipe.models.Disciplina;
import br.edu.unipe.models.Ponteiro;

public class OperationInList{
	
	
	public static Aluno[] addStudentInList(int posicao, Aluno aluno, Aluno alunos[]) {
		ActionsAlunos actionsAlunos = new ActionsAlunos();
		alunos = actionsAlunos.insertAlunoInList(alunos, aluno,posicao);
		return alunos;
	}
	
	public static Aluno creaeteNewStudent(String nomeDoAluno, int rgmDoAluno) {
		ListaEncadeada listaDeDisciplanas = new ListaEncadeada();
		Aluno aluno = new Aluno(nomeDoAluno,rgmDoAluno, listaDeDisciplanas);
		return aluno;
		
	}
	
	
	public static Aluno searchSpecificStudent(int rgmDoAluno, Aluno alunos[]) {
		ActionsAlunos actionsAlunos = new ActionsAlunos();
		Aluno alunoEncontrado = actionsAlunos.searchStudent(rgmDoAluno, alunos);
		return alunoEncontrado;
	}

	 
	public static Aluno[] removeStudentInLIst(int rgmDoAluno, Aluno alunos[], String nomeDoArquivo) {
		 ActionsAlunos actionsAlunos = new ActionsAlunos();
		 Aluno novaListaDeAlunos [] = null;
		 
		 try {
			 novaListaDeAlunos = actionsAlunos.removeStudent(rgmDoAluno, alunos);
			 
			 if(actionsAlunos.checkEmptyListAlunos(novaListaDeAlunos)) {
				 Arquivo arquivo = new Arquivo(nomeDoArquivo);
				 arquivo.removeAlunoUpdateFile(novaListaDeAlunos);
			 }
		 }catch (Exception e) {
			 System.err.println(e.getMessage());
		}
		 
		 return novaListaDeAlunos;
	 }
	 
	public static boolean isEmptyLis(Aluno alunos[]) {
		ActionsAlunos actionsAlunos = new ActionsAlunos();
		return actionsAlunos.checkEmptyListAlunos(alunos);
	}
	
	 
	 public static Object printAllStudents(Aluno[] alunos) {
		ActionsAlunos actionsAlunos = new ActionsAlunos();
			
		if(actionsAlunos.checkEmptyListAlunos(alunos)) {
				actionsAlunos.printAllStudents(alunos);
			}
		return null;
		}
	 
		public static Aluno addDisciplinas(Aluno alunoInserido, String nomeDaDisciplina) {
			
			if(nomeDaDisciplina != null) {
				
				Disciplina disciplina = new Disciplina(nomeDaDisciplina,80);
				alunoInserido.getListaDeDisciplinas().add(disciplina);
				
				return alunoInserido;
				
			}else {
				System.out.println("Ops!! parace que nenhuma disciplina foi adicionada");
			}
			return null;
		}
		
}
	