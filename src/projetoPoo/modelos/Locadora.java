package projetoPoo.modelos;

import projetoPoo.Repositorios.*;

public class Locadora {
	public RepositorioAluguel reposAlugueis = new RepositorioAluguel();
	public RepositorioCarros reposCarros = new RepositorioCarros();
	public RepositorioClientes reposClientes = new RepositorioClientes();
	public RepositorioFuncionario reposFuncionarios = new RepositorioFuncionario();
	
	public Locadora() {
		reposFuncionarios.Adicionar(new Funcionario("admin", "XXXXXXXXXXX", "admin"));
	}
}
