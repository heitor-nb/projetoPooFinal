package projetoPoo.modelos;

import projetoPoo.enums.*;

public class CarroHibrido extends Carro{
	
	private TipoDeCombustivel combustivel;
	private int tanque;
	private TipoDeTomada tomada;
	private int bateria;
	
	public CarroHibrido(String name,Double value,String placa,String modelo,Boolean automatico) {
		super(name,value,placa,modelo,automatico);
		this.tipo = TipoDeCarro.Híbrido;
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
	public String getTomada() {
		return this.tomada.name();
	}
	public void setTomada(TipoDeTomada tomada) {
		this.tomada = tomada;
	}

	public int getBateria() {
		return this.bateria;
	}
	public void setBateria(int bateria) {
		this.bateria = bateria;
	}
}