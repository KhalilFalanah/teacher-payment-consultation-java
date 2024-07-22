package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import dao.PagamentosDAO;
import model.Professor;
import model.ProfessorDE;
import model.ProfessorHorista;
import view.JanelaPrincipal;

public class PagamentosController implements ActionListener {

	private JanelaPrincipal jan;
	private PagamentosDAO pagdao;
	private Professor prof;

	public PagamentosController(JanelaPrincipal jan) {
		this.jan = jan;
		this.pagdao = new PagamentosDAO();
		registraListeners();
	}

	public void registraListeners() {
		jan.getBtnCadastrar().addActionListener(this);
		jan.getBtnLimparTela().addActionListener(this);
		jan.getBtnConsulta().addActionListener(this);
		jan.getBtnLimparTelaConsulta().addActionListener(this);
	}

	public void cadastraProfessores() {
		Professor professor = null;

		String nome = jan.getTxtNome().getText();
		String dataPagamento = jan.getTxtDataPagamento().getText();
		String matriculaStr = jan.getTxtMatricula().getText();

		if (!nome.isEmpty() || !dataPagamento.isEmpty() || !matriculaStr.isEmpty()) {

			if (!validadorData(dataPagamento)) {
				System.out.println("Formato da data de pagamento inválido. Use dd/mm/aaaa.");
				return;
			}

			if (jan.getRbDe().isSelected()) {
				try {
					int matricula = Integer.parseInt(matriculaStr);
					String salarioBaseStr = jan.getTxtSalarioBase().getText();

					if (!salarioBaseStr.isEmpty()) {
						double salarioBase = Double.parseDouble(salarioBaseStr);
						double salarioTotal = salarioBase * 2;
						professor = new ProfessorDE(nome, dataPagamento, matricula, salarioBase, salarioTotal);
						pagdao.cadastraProfessor(professor);
					}
				} catch (NumberFormatException e1) {
					System.out.println("Verifique se os valores estão corretos!");
				}

			} else if (jan.getRbHorista().isSelected()) {
				try {
					int matricula = Integer.parseInt(matriculaStr);
					String horasTrabalhadasStr = jan.getTxtHorasTrabalhadas().getText();
					String valorHoraStr = jan.getTxtValorHora().getText();

					if (!horasTrabalhadasStr.isEmpty() || !valorHoraStr.isEmpty()) {
						int horasTrabalhadas = Integer.parseInt(horasTrabalhadasStr);
						double valorHora = Double.parseDouble(valorHoraStr);
						double salarioTotal = horasTrabalhadas * valorHora;
						professor = new ProfessorHorista(nome, dataPagamento, matricula, horasTrabalhadas, valorHora,salarioTotal);
						pagdao.cadastraProfessor(professor);
					}

				} catch (NumberFormatException e1) {
					System.out.println("Verifique se os valores estão corretos!");
				}

			}

		} else {
			System.out.println("Preencha os campos");
		}
	}

	private boolean validadorData(String data) {
		String regex = "\\d{2}/\\d{2}/\\d{4}";
		return data.matches(regex);
	}

	public void consultaProfessor() {
		String matriculaStr = jan.getTxtConsultaMatricula().getText();
		int matricula = Integer.parseInt(matriculaStr);
		Professor prof = new ProfessorHorista();
		prof.setMatricula(matricula);

		if (matriculaStr == null || matriculaStr.isEmpty()) {
	        jan.getTxtPaneConsulta().setText("Preencha o campo de matrícula!");
	        return;
	    }

		if (pagdao.consultaPagamentos(prof)) {
			jan.getTxtPaneConsulta()
					.setText("Nome: " + prof.getNome() + "\n" + "Horas Trabalhadas: "
							+ ((ProfessorHorista) prof).getHorasTrabalhadas() + "\n" + "Valor Hora: "
							+ ((ProfessorHorista) prof).getValorHora() + "\n" + "Data de Pagamento: "
							+ prof.getDataPagamento() + "\n" + "Salario Total: "
							+ ((ProfessorHorista)prof).getSalarioTotal());
							
		} else {

			prof = new ProfessorDE();
			prof.setMatricula(matricula);

			if (pagdao.consultaPagamentos(prof)) {
				jan.getTxtPaneConsulta()
						.setText("Nome: " + prof.getNome() + "\n" + "Salário Base: "
								+ ((ProfessorDE) prof).getSalarioBase() + "\n" + "Data de Pagamento: "
								+ prof.getDataPagamento()+ "\n" + "Salario Total: "
								+ ((ProfessorDE)prof).getSalarioTotal());
			} else {
				jan.getTxtPaneConsulta().setText("Professor não encontrado.");
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Cadastrar")) {
			cadastraProfessores();
		} else if (e.getActionCommand().equals("Limpar Tela")) {
			limparTela();
		} else if (e.getActionCommand().equals("Consultar")) {
			consultaProfessor();
		} else if (e.getActionCommand().equals("Limpar Tela Consulta")) {
			limparTelaConsulta();
		}
	}

	private void limparTela() {
		jan.getTxtMatricula().setText("");
		jan.getTxtSalarioBase().setText("");
		jan.getTxtHorasTrabalhadas().setText("");
		jan.getTxtValorHora().setText("");
		jan.getTxtDataPagamento().setText("");
		jan.getTxtNome().setText("");
		jan.getGrupoProfessores().clearSelection();
	}

	private void limparTelaConsulta() {
		jan.getTxtConsultaMatricula().setText("");
		jan.getTxtPaneConsulta().setText("");
	}
}
