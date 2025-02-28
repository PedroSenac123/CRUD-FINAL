
package calculoscirculo;

import java.util.Scanner;


public class CalculosCirculo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite o valor do raio do círculo: ");
        double raio = scanner.nextDouble();
        
        Circulo circulo = new Circulo(raio);
        circulo.exibirResultados();
        
        scanner.close();

    }
    
}
