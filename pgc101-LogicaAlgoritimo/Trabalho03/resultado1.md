#### Trabalho Científico sobre Algoritmos Aproximados para o Problema de Balanceamento de Carga

#### Objetivo
O objetivo deste trabalho é comparar um algoritmo aproximado e um algoritmo exato para o Problema de Balanceamento de Carga. Para isso, utilizaremos o algoritmo Greedy-Balance como a solução aproximada e um algoritmo de programação dinâmica como a solução exata. Avaliaremos o desempenho dos dois algoritmos em termos de tempo de execução e qualidade das soluções em diferentes instâncias do problema.

#### Problema Proposto
Formulamos o Problema de Balanceamento de Carga da seguinte forma: Dados um conjunto de \( m \) máquinas \( (M_1, M_2, ..., M_m) \) e um conjunto de \( n \) trabalhos, cada trabalho \( j \) tem um tempo de processamento \( t_j \). Buscamos atribuir cada trabalho a uma das máquinas de modo que as cargas em todas as máquinas sejam o mais balanceadas possível. Em qualquer atribuição de trabalhos às máquinas, podemos deixar \( A(i) \) denotar o conjunto de trabalhos atribuídos à máquina \( M_i \); sob esta atribuição, a máquina \( M_i \) precisa trabalhar por um tempo total de \( T_i = \sum_{j \in A(i)} t_j \).

#### Algoritmo Aproximado: Greedy-Balance
O algoritmo Greedy-Balance funciona da seguinte maneira:
1. Inicialmente, nenhum trabalho está atribuído.
2. Defina \( T_i = 0 \) e \( A(i) = \emptyset \) para todas as máquinas \( M_i \).
3. Para \( j = 1, ..., n \):
   - Deixe \( M_i \) ser uma máquina que atinge o mínimo \( \min_k T_k \).
   - Atribua o trabalho \( j \) à máquina \( M_i \).
   - Defina \( A(i) \leftarrow A(i) \cup \{j\} \).
   - Atualize \( T_i \leftarrow T_i + t_j \).

#### Passo 1: Classificação do Problema Relacionado a NP-hard ou NP-completo
O Problema de Balanceamento de Carga é conhecido por ser NP-hard. Isso significa que não existe um algoritmo eficiente que resolva o problema exatamente para todas as instâncias possíveis, a menos que P=NP. Este tipo de problema exige o uso de algoritmos aproximados para encontrar soluções boas em tempo razoável.

Precisamos distribuir '𝑛' trabalhos entre '𝑚' máquinas para minimizar o tempo máximo de execução, é conhecido como NP-hard. Isso significa que não existe um algoritmo conhecido que resolva todos os casos do problema em tempo polinomial.

#### Passo 2: Pesquisa e Implementação do Algoritmo Aproximado
Para a implementação, utilizaremos o algoritmo Greedy-Balance descrito anteriormente. A razão de aproximação deste algoritmo é de no máximo 2 vezes a carga ótima, conforme encontrado em literaturas sobre algoritmos gulosos para balanceamento de carga.

A razão de aproximação para um algoritmo aproximado é uma medida de quão perto a solução do algoritmo está da solução ótima. O algoritmo Greedy-Balance, por exemplo, é um algoritmo simples com uma razão de aproximação de 2-1/m, onde 𝑚 é o número de máquinas.

#### Passo 3: Implementação do Algoritmo Exato
O algoritmo exato que usaremos é uma abordagem de programação dinâmica que resolve o problema encontrando a atribuição ótima dos trabalhos às máquinas. A seguir está a implementação do algoritmo exato.

#### Implementação dos Algoritmos
Abaixo estão as implementações dos algoritmos em Python:

##### Algoritmo Greedy-Balance
Python
```python
def greedy_balance(jobs, m):
    machines = [0] * m  # Inicializa as máquinas com tempo de carga 0
    assignments = [[] for _ in range(m)]  # Inicializa as atribuições

    for job in jobs:
        min_machine = machines.index(min(machines))
        machines[min_machine] += job
        assignments[min_machine].append(job)

    return machines, assignments
```

##### Algoritmo Exato (Programação Dinâmica)
Implementar o algoritmo exato para o problema de balanceamento de carga é mais complexo e pode envolver técnicas como programação dinâmica ou branch-and-bound. Devido à complexidade e ao espaço limitado, vou apresentar um pseudocódigo simplificado:

```pseudo
function exactBalance(jobTimes, m):
    n = length(jobTimes)
    dp = array of size (m+1) x (n+1)
    
    for i from 0 to m:
        dp[i][0] = 0
    
    for j from 1 to n:
        dp[0][j] = infinity
    
    for i from 1 to m:
        for j from 1 to n:
            dp[i][j] = min(dp[i][j-1], max(dp[i-1][k] + sum(jobTimes[k+1:j])))
    
    return dp[m][n]
```

Python
```python
import itertools

def exact_balance(jobs, m):
    n = len(jobs)
    dp = [[float('inf')] * (m + 1) for _ in range(1 << n)]
    dp[0][0] = 0

    for mask in range(1 << n):
        for k in range(m):
            if dp[mask][k] == float('inf'):
                continue

            for i in range(n):
                if mask & (1 << i):
                    continue
                next_mask = mask | (1 << i)
                dp[next_mask][k + 1] = min(dp[next_mask][k + 1], dp[mask][k] + jobs[i])

    return min(dp[-1])

# Função de utilidade para atribuir trabalhos às máquinas baseando-se na solução encontrada pela DP
def assign_jobs(jobs, m, optimal_time):
    n = len(jobs)
    assignments = [[] for _ in range(m)]
    machines = [0] * m

    def dfs(mask, k):
        if k == 0:
            return True
        if mask == 0:
            return False

        for i in range(n):
            if mask & (1 << i):
                new_mask = mask ^ (1 << i)
                if dp[new_mask][k - 1] + jobs[i] <= optimal_time:
                    assignments[k - 1].append(jobs[i])
                    machines[k - 1] += jobs[i]
                    if dfs(new_mask, k - 1):
                        return True
                    assignments[k - 1].pop()
                    machines[k - 1] -= jobs[i]

        return False

    dfs((1 << n) - 1, m)
    return machines, assignments
```

#### Passo 4: Execução dos Experimentos
Para comparar os dois algoritmos, executaremos ambos em diferentes instâncias do problema. A seguir estão alguns exemplos de como gerar as instâncias e executar os testes.

##### Geração de Instâncias de Teste
Python
```python
import random

def generate_instances(num_instances, num_jobs, num_machines):
    instances = []
    for _ in range(num_instances):
        jobs = [random.randint(1, 100) for _ in range(num_jobs)]
        instances.append((jobs, num_machines))
    return instances

# Exemplo de uso:
instances = generate_instances(10, 50, 5)
```

##### Execução dos Testes
```python
import time
import matplotlib.pyplot as plt

def run_tests(instances):
    greedy_times = []
    exact_times = []
    greedy_results = []
    exact_results = []

    for jobs, m in instances:
        # Teste do algoritmo Greedy
        start = time.time()
        greedy_machines, greedy_assignments = greedy_balance(jobs, m)
        greedy_time = time.time() - start
        greedy_times.append(greedy_time)
        greedy_results.append(max(greedy_machines))

        # Teste do algoritmo Exato
        start = time.time()
        optimal_time = exact_balance(jobs, m)
        exact_time = time.time() - start
        exact_times.append(exact_time)
        exact_results.append(optimal_time)

    return greedy_times, exact_times, greedy_results, exact_results

# Exemplo de uso:
greedy_times, exact_times, greedy_results, exact_results = run_tests(instances)

# Plotagem dos resultados
plt.figure(figsize=(12, 6))

plt.subplot(1, 2, 1)
plt.plot(greedy_times, label='Greedy')
plt.plot(exact_times, label='Exact')
plt.xlabel('Instance')
plt.ylabel('Time (s)')
plt.title('Execution Time Comparison')
plt.legend()

plt.subplot(1, 2, 2)
plt.plot(greedy_results, label='Greedy')
plt.plot(exact_results, label='Exact')
plt.xlabel('Instance')
plt.ylabel('Maximum Load')
plt.title('Load Comparison')
plt.legend()

plt.tight_layout()
plt.show()
```

#### Passo 5: Elaboração da Apresentação
Para a apresentação, criaremos um PDF contendo as seguintes seções:

1. **Introdução**
   - Descrição do problema e sua relevância.
   - Definição do Problema de Balanceamento de Carga.

2. **Algoritmos**
   - Descrição do Algoritmo Greedy-Balance.
   - Descrição do Algoritmo Exato.

3. **Prova da Razão de Aproximação**
   - Explicação teórica da razão de aproximação do algoritmo Greedy.

4. **Resultados Experimentais**
   - Tabelas e gráficos comparativos de tempo de execução e cargas máximas.
   - Análise dos resultados.

5. **Conclusão**
   - Discussão sobre as vantagens e desvantagens dos algoritmos.
   - Considerações finais sobre o desempenho dos algoritmos em diferentes instâncias.

#### Pesquisa sobre os Autores
Jon Kleinberg e Éva Tardos são ambos professores de Ciência da Computação na Cornell University. Kleinberg é conhecido por seu trabalho sobre análise de redes e motores de busca, enquanto Tardos é renomada por sua pesquisa em algoritmos de fluxo de rede e teoria dos jogos.

#### Referências
- Vídeo sobre Éva Tardos: [YouTube](https://www.youtube.com/watch?v=XkmMjmwwp50)
- Jon Kleinberg, Éva Tardos, Algorithm Design, 1st edition, Pearson, 2005
- "Introduction to Algorithms" de Thomas H. Cormen et al.

Para encontrar as informações sobre o problema de balanceamento de carga nos dois livros, aqui estão as referências relevantes:

**No livro "Algorithm Design" de Jon Kleinberg e Éva Tardos:**

- Algoritmos de Aproximação é discutido especificamente no capítulo 11. A definição formal e o desenvolvimento do algoritmo estão nas páginas 600-660.

- O problema de balanceamento de carga é discutido na seção intitulada "Load Balancing Revisited: A More Advanced LP Application", especificamente no capítulo sobre Algoritmos de Aproximação. A definição formal e o desenvolvimento do algoritmo estão nas páginas 638-639.

**No livro "Algoritmos: Teoria e Prática" de Thomas H. Cormen, Charles E. Leiserson, Ronald L. Rivest e Clifford Stein:**

- Algoritmos de Aproximação é discutido especificamente no capítulo 35. A definição formal e o desenvolvimento do algoritmo estão nas páginas 892-918.

- O problema de balanceamento de carga é mencionado no contexto de problemas de escalonamento de tarefas. A seção específica trata do problema de escalonamento para minimizar atrasos, encontrado no Capítulo 4 sobre Algoritmos Gulosos, páginas 126-127.

Essas seções abordam a formulação do problema, o desenvolvimento de algoritmos de aproximação e a análise de complexidade, fornecendo uma visão abrangente sobre o balanceamento de carga em sistemas computacionais.