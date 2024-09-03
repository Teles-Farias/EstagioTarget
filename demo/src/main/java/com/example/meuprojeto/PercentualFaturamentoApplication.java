package com.example.meuprojeto;

public class PercentualFaturamentoApplication {

    public static void main(String[] args) {
        // Valores de faturamento por estado
        double faturamentoSP = 67836.43;
        double faturamentoRJ = 36678.66;
        double faturamentoMG = 29229.88;
        double faturamentoES = 27165.48;
        double faturamentoOutros = 19849.53;

        // Valor total do faturamento
        double totalFaturamento = faturamentoSP + faturamentoRJ + faturamentoMG + faturamentoES + faturamentoOutros;

        // Cálculo e exibição dos percentuais
        double percentualSP = (faturamentoSP / totalFaturamento) * 100;
        double percentualRJ = (faturamentoRJ / totalFaturamento) * 100;
        double percentualMG = (faturamentoMG / totalFaturamento) * 100;
        double percentualES = (faturamentoES / totalFaturamento) * 100;
        double percentualOutros = (faturamentoOutros / totalFaturamento) * 100;

        // Exibindo os resultados
        System.out.printf("Percentual de representação de SP: %.2f%%%n", percentualSP);
        System.out.printf("Percentual de representação de RJ: %.2f%%%n", percentualRJ);
        System.out.printf("Percentual de representação de MG: %.2f%%%n", percentualMG);
        System.out.printf("Percentual de representação de ES: %.2f%%%n", percentualES);
        System.out.printf("Percentual de representação de Outros: %.2f%%%n", percentualOutros);
    }
}
