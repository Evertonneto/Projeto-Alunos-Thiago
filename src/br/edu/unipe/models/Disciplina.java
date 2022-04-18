package br.edu.unipe.models;

public class Disciplina {
	
	private String nomeDaDisciplina;
	private int quantidadeDeHoras;
	
	public Disciplina(String nomeDaDisciplina, int quantidadeDeHoras) {
		super();
		this.nomeDaDisciplina = nomeDaDisciplina;
		this.quantidadeDeHoras = quantidadeDeHoras;
	}

	public String getNomeDaDisciplina() {
		return nomeDaDisciplina;
	}

	public void setNomeDaDisciplina(String nomeDaDisciplina) {
		this.nomeDaDisciplina = nomeDaDisciplina;
	}

	public int getQuantidadeDeHoras() {
		return quantidadeDeHoras;
	}

	public void setQuantidadeDeHoras(int quantidadeDeHoras) {
		this.quantidadeDeHoras = quantidadeDeHoras;
	}
	
	
}
