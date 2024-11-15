package projetoPoo.modelos;

public class Funcionario {
    private String CPF; 
	private String name;
	private String senha;
	
	Funcionario(String name, String CPF, String senha) {
		this.name = name;
		this.CPF = CPF;
		this.senha = senha;
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

    public void setSenha(String senha) {
        this.senha = senha;
    }
    public String getSenha() {
        return this.senha;
    }

}
