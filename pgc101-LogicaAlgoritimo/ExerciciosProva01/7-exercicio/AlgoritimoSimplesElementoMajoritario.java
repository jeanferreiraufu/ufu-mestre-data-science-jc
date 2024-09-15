// Descrição: 7. Dado um vetor de inteiros, implemente um algoritmo que retorne o elemento majoritário do vetor.
// Algoritmo EncontraElementoMajoritario(A)
//   Entrada: Um array A de n elementos
//   Saída: O elemento majoritário, se existir; caso contrário, retornar "Nenhum elemento majoritário"
//
//   contar ← MapaVazio()  // Mapa para armazenar contagens
//
//   // Contar ocorrências de cada elemento
//   para i de 1 até n faça
//     se A[i] está em contar então
//       contar[A[i]] ← contar[A[i]] + 1
//     senão
//       contar[A[i]] ← 1
//
//   // Verificar se algum elemento é majoritário
//   para cada par (elemento, frequência) em contar faça
//     se frequência > n/2 então
//       retornar elemento
//
//   retornar "Nenhum elemento majoritário"
// Fim Algoritmo
import java.util.HashMap;
import java.util.Map;

public class AlgoritimoSimplesElementoMajoritario {

    public static void main(String[] args) {
        int[] meuArray = {8, 5, 9, 10, 7, 4, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8};
        System.out.println("Elemento majoritário: " + encontraElementoMajoritario(meuArray));
    }

    /**
     * @param A array de inteiros
     * @return o elemento majoritário do array, se existir; caso contrário, retorna -1
     */
    public static int encontraElementoMajoritario(int[] A) {
        Map<Integer, Integer> contar = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            if (contar.containsKey(A[i])) {
                contar.put(A[i], contar.get(A[i]) + 1);
            } else {
                contar.put(A[i], 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : contar.entrySet()) {
            if (entry.getValue() > A.length / 2) {
                return entry.getKey();
            }
        }

        return -1;
    }
}
