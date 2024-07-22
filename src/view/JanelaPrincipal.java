package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.CardLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JTextPane;

public class JanelaPrincipal extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private CardLayout cardLayout;
	private JTextField txtMatricula;
	private JTextField txtSalarioBase;
	private JTextField txtHorasTrabalhadas;
	private JTextField txtValorHora;
	private JTextField txtDataPagamento;
	private JTextField txtNome;
	private JRadioButton rbDe;
	private JRadioButton rbHorista;
	private ButtonGroup grupoProfessores;
	private JButton btnCadastrar;
	private JButton btnConsulta;
	private JButton btnLimparTelaConsulta;
	private JButton btnLimparTela;
	private JTextField txtConsultaMatricula;
	private JTextPane txtPaneConsulta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaPrincipal frame = new JanelaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JanelaPrincipal() {
		setTitle("Lançamento de Pagamentos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 628, 300);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnMenu = new JMenu("Menu");
		menuBar.add(mnMenu);

		JMenuItem mnPrincipal = new JMenuItem("Principal");
		mnMenu.add(mnPrincipal);
		mnPrincipal.addActionListener(this);

		JMenuItem mnLancamento = new JMenuItem("Lançamento");
		mnMenu.add(mnLancamento);
		mnLancamento.addActionListener(this);

		JMenuItem mnConsulta = new JMenuItem("Consulta");
		mnMenu.add(mnConsulta);
		mnConsulta.addActionListener(this);

		contentPane = new JPanel();
		cardLayout = new CardLayout();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(cardLayout);

		JPanel painelLancamento = new JPanel();
		painelLancamento.setForeground(new Color(0, 0, 0));
		painelLancamento.setBackground(SystemColor.menu);
		contentPane.add(painelLancamento, "lancamento");
		painelLancamento.setLayout(null);

		JLabel lblTituloLancamento = new JLabel("Tela de Lançamentos");
		lblTituloLancamento.setBackground(new Color(0, 0, 0));
		lblTituloLancamento.setForeground(new Color(0, 0, 0));
		lblTituloLancamento.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblTituloLancamento.setBounds(213, 0, 201, 32);
		painelLancamento.add(lblTituloLancamento);

		JLabel lblMatricula = new JLabel("Matrícula");
		lblMatricula.setForeground(new Color(0, 0, 0));
		lblMatricula.setBounds(68, 50, 96, 14);
		painelLancamento.add(lblMatricula);

		JLabel lblTipoProf = new JLabel("Tipo de professor");
		lblTipoProf.setForeground(new Color(0, 0, 0));
		lblTipoProf.setBounds(68, 78, 112, 14);
		painelLancamento.add(lblTipoProf);

		JLabel lblSalarioBase = new JLabel("Salário Base");
		lblSalarioBase.setForeground(new Color(0, 0, 0));
		lblSalarioBase.setBounds(68, 103, 112, 14);
		painelLancamento.add(lblSalarioBase);

		JLabel lblHorasTrabalhadas = new JLabel("Horas Trabalhadas");
		lblHorasTrabalhadas.setForeground(new Color(0, 0, 0));
		lblHorasTrabalhadas.setBounds(68, 128, 112, 14);
		painelLancamento.add(lblHorasTrabalhadas);

		JLabel lblValorHora = new JLabel("Valor da Hora");
		lblValorHora.setForeground(new Color(0, 0, 0));
		lblValorHora.setBounds(68, 153, 112, 14);
		painelLancamento.add(lblValorHora);

		JLabel lblDataPagamento = new JLabel("Data de Pagamento");
		lblDataPagamento.setForeground(new Color(0, 0, 0));
		lblDataPagamento.setBounds(68, 178, 128, 14);
		painelLancamento.add(lblDataPagamento);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setForeground(new Color(0, 0, 0));
		lblNome.setBounds(288, 50, 72, 14);
		painelLancamento.add(lblNome);

		txtMatricula = new JTextField();
		txtMatricula.setBounds(192, 47, 86, 20);
		painelLancamento.add(txtMatricula);
		txtMatricula.setColumns(10);

		txtSalarioBase = new JTextField();
		txtSalarioBase.setColumns(10);
		txtSalarioBase.setBounds(192, 97, 86, 20);
		painelLancamento.add(txtSalarioBase);

		txtHorasTrabalhadas = new JTextField();
		txtHorasTrabalhadas.setColumns(10);
		txtHorasTrabalhadas.setBounds(192, 122, 86, 20);
		painelLancamento.add(txtHorasTrabalhadas);

		txtValorHora = new JTextField();
		txtValorHora.setColumns(10);
		txtValorHora.setBounds(192, 147, 86, 20);
		painelLancamento.add(txtValorHora);

		txtDataPagamento = new JTextField();
		txtDataPagamento.setColumns(10);
		txtDataPagamento.setBounds(192, 172, 86, 20);
		painelLancamento.add(txtDataPagamento);

		rbDe = new JRadioButton("DE");
		rbDe.setBounds(190, 74, 56, 23);
		painelLancamento.add(rbDe);

		rbHorista = new JRadioButton("Horista");
		rbHorista.setBounds(248, 74, 96, 23);
		painelLancamento.add(rbHorista);

		grupoProfessores = new ButtonGroup();

		grupoProfessores.add(rbDe);
		grupoProfessores.add(rbHorista);

		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(346, 47, 86, 20);
		painelLancamento.add(txtNome);

		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(376, 195, 96, 23);
		painelLancamento.add(btnCadastrar);

		btnLimparTela = new JButton("Limpar Tela");
		btnLimparTela.setBounds(482, 195, 94, 23);
		painelLancamento.add(btnLimparTela);

		JPanel painelConsulta = new JPanel();
		contentPane.add(painelConsulta, "consulta");
		painelConsulta.setLayout(null);
		
		JLabel lblTituloConsulta = new JLabel("Tela de Consultas");
		lblTituloConsulta.setForeground(Color.BLACK);
		lblTituloConsulta.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblTituloConsulta.setBackground(Color.BLACK);
		lblTituloConsulta.setBounds(140, 11, 201, 32);
		painelConsulta.add(lblTituloConsulta);
		
		txtConsultaMatricula = new JTextField();
		txtConsultaMatricula.setBounds(194, 51, 86, 20);
		painelConsulta.add(txtConsultaMatricula);
		txtConsultaMatricula.setColumns(10);
		
		JLabel lblConsultaMatricula = new JLabel("Matrícula");
		lblConsultaMatricula.setBounds(138, 54, 46, 14);
		painelConsulta.add(lblConsultaMatricula);
		
		txtPaneConsulta = new JTextPane();
		txtPaneConsulta.setBounds(78, 82, 281, 136);
		painelConsulta.add(txtPaneConsulta);
		
		btnConsulta = new JButton("Consultar");
		btnConsulta.setBounds(369, 195, 89, 23);
		painelConsulta.add(btnConsulta);
		
		btnLimparTelaConsulta = new JButton("Limpar Tela Consulta");
		btnLimparTelaConsulta.setBounds(468, 195, 89, 23);
		painelConsulta.add(btnLimparTelaConsulta);

		JPanel painelPrincipal = new JPanel();
		painelPrincipal.setBackground(new Color(192, 192, 192));
		contentPane.add(painelPrincipal, "principal");

		ItemListener itemListenerHorista = new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				boolean isHoSelected = rbHorista.isSelected();
				txtSalarioBase.setEditable(!isHoSelected);
				txtSalarioBase.setText("");
			}
		};
		rbHorista.addItemListener(itemListenerHorista);
		
		ItemListener itemListenerDE = new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				boolean isDeSelected = rbDe.isSelected();
				txtValorHora.setEditable(!isDeSelected);
				txtHorasTrabalhadas.setEditable(!isDeSelected);
				txtValorHora.setText("");
				txtHorasTrabalhadas.setText("");
			}
		};
		rbDe.addItemListener(itemListenerDE);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("Lançamento")) {
			cardLayout.show(contentPane, "lancamento");
		} else if (e.getActionCommand().equals("Consulta")) {
			cardLayout.show(contentPane, "consulta");
		} else if (e.getActionCommand().equals("Principal")) {
			cardLayout.show(contentPane, "principal");
		}

	}

	public JTextField getTxtMatricula() {
		return txtMatricula;
	}

	public void setTxtMatricula(JTextField txtMatricula) {
		this.txtMatricula = txtMatricula;
	}

	public JTextField getTxtSalarioBase() {
		return txtSalarioBase;
	}

	public void setTxtSalarioBase(JTextField txtSalarioBase) {
		this.txtSalarioBase = txtSalarioBase;
	}

	public JTextField getTxtHorasTrabalhadas() {
		return txtHorasTrabalhadas;
	}

	public void setTxtHorasTrabalhadas(JTextField txtHorasTrabalhadas) {
		this.txtHorasTrabalhadas = txtHorasTrabalhadas;
	}

	public JTextField getTxtValorHora() {
		return txtValorHora;
	}

	public void setTxtValorHora(JTextField txtValorHora) {
		this.txtValorHora = txtValorHora;
	}

	public JTextField getTxtDataPagamento() {
		return txtDataPagamento;
	}

	public void setTxtDataPagamento(JTextField txtDataPagamento) {
		this.txtDataPagamento = txtDataPagamento;
	}

	public JTextField getTxtNome() {
		return txtNome;
	}

	public void setTxtNome(JTextField txtNome) {
		this.txtNome = txtNome;
	}

	public JRadioButton getRbDe() {
		return rbDe;
	}

	public void setRbDe(JRadioButton rbDe) {
		this.rbDe = rbDe;
	}

	public JRadioButton getRbHorista() {
		return rbHorista;
	}

	public void setRbHorista(JRadioButton rbHorista) {
		this.rbHorista = rbHorista;
	}

	public JButton getBtnCadastrar() {
		return btnCadastrar;
	}

	public void setBtnCadastrar(JButton btnCadastrar) {
		this.btnCadastrar = btnCadastrar;
	}

	public JButton getBtnLimparTela() {
		return btnLimparTela;
	}

	public void setBtnLimparTela(JButton btnLimparTela) {
		this.btnLimparTela = btnLimparTela;
	}

	public ButtonGroup getGrupoProfessores() {
		return grupoProfessores;
	}

	public void setGrupoProfessores(ButtonGroup grupoProfessores) {
		this.grupoProfessores = grupoProfessores;
	}

	public JTextField getTxtConsultaMatricula() {
		return txtConsultaMatricula;
	}

	public void setTxtConsultaMatricula(JTextField txtConsultaMatricula) {
		this.txtConsultaMatricula = txtConsultaMatricula;
	}

	public JTextPane getTxtPaneConsulta() {
		return txtPaneConsulta;
	}

	public void setTxtPaneConsulta(JTextPane txtPaneConsulta) {
		this.txtPaneConsulta = txtPaneConsulta;
	}

	public JButton getBtnConsulta() {
		return btnConsulta;
	}

	public void setBtnConsulta(JButton btnConsulta) {
		this.btnConsulta = btnConsulta;
	}

	public JButton getBtnLimparTelaConsulta() {
		return btnLimparTelaConsulta;
	}

	public void setBtnLimparTelaConsulta(JButton btnLimparTelaConsulta) {
		this.btnLimparTelaConsulta = btnLimparTelaConsulta;
	}
	
	
}