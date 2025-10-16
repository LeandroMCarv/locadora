package prova;

import java.util.Date;

public class PessoaFisica {
	private int cpf;
	private String nome;
	private char sexo;
	private int data;
	public int getCpf() {
		return cpf;
	}
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public PessoaFisica(int cpf, String nome, char sexo, int data) {
		this.cpf = cpf;
		this.nome = nome;
		this.sexo = sexo;
		this.data = data;
	}
	public PessoaFisica() {
		super();
	}
}
