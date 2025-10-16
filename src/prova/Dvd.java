package prova;

public class Dvd {
	private String nome;
	private Genero genero;
	private int codigo;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Genero getGenero() {
		return genero;
	}
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Dvd(String nome, Genero genero, int codigo) {
		this.nome = nome;
		this.genero = genero;
		this.codigo = codigo;
	}
}
