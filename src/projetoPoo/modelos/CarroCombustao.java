package projetoPoo.modelos;

import projetoPoo.enums.TipoDeCarro;
import projetoPoo.enums.TipoDeCombustivel;

public class CarroCombustao extends Carro {
	
	private TipoDeCarro tipo;
	private TipoDeCombustivel combustivel;
	private int tanque;
	
	CarroCombustao (String name,Double value,String placa,String modelo,Boolean automatico,TipoDeCombustivel combustivel,int tanque) {
		super(name,value,placa,modelo,automatico);
		this.tipo = TipoDeCarro.Combustao;
		this.combustivel = combustivel;
		this.tanque = tanque;
	}

	public String getTipo() {
		return this.tipo.name();
	}
	public void setTipo(TipoDeCarro tipo) {
		this.tipo = tipo;
	}

	public String getCombustivel() {
		return this.combustivel.name();
	}
	public void setCombustivel(TipoDeCombustivel combustivel) {
		this.combustivel = combustivel;
	}

	public int getTanque() {
		return this.tanque;
	}
	public void setTanque(int tanque) {
		this.tanque = tanque;
	}
}