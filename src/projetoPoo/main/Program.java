package projetoPoo.main;

import projetoPoo.controller.Controller;
import projetoPoo.modelos.Locadora;

public class Program {
	public static void main(String[] args) {
		System.out.println("Hello, world!");
		var controller = new Controller(new Locadora());
		controller.MenuInicial();
	}
}
