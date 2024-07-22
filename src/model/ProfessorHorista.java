package model;

public class ProfessorHorista extends Professor {
	private int horasTrabalhadas;
	private double valorHora;
	private double salarioTotal;
	
	public ProfessorHorista(String nome, String dataPagamento, int matricula, int horasTrabalhadas, double valorHora, double salarioTotal) {
		super(nome, dataPagamento, matricula);
		// TODO Auto-generated constructor stub
		this.horasTrabalhadas = horasTrabalhadas;
		this.valorHora = valorHora;
		this.salarioTotal = salarioTotal;
	}
	
	public ProfessorHorista() {
		
	}

	public int getHorasTrabalhadas() {
		return horasTrabalhadas;
	}

	public void setHorasTrabalhadas(int horasTrabalhadas) {
		this.horasTrabalhadas = horasTrabalhadas;
	}

	public double getValorHora() {
		return valorHora;
	}

	public void setValorHora(double valorHora) {
		this.valorHora = valorHora;
	}

	public double getSalarioTotal() {
		return salarioTotal;
	}

	public void setSalarioTotal(double salarioTotal) {
		this.salarioTotal = salarioTotal;
	}
	
	
	
}
