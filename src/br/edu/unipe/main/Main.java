package br.edu.unipe.main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import br.edu.unipe.domain.ActionsAlunos;
import br.edu.unipe.models.Aluno;
import br.edu.unipe.models.Disciplina;

public class Main {

	static ActionsAlunos actionsAlunos = new ActionsAlunos();
	static List<Aluno> alunos = new ArrayList<Aluno>();
	static LinkedList<Disciplina> disciplinas = new LinkedList<Disciplina>();
	static InputKeyboard inputKeyboard = new InputKeyboard();
	
	public static void main(String[] args) {
	
		showOptinos();

	}

	private static void showOptinos() {
		System.out.println();
		System.out.println();
		System.out.println("Escolha uma das opções: ");
		System.out.println("0 - Para encerrar o programa");
		System.out.println("1 - Para adicionar alunos a lista ");
		System.out.println("2 - Para buscar um aluno pelo rgm");
		
		int opcaoEscolhida = inputKeyboard.getInputInterger();
		 
		if(opcaoEscolhida != 0) {
			menu(opcaoEscolhida);
		}
	}

	private static void menu(int opcao) {
		
		
			switch (opcao) {
			case 1:
				inserirAlunosNaLista();
				showOptinos();
				break;
			case 2:
				buscarUmAlunoEspecifico();
				showOptinos();
				break;
			default:
				System.out.println("Opção invalida");
				break;
			}
			
		
	}

	private static int buscarUmAlunoEspecifico() {
		
		System.out.println("Digite o rgm do aluno: ");
		int rgmDoAluno = inputKeyboard.getInputInterger();
		
		Aluno alunoEncontrado = actionsAlunos.searchStudent(rgmDoAluno, alunos);
		
		if(alunoEncontrado != null) {
			System.out.println("O aluno: "+ alunoEncontrado.getNome()+" de rgm: "+alunoEncontrado.getRGM());
			return 1;
		}
		
		System.out.println("Aluno não encontrado");
		return 0;
	}

	private static void inserirAlunosNaLista() {
		String nomeDaDisciplina = null;
		
		for(int indice = 0; indice < 3; indice++) {
			
			System.out.println("Digite o nome do aluno: ");
			String nomeDoAluno = inputKeyboard.getInputString();
			
			System.out.println("Digite o RGM do aluno: ");
			int rgmDoAluno = inputKeyboard.getInputInterger();
			
			System.out.println("Digite o nome da disciplina:");
			nomeDaDisciplina = inputKeyboard.getInputString();
			
			System.out.println("Quer continuar a adicionar disciplinas(s ou n): ");
			String adicionarDisciplina = inputKeyboard.getInputString();
			
			adicionarMaisMaterias(adicionarDisciplina);
			
			addDisciplinas(nomeDaDisciplina);
			
			addAluno(nomeDoAluno,rgmDoAluno);
			
			
		}
		
	}

	private static void adicionarMaisMaterias(String adicionarDisciplina) {

		
		if (adicionarDisciplina.equals("s")) {
			do {
				
				System.out.println("Digite o nome da disciplina:");
				String nomeDaDisciplina = inputKeyboard.getInputString();
				
				addDisciplinas(nomeDaDisciplina);
				
				System.out.println("Quer continuar a adicionar disciplinas(s ou n): ");
				adicionarDisciplina = inputKeyboard.getInputString();
				
				
			}while(!adicionarDisciplina.equals("n"));
		}
		
	}
	

	private static void addDisciplinas(String nomeDaDisciplina) {
	 
		if(nomeDaDisciplina != null) {
			
			Disciplina disciplina = new Disciplina(nomeDaDisciplina,80);
			disciplinas.add(disciplina);
			
		}else {
			System.out.println("Ops!! parace que nenhuma disciplina foi adicionada");
		}
		
	}
	

	private static void addAluno(String nomeDoAluno, int rgmDoAluno) {
		if(nomeDoAluno != null && rgmDoAluno != 0) {
			
			Aluno aluno = new Aluno(nomeDoAluno, rgmDoAluno, disciplinas);
			alunos = actionsAlunos.insertAlunoInList(alunos, aluno);
		}
		
	}


}
