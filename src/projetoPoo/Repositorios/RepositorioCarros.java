package projetoPoo.Repositorios;

import java.util.ArrayList;

import projetoPoo.Interfaces.IRepositorioCarros;
import projetoPoo.modelos.Carro;

public class RepositorioCarros implements IRepositorioCarros{
	
	private ArrayList<Carro> lista;
	
	public RepositorioCarros() {
		lista = new ArrayList<Carro>();
	}

	private int Indice(String placa) {
		var index = -1;
		for(int i = 0; i < lista.size(); i++) {
			if(lista.get(i).getPlaca().equals(placa)) {
				index = i;
				break;
			}
		}
		return index;
	}
	
	@Override
	public void Adicionar(Carro carro) {
		var index = Indice(carro.getPlaca());
		if(index == -1) lista.add(carro);
	}

	@Override
	public ArrayList<Carro> Listar() {
		return lista;
	}

	@Override
	public Carro RecuperarPlaca(String placa) {
		var index = Indice(placa);
		return index > -1 ? lista.get(index) : null; // *
	}

	@Override
	public void Atualizar(Carro carro) {
		var index = Indice(carro.getPlaca());
		if(index > -1) {
			var aux = lista.get(index);
			aux.setName(carro.getName());
			aux.setValue(carro.getValue());
			// aux.setPlaca(carro.getPlaca());
			aux.setModelo(carro.getModelo());
			aux.setAutomatico(carro.getAutomatico());
		}
		// else System.out.println("Não encontrado");
	}

	@Override
	public void Remover(String placa) {
		var index = Indice(placa);
		if(index > -1) lista.remove(index);
	}

}
