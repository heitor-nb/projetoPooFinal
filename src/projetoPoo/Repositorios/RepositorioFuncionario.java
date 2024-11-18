package projetoPoo.Repositorios;

import java.util.ArrayList;

import projetoPoo.Interfaces.IRepositorioFuncionario;
import projetoPoo.modelos.Funcionario;

public class RepositorioFuncionario implements IRepositorioFuncionario {
	
	private ArrayList<Funcionario> lista;
	
	public RepositorioFuncionario() {
		lista = new ArrayList<Funcionario>();
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
	public void Adicionar(Funcionario funcionario) {
		var index = Indice(funcionario.getCPF()); // Fazer essa verificacao em repos carros
		if(index == -1) lista.add(funcionario);
	}

	@Override
	public ArrayList<Funcionario> Listar() {
		return lista;
	}

	@Override
	public Funcionario procurarPorCPF(String cpf) {
		var index = Indice(cpf);
		return index > -1 ? lista.get(index) : null;
	}

	@Override
	public void Atualizar(Funcionario funcionario) {
		var index = Indice(funcionario.getCPF());
		if(index > -1) {
			var aux = lista.get(index);
			aux.setName(funcionario.getName());
			aux.setSenha(funcionario.getSenha());
		}
	}

	@Override
	public void Remover(String cpf) {
		var index = Indice(cpf);
		if(index > -1) lista.remove(index);
	}
}
