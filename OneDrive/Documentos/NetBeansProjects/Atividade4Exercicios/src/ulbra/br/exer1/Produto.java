
package ulbra.br.exer1;

import java.util.Scanner;

class Produto {
    private int codigo;
    private String nome;
    private double precoUnitario;

    public Produto(int codigo, String nome, double precoUnitario) {
        this.codigo = codigo;
        this.nome = nome;
        this.precoUnitario = precoUnitario;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public void exibirDetalhes() {
        System.out.println("Código: " + codigo);
        System.out.println("Nome: " + nome);
        System.out.println("Preço Unitário: R$ " + precoUnitario);
    }

    public void descontarBlackFriday() {
        this.precoUnitario *= 0.8; 
    }
}

// Classe Eletronico
class Eletronico extends Produto {
    private int garantiaMeses;

    public Eletronico(int codigo, String nome, double precoUnitario, int garantiaMeses) {
        super(codigo, nome, precoUnitario);
        this.garantiaMeses = garantiaMeses;
    }

    public int calculaGarantiaEstendida() {
        return garantiaMeses + 12;
    }

    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes();
        System.out.println("Garantia: " + garantiaMeses + " meses");
    }
}

class Livro extends Produto {
    private String autor;

    public Livro(int codigo, String nome, double precoUnitario, String autor) {
        super(codigo, nome, precoUnitario);
        this.autor = autor;
    }

    public void exibirAutor() {
        System.out.println("Autor: " + autor);
    }

    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes();
        System.out.println("Autor: " + autor);
    }
}

class Loja {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Cadastro de Eletrônico:");
        System.out.print("Código: ");
        int codigoEletronico = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Nome: ");
        String nomeEletronico = scanner.nextLine();
        System.out.print("Preço Unitário: ");
        double precoEletronico = scanner.nextDouble();
        System.out.print("Garantia (meses): ");
        int garantia = scanner.nextInt();
        
        Eletronico eletronico = new Eletronico(codigoEletronico, nomeEletronico, precoEletronico, garantia);

        System.out.println("Cadastro de Livro:");
        System.out.print("Código: ");
        int codigoLivro = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Nome: ");
        String nomeLivro = scanner.nextLine();
        System.out.print("Preço Unitário: ");
        double precoLivro = scanner.nextDouble();
        scanner.nextLine(); 
        System.out.print("Autor: ");
        String autor = scanner.nextLine();
        
        Livro livro = new Livro(codigoLivro, nomeLivro, precoLivro, autor);

        eletronico.descontarBlackFriday();

        
        System.out.println("\nDetalhes do Eletrônico após Black Friday:");
        eletronico.exibirDetalhes();
        System.out.println("Garantia Estendida: " + eletronico.calculaGarantiaEstendida() + " meses");
        
        System.out.println("\nDetalhes do Livro:");
        livro.exibirDetalhes();
        livro.exibirAutor();

        scanner.close();
    }
}

