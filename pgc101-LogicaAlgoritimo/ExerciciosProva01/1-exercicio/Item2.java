import java.util.Scanner;

public class Item2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicita os valores de "a", "b" e "c" como entrada do usuário
        System.out.print("Digite o valor de a: ");
        double a = scanner.nextDouble();

        System.out.print("Digite o valor de b: ");
        double b = scanner.nextDouble();

        System.out.print("Digite o valor de c: ");
        double c = scanner.nextDouble();

        // Chama a função com os valores desejados
        double result = solveEquation(a, b, c);

        // Imprime o resultado
        System.out.println("O resultado é: " + result);
    }

    public static double solveEquation(double a, double b, double c) {
        // Calcula os logaritmos
        double log_b_a = Math.log(a) / Math.log(b);
        double log_c_b = Math.log(b) / Math.log(c);

        // Resolve a equação
        double result = (log_b_a + 1) * log_c_b;

        return result;
    }
}