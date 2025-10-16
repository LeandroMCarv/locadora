package prova;

import java.io.*;
import java.util.*;

public class Locadora {
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private ArrayList<Dvd> dvds = new ArrayList<Dvd>();
	private ArrayList<Locacao> locacoes = new ArrayList<Locacao>();
	private ArrayList<Genero> generos = new ArrayList<Genero>();
	public ArrayList<Genero> getGeneros() {
		return generos;
	}
	public void setGeneros(ArrayList<Genero> generos) {
		this.generos = generos;
	}
	public ArrayList<Cliente> getClientes() {
		return clientes;
	}
	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}
	public ArrayList<Dvd> getDvds() {
		return dvds;
	}
	public void setDvds(ArrayList<Dvd> dvds) {
		this.dvds = dvds;
	}
	public ArrayList<Locacao> getLocacoes() {
		return locacoes;
	}
	public void setLocacoes(ArrayList<Locacao> locacoes) {
		this.locacoes = locacoes;
	}
	public Locadora() {
		this.clientes = new ArrayList<Cliente>();
		this.dvds = new ArrayList<Dvd>();
		this.locacoes = new ArrayList<Locacao>();
		this.generos = new ArrayList<Genero>();
	}
	
	public void cadastraCliente() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Informe o cpf do cliente: ");
		int cpf = sc.nextInt();
		sc.nextLine();
		System.out.println("Informe o nome do cliente: ");
		String nome = sc.nextLine();
		System.out.println("Informe o sexo: ");
		char sexo = sc.next().charAt(0);
		System.out.println("Data de nascimento: ");
		int data = sc.nextInt();
		Cliente cliente = new Cliente(cpf,nome,sexo,data);
		clientes.add(cliente);
	}
	
	public Cliente consultaCliente(int cpf) {
		for(Cliente cliente:clientes) {
			if(cliente.getCpf()==cpf) {
				return cliente;
			}
		}
		return null;
	}
	
	public Cliente consultaCliente(String nome) {
		for(Cliente cliente:clientes) {
			if(cliente.getNome().equals(nome)) {
				return cliente;
			}
		}
		return null;
	}
	
	public Dvd consultaDvd(int codigo) {
		for(Dvd dvd:dvds) {
			if(dvd.getCodigo()==codigo) {
				return dvd;
			}
		}
		return null;
	}
	
	public Dvd consultaDvd(String nome) {
		for(Dvd dvd:dvds) {
			if(dvd.getNome().equals(nome)) {
				return dvd;
			}
		}
		return null;
	}
	
	public void consultaDvdGenero(int codigo) {
		for(Dvd dvd:dvds) {
			if(dvd.getGenero().getCodigo()==codigo) {
				System.out.println(dvd.getNome()+"\n"+dvd.getCodigo());
			}
		}
	}
	
	public void cadastraDvd() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Informe o nome: ");
		String nome = sc.next();
		System.out.println("Informe o codigo do dvd: ");
		int codigo = sc.nextInt();
		listaGeneros();
		System.out.println("Informe o codigo do generos que o filme se enquadra: ");
		int codGenero=sc.nextInt();
		Genero genFilme=null;
		for(Genero g:generos) {
			if(codGenero==g.getCodigo()) {
				genFilme=g;
			}
		}
		if(genFilme!=null) {
			dvds.add(new Dvd(nome,genFilme,codigo));
		}
		else {
			System.out.println("Nao foi possivel cadastrar o Dvd");
		}
	}
	
	public void cadastraGenero() {
		generos.add(new Genero(1,"Terror"));
		generos.add(new Genero(2,"Comedia"));
		generos.add(new Genero(3,"Acao"));
		generos.add(new Genero(4,"Ficcao"));
		generos.add(new Genero(5,"Drama"));
		generos.add(new Genero(6,"Infantil"));
		generos.add(new Genero(7,"Suspense"));
	}
	
	public void listaGeneros() {
		System.out.println("Generos disponiveis:");
		for(Genero genero:generos) {
			System.out.println(genero.getCodigo()+"="+genero.getDescricao()+"\n");
		}
	}
	
	public boolean locaDvd() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Informe o cpf do cliente: ");
		int cpf = sc.nextInt();
		Cliente a = consultaCliente(cpf);
		if(a!=null) {
			System.out.println("Dvds disponiveis: ");
			for(Dvd dvd:dvds) {
				System.out.println(dvd.getCodigo()+"->"+dvd.getGenero().getDescricao()+"|"+dvd.getNome());
			}
			System.out.println("Informe o codigo do dvd desejado: ");
			int codFilme = sc.nextInt();
			for(Dvd dvd:dvds) {
				if(dvd.getCodigo()==codFilme) {
					System.out.println("Informe a data de retirada: ");
					int dataRetirada = sc.nextInt();
					Locacao locacao = new Locacao(dvd,a,dataRetirada,0);
					locacoes.add(locacao);
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean devolveDvd() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Informe o cpf do cliente: ");
		int cpf = sc.nextInt();
		Cliente a = consultaCliente(cpf);
		if(a!=null) {
			for(Locacao loc:locacoes) {
				if(a==loc.getCliente()) {
					System.out.println("Informe a data de devolucao");
					int dataDevolucao = sc.nextInt();
					loc.setDataDevolucao(dataDevolucao);
					return true;
				}
			}
		}
		return false;
	}
	
	public void consultarDvdsNaoDevolvidos() {
		for(Locacao loc:locacoes) {
			if(loc.getDataDevolucao()==0) {
				System.out.println(loc.getDvd().getNome()+"\n"+loc.getDvd().getCodigo());
			}
		}
	}
	
	public void consultarClientesComFilmeAlocado() {
		for(Locacao loc:locacoes) {
			if(loc.getDataDevolucao()==0) {
				System.out.println(loc.getCliente().getNome()+"\n"+loc.getCliente().getCpf());
			}
		}
	}
	
	public void consultarFilmesAlocadosPorCliente(int cpf) {
		Cliente x = consultaCliente(cpf);
		if(x!=null) {
			for(Locacao l:locacoes) {
				if(l.getCliente().getCpf()==cpf) {
					System.out.println(l.getDvd().getNome()+"\n"+l.getDvd().getGenero().getDescricao());
				}
			}
		}
		else {
			System.out.println("Cliente nao encontrado");
		}
	}
	
	public void listarLocacoes(int dataInicial,int dataFinal) {
		for(Locacao l:locacoes) {
			if(l.getDataLocacao()>=dataInicial && l.getDataDevolucao()<=dataFinal) {
				System.out.println(l.getCliente().getNome()+"--"+l.getDvd().getNome());
			}
		}
	}
	public void CriaArquivo() {
		try {
			File arquivo = new File("a.txt");
		} catch (Exception e) {
			System.out.println("Ocorreu um erro");
			e.printStackTrace();
		}
	}
	public void EscreveArquivo() {
		try {
			FileWriter escritor = new FileWriter("a.txt");
			for(Cliente cliente:clientes) {
				escritor.write(cliente.getNome()+" "+cliente.getCpf()+" "+cliente.getData()+" "+cliente.getSexo());
				escritor.write(cliente.listaDependentes());
			}
			escritor.close();
		} catch (Exception e) {
			System.out.println("Ocorreu um erro");
			e.printStackTrace();
		}
	}
}
