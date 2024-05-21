# Primeira Lista de Exercícios Análise de Algoritmos – Pós-Graduação – 20/05/2024 

## 1- Resolva os itens abaixo:
(i) Suponha bx=a , qual o valor de x em termos de a e b.
(ii) Usando o item (a), mostre que logc(ab )=logc a+logc b
(iii) Mostre que a logb n=n logb a

## 2- Resolva as recorrências abaixo utilizando o método mais adequado, exceto quanto especificado.
(a) T(n) = 7T(n/7) + n, não utilize o teorema Master, mas indução matemática.
(b) T(n) = 9T(n/3) + n2
(c) T(n) = 8T(n/2) + n3
(d) T(n) = 49T(n/25)+ n3/2
logn
(e) T(n) = T(n-1) + 2, utilize árvore de recursão.
(f) T(n) = T(n-1) + nc
, onde c >= 1 é uma constante, pelo teorema Master.
(g) T(n) = T(n-1) + cn
, onde c > 1 é uma constante, pelo teorema Master.
(h) T(n) = 2T(n-1) + 1, por indução. 
(i) T (n)=T (√n)+1
(j) T(n) = 2T(n/3) + 1
(k) T(n) = 5T(n/4) + n
Obs: Quando necessário, assuma como caso base o valor de n mais adequado

## 3- Apresente a recorrência que expressa o tempo do algoritmo que, dado um problema de tamanho n,
divide-o em cinco subproblemas cujos tamanhos são a metade do problema original, resolve cada um
destes subproblemas e combina as suas soluções em tempo linear. Qual seria o tempo de execução deste
algoritmo??

## 4- Dado um vetor de n elementos não ordenados, encontre os k menores números e como saída apresente estes elementos de forma ordenada. Descreva os algoritmos que implementam os métodos abaixo, com melhor tempo assintótico para o pior caso e apresente os tempos em função de n e k.
(a) Ordenação dos n elementos.
(b) Utilizando fila de prioridades.

## 5- Dados n inteiros no intervalo fechado . Dê um algoritmo que preprocesse a entrada em de tal maneira que a pergunta a seguir possa ser respondida em . Quantos inteiros
estão no intervalo , onde a e b são argumentos dados?

## 6- O algoritmo ordena_insercao(A, n) pode ser um algoritmo recursivo da seguinte maneira: Encontre o maior elemento e coloque-o na última posição. Recursivamente ordene os elementos restantes.
(a) Escreva em pseudo-código esta versão recursiva.
(b) Apresente a recorrência que expresse o tempo deste algoritmo 
(c) Utilize o método da expansão para resolver a recorrência.
(d) Prove por indução o resultado obtido em (c)
