package projetoPoo.modelos;

public class Aluguel {
    private String ID; 
	private Carro carro;
	private Cliente cliente;
    private int time;
    private double finalPrice;
    private boolean due;
	
	Aluguel(String ID,Carro carro,Cliente cliente,int time,double finalPrice,boolean due) {
		this.ID = ID;
        this.carro = carro;
        this.cliente = cliente;
        this.time = time;
        this.finalPrice = finalPrice;
        this.due = due;
	}

    public void setID (String ID) {
        this.ID = ID;
    }
     public void setDue (boolean due) {
        this.due = due;
    }
    public void setCarro (Carro carro) {
        this.carro = carro;
    }
    public void setTime (int time) {
        this.time = time;
    }
    public void setCliente (Cliente cliente) {
        this.cliente = cliente;
    }
    public void setFinalPrice (double finalprice) {
        this.finalPrice = finalprice;
    }

    public String getID () {
        return this.ID ;
    }
     public boolean getDue () {
        return this.due ;
    }
    public Carro getCarro () {
        return this.carro ;
    }
    public int getTime() {
        return this.time ;
    }
    public Cliente getCliente() {
        return this.cliente ;
    }
    public double getFinalPrice() {
        return this.finalPrice ;
    }
	
}
