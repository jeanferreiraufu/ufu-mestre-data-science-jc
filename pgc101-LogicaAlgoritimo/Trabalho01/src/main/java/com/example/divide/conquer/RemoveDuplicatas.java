package com.example.divide.conquer;

import java.util.Arrays;

import org.jfree.data.xy.XYSeries;

public class RemoveDuplicatas {

    public static void main(String[] args) {
        // Inicia a classe para geração do gráfico.
        GeradorGrafico grafico = new GeradorGrafico();
        XYSeries seriesOtimizado = new XYSeries("Otimizado");
        XYSeries seriesNaive = new XYSeries("Não Otimizado");
        XYSeries seriesMerge = new XYSeries("Merge");        

        // Define tamanhos de arrays para os experimentos
        int[] tamanhos = { 20, 1000, 5000, 10000, 20000 }; // Tamanhos dos arrays a serem testados

        boolean imprimiu = false;

        // Executa experimentos para cada tamanho de array
        for (int tamanho : tamanhos) {
            int[] duplicatas = gerarArrayComDuplicatas(tamanho);

            // Algoritmo otimizado: Remoção de duplicatas
            long tempoInicioOtimizado = System.nanoTime();
            int[] arrayUnicoOtimizado = removerDuplicatasOtimizado(duplicatas);
            long tempoFimOtimizado = System.nanoTime();
            long tempoExecucaoOtimizado = tempoFimOtimizado - tempoInicioOtimizado;
            seriesOtimizado.add(tamanho, tempoExecucaoOtimizado);
            
            // Algoritmo não otimizado: Remoção de duplicatas
            long tempoInicioNaive = System.nanoTime();
            int[] arrayUnicoNaive = removerDuplicatasNaive(duplicatas);
            long tempoFimNaive = System.nanoTime();
            long tempoExecucaoNaive = tempoFimNaive - tempoInicioNaive;
            seriesNaive.add(tamanho, tempoExecucaoNaive);

            // Algoritmo com merge: Remoção de duplicatas
            long tempoInicioMerge = System.nanoTime();
            int[] arrayUnicoMerge = removerDuplicatasPorMerge(duplicatas);
            long tempoFimMerge = System.nanoTime();
            long tempoExecucaoMerge = tempoFimMerge - tempoInicioMerge;
            seriesMerge.add(tamanho, tempoExecucaoMerge);

            // Imprime informações de tempo para o tamanho atual do array
            System.out.println("Tamanho do array: " + tamanho);
            System.out.println("Tempo (otimizado): " + tempoExecucaoOtimizado + " nanos");
            System.out.println("Tempo (naive): " + tempoExecucaoNaive + " nanos");
            System.out.println("Tempo (merge): " + tempoExecucaoMerge + " nanos");
            System.out.println("-------------------------------------------");

            if (!imprimiu) {
                imprimiu = true;
                //Imprime arrays para análise
                imprimirArrayInteiro(duplicatas, "Com duplicatas (entrada)");
                imprimirArrayInteiro(arrayUnicoOtimizado, "Sem duplicatas para Otimizado (Saída 1)");
                imprimirArrayInteiro(arrayUnicoNaive, "Sem duplicatas para Não Otimizado (Saída 2)");
                imprimirArrayInteiro(arrayUnicoMerge, "Sem duplicatas para Merge (Saída 3)");
            }
        }

        // Gráfico com cálculo de complexidade
        grafico.geraGraficoComplexidade(seriesOtimizado, seriesNaive, seriesMerge);

        grafico.geraGraficoComplexidade(seriesOtimizado, seriesMerge);
    }

    // Método para imprimir um array de inteiros como uma string formatada
    private static void imprimirArrayInteiro(int[] array, String nomeArray) {
        StringBuilder resultadoArray = new StringBuilder();

        // Percorre o array e concatena os elementos na string com separadores
        for (int i = 0; i < array.length; i++) {
            resultadoArray.append(array[i]); // Adiciona o número à string

            // Adiciona separador '-' se não for o último elemento do array
            if (i < array.length - 1) {
                resultadoArray.append("-");
            }
        }

        // Imprime a string resultante contendo os elementos do array
        System.out.println("Array " + nomeArray + ": " + resultadoArray);
    }

    // Método para gerar um array com duplicatas
    private static int[] gerarArrayComDuplicatas(int tamanho) {
        int[] array = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            array[i] = (int) (Math.random() * tamanho); // Números aleatórios até o tamanho do array
        }
        return array;
    }

    // Algoritmo otimizado para remoção de duplicatas
    private static int[] removerDuplicatasOtimizado(int[] duplicatas) {
        // Verifica se o array está vazio
        if (duplicatas.length == 0) {
            return new int[0]; // Retorna um array vazio se não há elementos
        }

        // Ordena o array para agrupar elementos duplicados consecutivos
        Arrays.sort(duplicatas);

        // Inicializa o tamanho do array resultante com o primeiro elemento
        int novoTamanho = 1;

        // Percorre o array para identificar e copiar elementos únicos
        for (int i = 1; i < duplicatas.length; i++) {
            if (duplicatas[i] != duplicatas[i - 1]) {
                duplicatas[novoTamanho] = duplicatas[i];
                novoTamanho++;
            }
        }

        // Retorna um novo array com elementos únicos de tamanho novoTamanho
        return Arrays.copyOf(duplicatas, novoTamanho);
    }

    // Algoritmo não otimizado para remoção de duplicatas
    private static int[] removerDuplicatasNaive(int[] duplicatas) {
        int count = 0;
        for (int i = 0; i < duplicatas.length; i++) {
            for (int j = i + 1; j < duplicatas.length; j++) {
                if (duplicatas[i] == duplicatas[j]) {
                    count++;
                    break; // Uma vez que encontramos uma duplicata, podemos sair do loop interno
                }
            }
        }

        int[] arrayUnico = new int[duplicatas.length - count];
        int index = 0;

        for (int i = 0; i < duplicatas.length; i++) {
            boolean isDuplicate = false;
            for (int j = 0; j < index; j++) {
                if (duplicatas[i] == arrayUnico[j]) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                arrayUnico[index] = duplicatas[i];
                index++;
            }
        }

        return arrayUnico;
    }

    // Algoritmo com merge de soluções para remoção de duplicatas
    private static int[] removerDuplicatasPorMerge(int[] array) {
        if (array.length <= 1) {
            return array;
        }

        int meio = array.length / 2;
        int[] esquerda = removerDuplicatasPorMerge(Arrays.copyOfRange(array, 0, meio));
        int[] direita = removerDuplicatasPorMerge(Arrays.copyOfRange(array, meio, array.length));

        return mesclarArrayEsquerdaDireita(esquerda, direita);
    }

    // Método para mesclar dois arrays ordenados
    private static int[] mesclarArrayEsquerdaDireita(int[] esquerda, int[] direita) {
        int[] resultado = new int[esquerda.length + direita.length];
        int i = 0, j = 0, k = 0;

        while (i < esquerda.length && j < direita.length) {
            if (esquerda[i] < direita[j]) {
                resultado[k++] = esquerda[i++];
            } else if (esquerda[i] > direita[j]) {
                resultado[k++] = direita[j++];
            } else {
                resultado[k++] = esquerda[i++]; // Adiciona apenas um dos elementos se forem iguais
                j++;
            }
        }

        // Adiciona os elementos restantes da parte não processada dos arrays
        while (i < esquerda.length) {
            resultado[k++] = esquerda[i++];
        }
        while (j < direita.length) {
            resultado[k++] = direita[j++];
        }

        // Retorna apenas a parte preenchida do array resultante
        return Arrays.copyOf(resultado, k);
    }
}
