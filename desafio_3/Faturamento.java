package desafio_3;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Faturamento {
    public static void main(String[] args) {
        String path = "src/main/java/org/gfilipe/projects/desafio_3/dados.json";
        Charset encoding = StandardCharsets.UTF_8;

        try {
            String jsonContent = Files.readString(Path.of(path), encoding);

            JSONArray faturamentoDiario = new JSONArray(jsonContent);

            double faturamentoMinimo = Double.MAX_VALUE;
            double faturamentoMaximo = 0;
            double somaFaturamentosDiarios = 0;

            List<Double> valores = new ArrayList<>();

            for (int i = 0; i < faturamentoDiario.length(); i++) {
                JSONObject dia = faturamentoDiario.getJSONObject(i);
                double valor = dia.getDouble("valor");
                if (valor > 0) {
                    faturamentoMinimo = Math.min(faturamentoMinimo, valor);
                    faturamentoMaximo = Math.max(faturamentoMaximo, valor);
                    somaFaturamentosDiarios += valor;
                    valores.add(valor);
                }
            }

            double faturamentoMedio = somaFaturamentosDiarios /valores.size();

            long diasFaturamentoAcimaMedia = valores.stream().filter(valor -> valor > faturamentoMedio).count();
            System.out.println("Análise de Faturamento Diário");
            System.out.printf("Menor valor de faturamento: R$%.2f%n", faturamentoMinimo);
            System.out.printf("Maior valor de faturamento: R$%.2f%n", faturamentoMaximo);
            System.out.printf("Número de dias com faturamento acima da média: %d%n", diasFaturamentoAcimaMedia);

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo JSON: " + e.getMessage());
        }

    }
}

/*
3) Dado um vetor que guarda o valor de faturamento diário de uma distribuidora, faça um programa, na linguagem que desejar, que calcule e retorne:

        • O menor valor de faturamento ocorrido em um dia do mês;
        • O maior valor de faturamento ocorrido em um dia do mês;
        • Número de dias no mês em que o valor de faturamento diário foi superior à média mensal.

        IMPORTANTE:
        a) Usar o json ou xml disponível como fonte dos dados do faturamento mensal;
        b) Podem existir dias sem faturamento, como nos finais de semana e feriados. Estes dias devem ser ignorados no cálculo da média;
*/