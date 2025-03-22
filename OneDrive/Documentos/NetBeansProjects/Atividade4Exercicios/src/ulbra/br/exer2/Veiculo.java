
package ulbra.br.exer2;

import java.util.Scanner;

// Classe Veiculo
class Veiculo {
    private String marca;
    private String modelo;
    private int ano;
    private double preco;

    public Veiculo(String marca, String modelo, int ano, double preco) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.preco = preco;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void exibirDetalhes() {
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Ano: " + ano);
        System.out.println("Preço: R$ " + preco);
    }
}

// Classe Carro
class Carro extends Veiculo {
    private int portas;

    public Carro(String marca, String modelo, int ano, double preco, int portas) {
        super(marca, modelo, ano, preco);
        this.portas = portas;
    }

    public double calcularSeguro() {
        return getPreco() * 0.05; // Seguro é 5% do valor do carro
    }

    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes();
        System.out.println("Número de Portas: " + portas);
        System.out.println("Valor do Seguro: R$ " + calcularSeguro());
    }
}

// Classe Moto
class Moto extends Veiculo {
    private int cilindradas;

    public Moto(String marca, String modelo, int ano, double preco, int cilindradas) {
        super(marca, modelo, ano, preco);
        this.cilindradas = cilindradas;
    }

    public void exibirCilindradas() {
        System.out.println("Cilindradas: " + cilindradas + " cc");
    }

    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes();
        System.out.println("Cilindradas: " + cilindradas + " cc");
    }
}

// Classe Concessionaria
class Concessionaria {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Criando um carro
        System.out.println("Cadastro de Carro:");
        System.out.print("Marca: ");
        String marcaCarro = scanner.nextLine();
        System.out.print("Modelo: ");
        String modeloCarro = scanner.nextLine();
        System.out.print("Ano: ");
        int anoCarro = scanner.nextInt();
        System.out.print("Preço: ");
        double precoCarro = scanner.nextDouble();
        System.out.print("Número de portas: ");
        int portas = scanner.nextInt();
        scanner.nextLine(); // Consumir nova linha
        
        Carro carro = new Carro(marcaCarro, modeloCarro, anoCarro, precoCarro, portas);

        // Criando uma moto
        System.out.println("Cadastro de Moto:");
        System.out.print("Marca: ");
        String marcaMoto = scanner.nextLine();
        System.out.print("Modelo: ");
        String modeloMoto = scanner.nextLine();
        System.out.print("Ano: ");
        int anoMoto = scanner.nextInt();
        System.out.print("Preço: ");
        double precoMoto = scanner.nextDouble();
        System.out.print("Cilindradas: ");
        int cilindradas = scanner.nextInt();
        
        Moto moto = new Moto(marcaMoto, modeloMoto, anoMoto, precoMoto, cilindradas);

        // Exibindo detalhes dos veículos
        System.out.println("\nDetalhes do Carro:");
        carro.exibirDetalhes();

        System.out.println("\nDetalhes da Moto:");
        moto.exibirDetalhes();
        moto.exibirCilindradas();

        scanner.close();
    }
}
