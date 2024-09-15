Dados n inteiros no intervalo fechado . 
Dê um algoritmo que preprocesse a entrada em O(n+k) de tal maneira que a pergunta a seguir possa ser respondida em O(1). Quantos inteiros estão no intervalo [a,b], onde a e b são argumentos dados?

###########################################
Para resolver o problema de determinar quantos inteiros estão no intervalo \([a, b]\) de um array \(A\) de \(n\) inteiros no intervalo fechado \([1, k]\), podemos usar um algoritmo baseado em pré-processamento com uma complexidade \(O(n + k)\) e consultas respondidas em \(O(1)\).

### Passos do Algoritmo:

1. **Pré-processamento:**
   - Utilize um array de contagem para armazenar a frequência de cada inteiro no intervalo \([1, k]\).
   - Construa um array de prefixos para que cada posição \(i\) contenha a soma acumulada das frequências até \(i\).

2. **Consulta:**
   - Para responder à pergunta "quantos inteiros estão no intervalo \([a, b]\)", use o array de prefixos para calcular a diferença entre os prefixos correspondentes a \(b\) e \(a-1\).

### Detalhamento do Algoritmo:

#### Pré-processamento:

1. **Array de contagem:**
   - Crie um array `count` de tamanho \(k + 1\) (usamos \(k + 1\) para facilitar o uso de índices diretos).
   - Percorra o array de entrada e incremente a posição correspondente em `count`.

2. **Array de prefixos:**
   - Crie um array `prefix` de tamanho \(k + 1\).
   - O valor em `prefix[i]` será a soma acumulada dos elementos em `count` até a posição \(i\).

#### Consulta:

- Para encontrar o número de inteiros no intervalo \([a, b]\), use:
  \[
  \text{resultado} = \text{prefix}[b] - \text{prefix}[a-1]
  \]
  - Isso funciona porque `prefix[b]` contém a soma dos elementos até \(b\) e `prefix[a-1]` contém a soma dos elementos até \(a-1\), então a diferença dá exatamente o número de inteiros no intervalo \([a, b]\).

### Implementação em Java:

```java
public class IntervalQuery {

    private int[] prefix;

    // Método para pré-processar a entrada
    public void preprocess(int[] A, int k) {
        int n = A.length;
        int[] count = new int[k + 1];
        
        // Preencher o array de contagem
        for (int i = 0; i < n; i++) {
            count[A[i]]++;
        }

        // Preencher o array de prefixos
        prefix = new int[k + 1];
        for (int i = 1; i <= k; i++) {
            prefix[i] = prefix[i - 1] + count[i];
        }
    }

    // Método para responder à consulta
    public int query(int a, int b) {
        if (a > b || a < 1 || b >= prefix.length) {
            throw new IllegalArgumentException("Intervalo inválido");
        }
        return prefix[b] - prefix[a - 1];
    }

    public static void main(String[] args) {
        IntervalQuery intervalQuery = new IntervalQuery();
        
        // Exemplo de entrada
        int[] A = {1, 2, 2, 3, 3, 3, 4, 4, 5};
        int k = 5;

        // Pré-processar a entrada
        intervalQuery.preprocess(A, k);

        // Exemplos de consultas
        System.out.println(intervalQuery.query(2, 4)); // Saída: 6 (2x2 + 3x3 + 2x4)
        System.out.println(intervalQuery.query(1, 5)); // Saída: 9 (todos os elementos)
        System.out.println(intervalQuery.query(3, 3)); // Saída: 3 (3x3)
    }
}
```

### Análise de Complexidade:

- **Pré-processamento:**
  - Contagem dos elementos no array \(A\): \(O(n)\).
  - Construção do array de prefixos: \(O(k)\).
  - Total: \(O(n + k)\).

- **Consulta:**
  - Cada consulta é respondida em \(O(1)\), já que envolve apenas uma subtração no array de prefixos.

Este algoritmo é eficiente tanto no pré-processamento quanto na consulta, cumprindo os requisitos do problema.