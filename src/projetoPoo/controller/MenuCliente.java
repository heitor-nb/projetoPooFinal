package projetoPoo.controller;

import java.util.Scanner;

import projetoPoo.modelos.Cliente;
import projetoPoo.modelos.Locadora;
import projetoPoo.view.View;

public class MenuCliente{

	private Locadora locadora;
	
	public MenuCliente(Locadora locadora) {
		this.locadora = locadora;
	}
	
	public void Executar(Cliente cliente) {
		View.MenuCliente();
		int option = -1;
		var scanner = new Scanner(System.in);
		
		try {
			do option = scanner.nextInt();
			while(option < 0 || option > 1);
		}
		catch(Exception ex) {
			System.out.println("Erro: " + ex.getMessage());
			Executar(cliente);
		}
		
		switch(option) {
		case 1:
			ListarLocacoes(cliente.getCPF());
			break;
		case 0:
			option = -1;
			break;
		default:
			break;
		}
		if(option != -1) Executar(cliente);
	}
	
	private void ListarLocacoes(String cpf) {
		var lista = locadora.reposAlugueis.ListarPorCliente(cpf);
		if(lista.size() == 0) System.out.println("Nenhuma locação");
		else {
			System.out.println("Locações:");
			for(int i = 0; i < lista.size(); i++) {
				var aux = lista.get(i);
				System.out.println(aux.getCarro().getName() + " - " +
						aux.getTime() + "dias - Valor total: " + aux.getFinalPrice() +
						" - Ativo: " + !aux.getDue());
			}
		}
	}

}
