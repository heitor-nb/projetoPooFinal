package projetoPoo.Interfaces;

import java.util.ArrayList;
import projetoPoo.modelos.Cliente;

public interface IRepositorioClientes {
	void Adicionar(Cliente cliente);
	ArrayList<Cliente> Listar();
	Cliente RecuperarPlaca(String cpf);
	void Atualizar(Cliente cliente);
	void Remover(String cpf);
}
