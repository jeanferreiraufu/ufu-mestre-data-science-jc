public class MergeSort {

    public static void main(String[] args) {
        int[] meuArray = {8, 5, 9, 10, 7, 4};
        mergeSort(meuArray, 0, meuArray.length - 1);
        System.out.println("meuArrayay ordenado: ");
        for (int num : meuArray) {
            System.out.print(num + " ");
        }
    }

    public static void mergeSort(int[] meuArray, int esquerda, int direita) {

        if (esquerda < direita) {
            int meio = (esquerda + direita) / 2;

            System.out.println("esquerda: " + esquerda + " - meio: " + meio + " - direita: " + direita);
            mergeSort(meuArray, esquerda, meio);
            System.out.println("esquerda: " + esquerda + " - meio: " + meio + " - direita: " + direita);
            mergeSort(meuArray, meio + 1, direita);
            System.out.println("esquerda: " + esquerda + " - meio: " + meio + " - direita: " + direita);    

            merge(meuArray, esquerda, meio, direita); 
        }
    }

    private static void merge(int[] meuArray, int esquerda, int meio, int direita) {
        int n1 = meio - esquerda + 1;
        int n2 = direita - meio;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = meuArray[esquerda + i];
            System.out.println("L[" + i + "]: " + L[i]);
        }
        for (int j = 0; j < n2; j++) {
            R[j] = meuArray[meio + 1 + j];
            System.out.println("R[" + j + "]: " + R[j]);
        }

        int i = 0, j = 0;
        int k = esquerda;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                meuArray[k] = L[i];
                i++;
            } else {
                meuArray[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            meuArray[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            meuArray[k] = R[j];
            j++;
            k++;
        }
    }

}
