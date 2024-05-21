import java.util.Scanner;
import java.lang.Math;

public class Item1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicita os valores de "a" e "b" como entrada do usuário
        System.out.print("Digite o valor de a: ");
        double a = scanner.nextDouble();

        System.out.print("Digite o valor de b: ");
        double b = scanner.nextDouble();

        // Calcula o logaritmo na base "b" de "a" usando a fórmula "x = log_b(a)"
        double x = Math.log(a) / Math.log(b);

        // Retorna o valor de "x"
        System.out.println("O valor de x é: " + x);
    }
}