package projetoPoo.menus;

import java.util.ArrayList;
import java.util.Scanner;

import projetoPoo.Interfaces.IMenu;
import projetoPoo.modelos.Locadora;

public class MenuInicial implements IMenu{

	private Locadora locadora;
	private MenuFuncionario menuFuncionario;
	
	public MenuInicial(Locadora locadora) {
		this.locadora = locadora;
		menuFuncionario = new MenuFuncionario(locadora);
	}
	
	@Override
	public void Executar() { // *
		System.out.println("Locadora do tigrinho.\n");
		var scanner = new Scanner(System.in);
		System.out.println("1 - Login / 0 - Sair");
		int opcao;
		do opcao = scanner.nextInt();
		while(opcao < 0 || opcao > 1);
		if(opcao != 0) Login(scanner);
	}
	
	private void Login(Scanner scanner) {
		System.out.println("Nome:");
		var nome = scanner.nextLine();
		var funcionario = locadora.reposFuncionario.RecuperarNome(nome);
		if(funcionario != null) {
			System.out.println("Bem-vindo(a) " + nome + "\nSenha:");
			var senha = scanner.nextLine();
			if(senha.equals(funcionario.getSenha())) menuFuncionario.Executar(funcionario);
			else System.out.println("Senha incorreta.");
		}
		else {
			System.out.println("Nome não encontrado.");
		}
		Executar();
	}
	
}
