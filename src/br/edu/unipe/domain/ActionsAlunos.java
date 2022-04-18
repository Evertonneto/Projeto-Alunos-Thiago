package br.edu.unipe.domain;

import java.util.LinkedList;
import java.util.List;

import br.edu.unipe.models.Aluno;
import br.edu.unipe.models.Disciplina;

public class ActionsAlunos {

	public boolean checkEmptyListAlunos(List<Aluno> alunos) {
		return alunos.isEmpty();
	}
	
	
	public boolean checkEmptyListDisciplinas(LinkedList<Disciplina> disciplinas) {
		return disciplinas.isEmpty();
	}
	

	public Aluno searchStudent(int rgmDoAluno, List<Aluno> alunos) {
		
		Aluno alunoEncontrado = null;
		if(alunos.size() !=0) {
			
			for(Aluno aluno: alunos) {
				 if (rgmDoAluno == aluno.getRGM()) {
					 alunoEncontrado = aluno;
				 }
			}         
		}
		
		return alunoEncontrado;
	}


	public Disciplina searchDisciplina(String nomeDaDisciplina, Aluno aluno) {
		
		Disciplina disciplinaEncontrada  = null;
		if(aluno.getDisciplinas().size() != 0) {
			
			for(Disciplina disciplina : aluno.getDisciplinas()) {
				
				if(nomeDaDisciplina == disciplina.getNomeDaDisciplina()) {
				
					disciplinaEncontrada = disciplina;
				}
			}
	
		}
		return disciplinaEncontrada;
	}


	public boolean removeDisciplina(String nomeDaDisciplina, Aluno aluno) {
		
		if(aluno.getDisciplinas().size() != 0) {
			
			for(Disciplina disciplina : aluno.getDisciplinas()) {
				
				if(nomeDaDisciplina == disciplina.getNomeDaDisciplina()) {
			
					return aluno.getDisciplinas().remove(disciplina);
				}
			}
	
		}
		return false;
	}


	public List<Aluno> insertAlunoInList(List<Aluno> alunos, Aluno aluno) {
		alunos.add(aluno);
		return alunos;
	}




}
