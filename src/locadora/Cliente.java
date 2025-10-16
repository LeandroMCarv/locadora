package prova;

import java.util.*;

public class Cliente extends PessoaFisica{
	private ArrayList<Dependente> dependentes;
	
	public ArrayList<Dependente> getDependentes() {
		return dependentes;
	}

	public void setDependentes(ArrayList<Dependente> dependentes) {
		this.dependentes = dependentes;
	}

	public Cliente(int cpf, String nome, char sexo, int data) {
		super(cpf, nome, sexo, data);
		this.dependentes = new ArrayList<Dependente>();
	}
	
	public void cadastrarDependetes() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Informe o cpf do dependente: ");
		int cpf = sc.nextInt();
		sc.nextLine();
		System.out.println("Informe o nome do dependente: ");
		String nome = sc.nextLine();
		System.out.println("Informe o sexo do dependente: ");
		char sexo = sc.next().charAt(0);
		System.out.println("Data de nascimento do dependente: ");
		int data = sc.nextInt();
		Dependente dependente = new Dependente(cpf,nome,sexo,data);
		dependentes.add(dependente);
	}
	
	public String listaDependentes() {
		String linha="";
		if(dependentes.size()!=0) {
			for(Dependente d:dependentes) {
				linha += d.getNome()+" "+d.getCpf()+" "+d.getData()+" "+d.getSexo()+"\n";
			}
			return linha;
		}
		return null;
	}
}
