import math

def solve_equation(a, b, c):
    # Calcula os logaritmos
    log_b_a = math.log(a, b)
    log_c_b = math.log(b, c)

    # Resolve a equação
    result = (log_b_a + 1) * log_c_b

    return result

# Solicita os valores de "a" e "b" como entrada do usuário
a = float(input("Digite o valor de a: "))
b = float(input("Digite o valor de b: "))
c = float(input("Digite o valor de c: "))

# Chama a função com os valores desejados
result = solve_equation(a, b, c)

# Imprime o resultado
print("O resultado é: ", result)