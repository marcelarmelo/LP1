package carro;

public class TestaCarro {
    public static void main(String[] args) {
        Carro c1 = new Carro();
        //c1.marca = "Ford";
        //c1.cor = "Preto";
        // c1.modelo = "KA 1.0";
        c1.frear();
        c1.status();
        c1.acelerar();
        c1.marcha();
    }
}
