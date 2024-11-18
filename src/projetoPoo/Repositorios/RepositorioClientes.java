package projetoPoo.Repositorios;

import java.util.ArrayList;

import projetoPoo.Interfaces.IRepositorioClientes;
import projetoPoo.modelos.Cliente;

public class RepositorioClientes implements IRepositorioClientes {
	
	private ArrayList<Cliente> lista;
	
	public RepositorioClientes() {
		lista = new ArrayList<Cliente>();
	}

	private int Indice(String cpf) {
		var index = -1;
		for(int i = 0; i < lista.size(); i++) {
			if(lista.get(i).getCPF().equals(cpf)) {
				index = i;
				break;
			}
		}
		return index;
	}

	@Override
	public void Adicionar(Cliente cliente) {
		var index = Indice(cliente.getCPF()); // Fazer essa verificacao em repos carros
		if(index == -1) lista.add(cliente);
	}

	@Override
	public ArrayList<Cliente> Listar() {
		return lista;
	}

	@Override
	public Cliente procurarPorCPF(String cpf) {
		var index = Indice(cpf);
		return index > -1 ? lista.get(index) : null;
	}

	@Override
	public void Atualizar(Cliente cliente) {
		var index = Indice(cliente.getCPF());
		if(index > -1) {
			var aux = lista.get(index);
			aux.setName(cliente.getName());
			aux.setAlugou(cliente.getAlugou());
		}
	}

	@Override
	public void Remover(String cpf) {
		var index = Indice(cpf);
		if(index > -1) lista.remove(index);
	}
}
