package com.example.calculadoramatrizes;

public class Inversa {
    /* ==============================================================================================*/
    /* ==================================== ATRIBUTOS DA CLASSE ==================================== */

    private float[][] matriz;

    /* ===============================================================================================*/
    /* ==================================== CONSTRUTOR DA CLASSE ==================================== */

    public Inversa(float[][] matriz) {

        this.matriz = matriz;

    }

    /* ===============================================================================================*/
    /* ====================================== MÉTODOS DA CLASSE ======================================*/

    public float[][] getInversa() { //Retorna a matriz inversa

        float determinante = new Laplace().getDeterminante(matriz); //Pega o determinante da matriz

        if (determinante == 0) return null; //Não possui inversa

        //Cria uma matriz com as mesmas dimensões da original
        float matrizInversa[][] = new float[matriz.length][matriz.length];

        /*
         * [ A  B  C ]   [ a  b  c ]   [ 1  0  0 ]
         * [ D  E  F ] * [ d  e  f ] = [ 0  1  0 ]
         * [ G  H  I ]   [ g  h  i ]   [ 0  0  1 ]
         *
         * Aa + Bd + Cg = 1
         * Da + Ed + Fg = 0
         * Ga + Hd + Ig = 0
         *
         * Ab + Be + Ch = 0
         * Db + Ee + Fh = 1
         * Gb + He + Ih = 0
         *
         * Ac + Bf + Ci = 0
         * Dc + Ef + Fi = 0
         * Gc + Hf + Ii = 1
         *
         */

        for (int j = 0; j < matriz.length; j++) { //Percorre as colunas da matriz

            //Para calcular a inversa, cria-se um sistema linear com os elementos da matriz e a matriz identidade

            float[] solucao = new SistemaLinear(matriz, //Passa a matriz no construtor

                    getColuna(j)). //Pega a coluna da matriz identidade

                    getSolucao(determinante); //Passa o determinante para calcular a solução do sistema

            for (int i = 0; i < matriz.length; i++) { //Percorre as linhas da coluna

                matrizInversa[i][j] = solucao[i]; //Passa o valor da solução para a matriz inversa

            }

        }

        return matrizInversa; //Retorna a matriz inversa

    }

    private float[] getColuna(int j) { //Método que retorna a coluna da matriz identidade

        float[] coluna = new float[matriz.length];

        for (int i = 0; i < matriz.length; i++) {

            coluna[i] = i == j ? 1 : 0; //Se i == j retorna 1, se for diferente 0

        }

        return coluna;

    }
}
