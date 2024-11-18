package projetoPoo.Interfaces;

import java.util.ArrayList;

import projetoPoo.modelos.Funcionario;

public interface IRepositorioFuncionario  {
	void Adicionar(Funcionario funcionario);
	ArrayList<Funcionario> Listar();
	Funcionario procurarPorCPF(String cpf)                                                    ;
	void Atualizar(Funcionario funcionario);
	void Remover(String cpf);
}
