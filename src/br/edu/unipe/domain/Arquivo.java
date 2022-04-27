package br.edu.unipe.domain;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.List;

import br.edu.unipe.models.Aluno;
import br.edu.unipe.models.Ponteiro;

public class Arquivo {

	private String nomeDoArquivo;
	public  File file;

	public Arquivo(String nomeDoArquivo) {
		super();
		this.file = new File(nomeDoArquivo);
	}

	public  boolean verifyExistFile() {
		return file.isFile();
	}
	
	public boolean deleteFile() {
		return file.delete();
	}

	public boolean createFile(){
		if(!verifyExistFile()) {
			
			try {
				
				return file.createNewFile();
				
			}catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
	
		return false;
	}
	
	public void writerInFile(Aluno alunos[]) {
		
		if(createFile()) {
			try {
				
				FileWriter arquivoEscrito = new FileWriter(file.getName(),true);
				BufferedWriter bufferedWriter = new BufferedWriter(arquivoEscrito);
				
				for(int i= 0; i < alunos.length; i++) {
					
					bufferedWriter.write(alunos[i].getNome()+"   "+alunos[i].getRGM());
					
					for (Ponteiro n = alunos[i].getListaDeDisciplinas().primeiro; n != null; n = n.getProximo()) {
						
						bufferedWriter.write("  "+n.getDisciplina().getNomeDaDisciplina());
					}
					bufferedWriter.newLine();
				}
				
				bufferedWriter.close();
				
			}catch (Exception e) {
				System.err.println(e.getMessage());
			}
		   return;	
		}
		removeAlunoUpdateFile(alunos);
	}

	public void removeAlunoUpdateFile(Aluno[] alunos) {
		
		if(deleteFile() || createFile()) {
			try {
				
				FileWriter arquivoEscrito = new FileWriter(file.getName(),true);
				BufferedWriter bufferedWriter = new BufferedWriter(arquivoEscrito);
				
				for(int i= 0; i < alunos.length; i++) {
					
					bufferedWriter.write(alunos[i].getNome()+"   "+alunos[i].getRGM());
					
					for (Ponteiro n = alunos[i].getListaDeDisciplinas().primeiro; n != null; n = n.getProximo()) {
						
						bufferedWriter.write("  "+n.getDisciplina().getNomeDaDisciplina());
					}
					bufferedWriter.newLine();
				}
				
				bufferedWriter.close();
				
			}catch (Exception e) {
				System.err.println(e.getMessage());
			}
			
		}
	}
	
}
