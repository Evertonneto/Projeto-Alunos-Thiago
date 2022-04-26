package br.edu.unipe.main;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

import br.edu.unipe.domain.ActionsAlunos;
import br.edu.unipe.domain.Arquivo;
import br.edu.unipe.domain.ListaEncadeada;
import br.edu.unipe.models.Aluno;
import br.edu.unipe.models.Disciplina;
import br.edu.unipe.models.Node;

public class Main {

	static ActionsAlunos actionsAlunos = new ActionsAlunos();
	static Aluno alunos[] = new Aluno[3];
	static ListaEncadeada listaDisciplinas = new ListaEncadeada();
	static InputKeyboard inputKeyboard = new InputKeyboard();
	static Arquivo arquivo = new Arquivo("listaDeAlunos.txt");
	
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
		System.out.println("3 - Para remover um aluno pelo rgm");
		System.out.println("4 - Para mostrar todos os alunos");
		
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
			case 3:
				removerUmAlunoDaLista();
				showOptinos();
				break;
			case 4:
				mostrarTodosOsAlunos();
				showOptinos();
			default:
				System.out.println("Opção invalida");
				break;
			}
			
		
	}

	private static void mostrarTodosOsAlunos() {
		if(actionsAlunos.checkEmptyListAlunos(alunos)) {
			actionsAlunos.printAllStudents(alunos);
		}
		
	}

	private static void removerUmAlunoDaLista() {
		System.out.println("Digite o rgm do aluno a er removido: ");
		int rgmDoAluno = inputKeyboard.getInputInterger();
		
		Aluno novaListaDeAlunos [] = null;
		
		try {
			novaListaDeAlunos = actionsAlunos.removeStudent(rgmDoAluno, alunos);
			
			if(actionsAlunos.checkEmptyListAlunos(alunos)) {
				
				System.out.println("Aluno removido \n\n");
				
				arquivo.removeAlunoUpdateFile(novaListaDeAlunos);
			}
			
			actionsAlunos.printAllStudents(novaListaDeAlunos);

		}catch(Exception error) {
			System.err.println(error.getMessage());
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
		ListaEncadeada listaisciplinas = null;
		Aluno listaDeAlunos[] = null;
		
		for(int indice = 0; indice < alunos.length; indice++) {
			
			System.out.println("Digite o nome do aluno: ");
			String nomeDoAluno = inputKeyboard.getInputString();
			
			System.out.println("Digite o RGM do aluno: ");
			int rgmDoAluno = inputKeyboard.getInputInterger();
			
			System.out.println("Digite o nome da disciplina:");
			String nomeDaDisciplina = inputKeyboard.getInputString();
			
			
			listaisciplinas = addDisciplinas(nomeDaDisciplina);
			Aluno novoAluno = creaeteNewStudent(nomeDoAluno,rgmDoAluno,listaisciplinas);
			
			System.out.println("Quer continuar a adicionar disciplinas(s ou n): ");
			String adicionarDisciplina = inputKeyboard.getInputString();
			novoAluno = adicionarMaisMaterias(adicionarDisciplina, novoAluno);
			
			addAluno(indice, novoAluno);
			
		}
		arquivo.writerInFile(alunos);
		actionsAlunos.printAllStudents(alunos);
	}

	private static Aluno creaeteNewStudent(String nomeDoAluno, int rgmDoAluno, ListaEncadeada listaisciplinas) {
		Aluno aluno = new Aluno(nomeDoAluno,rgmDoAluno, listaisciplinas);
		return aluno;
		
	}

	private static Aluno adicionarMaisMaterias(String adicionarDisciplina, Aluno alunoInserido) {

		
		if (adicionarDisciplina.equals("s")) {
			do {
				
				System.out.println("Digite o nome da disciplina:");
				String nomeDaDisciplina = inputKeyboard.getInputString();
				
				alunoInserido = addMaisDisciplinas(alunoInserido,nomeDaDisciplina);
				
				System.out.println("Quer continuar a adicionar disciplinas(s ou n): ");
				adicionarDisciplina = inputKeyboard.getInputString();
				
				
			}while(!adicionarDisciplina.equals("n"));
		}
		
		return alunoInserido;
		
	}
	

	private static Aluno addMaisDisciplinas(Aluno alunoInserido, String nomeDaDisciplina) {
	
		if(nomeDaDisciplina != null) {
			
			Disciplina disciplina = new Disciplina(nomeDaDisciplina,80);
			alunoInserido.getListaDeDisciplinas().add(disciplina);
			
			return alunoInserido;
			
		}else {
			System.out.println("Ops!! parace que nenhuma disciplina foi adicionada");
		}
		return null;
	}
	

	private static ListaEncadeada addDisciplinas(String nomeDaDisciplina) {
	 
		ListaEncadeada listaDisciplinas = new ListaEncadeada();
	
		if(nomeDaDisciplina != null) {
			
			Disciplina disciplina = new Disciplina(nomeDaDisciplina,80);
			listaDisciplinas.add(disciplina);
			
			return listaDisciplinas;
			
		}else {
			System.out.println("Ops!! parace que nenhuma disciplina foi adicionada");
		}
		return listaDisciplinas;
		
	}
	

	private static Aluno[] addAluno(int posicao, Aluno aluno) {
			alunos = actionsAlunos.insertAlunoInList(alunos, aluno,posicao);
			return alunos;
	}
	


}
