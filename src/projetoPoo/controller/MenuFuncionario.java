package projetoPoo.controller;

import java.util.Scanner;

import projetoPoo.Interfaces.IMenu;
import projetoPoo.enums.TipoDeCarro;
import projetoPoo.enums.TipoDeCombustivel;
import projetoPoo.enums.TipoDeTomada;
import projetoPoo.modelos.Aluguel;
import projetoPoo.modelos.Carro;
import projetoPoo.modelos.CarroCombustao;
import projetoPoo.modelos.CarroEletrico;
import projetoPoo.modelos.CarroHibrido;
import projetoPoo.modelos.Cliente;
import projetoPoo.modelos.Funcionario;
import projetoPoo.modelos.Locadora;
import projetoPoo.view.View;

public class MenuFuncionario implements IMenu{

	private Locadora locadora;
	
	public MenuFuncionario(Locadora locadora) {
		this.locadora = locadora;
	}
	
	@Override
	public void Executar(Funcionario funcionario) {
		View.MenuFuncionario();
		int option = -1;
		var scanner = new Scanner(System.in);
		
		try {
			do option = scanner.nextInt();
			while(option < 0 || option > 10);
		}
		catch(Exception ex) { // ?
			System.out.println(ex);
		}
		
		switch(option) {
		case 1:
			RegistrarLocacao(funcionario);
			break;
		case 2:
			RegistrarDevolucao();
			break;
		case 3:
			AdicionarCarro();
			break;
		case 4:
			AdicionarFuncionario();
			break;
		case 5:
			VerSaldo();
			break;
		case 6:
			CadastrarCliente();
			break;
		case 7:
			ListarFuncionarios();
			break;
		case 8:
			HistoricoLocacoes();
			break;
		case 9:
			ListarCarros();
			break;
		case 10:
			ListarClientes();
			break;
		case 0:
			option = -1;
			break;
		default:
			break;
		}
		if(option != -1) Executar(funcionario);
	}
	
	private void RegistrarLocacao(Funcionario funcionario) {
		
		
		var tipos = TipoDeCarro.values();
		var scanner = new Scanner(System.in);
		System.out.println("----- Tipo de carro -----");
		for(int i = 0; i < tipos.length; i++) {
			System.out.println(i + " - " + tipos[i]);
		}
		System.out.println("Digite a opção:");
		int option = 0;
		try {
			do option = scanner.nextInt();
			while(option < 0 || option >= tipos.length);
		}
		catch(Exception ex) {
			System.out.println(ex);
			return;
		}
		
		var lista = locadora.reposCarros.ListarPorTipo(tipos[option]);
		
		if(lista.size() == 0) {
			System.out.println("Nenhum carro disponivel.");
			System.out.println("Redirecionando para tela principal...\n(press enter)");
			scanner.nextLine();
			return;
		}
		
		for(int i = 0; i < lista.size(); i++) {
			var carro = lista.get(i);
			System.out.println(i + ". " + carro.getName() + " - " + carro.getPlaca() +
					" - Diária: R$" + carro.getValue());
		}
		
		System.out.println("Digite a opção:");
		option = -1;
		try {
			do option = scanner.nextInt();
			while(option < 0 || option >= tipos.length);
		}
		catch(Exception ex) {
			System.out.println(ex);
			return;
		}
		var carro = lista.get(option);
		System.out.println("Carro:");
		carro.ExibirDetalhes();
		if(locadora.reposClientes.Listar().size() == 0) {
			System.out.println("Nenhum Cliente cadastrado.");
			System.out.println("Redirecionando para tela de cadastro...\n(press enter)");
			scanner.nextLine();
			CadastrarCliente();
		}
		System.out.println("----- Cliente -----");
		System.out.println("Digite o CPF:");
		Cliente cliente = null;
		
		try {
			var cpf = scanner.next(); // *
			cliente = locadora.reposClientes.procurarPorCPF(cpf);
		}
		catch(Exception ex) {
			System.out.println(ex);
			return;
		}
		if(cliente == null) {
			System.out.println("Cliente não cadastrado.");
			System.out.println("Redirecionando para tela de cadastro...\n(press enter)");
			scanner.nextLine();
			CadastrarCliente();
		}
		else {
			System.out.println("Cliente: " + cliente.getName() + " - " + cliente.getCPF());
			System.out.println("Quantidade de diárias:");
			int diarias = 0;
			try {
				do diarias = scanner.nextInt();
				while(diarias < 1);
			}
			catch(Exception ex) {
				System.out.println(ex);
				return;
			}
			System.out.println("----- Resumo -----");
			System.out.println("Carro: " + carro.getName() +
					"\nCliente: " + cliente.getName() +
					"\nDiárias: " + diarias +
					"\nTotal: " + diarias*carro.getValue());
			System.out.println("Confirma: (0 - Não/ 1 - Sim)");
			try {
				do option = scanner.nextInt();
				while(option != 0 && option != 1);
			}
			catch(Exception ex) {
				System.out.println(ex.getMessage());
				return;
			}
			if(option == 0) System.out.println("Retornando...");
			else {
				var id = String.valueOf(locadora.reposAlugueis.Listar().size());
				var aluguel = new Aluguel(id, carro,
						cliente, funcionario, diarias, diarias*carro.getValue(), false);
				carro.setDisponivel(false);
				locadora.reposAlugueis.Adicionar(aluguel);
				System.out.println("Aluguel adicionado.\nId: " + id);
			}
		}
	}
	
	private void RegistrarDevolucao() { 
		System.out.println("Placa:");
		var scanner = new Scanner(System.in);
		String placa;
		try {
			placa = scanner.next(); // *
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			return;
		}
		var lista = locadora.reposAlugueis.ListarAtivos();
		var index = -1;
		for(int i = 0; i < lista.size(); i++) {
			if(lista.get(i).getCarro().getPlaca().equals(placa)) {
				index = i;
				break;
			}
		}
		if(index > -1) {
			lista.get(index).setDue(true);
			lista.get(index).getCarro().setDisponivel(true);
			System.out.println("Devolvido.\nId: " + lista.get(index).getID());
		}
		else System.out.println("Nenhum aluguel ativo com essa placa.");
	}
	
	private void AdicionarCarro() {
		try {
			var scanner = new Scanner(System.in);
			var tipos = TipoDeCarro.values();
			System.out.println("Tipo:");
			for(int i = 0; i < tipos.length; i++) {
				System.out.println(i + " - " + tipos[i]);
			}
			System.out.println("Digite a opção:");
			int option;
			do option = scanner.nextInt();
			while(option < 0 || option >= tipos.length);
			var tipo = tipos[option];
			System.out.println("Nome:");
			var nome = scanner.next();
			System.out.println("Placa:");
			var placa = scanner.next();
			System.out.println("Modelo:");
			var modelo = scanner.next();
			System.out.println("Marca:");
			var marca = scanner.next();
			System.out.println("Automático? (0 - Não/ 1 - Sim)");
			int automatico;
			do automatico = scanner.nextInt();
			while(automatico != 0 && automatico != 1);
			System.out.println("Diária:");
			var diaria = scanner.nextDouble();
			Carro carro;
			switch(tipo) {
			case Híbrido:
				carro = new CarroHibrido(nome, diaria, placa, modelo,
						automatico == 0 ? false : true, marca);
				break;
			case Combustao:
				var combustiveis = TipoDeCombustivel.values();
				System.out.println("Tipo de combústivel:");
				for(int i = 0; i < combustiveis.length; i++) {
					System.out.println(i + " - " + combustiveis[i]);
				}				
				System.out.println("Digite a opção:");
				do option = scanner.nextInt();
				while(option < 0 || option >= tipos.length);
				var combustivel = combustiveis[option];
				System.out.println("Tanque:");
				var tanque = scanner.nextInt();
				carro = new CarroCombustao(nome, diaria, placa, modelo,
						automatico == 0 ? false : true, combustivel, tanque, marca);
				break;
			case Elétrico:
				var tomadas = TipoDeTomada.values();
				System.out.println("Tipo de combústivel:");
				for(int i = 0; i < tomadas.length; i++) {
					System.out.println(i + " - " + tomadas[i]);
				}
				System.out.println("Digite a opção:");
				do option = scanner.nextInt();
				while(option < 0 || option >= tipos.length);
				var tomada = tomadas[option];
				System.out.println("Bateria:");
				var bateria = scanner.nextInt();
				carro = new CarroEletrico(nome, diaria, placa, modelo,
						automatico == 0 ? false : true, tomada, bateria,marca);
				break;
			default: // *
				carro = new CarroHibrido(nome, diaria, placa, modelo,
						automatico == 0 ? false : true,marca);
				break;
			}
			System.out.println("Confirma as informações? (0 - Não/ 1 - Sim)");
			carro.ExibirDetalhes();
			do option = scanner.nextInt();
			while(option != 0 && option != 1);
			if(option == 0) System.out.println("Retornando...");
			else {
				locadora.reposCarros.Adicionar(carro);
				System.out.println("Carro adicionado.\nPlaca: " + carro.getPlaca());
			}
		}
		catch(Exception ex) {
			System.out.println("Erro:" + ex.getMessage());
		}
	}
	
	private void AdicionarFuncionario() {
		try {
			var scanner = new Scanner(System.in);
			System.out.println("CPF:");
			var cpf = scanner.next();
			System.out.println("Nome:");
			var nome = scanner.next();
			System.out.println("Senha:");
			var senha = scanner.next();
			var funcionario = new Funcionario(nome, cpf, senha);
			System.out.println("Confirma as informações? (0 - Não/ 1 - Sim)");
			funcionario.ExibirDetalhes();
			int option;
			do option = scanner.nextInt();
			while(option != 0 && option != 1);
			if(option == 0) System.out.println("Retornando...");
			else {
				locadora.reposFuncionarios.Adicionar(funcionario);
				System.out.println("Funcionário adicionado.\nNome: " + funcionario.getName());
			}
		}
		catch(Exception ex) {
			System.out.println("Erro: " + ex.getMessage());
		}
	}
	
	private void VerSaldo() {
		var lista = locadora.reposAlugueis.ListarDevolvidos();
		var saldo = 0;
		for(int i = 0; i < lista.size(); i++) saldo += lista.get(i).getFinalPrice();
		System.out.println("Saldo total: " + saldo);
	}
	
	private void CadastrarCliente() {
		try {
			var scanner = new Scanner(System.in);
			System.out.println("CPF:");
			var cpf = scanner.next();
			Cliente cliente = locadora.reposClientes.procurarPorCPF(cpf);
			if(cliente == null) {
				System.out.println("Nome:");
				var nome = scanner.next();
				System.out.println("Confirma as informações? (0 - Não/ 1 - Sim)");
				System.out.println("CPF: " + cpf + "\nNome: " + nome);
				int option;
				do option = scanner.nextInt();
				while(option != 0 && option != 1);
				if(option == 0) System.out.println("Retornando...");
				else {
					var aux = new Cliente(nome, cpf);
					locadora.reposClientes.Adicionar(aux);
					System.out.println("Cliente adicionado.\nNome: " + aux.getName());
				}
			}
			else System.out.println("CPF já cadastrado.");
		}
		catch(Exception ex) {
			System.out.println("Erro:" + ex.getMessage());
		}
	}
	
	private void ListarFuncionarios() {
		var lista = locadora.reposFuncionarios.Listar();
		System.out.println("Funcionários:");
		for(int i = 0; i < lista.size(); i++) System.out.println(lista.get(i).getName() +
				" - " + lista.get(i).getCPF());
	}
	private void ListarClientes() {
		var lista = locadora.reposClientes.Listar();
		System.out.println("Clientes:");
		for(int i = 0; i < lista.size(); i++) System.out.println(lista.get(i).getName() +
				" - " + lista.get(i).getCPF());
	}
	
	private void HistoricoLocacoes() {
		var lista = locadora.reposAlugueis.ListarDevolvidos();
		if(lista.size() == 0) {
			System.out.println("Não há devoluções registradas");
		} else {
		System.out.println("Histórico de locações:");
		for(int i = 0; i < lista.size(); i++) {
			var aluguel = lista.get(i);
			System.out.println(aluguel.getID() + " - " + aluguel.getCarro().getName() +
					" - " + aluguel.getCliente().getName());
			}
		}
	}
	
	private void ListarCarros() { 
		var lista = locadora.reposCarros.Listar();
		System.out.println("Carros:");
		for(int i = 0; i < lista.size(); i++) {
			var carro = lista.get(i);
			System.out.println(carro.getPlaca() + " | " + carro.getName() +
					" - R$" + carro.getValue() + "/dia");
		}
	}
	
}


