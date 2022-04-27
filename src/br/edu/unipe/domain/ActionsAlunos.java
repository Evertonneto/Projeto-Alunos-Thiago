package br.edu.unipe.domain;

import br.edu.unipe.models.Aluno;
import br.edu.unipe.models.Ponteiro;

public class ActionsAlunos {

	
	public boolean checkEmptyListAlunos(Aluno[] alunos) {
		return alunos[0] != null;
	}
	

	public Aluno searchStudent(int rgmDoAluno, Aluno[] alunos) {
		
		Aluno alunoEncontrado = null;
		if(alunos[0] != null) {
			
			for(int indice = 0; indice < alunos.length; indice++) {
				 
				if (rgmDoAluno == alunos[indice].getRGM()) {
					 alunoEncontrado = alunos[indice];
				 }
			}
		}
		
		return alunoEncontrado;
	}



	public Aluno[] insertAlunoInList(Aluno[] alunos, Aluno aluno, int posicao) {
		alunos[posicao] = aluno;
		
		return alunos;
	
	}


	public Aluno[] removeStudent(int rgmDoAluno, Aluno[] alunos) {
		
		Aluno[] novaListaDeAlunos = new Aluno[alunos.length -1];
		
		if(checkEmptyListAlunos(alunos)) {
			for (int i = 0, j = 0; i < alunos.length; i++) {
			    if (rgmDoAluno != alunos[i].getRGM()) {
			        novaListaDeAlunos[j++] = alunos[i];
			    }
			}
		}
			
		return novaListaDeAlunos;
	}

	public void printAllStudents(Aluno[] alunos) {
		
		for(int i= 0; i < alunos.length; i++) {
			System.out.print(alunos[i].getNome()+" "+alunos[i].getRGM()+"  ");
			
			for (Ponteiro n = alunos[i].getListaDeDisciplinas().primeiro; n != null; n = n.getProximo()) {
				
				System.out.print(n.getDisciplina().getNomeDaDisciplina()+" ");
				
			}
			
			System.out.println();
		}
		
		
		
	}
	



}
