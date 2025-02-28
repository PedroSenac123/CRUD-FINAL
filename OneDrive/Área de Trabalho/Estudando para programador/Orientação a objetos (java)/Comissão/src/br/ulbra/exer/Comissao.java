package br.ulbra.exer;


import java.util.Scanner;



public class Comissao {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
         Vendedor vendedor = new Vendedor("", 0, 0);
        
        
        System.out.print("Digite o nome do vendedor: ");
        vendedor.setNome(scanner.nextLine());
        
        System.out.print("Digite a meta de vendas: ");
        vendedor.setMeta( scanner.nextDouble());
        
        System.out.print("Digite o total vendido: ");
        vendedor.setTotalVendido( scanner.nextDouble());
        vendedor.exibirInformacoes();
       
        
        scanner.close();

    }
    
}
