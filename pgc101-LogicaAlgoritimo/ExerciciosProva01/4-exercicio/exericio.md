# Dado um vetor de n elementos não ordenados, encontre os k menores números e como saída apresente estes elementos de forma ordenada. Descreva os algoritmos que implementam os métodos abaixo, com melhor tempo assintótico para o pior caso e apresente os tempos em função de n e k.
* (a) Ordenação dos n elementos.
* (b) Utilizando fila de prioridades

################################################
Para resolver o problema de encontrar os k menores números em um vetor de n elementos não ordenados e apresentá-los de forma ordenada, podemos considerar duas abordagens: ordenação dos n elementos e utilização de uma fila de prioridades. Vamos analisar ambos os métodos, descrevendo os algoritmos e comparando seus tempos de execução.

### (a) Ordenação dos n elementos

#### Descrição do Algoritmo:
1. **Ordenar o vetor**: Utilize um algoritmo de ordenação eficiente, como QuickSort ou MergeSort, para ordenar todos os n elementos do vetor. A complexidade de tempo para ordenação será O(n log n).
2. **Selecionar os k menores**: Após a ordenação, os k menores elementos estarão nas primeiras k posições do vetor. Copie esses k elementos para um novo vetor.

#### Complexidade Temporal:
- A complexidade de ordenar os n elementos é O(n log n).
- Selecionar os primeiros k elementos tem complexidade O(k).
- A complexidade total é dominada pela ordenação, então é O(n log n).

#### Implementação em Java:
```java
import java.util.Arrays;

public class MenoresNumerosOrdenacao {
    public static int[] encontrarMenores(int[] array, int k) {
        // Ordena o array
        Arrays.sort(array);

        // Cria um novo array para armazenar os k menores elementos
        int[] menores = new int[k];
        System.arraycopy(array, 0, menores, 0, k);

        return menores;
    }

    public static void main(String[] args) {
        int[] array = {7, 2, 9, 4, 5, 1, 6, 8, 3};
        int k = 4;

        int[] menores = encontrarMenores(array, k);
        System.out.println("Os " + k + " menores números são: " + Arrays.toString(menores));
    }
}
```

### (b) Utilizando fila de prioridades

#### Descrição do Algoritmo:
1. **Construir uma fila de prioridades (Max-Heap)**: Use uma fila de prioridades para manter os k menores elementos encontrados até o momento. A complexidade para construir o heap é O(k).
2. **Iterar sobre o vetor**: Percorra o vetor, comparando cada elemento com o maior elemento na fila de prioridades (a raiz do Max-Heap). Se o elemento atual for menor que a raiz, substitua a raiz pelo elemento atual e ajuste o heap.
3. **Extrair e ordenar os k menores elementos**: No final, os k menores elementos estarão na fila de prioridades. Extraia esses elementos e ordene-os, se necessário.

#### Complexidade Temporal:
- Construir a fila de prioridades inicialmente com k elementos tem complexidade O(k).
- Inserir um elemento no heap e ajustar o heap tem complexidade O(log k). Para n elementos, isso resulta em O(n log k).
- Extrair e ordenar os k menores elementos tem complexidade O(k log k).

A complexidade total é O(n log k + k log k), que é mais eficiente que O(n log n) para k << n.

#### Implementação em Java:
```java
import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.Collections;

public class MenoresNumerosHeap {
    public static int[] encontrarMenores(int[] array, int k) {
        // Usa uma fila de prioridade (Max-Heap) para encontrar os k menores elementos
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());

        for (int num : array) {
            if (heap.size() < k) {
                heap.add(num);
            } else if (num < heap.peek()) {
                heap.poll();
                heap.add(num);
            }
        }

        // Converte o heap em um array e ordena os elementos
        int[] menores = new int[k];
        for (int i = 0; i < k; i++) {
            menores[i] = heap.poll();
        }

        Arrays.sort(menores);
        return menores;
    }

    public static void main(String[] args) {
        int[] array = {7, 2, 9, 4, 5, 1, 6, 8, 3};
        int k = 4;

        int[] menores = encontrarMenores(array, k);
        System.out.println("Os " + k + " menores números são: " + Arrays.toString(menores));
    }
}
```

### Comparação dos Tempos de Execução:

- **Ordenação dos n elementos**:
  - Complexidade: O(n log n)
  - Vantagem: Simplicidade na implementação.
  - Desvantagem: Ineficiente para valores grandes de n, especialmente quando k é pequeno.

- **Utilizando fila de prioridades (Max-Heap)**:
  - Complexidade: O(n log k + k log k)
  - Vantagem: Mais eficiente que a ordenação completa quando k << n.
  - Desvantagem: Implementação ligeiramente mais complexa.

Para comparar os tempos de execução em diferentes cenários, considere a seguinte tabela:

```markdown
| Método                  | Complexidade      | Desempenho esperado                 |
|-------------------------|-------------------|-------------------------------------|
| Ordenação dos n elementos | O(n log n)       | Rápido para k próximo de n          |
| Fila de prioridades       | O(n log k + k log k) | Mais rápido para k << n              |
```

Com base nessa análise, a fila de prioridades é preferível para encontrar os k menores números em arrays grandes onde k é relativamente pequeno.
