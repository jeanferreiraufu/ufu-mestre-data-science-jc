import math

# Solicita os valores de "a" e "b" como entrada do usuário
a = float(input("Digite o valor de a: "))
b = float(input("Digite o valor de b: "))

# Calcula o logaritmo na base "b" de "a" usando a fórmula "x = log_b(a)"
x = math.log(a, b)

# Retorna o valor de "x"
print("O valor de x é: ", x)