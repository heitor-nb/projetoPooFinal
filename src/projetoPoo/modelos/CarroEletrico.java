package projetoPoo.modelos;

import projetoPoo.enums.*;

public class CarroEletrico extends Carro{
	
	private TipoDeCarro tipo;
	private TipoDeTomada tomada;
	private int bateria;
	
	CarroEletrico  (String name,Double value,String placa,String modelo,Boolean automatico,TipoDeTomada tomada,int bateria) {
		super(name,value,placa,modelo,automatico);
		this.tipo = TipoDeCarro.Elétrico;
		this.tomada = tomada;
		this.bateria = bateria;
	}

	public String getTipo() {
		return this.tipo.name();
	}
	public void setTipo(TipoDeCarro tipo) {
		this.tipo = tipo;
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