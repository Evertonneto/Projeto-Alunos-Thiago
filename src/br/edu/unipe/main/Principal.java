package br.edu.unipe.main;

import br.edu.unipe.domain.Arquivo;

public class Principal {

	public static void main(String[] args) {
	  criar();
	}

	private static void criar() {

			Arquivo arquivo = new Arquivo("listaDeAlunos.txt");
			arquivo.readAllStudensInFile();
	}
	

}
