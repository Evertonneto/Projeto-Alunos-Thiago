package br.edu.unipe.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.edu.unipe.domain.Arquivo;
import br.edu.unipe.models.Aluno;

public class TestArquivo {
	
	Arquivo arquivo = new Arquivo("listaDeAlunos.txt");
	
	@Test
	@DisplayName("Arquivo: criando uma arquivo")
	void verificarSeListaVazia(){
		
		
		
		boolean result = arquivo.createFile();
		
		assertEquals(true, result);
	}
	
	@Test
	@DisplayName("Arquivo: verificando se arquivo existe")
	void verificarSeArquivoExiste(){
		
		
		boolean checkExistFile = arquivo.verifyExistFile();
		
		assertEquals(true, checkExistFile);
	}
	
	@Test
	@DisplayName("Arquivo: removendo aluno do arquivo")
	void escreverNoArquivo() {
		
		arquivo.removeLine("Matheus");		
	}
	
	@Test
	@DisplayName("Arquivo: lendo conteudo do arquivo")
	void lerConteudoDoArquivo() {
		String nomesDosAlunos = arquivo.readAllStudensInFile();
		
		
		
		assertEquals(true, nomesDosAlunos.equals("Matheus"));
	}
	
}
