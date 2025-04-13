package br.ulbra.entity;

public class Usuario {

    private int idUsu;
    private String nomeUsu;
    private String emailUsu;
    private String loginUsu;
    private String senhaUsu;
    private String foneUsu;
    private String cpfUsu;
    private String cepUsu;
    private String logradouroUsu;
    private String numeroUsu;
    private String bairroUsu;
    private String cidadeUsu;
    private String estadoUsu;

    public Usuario() {
    }

    public Usuario(int idUsu, String nomeUsu, String emailUsu, String senhaUsu, String foneUsu, String cpfUsu, String cepUsu, String logradouroUsu, String numeroUsu, String bairroUsu, String cidadeUsu, String estadoUsu, String loginUsu) {
        this.idUsu = idUsu;
        this.nomeUsu = nomeUsu;
        this.emailUsu = emailUsu;
        this.senhaUsu = senhaUsu;
        this.foneUsu = foneUsu;
        this.cpfUsu = cpfUsu;
        this.cepUsu = cepUsu;
        this.logradouroUsu = logradouroUsu;
        this.numeroUsu = numeroUsu;
        this.bairroUsu = bairroUsu;
        this.cidadeUsu = cidadeUsu;
        this.estadoUsu = estadoUsu;
        this.loginUsu = loginUsu;
    }

    public Usuario(int id_user, String user_name, String email, String fone, String cep) {
        this.idUsu = id_user;
        this.nomeUsu = user_name;
        this.emailUsu = email;
        this.foneUsu = fone;
        this.cepUsu = cep;
    }

    public boolean validarSenha(String senhaUsu) {
        // Regex explicação:
        // (?=.*[a-z])       → pelo menos uma letra minúscula
        // (?=.*[A-Z])       → pelo menos uma letra maiúscula
        // (?=.*\\d)         → pelo menos um número
        // (?=.*[@#$%^&+=!]) → pelo menos um caractere especial
        // .{8,}             → no mínimo 8 caracteres no total
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$";
        return senhaUsu.matches(regex);
    }

      public boolean validarCPF(String cpf) {
        // Remove os caracteres não numéricos (pontos e traços)
        cpf = cpf.replaceAll("[^0-9]", "");

        // Verifica se o CPF tem exatamente 11 dígitos
        if (cpf.length() != 11) {
            return false;
        }

        // Verifica se todos os números são iguais (exemplo: 111.111.111-11, 222.222.222-22, etc.)
        if (cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        // Calcula o primeiro dígito verificador
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += (10 - i) * (cpf.charAt(i) - '0');
        }
        int digito1 = 11 - (soma % 11);
        if (digito1 >= 10) digito1 = 0;

        // Calcula o segundo dígito verificador
        soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += (11 - i) * (cpf.charAt(i) - '0');
        }
        soma += 2 * digito1;
        int digito2 = 11 - (soma % 11);
        if (digito2 >= 10) digito2 = 0;

        // Verifica se os dois dígitos verificadores calculados são iguais aos informados
        return cpf.charAt(9) == (digito1 + '0') && cpf.charAt(10) == (digito2 + '0');
    }
    
    
    public String toString() {
        return " ID:        " + this.idUsu
                + " | Nome:     " + this.nomeUsu
                + " | E-mail:   " + this.emailUsu
                + " | Senha:    " + this.senhaUsu
                + " | Fone:     " + this.foneUsu
                + " | CPF:      " + this.cpfUsu
                + " | CEP:      " + this.cepUsu
                + " | Lograd.:  " + this.logradouroUsu
                + " | Número:   " + this.numeroUsu
                + " | Bairro:   " + this.bairroUsu
                + " | Cidade:   " + this.cidadeUsu
                + " | Estado:   " + this.estadoUsu;
    }

    public int getIdUsu() {
        return idUsu;
    }

    public void setIdUsu(int idUsu) {
        this.idUsu = idUsu;
    }

    public String getNomeUsu() {
        return nomeUsu;
    }

    public void setNomeUsu(String nomeUsu) {
        this.nomeUsu = nomeUsu;
    }

    public String getEmailUsu() {
        return emailUsu;
    }

    public void setEmailUsu(String emailUsu) {
        this.emailUsu = emailUsu;
    }

    public String getSenhaUsu() {
        return senhaUsu;
    }

    public void setSenhaUsu(String senhaUsu) {
        this.senhaUsu = senhaUsu;
    }

    public String getFoneUsu() {
        return foneUsu;
    }

    public void setFoneUsu(String foneUsu) {
        this.foneUsu = foneUsu;
    }

    public String getCpfUsu() {
        return cpfUsu;
    }

    public void setCpfUsu(String cpfUsu) {
        this.cpfUsu = cpfUsu;
    }

    public String getCepUsu() {
        return cepUsu;
    }

    public void setCepUsu(String cepUsu) {
        this.cepUsu = cepUsu;
    }

    public String getLogradouroUsu() {
        return logradouroUsu;
    }

    public void setLogradouroUsu(String logradouroUsu) {
        this.logradouroUsu = logradouroUsu;
    }

    public String getNumeroUsu() {
        return numeroUsu;
    }

    public void setNumeroUsu(String numeroUsu) {
        this.numeroUsu = numeroUsu;
    }

    public String getBairroUsu() {
        return bairroUsu;
    }

    public void setBairroUsu(String bairroUsu) {
        this.bairroUsu = bairroUsu;
    }

    public String getCidadeUsu() {
        return cidadeUsu;
    }

    public void setCidadeUsu(String cidadeUsu) {
        this.cidadeUsu = cidadeUsu;
    }

    public String getEstadoUsu() {
        return estadoUsu;
    }

    public void setEstadoUsu(String estadoUsu) {
        this.estadoUsu = estadoUsu;
    }

    public String getLoginUsu() {
        return loginUsu;
    }

    public void setLoginUsu(String loginUsu) {
        this.loginUsu = loginUsu;
    }

}
