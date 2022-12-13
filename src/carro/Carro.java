package carro;

/**
 *
 * @author Marcela Ribeiro
 */
public class Carro {
    private String marca;
    private String modelo;
    private String cor;
    private String roda;
    private String acessorio;
    private boolean velocidade;
    
     //Método Construtor
    public Carro() {
    }
    
    public Carro(String marca, String modelo, String cor, String roda, String acessorio, boolean velocidade) {
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.velocidade = velocidade;
        this.acessorio = acessorio;
        this.roda = roda;

        
    }
    
    public String getModelo(){
        return modelo;
    }
    public void setModelo(String modelo){
        this.modelo = modelo;
    }
    public String getMarca(){
        return marca;
    }
    public void setMarca(String marca){
        this.marca = marca;
        
    }
    public String getCor(){
        return cor;
    }
    public void setCor(String cor){
        this.cor = cor;
    }
    public String getRoda(){
        return roda;
    }
    public void setRoda(String roda){
        this.roda = roda;
    }
    public String getAcessorio(){
        return acessorio;
    }
    public void setAcessorio(String acessorio){
        this.acessorio = acessorio;
    }
    
    public void status(){
        System.out.println("Marca: " + this.marca);
        System.out.println("Modelo: " + this.modelo);
        System.out.println("Cor: " + this.cor);
        System.out.println("Rodas: " + this.roda);
        System.out.println("Acessorio: " + this.acessorio);
    }
    
    void acelerar(){
        System.out.println("Acelerar");
        this.velocidade = true;
    }

    void frear(){
        this.velocidade = false;
    }
    void marcha(){
        if (this.velocidade == true) {
            System.out.println("Mudar a marcha");
        } else {
            System.out.println("ATENÇÃO! Mudar de marcha sem necessidade, pode danificar o seu câmbio");
        }
        
    }
    
    public String toString() {
    	return "Marca: " + marca + "Modelo: " + modelo + "Cor: " + cor + "Roda: " + roda + "Acessório: " + acessorio;
    }
    
}
