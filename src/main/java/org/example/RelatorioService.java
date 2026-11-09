package org.example;

public class RelatorioService {
    public String gerarRelatorio(int tipo) {
        if (tipo == 1) {
            return "Relatório Completo";
        } else if (tipo == 2) {
            return "Relatório Resumido";
        }
        return "Relatório Padrão";
    }
}