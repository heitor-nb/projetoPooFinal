package projetoPoo.modelos;

public class Cliente {
    private String CPF; 
	private String name;
	private boolean alugou;
	
	Cliente(String name,String CPF,boolean alugou) {
		this.name = name;
		this.CPF = CPF;
		this.alugou = alugou;
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
    public String getCPF(String CPF) {
        return this.CPF;
    }

    public void setAlugou(boolean alugou) {
        this.alugou = alugou;
    }
    public boolean getAlugou() {
        return this.alugou;
    }
	
}
