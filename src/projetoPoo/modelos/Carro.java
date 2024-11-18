package projetoPoo.modelos;

import projetoPoo.enums.TipoDeCarro;

public abstract class Carro {
	
	protected TipoDeCarro tipo;
	private boolean disponivel;
	private String name;
	private double value;
	private String placa;
	private String modelo;
	private Boolean automatico;
	private String marca;
	
	Carro(String name,Double value,String placa,String modelo,Boolean automatico,String marca) {
		this.name = name;
		this.value = value;
		this.placa = placa;
		this.modelo = modelo;
		this.marca = marca;
		this.automatico = automatico;
		disponivel = true;
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

	public TipoDeCarro getTipo() {
		return tipo;
	}

	public void setTipo(TipoDeCarro tipo) {
		this.tipo = tipo;
	}

	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}
	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
	public void ExibirDetalhes() {
		System.out.println("Nome: " + name + "\nPlaca: " + placa +"\nMarca:"+marca+ "\nModelo: " + modelo +
				"\nAutomático: " + automatico + "\n*Disponível: " + disponivel +
				"\n*Tipo: " + tipo + "\nDiária: " + value);
	}
	
}

