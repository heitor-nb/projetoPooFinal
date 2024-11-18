package projetoPoo.modelos;

import projetoPoo.enums.*;

public class CarroEletrico extends Carro{
	
	private TipoDeTomada tomada;
	private int bateria;
	
	public CarroEletrico(String name,Double value,String placa,String modelo,Boolean automatico,TipoDeTomada tomada,int bateria,String marca) {
		super(name,value,placa,modelo,automatico,marca);
		this.tipo = TipoDeCarro.Elétrico;
		this.tomada = tomada;
		this.bateria = bateria;
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