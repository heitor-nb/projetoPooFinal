package projetoPoo.Repositorios;

import java.util.ArrayList;

import projetoPoo.Interfaces.IRepositorioAluguel;
import projetoPoo.modelos.Aluguel;

public class RepositorioAluguel implements IRepositorioAluguel{
	
	private ArrayList<Aluguel> lista;
	
	public RepositorioAluguel() {
		lista = new ArrayList<Aluguel>();
	}

	private int Indice(String id) {
		var index = -1;
		for(int i = 0; i < lista.size(); i++) {
			if(lista.get(i).getID().equals(id)) {
				index = i;
				break;
			}
		}
		return index;
	}
	
	@Override
	public void Adicionar(Aluguel aluguel) {
		var index = Indice(aluguel.getID());
		if(index == -1) lista.add(aluguel);
	}

	@Override
	public ArrayList<Aluguel> Listar() {
		return lista;
	}

	@Override
	public Aluguel procurarPorId(String id) {
		var index = Indice(id);
		return index > -1 ? lista.get(index) : null; // *
	}

	@Override
	public void Atualizar(Aluguel aluguel) {
		var index = Indice(aluguel.getID());
		if(index > -1) {
			var aux = lista.get(index);
			aux.setCarro(aluguel.getCarro());
			aux.setCliente(aluguel.getCliente());
			aux.setDue(aluguel.getDue());
			aux.setFinalPrice(aluguel.getFinalPrice());
			aux.setTime(aluguel.getTime());
		}
		// else System.out.println("Não encontrado");
	}

	@Override
	public void Remover(String id) {
		var index = Indice(id);
		if(index > -1) lista.remove(index);
	}

}
