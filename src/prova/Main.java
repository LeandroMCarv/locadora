package prova;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Locadora locadora = new Locadora();
		int op;
		do {
		menu();
		op = sc.nextInt();
		switch(op) {
		case 0:
			System.out.println("Saindo...");
			break;
		case 1:
			locadora.cadastraCliente();
			break;
		case 2:
			System.out.println("Informe o cpf do Cliente: ");
			int cpf = sc.nextInt();
			Cliente clienteBuscado = locadora.consultaCliente(cpf);
			if(clienteBuscado!=null) {
				clienteBuscado.cadastrarDependetes();
			}
			else {
				System.out.println("Cliente nao encontrado...");
			}
			break;
		case 3:
			locadora.cadastraDvd();
			break;
		case 4:
			locadora.cadastraGenero();
			break;
		case 5:
			if(locadora.locaDvd()) {
				System.out.println("Dvd locado");
			}
			else {
				System.out.println("Dvd nao pode ser alocado");
			}
			break;
		case 6:
			if(locadora.devolveDvd()) {
				System.out.println("Dvd devolvido com sucesso");
			}
			else {
				System.out.println("Falha na devolucao");
			}
			break;
		case 7:
			System.out.println("Informe o cpf do cliente: ");
			cpf = sc.nextInt();
			Cliente teste = locadora.consultaCliente(cpf);
			if(teste!=null) {
				System.out.println(teste.getNome()+"\n"+teste.getCpf());
			}
			else {
				System.out.println("Cliente nao enncontrado");
			}
			break;
		case 8:
			System.out.println("Informe o nome do cliente: ");
			String nome = sc.next();
			teste = locadora.consultaCliente(nome);
			if(teste!=null) {
				System.out.println(teste.getNome()+"\n"+teste.getCpf());
			}
			else {
				System.out.println("Cliente nao enncontrado");
			}
			break;
		case 9:
			System.out.println("Informe o codigo do Dvd: ");
			int codFilme = sc.nextInt();
			Dvd a = locadora.consultaDvd(codFilme);
			if(a!=null) {
				System.out.println(a.getCodigo()+"\n"+a.getNome()+"\n"+a.getGenero().getDescricao());
			}
			break;
		case 10:
			System.out.println("Informe o titulo do Dvd: ");
			String titulo = sc.next();
			a = locadora.consultaDvd(titulo);
			if(a!=null) {
				System.out.println(a.getCodigo()+"\n"+a.getNome()+"\n"+a.getGenero().getDescricao());
			}
			break;
		case 11:
			System.out.println("Informe o codigo do genero do Dvd escolhido: ");
			int codGenero = sc.nextInt();
			locadora.consultaDvdGenero(codGenero);
			break;
		case 12:
			locadora.consultarDvdsNaoDevolvidos();
			break;
		case 13:
			locadora.consultarClientesComFilmeAlocado();
			break;
		case 14:
			System.out.println("Informe o cpf do Cliente: ");
			cpf = sc.nextInt();
			locadora.consultarFilmesAlocadosPorCliente(cpf);
			break;
		case 15:
			System.out.println("Informe a data inicial: ");
			int dataInicial = sc.nextInt();
			System.out.println("Informe a data final: ");
			int dataFinal = sc.nextInt();
			locadora.listarLocacoes(dataInicial, dataFinal);
			break;
		default:
			System.out.println("Opcao invalida!");
		}
		}while(op!=0);
	}
	public static void menu() {
		System.out.println("\tMENU:\n0-Sair\n1-Cadastrar Cliente\n2-Cadastrar Dependente\n3-Cadastrar Dvd\n4-Cadastrar Genero\n5-Locar Dvd\n6-Devolver Dvd\n"
				+ "7-Consultar Cliente pelo Cpf\n8-Consultar Cliente pelo Nome\n9-Consultar Dvd pelo Codigo\n10-Consultar Dvd pelo Titulo\n11-Consultar Dvds"
				+ " pelo genero\n12-Consultar Dvds locados que ainda nao foram devolvidos\n13-Consultar clientes que estao com Filmes Locados\n14-Consultar"
				+ " Filmes ja alugados Por um Determinado Cliente\n15-Listar as locacoes\nOpcao Desejada:");
	}
}