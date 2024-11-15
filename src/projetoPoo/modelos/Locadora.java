package projetoPoo.modelos;

import java.util.ArrayList;
import projetoPoo.Repositorios.*;

public class Locadora {
	private ArrayList<Aluguel> alugueis = new ArrayList<Aluguel>(); 
	private ArrayList<Carro> carros = new ArrayList<Carro>();
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
	// public RepositorioAlugueis reposAlugueis;
	public RepositorioCarros reposCarros;
	public RepositorioClientes reposClientes;
	// public RepositorioFuncionarios reposFuncionarios;
}
