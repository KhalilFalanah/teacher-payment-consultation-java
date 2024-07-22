package model;

public class Professor {
	private String nome;
	private String dataPagamento;
	private int matricula;

	
	public Professor(String nome, String dataPagamento, int matricula) {
		super();
		this.nome = nome;
		this.matricula = matricula;
		this.dataPagamento = dataPagamento;
	}

	public Professor() {
		
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(String dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	
	
}
