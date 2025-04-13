package br.ulbra.entity;


public class Produto {
    private int idProd;
    private String nomeProd;
    private String dataCadProd;
    private String categoriaProd;
    private double valorUnitProd;
    private int quantidadeProd;

   
    public Produto() {
    }

    // Construtor completo
    public Produto(int idProd, String nomeProd, String dataCadProd, String categoriaProd, double valorUnitProd, int quantidadeProd) {
        this.idProd = idProd;
        this.nomeProd = nomeProd;
        this.dataCadProd = dataCadProd;
        this.categoriaProd = categoriaProd;
        this.valorUnitProd = valorUnitProd;
        this.quantidadeProd = quantidadeProd;
    }

    // Getters e Setters
    public int getIdProd() {
        return idProd;
    }

    public void setIdProd(int idProd) {
        this.idProd = idProd;
    }

    public String getNomeProd() {
        return nomeProd;
    }

    public void setNomeProd(String nomeProd) {
        this.nomeProd = nomeProd;
    }

    public String getDataCadProd() {
        return dataCadProd;
    }

    public void setDataCadProd(String dataCadProd) {
        this.dataCadProd = dataCadProd;
    }

    public String getCategoriaProd() {
        return categoriaProd;
    }

    public void setCategoriaProd(String categoriaProd) {
        this.categoriaProd = categoriaProd;
    }

    public double getValorUnitProd() {
        return valorUnitProd;
    }

    public void setValorUnitProd(double valorUnitProd) {
        this.valorUnitProd = valorUnitProd;
    }

    public int getQuantidadeProd() {
        return quantidadeProd;
    }

    public void setQuantidadeProd(int quantidadeProd) {
        this.quantidadeProd = quantidadeProd;
    }

    // Método toString()
    @Override
    public String toString() {
        return "ID: " + this.idProd +
               " | Nome: " + this.nomeProd +
               " | Data Cadastro: " + this.dataCadProd +
               " | Categoria: " + this.categoriaProd +
               " | Valor Unitário: R$ " + this.valorUnitProd +
               " | Quantidade: " + this.quantidadeProd;
    }
    
    public double calcularEstoque() {
        return valorUnitProd * quantidadeProd;
    }
    
    
}

