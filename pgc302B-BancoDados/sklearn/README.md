# Projeto PGC302B - Banco de Dados com Scikit-Learn

Este repositório contém códigos Python que utilizam a biblioteca Scikit-Learn para realizar diversas operações relacionadas a aprendizado de máquina e análise de dados. Abaixo está uma descrição detalhada do que foi feito em cada arquivo de código.

## Estrutura do Repositório

- `data_preprocessing.py`: Este script realiza a pré-processamento dos dados, incluindo a limpeza, normalização e divisão dos dados em conjuntos de treino e teste.
- `model_training.py`: Este script treina diferentes modelos de aprendizado de máquina utilizando os dados pré-processados.
- `model_evaluation.py`: Este script avalia a performance dos modelos treinados utilizando métricas como acurácia, precisão, recall e F1-score.
- `model_prediction.py`: Este script utiliza os modelos treinados para fazer previsões em novos dados.

## Detalhes dos Arquivos

### data_preprocessing.py

Este arquivo contém funções para carregar os dados, limpar valores ausentes, normalizar os dados e dividir o conjunto de dados em treino e teste. As principais etapas incluem:

1. **Carregamento dos Dados**: Utiliza pandas para carregar os dados de um arquivo CSV.
2. **Limpeza dos Dados**: Remove ou substitui valores ausentes.
3. **Normalização**: Escala os dados para que todas as características tenham a mesma escala.
4. **Divisão dos Dados**: Divide os dados em conjuntos de treino e teste.

### model_training.py

Este arquivo treina vários modelos de aprendizado de máquina, incluindo:

1. **Regressão Linear**: Utiliza `LinearRegression` do Scikit-Learn.
2. **Árvore de Decisão**: Utiliza `DecisionTreeClassifier`.
3. **Random Forest**: Utiliza `RandomForestClassifier`.
4. **SVM**: Utiliza `SVC` para máquinas de vetores de suporte.

Cada modelo é treinado utilizando os dados de treino e os parâmetros são ajustados para otimizar a performance.

### model_evaluation.py

Este arquivo avalia a performance dos modelos treinados utilizando várias métricas:

1. **Acurácia**: Proporção de previsões corretas.
2. **Precisão**: Proporção de verdadeiros positivos sobre o total de positivos preditos.
3. **Recall**: Proporção de verdadeiros positivos sobre o total de positivos reais.
4. **F1-Score**: Média harmônica da precisão e recall.

### model_prediction.py

Este arquivo utiliza os modelos treinados para fazer previsões em novos dados. Inclui funções para carregar novos dados, aplicar o mesmo pré-processamento e gerar previsões.

## Requisitos

Para executar os scripts, você precisará das seguintes bibliotecas Python:

- pandas
- numpy
- scikit-learn

Você pode instalar todas as dependências utilizando o seguinte comando:

```bash
pip install pandas numpy scikit-learn