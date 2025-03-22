
package ulbra.br.exer3;

import java.util.Scanner;

class Funcionario {
    private String nome;
    private String cpf;
    private double salario;

    public Funcionario(String nome, String cpf, double salario) {
        this.nome = nome;
        this.cpf = cpf;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void exibirDetalhes() {
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("Salário: R$ " + salario);
    }
}


class Gerente extends Funcionario {
    private String departamento;

    public Gerente(String nome, String cpf, double salario, String departamento) {
        super(nome, cpf, salario);
        this.departamento = departamento;
    }

    public double calcularBonus() {
        return getSalario() * 0.1; 
    }

    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes();
        System.out.println("Departamento: " + departamento);
        System.out.println("Bônus: R$ " + calcularBonus());
    }
}

// Classe Vendedor
class Vendedor extends Funcionario {
    private double comissao;

    public Vendedor(String nome, String cpf, double salario, double comissao) {
        super(nome, cpf, salario);
        this.comissao = comissao;
    }

    public double calcularSalarioComComissao() {
        return getSalario() + comissao;
    }

    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes();
        System.out.println("Comissão: R$ " + comissao);
        System.out.println("Salário Total: R$ " + calcularSalarioComComissao());
    }
}


class Empresa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       
        System.out.println("Cadastro de Gerente:");
        System.out.print("Nome: ");
        String nomeGerente = scanner.nextLine();
        System.out.print("CPF: ");
        String cpfGerente = scanner.nextLine();
        System.out.print("Salário: ");
        double salarioGerente = scanner.nextDouble();
        scanner.nextLine(); 
        System.out.print("Departamento: ");
        String departamento = scanner.nextLine();
        
        Gerente gerente = new Gerente(nomeGerente, cpfGerente, salarioGerente, departamento);

    
        System.out.println("Cadastro de Vendedor:");
        System.out.print("Nome: ");
        String nomeVendedor = scanner.nextLine();
        System.out.print("CPF: ");
        String cpfVendedor = scanner.nextLine();
        System.out.print("Salário: ");
        double salarioVendedor = scanner.nextDouble();
        System.out.print("Comissão: ");
        double comissao = scanner.nextDouble();
        
        Vendedor vendedor = new Vendedor(nomeVendedor, cpfVendedor, salarioVendedor, comissao);

        
        System.out.println("\nDetalhes do Gerente:");
        gerente.exibirDetalhes();

        System.out.println("\nDetalhes do Vendedor:");
        vendedor.exibirDetalhes();

        scanner.close();
    }
}

