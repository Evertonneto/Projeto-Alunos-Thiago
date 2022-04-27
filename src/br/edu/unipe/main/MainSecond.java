package br.edu.unipe.main;

import java.util.HashMap;
import java.util.Map;

import br.edu.unipe.domain.ActionsAlunos;
import br.edu.unipe.domain.Arquivo;
import br.edu.unipe.domain.ListaEncadeada;
import br.edu.unipe.models.Aluno;
import br.edu.unipe.models.Disciplina;

public class MainSecond {

	static Aluno alunos[] = new Aluno[3];
	static InputKeyboard inputKeyboard = new InputKeyboard();
	static Arquivo arquivo = new Arquivo("listaDeAlunos.txt");
	
	static HashMap<Integer, String> map = new HashMap<Integer, String>(); 
			
			
	public static void main(String[] args) {
		showOptinos();
	}

	private static void showOptinos() {
		System.out.println();
		System.out.println();
		map.put(0, " - Para finalizar o programa");
		map.put(1, " - Para adicionar alunos a lista");
		map.put(2, " - Para buscar um aluno pelo rgm");
		map.put(3, " - Para remover um aluno pelo rgm");
		map.put(4, " - Para mostrar todos os alunos");
		
		for(Map.Entry<Integer, String> entry: map.entrySet()) {
			System.out.print(entry.getKey());
			System.out.println(entry.getValue());
		}
		
		System.out.println("Escolha uma das opções:");
		int opcaoEscolhida = inputKeyboard.getInputInterger();
		 
		if(opcaoEscolhida != 0 ) {
			menu(opcaoEscolhida);
		}
		
	}


	private static void menu(int opcao) {
		switch (opcao) {
		case 0:
			finalizarPrograma();
			break;
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

	private static Object mostrarTodosOsAlunos() {
		return OperationInList.printAllStudents(alunos);
	}

	private static void removerUmAlunoDaLista() {
		System.out.println("Digite o rgm do aluno a er removido: ");
		int rgmDoAluno = inputKeyboard.getInputInterger();
		
		alunos = OperationInList.removeStudentInLIst(rgmDoAluno,alunos,arquivo.file.getName());
		
		if(OperationInList.isEmptyLis(alunos)) {
			System.out.println("Aluno removido \n\n");
			mostrarTodosOsAlunos();
		}
	}

	private static Object buscarUmAlunoEspecifico() {
		
		System.out.println("Digite o rgm do aluno: ");
		int rgmDoAluno = inputKeyboard.getInputInterger();
		
		Aluno alunoEncontrado = OperationInList.searchSpecificStudent(rgmDoAluno,alunos);
		
		if(alunoEncontrado != null) {
			System.out.println("O aluno: "+ alunoEncontrado.getNome()+" de rgm: "+alunoEncontrado.getRGM());
			return null;
		}
		
		System.out.println("Aluno não encontrado");
		return null;
	}

	private static Object inserirAlunosNaLista() {
		ListaEncadeada listaisciplinas = null;
		Aluno listaDeAlunos[] = null;
		
		for(int indice = 0; indice < alunos.length; indice++) {
			
			System.out.println("Digite o nome do aluno: ");
			String nomeDoAluno = inputKeyboard.getInputString();
			
			System.out.println("Digite o RGM do aluno: ");
			int rgmDoAluno = inputKeyboard.getInputInterger();
			
			System.out.println("Digite o nome da disciplina:");
			String nomeDaDisciplina = inputKeyboard.getInputString();
			
			Aluno novoAluno = OperationInList.creaeteNewStudent(nomeDoAluno,rgmDoAluno);
			Aluno alunoInserido = OperationInList.addDisciplinas(novoAluno, nomeDaDisciplina);
			
			
			System.out.println("Quer continuar a adicionar disciplinas(s ou n): ");
			String adicionarDisciplina = inputKeyboard.getInputString();
			alunoInserido = adicionarMaisMaterias(adicionarDisciplina, alunoInserido);
			
			alunos = OperationInList.addStudentInList(indice,alunoInserido,alunos);
			
		}
		arquivo.writerInFile(alunos);
		OperationInList.printAllStudents(alunos);
		return null;
	}



	private static Aluno adicionarMaisMaterias(String adicionarDisciplina, Aluno alunoInserido) {

		
		if (adicionarDisciplina.equals("s")) {
			do {
				
				System.out.println("Digite o nome da disciplina:");
				String nomeDaDisciplina = inputKeyboard.getInputString();
				
				alunoInserido = OperationInList.addDisciplinas(alunoInserido, nomeDaDisciplina);
				
				System.out.println("Quer continuar a adicionar disciplinas(s ou n): ");
				adicionarDisciplina = inputKeyboard.getInputString();
				
				
			}while(!adicionarDisciplina.equals("n"));
		}
		
		return alunoInserido;
		
	}
	
	private static Object finalizarPrograma() {
		System.exit(0);
		return null;
	}

}
