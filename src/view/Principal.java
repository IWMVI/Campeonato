package view;

import java.io.IOException;

import model.Funcoes;

public class Principal {
	public static void main(String[] args) throws IOException {
		Funcoes f = new Funcoes();
		Menu m = new Menu();
		
		do {
			m.showMenu();
			f.showFuncoes(m.getOpcao());
		} while(m.getOpcao() != 0);
	}
}
