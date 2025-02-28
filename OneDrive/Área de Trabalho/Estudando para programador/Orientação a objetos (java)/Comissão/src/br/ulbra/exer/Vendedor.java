package br.ulbra.exer;

public class Vendedor {

    private String nome;
    private double meta;
    private double totalVendido;

    public Vendedor(String nome, double meta, double totalVendido) {
        this.nome = nome;
        this.meta = meta;
        this.totalVendido = totalVendido;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getMeta() {
        return meta;
    }

    public void setMeta(double meta) {
        this.meta = meta;
    }

    public double getTotalVendido() {
        return totalVendido;
    }

    public void setTotalVendido(double totalVendido) {
        this.totalVendido = totalVendido;
    }

    public double calcularComissao() {
        double percentual = (totalVendido / meta) * 100;
        double taxaComissao;

        if (percentual < 50) {
            System.out.println("50");
            taxaComissao = 0.01;
        } else if (percentual <= 75) {
            System.out.println("50 - 75");
            taxaComissao = 0.025;
        } else if (percentual <= 100) {
            System.out.println("75 100");
            taxaComissao = 0.035;
        } else {
            System.out.println("acima da meta");
            taxaComissao = 0.05;
        }

        return totalVendido * taxaComissao;
    }

    public void exibirInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("Meta: R$" + meta);
        System.out.println("Total Vendido: R$" + totalVendido);
        System.out.println("Comissão: R$" + calcularComissao());
    }
}
