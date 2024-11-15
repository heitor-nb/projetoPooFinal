package projetoPoo.Interfaces;

import java.util.ArrayList;

import projetoPoo.modelos.Carro;

public interface IRepositorioCarros{
	void Adicionar(Carro carro);
	ArrayList<Carro> Listar();
	Carro RecuperarPlaca(String placa);
	void Atualizar(Carro carro);
	void Remover(String placa);
}
