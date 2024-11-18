package projetoPoo.Interfaces;

import java.util.ArrayList;

import projetoPoo.enums.TipoDeCarro;
import projetoPoo.modelos.Carro;

public interface IRepositorioCarros{
	void Adicionar(Carro carro);
	ArrayList<Carro> Listar();
	ArrayList<Carro> ListarPorTipo(TipoDeCarro tipo);
	Carro RecuperarPlaca(String placa);
	void Atualizar(Carro carro);
	void Remover(String placa);
}
