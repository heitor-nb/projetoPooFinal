package projetoPoo.Interfaces;

import java.util.ArrayList;

import projetoPoo.modelos.Aluguel;


public interface IRepositorioAluguel {
	void Adicionar(Aluguel aluguel);
	ArrayList<Aluguel> Listar();
	Aluguel procurarPorId(String id)                                                    ;
	void Atualizar(Aluguel aluguel);
	void Remover(String id);
}
