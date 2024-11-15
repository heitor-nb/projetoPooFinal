package projetoPoo.menus;

import projetoPoo.Interfaces.IMenu;
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
	}
	
}
