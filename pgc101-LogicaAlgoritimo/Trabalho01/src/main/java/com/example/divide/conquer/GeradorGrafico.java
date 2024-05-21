package com.example.divide.conquer;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;

public class GeradorGrafico {

    public static void geraGraficoComplexidade(XYSeries seriesOtimizado, XYSeries seriesMerge) {
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(seriesOtimizado);
        dataset.addSeries(seriesMerge);

        JFreeChart chart = ChartFactory.createXYLineChart(
                "Complexidade dos Algoritmos de Remoção de Duplicatas",
                "Tamanho do Array (n)", "Tempo de Execução (nanossegundos)",
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

    public static void geraGraficoComplexidade(XYSeries seriesOtimizado, XYSeries seriesNaive, XYSeries seriesMerge) {
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(seriesOtimizado);
        dataset.addSeries(seriesNaive);
        dataset.addSeries(seriesMerge);

        JFreeChart chart = ChartFactory.createXYLineChart(
                "Complexidade dos Algoritmos de Remoção de Duplicatas",
                "Tamanho do Array (n)", "Tempo de Execução (nanossegundos)",
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
