package com.example.calculadoramatrizes;

public class Laplace {
    /*
     *
     *      Escolhe-se uma fila (linha ou coluna) qualquer. O determinante será a soma entre cada
     *  elemento multiplicado pelo seu cofator.
     *
     */

    /* ===============================================================================================*/
    /* ====================================== MÉTODOS DA CLASSE ======================================*/

    public float getDeterminante(float matriz[][]) { //Método que retorna o determinante da matriz

        if (matriz.length == 1) return matriz[0][0]; //Se for 1x1, o determinante é o único elemento

        float determinante = 0;

        for (int i = 0; i < matriz.length; i++) { //Percorre a primeira coluna

            determinante += matriz[i][0] * cofator(matriz, i, 0); //Elemento * cofator do elemento

        }

        return determinante; //Retorna o valor do determinante

    }

    private float cofator(float matriz[][], int i, int j) { //Método para calcular o cofator do elemento

        // C(ij) = (-1)^(i + j) * D(ij)

        float cofator = ((i + j) % 2 == 0 ? 1 : -1) * //Se a soma for par, multiplica por 1, senão, -1

                menorComplementar(matriz, i, j); //Calcular o menor complementar do elemento

        return cofator; //Retorna o cafator calculado

    }

    private float menorComplementar(float matriz[][], int i, int j) { //Calcula o menor complementar do elemento

        /*
         *
         *      O menor complementar de um elemento de uma matriz quadrada é o determinante dela,
         *  eliminando-se a linha e a coluna as quais o elemento pertence.
         *
         */

        float matrizReduzida[][] = new float[matriz.length - 1][matriz.length - 1];

        for (int k = 0; k < matrizReduzida.length; k++) { //Percorre a linha

            for (int l = 0; l < matrizReduzida.length; l++) { //Percorre a coluna

                matrizReduzida[k][l] = //Insere dentro da matriz

                        matriz[k >= i ? k + 1 : k][l >= j ? l + 1 : l]; //Se o índice for maior ou igual à coordenada do elemento, soma 1 no índice

            }

        }

        return getDeterminante(matrizReduzida); //Retorna o determinante dessa nova matriz

    }
}
