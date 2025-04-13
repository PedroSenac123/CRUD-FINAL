package br.ulbra.ViaCEP;

import br.ulbra.entity.Endereco;
import com.google.gson.Gson;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.net.URL;
import java.net.HttpURLConnection;
import javax.swing.JOptionPane;

public class ViaCEP {

    private Endereco buscarEnderecoPorCep(String cep) throws Exception {
        String url = "https://viacep.com.br/ws/" + cep + "/json/";
        java.net.URL enderecoUrl = new java.net.URL(url);
        java.net.HttpURLConnection conexao = (java.net.HttpURLConnection) enderecoUrl.openConnection();
        conexao.setRequestMethod("GET");

        java.io.BufferedReader in = new java.io.BufferedReader(
                new java.io.InputStreamReader(conexao.getInputStream())
        );
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        com.google.gson.Gson gson = new com.google.gson.Gson();
        Endereco endereco = gson.fromJson(response.toString(), Endereco.class);
        return endereco;
    }
}
