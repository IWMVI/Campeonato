package entities;

public class Times {

	private String name;
	private int golsMarcados;
	private int golsSofridos;
	private int vitorias;
	private int empates;
	private int derrotas;
	private int pontos;
	
	public Times() {
		
	}
	
	public Times(String name, int golsMarcados, int golsSofridos, int vitorias, int empates, int derrotas, int pontos) {
		this.name = name;
		this.golsMarcados = golsMarcados;
		this.golsSofridos = golsSofridos;
		this.vitorias = vitorias;
		this.empates = empates;
		this.derrotas = derrotas;
		this.pontos = pontos;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGolsMarcados() {
		return golsMarcados;
	}

	public void setGolsMarcados(int golsMarcados) {
		this.golsMarcados = golsMarcados;
	}

	public int getGolsSofridos() {
		return golsSofridos;
	}

	public void setGolsSofridos(int golsSofridos) {
		this.golsSofridos = golsSofridos;
	}

	public int getVitorias() {
		return vitorias;
	}

	public void setVitorias(int vitorias) {
		this.vitorias = vitorias;
	}

	public int getEmpates() {
		return empates;
	}

	public void setEmpates(int empates) {
		this.empates = empates;
	}

	public int getDerrotas() {
		return derrotas;
	}

	public void setDerrotas(int derrotas) {
		this.derrotas = derrotas;
	}

	public int getPontos() {
		return pontos;
	}

	public void setPontos(int pontos) {
		this.pontos = pontos;
	}

	public int getSaldoGols() {
		return golsMarcados - golsSofridos;
	}
}
