package view;

import javax.swing.JOptionPane;

public class Menu {
	private int opcao;

	public int getOpcao() {
		return opcao;
	}

	public void showMenu() {
		opcao = Integer.parseInt
				(JOptionPane.showInputDialog
						("MENU\n01. Registrar Time\n02. Classificação\n03. Gravar Dados\n04. Ler Dados\n00. Finalizar"));
	}
}
