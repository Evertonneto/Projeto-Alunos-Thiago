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

public class Arquivo {

	private String nomeDoArquivo;
	public File file;

	public Arquivo(String nomeDoArquivo) {
		super();
		this.file = new File(nomeDoArquivo);
	}

	public boolean verifyExistFile() {
		return file.isFile();
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

	public void removeLine(String conteudo) {
		try {
			
			FileReader fileReader = new FileReader(file);
			FileWriter arquivoEscrito = new FileWriter(file.getName(),true);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line = "";
			
			while((line = bufferedReader.readLine()) != null) {
				
				if(!line.trim().equals(conteudo.trim())) {
					arquivoEscrito.write(line+ "\r\n");
				}
				
			}
			arquivoEscrito.close();
			fileReader.close();
		} catch (IOException e) {
			
			System.err.println(e.getMessage());
		}
	}

	@SuppressWarnings("null")
	public String readAllStudensInFile() {
		List<String> listDataStudents = null;
		String dataStudent = null;
		try {
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			while(bufferedReader.ready()) {
				dataStudent = bufferedReader.readLine();
				
			}
			
			bufferedReader.close();
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		
		return dataStudent;
	}
	
	
	
	

}
