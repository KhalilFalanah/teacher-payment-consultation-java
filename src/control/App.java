package control;

import model.Professor;
import view.JanelaPrincipal;

public class App {
	public static void main(String[] args) {
		JanelaPrincipal jan = new JanelaPrincipal();
		jan.setVisible(true);
		Professor p = new Professor();
		PagamentosController pag = new PagamentosController(jan);
	}
}
