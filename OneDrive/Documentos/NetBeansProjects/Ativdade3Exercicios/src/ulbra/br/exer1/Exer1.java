/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ulbra.br.exer1;

/**
 *
 * @author Vanderlei
 */
public class Exer1 {
    private String palavra;

    public Exer1() {
    }

    public Exer1(String palavra) {
        this.palavra = palavra;
    }

    public String getPalavra() {
        return palavra;
    }

    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }
    
    public int ContarPalavra(){
        return palavra.length();
    }
    
   
}
