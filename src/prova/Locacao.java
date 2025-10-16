package prova;

import java.util.*;

public class Locacao {
	private Dvd dvd;
	private Cliente cliente;
	private int dataLocacao;
	private int dataDevolucao;
	public Dvd getDvd() {
		return dvd;
	}
	public void setDvd(Dvd dvd) {
		this.dvd = dvd;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public int getDataLocacao() {
		return dataLocacao;
	}
	public void setDataLocacao(int dataLocacao) {
		this.dataLocacao = dataLocacao;
	}
	public int getDataDevolucao() {
		return dataDevolucao;
	}
	public void setDataDevolucao(int dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
	public Locacao(Dvd dvd, Cliente cliente, int dataLocacao, int dataDevolucao) {
		this.dvd = dvd;
		this.cliente = cliente;
		this.dataLocacao = dataLocacao;
		this.dataDevolucao = dataDevolucao;
	}
	
}
