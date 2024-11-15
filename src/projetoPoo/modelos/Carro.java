package projetoPoo.modelos;

public class Carro {
	private String name;
	private double value;
	private String placa;
	private String modelo;
	private Boolean automatico;
	
	Carro(String name,Double value,String placa,String modelo,Boolean automatico) {
		this.name = name;
		this.value = value;
		this.placa = placa;
		this.modelo = modelo;
		this.automatico = automatico;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getPlaca() {
		return this.placa;
	}

	public void setValue(Double value) {
		this.value = value;
	}
	public double getValue() {
		return this.value;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	
	public String getModelo() {
		return this.modelo;
	}
	
	public void setAutomatico(Boolean automatico) {
		this.automatico = automatico;
	}
	public boolean getAutomatico() {
		return this.automatico;
	}
	
}

