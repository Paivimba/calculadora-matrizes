package com.example.calculadoramatrizes;

public class SistemaLinear {
    /*
     *
     * ax + by + cz = k
     * dx + ey + fz = l
     * gx + hy + iz = m
     *
     * [ a  b  c ]   [ x ]   [ k ]
     * [ d  e  f ] * [ y ] = [ l ]
     * [ g  h  i ]   [ z ]   [ m ]
     *
     * Por Cramer
     *
     *      | a  b  c |
     *  D = | d  e  f |
     *      | g  h  i |
     *
     *
     *       | k  b  c |
     *  Dx = | l  e  f |
     *       | m  h  i |
     *
     *       | a  k  c |
     *  Dy = | d  l  f |
     *       | g  m  i |
     *
     *       | a  b  k |
     *  Dz = | d  e  l |
     *       | g  h  m |
     *
     *
     *  x = Dx / D; y = Dy / D; z = Dz / D.
     *
     */

    /* ==============================================================================================*/
    /* ==================================== ATRIBUTOS DA CLASSE ==================================== */

    private float[][] coeficientes;
    private float[] termosIndependentes;

    /* ===============================================================================================*/
    /* ==================================== CONSTRUTOR DA CLASSE ==================================== */

    public SistemaLinear(float[][] coeficientes, float[] termosIndependentes) {

        this.coeficientes = coeficientes;

        this.termosIndependentes = termosIndependentes;

    }

    /* ===============================================================================================*/
    /* ====================================== MÉTODOS DA CLASSE ======================================*/

    public String getSolucao() { //Método que retorna a solução como String e sua classificação

        float determinante = new Laplace().getDeterminante(coeficientes); //Calcula o determinante da matriz formada pelos coeficientes

        float[] solucao = getSolucao(determinante); //Chama o método que calcula a solução e retorna um vetor

        String retorno = "Sistema Possível -> "; //Inicializa a variável de retorno considerando SPD

        for (int i = 0; i < solucao.length; i++) { //Percorre a solução

            if (determinante == 0 && solucao[i] != 0) //Caso o det seja 0 e a solução diferente de 0

                return "Sistema Impossível!"; //Retorna a classificação SI

            if (determinante == 0 && solucao[i] == 0) //Caso o det e a solução seja igual à 0

                retorno = "Sistema Possível e Indeterminado!"; //Insere em retorno a classificação SPI

            if (determinante != 0) //Se o determinante for diferente de 0

                retorno += solucao[i] + "; "; //Concatena a solução

        }

        return retorno; //Retorna a análise do sistema

    }

    public float[] getSolucao(float determinante) { //Método que calcula a solução do sistema

        Laplace laplace = new Laplace(); //Objeto da classe Laplace

        float[] solucao = new float[coeficientes.length]; //Cria um vetor com base no gruau de liberdade do sistema

        for (int j = 0; j < coeficientes.length; j++) //Percorre as colunas do coeficiente

            solucao[j] = laplace.getDeterminante(substituiColuna(j)) //Pega o determinante da matriz com a coluna substituída

                    / (determinante != 0 ? determinante : 1); //Caso o determiante seja 0, divide por 1

        return solucao; //Retorna o vetor de solução

    }

    private float[][] substituiColuna(int coluna) { //Método para subtituir os termos independentes na matriz dos coeficientes

        float[][] matriz = new float[coeficientes.length][coeficientes.length];

        for (int i = 0; i < coeficientes.length; i++) { //Percorre a linha

            for (int j = 0; j < matriz.length; j++) { //Percorre a coluna

                matriz[i][j] = (j != coluna ? //Se não corresponder a coluna que deseja alterar

                        coeficientes[i][j] : //Passa o coeficiente da matriz original

                        termosIndependentes[i]); //Senão, passa o termo independente

            }

        }

        return matriz; //Retorna a matriz

    }
}
