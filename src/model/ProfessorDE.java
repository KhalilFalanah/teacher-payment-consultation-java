package model;

public class ProfessorDE extends Professor {
	private double salarioBase;
	private double salarioTotal;
	
	public ProfessorDE(String nome, String dataPagamento, int matricula, double salarioBase,double salarioTotal) {
		super(nome, dataPagamento, matricula);
		// TODO Auto-generated constructor stub
		this.salarioBase = salarioBase;
		this.salarioTotal = salarioTotal;
	}

	public ProfessorDE() {
		
	}
	
	public double getSalarioBase() {
		return salarioBase;
	}
	
	public void setSalarioBase(double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public double getSalarioTotal() {
		return salarioTotal;
	}

	public void setSalarioTotal(double salarioTotal) {
		this.salarioTotal = salarioTotal;
	}
	
	
}
