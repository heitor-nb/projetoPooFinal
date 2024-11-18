package projetoPoo.modelos;

public class Cliente {
    private String CPF; 
	private String name;
	private boolean alugou;
	
	public Cliente(String name,String CPF) {
		this.name = name;
		this.CPF = CPF;
		this.alugou = false;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }
    public String getCPF() {
        return this.CPF;
    }

    public void setAlugou(boolean alugou) {
        this.alugou = alugou;
    }
    public boolean getAlugou() {
        return this.alugou;
    }
	
}
