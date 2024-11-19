package projetoPoo.controller;

import java.util.Scanner;

import projetoPoo.modelos.Locadora;

public class Controller{ 

	private Locadora locadora;
	private MenuFuncionario menuFuncionario;
	private MenuCliente menuCliente;
	
	public Controller(Locadora locadora) {
		this.locadora = locadora;
		menuFuncionario = new MenuFuncionario(locadora);
		menuCliente = new MenuCliente(locadora);
	}
	
	public void MenuInicial() { 
		try {
			System.out.println("Locadora do tigrinho.\n"
					+ "2 - Cliente / 1 - Funcionário / 0 - Sair");
			var scanner = new Scanner(System.in);
			int menu;
			do menu = scanner.nextInt();
			while(menu < 0 || menu > 2);
			if(menu == 2 && locadora.reposClientes.Listar().size() == 0) {
				System.out.println("Nenhum cliente cadastrado.\nRetornando...");
				MenuInicial();
			}
			if(menu != 0) Login(scanner, menu);
		}
		catch(Exception ex) {
			System.out.println("Erro: " + ex.getMessage());
			MenuInicial();
		}
	}
	
	private void Login(Scanner scanner, int menu) {
		System.out.println("Nome:");
		var nome = scanner.next();
		if(menu == 1) {
			var funcionario = locadora.reposFuncionarios.ProcurarPorNome(nome);
			if(funcionario != null) {
				System.out.println("Bem-vindo(a) " + nome + "\nSenha:");
				var senha = scanner.next();
				if(senha.equals(funcionario.getSenha())) menuFuncionario.Executar(funcionario);
				else System.out.println("Senha incorreta.");
			}
			else {
				System.out.println("Nome não encontrado.");
			}
			MenuInicial();
		}
		else {
			var cliente = locadora.reposClientes.ProcurarPorNome(nome);
			if(cliente != null) {
				System.out.println("Bem-vindo(a) " + nome + "\nCPF:");
				var cpf = scanner.next();
				if(cpf.equals(cliente.getCPF())) menuCliente.Executar(cliente);
				else System.out.println("Senha incorreta.");
			}
			else {
				System.out.println("Nome não encontrado.");
			}
			MenuInicial();
		}
	}
	
}
