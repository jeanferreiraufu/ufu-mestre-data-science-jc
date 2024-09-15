Suponha o problema de encontrar em um conjunto o elemento mais freqüente, isto é, o elemento cujo número de ocorrências é maior que ⌈n/2⌉ . Note que se tal elemento existir, é único e denominado elemento majoritário.
(a) Escreva um algoritmo para resolver este problema.
(b) É possível encontrar um algoritmo “divide ando conquer” com um tempo melhor? Note que a etapa de combinar deve ser interessante o bastante para que o algoritmo seja, pelo menos, θ (nlogn) . Neste caso, o tempo de combinar deveria ser linear


#################################

Para resolver o problema de encontrar o elemento majoritário em um conjunto, vamos apresentar duas abordagens:

1. **Algoritmo simples para encontrar o elemento majoritário**.
2. **Algoritmo "divide and conquer" para encontrar o elemento majoritário**.

### (a) Algoritmo Simples:

A abordagem simples é usar uma tabela de hash (ou um dicionário) para contar as ocorrências de cada elemento. Se algum elemento tiver uma contagem maior que ⌈n/2⌉, então esse é o elemento majoritário.

#### Pseudo-código:

```pseudo
Algoritmo EncontraElementoMajoritario(A)
  Entrada: Um array A de n elementos
  Saída: O elemento majoritário, se existir; caso contrário, retornar "Nenhum elemento majoritário"

  contar ← MapaVazio()  // Mapa para armazenar contagens

  // Contar ocorrências de cada elemento
  para i de 1 até n faça
    se A[i] está em contar então
      contar[A[i]] ← contar[A[i]] + 1
    senão
      contar[A[i]] ← 1

  // Verificar se algum elemento é majoritário
  para cada par (elemento, frequência) em contar faça
    se frequência > n/2 então
      retornar elemento

  retornar "Nenhum elemento majoritário"
```

### Complexidade Temporal:

- Contar as ocorrências leva \(O(n)\).
- Verificar se algum elemento é majoritário leva \(O(n)\).
- Portanto, a complexidade total é \(O(n)\).

### (b) Algoritmo "Divide and Conquer":

A abordagem "divide and conquer" para este problema envolve dividir o array em duas metades, encontrar o elemento majoritário em cada metade e depois combinar os resultados para encontrar o elemento majoritário no array original.

#### Pseudo-código:

```pseudo
Algoritmo EncontraElementoMajoritarioDivideConquer(A, esquerda, direita)
  Entrada: Um array A, índices esquerda e direita
  Saída: O elemento majoritário no subarray A[esquerda...direita]

  // Caso base: se o subarray tem apenas um elemento, esse é o majoritário
  se esquerda = direita então
    retornar A[esquerda]

  meio ← (esquerda + direita) / 2

  // Encontrar o elemento majoritário nas duas metades
  majoritarioEsquerda ← EncontraElementoMajoritarioDivideConquer(A, esquerda, meio)
  majoritarioDireita ← EncontraElementoMajoritarioDivideConquer(A, meio + 1, direita)

  // Combinar os resultados das duas metades
  se majoritarioEsquerda = majoritarioDireita então
    retornar majoritarioEsquerda

  // Contar ocorrências dos majoritários no array completo
  contarEsquerda ← ContaOcorrencias(A, majoritarioEsquerda, esquerda, direita)
  contarDireita ← ContaOcorrencias(A, majoritarioDireita, esquerda, direita)

  // Retornar o elemento com maior contagem
  se contarEsquerda > (direita - esquerda + 1) / 2 então
    retornar majoritarioEsquerda
  senão se contarDireita > (direita - esquerda + 1) / 2 então
    retornar majoritarioDireita
  senão
    retornar "Nenhum elemento majoritário"

Algoritmo ContaOcorrencias(A, elemento, esquerda, direita)
  contar ← 0
  para i de esquerda até direita faça
    se A[i] = elemento então
      contar ← contar + 1
  retornar contar
```

### Complexidade Temporal:

- A complexidade da divisão do problema é \(O(\log n)\) (pois o array é dividido repetidamente pela metade).
- A complexidade da combinação dos resultados é \(O(n)\) (pois cada elemento é contado na etapa de combinação).
- Portanto, a complexidade total do algoritmo é \(O(n \log n)\).

### Comparação dos Algoritmos:

- O algoritmo simples tem uma complexidade de \(O(n)\) e é mais eficiente quando comparado com o algoritmo "divide and conquer" que tem uma complexidade de \(O(n \log n)\).
- No entanto, o algoritmo "divide and conquer" é uma abordagem mais sofisticada que pode ser interessante para estudar e entender os princípios de divisão e combinação de problemas.

Ambos os algoritmos são úteis dependendo do contexto e das restrições do problema em mãos.