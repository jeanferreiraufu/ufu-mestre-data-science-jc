Desenvolva um novo Trabalho ciêntifico de Algoritmos Aproximados.

Bibliografia:
Jon Kleinberg, Éva Tardos, Algorithm Design, 1st edition, Pearson, 2005

Objetivo: Comparar algoritmo aproximado e algoritmo exato para problemas difíceis Instruções.

Problema Proposto:
Formulamos o Problema de Balanceamento de Carga da seguinte forma. Somos dados um conjunto de (m) máquinas (M_1,..., M_m) e um conjunto de (n) trabalhos; cada trabalho (j) tem um tempo de processamento (t_j). Buscamos atribuir cada trabalho a uma das máquinas de modo que as cargas colocadas em todas as máquinas sejam o mais "balanceadas" possível. Mais concretamente, em qualquer atribuição de trabalhos às máquinas, podemos deixar (A(i)) denotar o conjunto de trabalhos atribuídos à máquina (M_i); sob esta atribuição, a máquina (M_i) precisa trabalhar por um tempo total de (T_i = \sum_{j \in A(i)} t_j).

Algoritimo Proposto:
Greedy-Balance:
Start with no jobs assigned
Set Ti = 0 and A(i) = ∅ for all machines Mi
For j = 1, . . . , n
    Let Mi be a machine that achieves the minimum mink Tk
    Assign job j to machine Mi
    Set A(i) ← A(i) ∪ {j}
    Set Ti ← Ti + tj
End Fof

Passo 1: Me garanta que este problema está relacionado ao: NP-hard ou NP-completo.

Pesquise algum artigo de referência na Internet(web) artigo que tenha um algoritmo aproximado para este problema.
Bem como a prova da razão de aproximação.

Passo 2: Extrair do artigo os principais elementos para implementação do algoritmo aproximado, tais como a descrição do problema, elementos principais na solução do problema e função objetivo. 

Passo 3: Implementa o algoritmo aproximado e o algoritmo exato (aquele que encontra a solução ótimado problema).

Passo 4- Executa experimentos, com diferentes instâncias do problema, utilizando ambos os algoritmos implementados, fazendo tomadas de tempo e soluções (ou valores da função objetivo). 
Compare os tempos e soluções através de tabelas e gráficos. 
Outras medidas estatísticas também podem ser utilizadas.

Passo 5- Elabore uma apresentação (em formato pdf) contendo a especificação dos algoritmos, destacando principais aspectos do aproximado, provando a razão de aproximação, benchmark utilizado e comparação dos resultados, finalizando com conclusão relativa à comparação dos resultados. 

Restrições: 
1) Referências que auxiliem nas especificações dos algoritmos podem ser utilizadas, favor destacar na elaboração da apresentação.
2) Caso a referência utilize exemplos de dados no texto ou benchmarks ou datasets, então deve se reutilizar estes mesmos dados para as comparações. 
3) Caso o artigo utilize dados gerados aleatoriamente, então deve se proceder da mesma maneira.

Adicione a pesquisa sobre os autores: 
https://www.youtube.com/watch?v=XkmMjmwwp50


https://www.youtube.com/watch?v=rREv8lD1dSY

