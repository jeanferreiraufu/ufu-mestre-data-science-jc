package com.example.programacao.dinamica;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import org.jfree.data.xy.XYSeries;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        int arrEntrada[] = { 100, 80, 180, 120, 260, 310 };
        // Teste do algoritmo Maximum Sum Increasing Subsequence (MSIS)
        System.out.println("\nAlgoritmo Maximum Sum Increasing Subsequence (MSIS):");
        System.out.println("A soma máxima da subsequência crescente é " + maiorSomaE(arrEntrada));

        // Teste do algoritmo iterativo
        System.out.println("\nAlgoritmo Iterativo:");
        int[] resultIterative = subSequenciaCrescenteSomaMaxima(arrEntrada);
        System.out.println("A soma máxima da subsequência crescente é: " + Arrays.stream(resultIterative).sum());
        System.out.println("Subsequência: " + Arrays.toString(resultIterative));

        // Teste do algoritmo recursivo
        System.out.println("\nAlgoritmo Recursivo:");
        List<Integer> resultRecursive = subSequenciaCrescenteSomaMaximaRecursiva(arrEntrada, arrEntrada.length - 1);
        System.out.println("A soma máxima da subsequência crescente é: "
                + resultRecursive.stream().mapToInt(Integer::intValue).sum());
        System.out.println("Subsequência: " + resultRecursive);

        // Teste do algoritmo para mostrar/construir a solução ótima
        System.out.println("\nAlgoritmo para mostrar/construir a solução ótima:");
        int[] otimoResultado = encontreSolucaoOtima(arrEntrada);
        System.out.println("Subsequência ótima: " + Arrays.toString(otimoResultado));
        System.out.println("Soma ótima: " + Arrays.stream(otimoResultado).sum());

        gerarGraficoTesteAlgoritimoInstaciasDinamicas();

    }

    // Algoritmo Maximum Sum Increasing Subsequence (MSIS)
    public static int maiorSomaE(int arrEntrada[]) {
        int n = arrEntrada.length;
        if (n == 0) {
            return 0;
        }

        int MSIS[] = new int[n];
        for (int i = 0; i < n; i++) {
            MSIS[i] = arrEntrada[i];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arrEntrada[i] > arrEntrada[j] && MSIS[i] < MSIS[j] + arrEntrada[i]) {
                    MSIS[i] = MSIS[j] + arrEntrada[i];
                }
            }
        }

        int max = MSIS[0];
        for (int i = 1; i < n; i++) {
            if (MSIS[i] > max) {
                max = MSIS[i];
            }
        }
        return max;
    }

    // Algoritmo iterativo
    public static int[] subSequenciaCrescenteSomaMaxima(int[] arrEntrada) {
        int n = arrEntrada.length;
        if (n == 0)
            return new int[] { 0 };

        int[] MSIS = new int[n];
        int[] posicoes = new int[n];
        Arrays.fill(MSIS, 0);
        MSIS[0] = arrEntrada[0];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arrEntrada[i] > arrEntrada[j] && MSIS[i] < MSIS[j] + arrEntrada[i]) {
                    MSIS[i] = MSIS[j] + arrEntrada[i];
                    posicoes[i] = j;
                }
            }
        }
        // System.out.println("MSIS: " + java.util.Arrays.toString(MSIS)); // Add
        // closing parenthesis here
        // System.out.println("posicoes: " + java.util.Arrays.toString(posicoes)); //
        // Add closing parenthesis here

        int maxSum = Arrays.stream(MSIS).max().getAsInt();
        List<Integer> subsequence = new ArrayList<>();
        int maxIndex = -1;
        for (int i = 0; i < n; i++) {
            if (MSIS[i] == maxSum) {
                maxIndex = i;
                break;
            }
        }

        subsequence.add(arrEntrada[maxIndex]);
        while (maxIndex != posicoes[maxIndex]) {
            maxIndex = posicoes[maxIndex];
            subsequence.add(arrEntrada[maxIndex]);
        }

        int[] result = new int[subsequence.size()];
        for (int i = 0; i < subsequence.size(); i++) {
            result[i] = subsequence.get(i);
        }

        return result;
    }

    // Algoritmo recursivo (sem memorização)
    public static List<Integer> subSequenciaCrescenteSomaMaximaRecursiva(int[] arrEntrada, int i) {
        List<Integer> result = new ArrayList<>();
        if (i == 0) {
            result.add(arrEntrada[0]);
            return result;
        }

        int maxSum = arrEntrada[i];
        List<Integer> maxSubsequence = new ArrayList<>();
        maxSubsequence.add(arrEntrada[i]);

        for (int j = 0; j < i; j++) {
            List<Integer> prevSubsequence = subSequenciaCrescenteSomaMaximaRecursiva(arrEntrada, j);
            int prevSum = prevSubsequence.stream().mapToInt(Integer::intValue).sum();
            if (arrEntrada[i] > arrEntrada[j] && maxSum < prevSum + arrEntrada[i]) {
                maxSum = prevSum + arrEntrada[i];
                maxSubsequence = new ArrayList<>(prevSubsequence);
                maxSubsequence.add(arrEntrada[i]);
            }
        }

        return maxSubsequence;
    }

    // Algoritmo para mostrar/construir a solução ótima
    public static int[] encontreSolucaoOtima(int[] arr) {
        return subSequenciaCrescenteSomaMaxima(arr);
    }

    public static void testesAlgoritimosInstanciasDinamicos(long[] resultadoFinal, int size) {
        System.out.println("\nTeste com instância de tamanho " + size + ":");

        // Gerar uma instância aleatória do problema
        int[] arr = geradorArrayDanamico(size);

        // Teste do algoritmo iterativo
        long startTimeIterative = System.nanoTime();
        int[] resultIterative = subSequenciaCrescenteSomaMaxima(arr);
        long endTimeIterative = System.nanoTime();
        long durationIterative = (endTimeIterative - startTimeIterative) / 1000000; // Tempo em milissegundos

        // Teste do algoritmo recursivo (sem memorização)
        long startTimeRecursive = System.nanoTime();
        int[] resultRecursive = encontreSolucaoOtima(arr);
        long endTimeRecursive = System.nanoTime();
        long durationRecursive = (endTimeRecursive - startTimeRecursive) / 1000000; // Tempo em milissegundos

        // Verificar se os resultados são iguais
        boolean resultsMatch = Arrays.equals(resultIterative, resultRecursive);

        // Imprimir resultados
        // System.out.println("Algoritmo Iterativo:");
        // System.out.println("Subsequência ótima: " +
        // Arrays.toString(resultIterative));
        // System.out.println("Soma ótima: " + Arrays.stream(resultIterative).sum());
        // System.out.println("Tempo de execução: " + durationIterative + " ms");
        // System.out.println();

        // System.out.println("Algoritmo Recursivo:");
        // System.out.println("Subsequência ótima: " +
        // Arrays.toString(resultRecursive));
        // System.out.println("Soma ótima: " + Arrays.stream(resultRecursive).sum());
        // System.out.println("Tempo de execução: " + durationRecursive + " ms");
        // System.out.println();

        // System.out.println("Os resultados dos algoritmos são iguais: " +
        // resultsMatch);

        resultadoFinal[0] = size;
        resultadoFinal[1] = durationIterative;
        resultadoFinal[2] = durationRecursive;
    }

    // Função para gerar uma instância aleatória do problema
    public static int[] geradorArrayDanamico(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(1000); // Números aleatórios até 999
        }
        return arr;
    }

    // Função para gerar gráfico com diferentes instâncias do problema
    public static void gerarGraficoTesteAlgoritimoInstaciasDinamicas() {
        // Teste com diferentes instâncias do problema
        System.out.println("\nTeste com diferentes instâncias do problema:");

        // Define o número de testes a serem realizados
        int numTestes = 5;

        // Cria um array para armazenar as séries
        XYSeries[] series = new XYSeries[2];

        XYSeries series1 = new XYSeries("Interativo");
        XYSeries series2 = new XYSeries("Recursivo");        

        // Loop para gerar os resultados e adicionar as séries
        for (int i = 0; i < numTestes; i++) {
            long[] resultado = new long[3];
            testesAlgoritimosInstanciasDinamicos(resultado, (i + 1) * 10000);

            System.out.println("Tempo de execução Entrada " + resultado[0] + ": Interativo= " + resultado[1] + " ms"
                    + " Recursivo: " + resultado[2] + " ms");

           series1.add(resultado[0], resultado[1]);
           series2.add(resultado[0], resultado[2]);
        }
        series[0] = series1;
        series[1] = series2;
        
        // Gera o gráfico
        geraGraficoComplexidade(series);

    }

    //método para gerar grafico
    public static void geraGraficoComplexidade(XYSeries[] series) {
        XYSeriesCollection dataset = new XYSeriesCollection();
        for (XYSeries serie : series) {
            dataset.addSeries(serie);
        }

        JFreeChart chart = ChartFactory.createXYLineChart(
                "Complexidade dos Algoritmos",
                "Tamanho", "Tempo Execução (ms)",
                dataset);

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Gráfico de Complexidade");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new BorderLayout());

            ChartPanel chartPanel = new ChartPanel(chart);
            frame.add(chartPanel, BorderLayout.CENTER);

            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }       
}
