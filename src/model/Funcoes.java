package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

import entities.Times;

public class Funcoes {

	Times[] time = new Times[3];

	public void showFuncoes(int opcao) throws IOException {
		switch (opcao) {
		case 0:
			JOptionPane.showMessageDialog(null, "Finalizado!");
			break;

		case 1:
			for (int i = 0; i < time.length; i++) {
				String name = JOptionPane.showInputDialog(null, "Informe o nome do " + (i + 1) + "º time");
				int golsMarcados = Integer
						.parseInt(JOptionPane.showInputDialog("Informe a quantidade de gols marcados"));
				int golsSofridos = Integer
						.parseInt(JOptionPane.showInputDialog("Informe a quantidade de gols sofridos"));
				int vitorias = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de vitórias"));
				int empates = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de empates"));
				int derrotas = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de derrotas"));
				int pontos = (vitorias * 3) + (empates);
				time[i] = new Times(name, golsMarcados, golsSofridos, vitorias, empates, derrotas, pontos);
			}
			break;
		// Classificação
		case 2:
			for (int i = 0; i < time.length; i++) {
				for (int j = i + 1; j < time.length; j++) {
					if (time[j].getPontos() > time[i].getPontos()) {
						Times aux = time[j];
						time[j] = time[i];
						time[i] = aux;
					} else if (time[j].getPontos() == time[i].getPontos()) {
						if (time[j].getSaldoGols() > time[i].getSaldoGols()) {
							Times aux = time[j];
							time[j] = time[i];
							time[i] = aux;
						}
					} else if (time[j].getSaldoGols() == time[i].getSaldoGols()) {
						if (time[j].getGolsMarcados() > time[i].getGolsMarcados()) {
							Times aux = time[j];
							time[j] = time[i];
							time[i] = aux;
						}
					} else if (time[j].getGolsMarcados() == time[i].getGolsMarcados()) {
						if (time[j].getGolsSofridos() > time[i].getGolsSofridos()) {
							Times aux = time[j];
							time[j] = time[i];
							time[i] = aux;
						}
					}
				}
			}

			System.out.println("Classificação\n");
			for (int i = 0; i < time.length; i++) {
				System.out.println((i + 1) + "º " + time[i].getName());
				System.out.println("Vitórias: " + time[i].getVitorias());
				System.out.println("Empates: " + time[i].getEmpates());
				System.out.println("Derrotas: " + time[i].getDerrotas());
				System.out.println("Gols Marcados: " + time[i].getGolsMarcados());
				System.out.println("Gols Sofridos: " + time[i].getGolsSofridos());
				System.out.println("Saldo de Gols: " + time[i].getSaldoGols());
				System.out.println("Pontos: " + time[i].getPontos());
				System.out.println();
			}
			break;
		// Gravação
		case 3:
			try {
				String nome = JOptionPane.showInputDialog("Informe o nome do arquivo para salvar");
				BufferedWriter escrita = new BufferedWriter(new FileWriter(nome + ".txt"));
				for (int i = 0; i < time.length; i++) {
					escrita.write(time[i].getName() + "\n");
					escrita.write(time[i].getVitorias() + "\n");
					escrita.write(time[i].getEmpates() + "\n");
					escrita.write(time[i].getDerrotas() + "\n");
					escrita.write(time[i].getGolsMarcados() + "\n");
					escrita.write(time[i].getGolsSofridos() + "\n");
					escrita.write(time[i].getPontos() + "\n");
					escrita.newLine();
				}

				escrita.close();
				JOptionPane.showMessageDialog(null, "Arquivo " + nome + " gravado com sucesso!");
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Erro ao gravar arquivo!");
			}

			break;

		case 4:
			try {
				String n = JOptionPane.showInputDialog("Informe o nome do arquivo.");
				BufferedReader leitura = new BufferedReader(new FileReader(n + ".txt"));
				Times[] atual = new Times[3];
				for (int i = 0; i < atual.length; i++) {
					atual[i] = new Times();
					atual[i].setName(leitura.readLine());
					atual[i].setVitorias(Integer.parseInt(leitura.readLine()));
					atual[i].setEmpates(Integer.parseInt(leitura.readLine()));
					atual[i].setDerrotas(Integer.parseInt(leitura.readLine()));
					atual[i].setGolsMarcados(Integer.parseInt(leitura.readLine()));
					atual[i].setGolsSofridos(Integer.parseInt(leitura.readLine()));
					atual[i].setPontos(Integer.parseInt(leitura.readLine()));
					leitura.readLine();
				}

				leitura.close();
				time = atual;
				JOptionPane.showInternalMessageDialog(null, "Arquivo " + n + " carregado com sucesso!");
			} catch (IOException e) {  
				JOptionPane.showMessageDialog(null, "Erro ao ler arquivo");
			}
			break;

		default:
			JOptionPane.showMessageDialog(null, "Opção Inválida!");
			break;
		}
	}
}
