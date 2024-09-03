package com.example.meuprojeto;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@SpringBootApplication
public class FaturamentoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(FaturamentoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Caminho para o arquivo JSON dentro do diretório resources
        String filePath = "dados.json";

        try {
            // Ler o arquivo JSON do classpath
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(new ClassPathResource(filePath).getInputStream());

            List<Double> valores = new ArrayList<>();
            double menorValor = Double.MAX_VALUE;
            double maiorValor = Double.MIN_VALUE;
            double somaValores = 0.0;

            Iterator<JsonNode> elements = root.elements();
            while (elements.hasNext()) {
                JsonNode node = elements.next();
                double valor = node.get("valor").asDouble();

                if (valor > 0) {
                    // Atualizar o menor e maior valor
                    if (valor < menorValor) menorValor = valor;
                    if (valor > maiorValor) maiorValor = valor;

                    // Adicionar o valor à lista e somar para a média
                    valores.add(valor);
                    somaValores += valor;
                }
            }

            // Calcular a média mensal
            double mediaMensal = valores.size() > 0 ? somaValores / valores.size() : 0;

            // Contar o número de dias com faturamento acima da média
            int diasAcimaMedia = 0;
            for (double valor : valores) {
                if (valor > mediaMensal) {
                    diasAcimaMedia++;
                }
            }

            // Exibir resultados
            System.out.println("Menor valor de faturamento: " + menorValor);
            System.out.println("Maior valor de faturamento: " + maiorValor);
            System.out.println("Número de dias com faturamento acima da média: " + diasAcimaMedia);

        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo JSON: " + e.getMessage());
        }
    }
}
