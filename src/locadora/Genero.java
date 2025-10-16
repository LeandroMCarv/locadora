package prova;

public class Genero {
	private int codigo;
	private String descricao;
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Genero(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
}
