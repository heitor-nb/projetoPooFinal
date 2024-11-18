package projetoPoo.controller;

import java.util.Scanner;

import projetoPoo.modelos.Locadora;

public class Controller{ // Tratar erros

	private Locadora locadora;
	private MenuFuncionario menuFuncionario;
	
	public Controller(Locadora locadora) {
		this.locadora = locadora;
		menuFuncionario = new MenuFuncionario(locadora);
	}
	
	public void MenuInicial() { // *
		try {
			System.out.println("Locadora do tigrinho.\n");
			var scanner = new Scanner(System.in);
			System.out.println("1 - Login / 0 - Sair");
			int opcao;
			do opcao = scanner.nextInt();
			while(opcao < 0 || opcao > 1);
			if(opcao != 0) Login(scanner);
		}
		catch(Exception ex) {
			System.out.println("Erro: " + ex.getMessage());
			MenuInicial();
		}
	}
	
	private void Login(Scanner scanner) {
		System.out.println("Nome:");
		var nome = scanner.next();
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
	
}
