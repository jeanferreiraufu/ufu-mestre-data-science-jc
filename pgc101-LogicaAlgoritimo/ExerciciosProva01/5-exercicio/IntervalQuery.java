public class IntervalQuery {

    private int[] prefix;

    // Método para pré-processar a entrada
    public void preprocess(int[] A, int k) {
        int n = A.length;
        int[] count = new int[k + 1];
        System.out.println("n: " + n);
        System.out.println("k: " + k);
        System.out.println("count: " + count.length);

        
        // Preencher o array de contagem
        for (int i = 0; i < n; i++) {
            count[A[i]]++;
        }

        // Preencher o array de prefixos
        prefix = new int[k + 1];
        for (int i = 1; i <= k; i++) {
            prefix[i] = prefix[i - 1] + count[i];
        }

        System.out.println("prefix: " + prefix.length);
        for (int i = 0; i < prefix.length; i++) {
            System.out.println("prefix[" + i + "]: " + prefix[i]);
        }
    }

    // Método para responder à consulta
    public int query(int a, int b) {
        if (a > b || a < 1 || b >= prefix.length) {
            throw new IllegalArgumentException("Intervalo inválido");
        }
        System.out.println("a: " + a + " - b: " + b);
        System.out.println("prefix: " + prefix[b] + " - " + prefix[a - 1]);
        return prefix[b] - prefix[a - 1];
    }

    public static void main(String[] args) {
        IntervalQuery intervalQuery = new IntervalQuery();
        
        // Exemplo de entrada
        int[] A = {1, 2, 2, 3, 3, 3, 4, 4, 5, 6, 7, 8, 9};
        int k = 9;

        // Pré-processar a entrada
        intervalQuery.preprocess(A, k);

        // Exemplos de consultas
        System.out.println(intervalQuery.query(2, 5)); // Saída: 8 (2x2 + 3x3 + 2x4)
        System.out.println(intervalQuery.query(1, 5)); // Saída: 9 (todos os elementos)
        System.out.println(intervalQuery.query(3, 3)); // Saída: 3 (3x3)
        System.out.println(intervalQuery.query(1, 7)); // Saída: 11 (3x3)
    }
}
