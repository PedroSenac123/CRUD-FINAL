
package br.ulbra.entity;


public class Endereco {
    private String logradouro;
    private String bairro;
    private String cidade; // cidade
    private String estado;         // estado

    public String getLogradouro() { return logradouro; }
    public String getBairro() { return bairro; }
    public String getLocalidade() { return cidade; }
    public String getUf() { return estado; }
}
    