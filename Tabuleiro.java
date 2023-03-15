import java.util.Scanner;
import java.util.Random;

public class Tabuleiro {
  int linhas;
  int colunas;
  int[][] tabuleiro;

  public Tabuleiro(int linhas, int colunas) {
    this.linhas = linhas;
    this.colunas = colunas;
    this.tabuleiro = new int[linhas][colunas];
  }

  public void aleatorizarTabuleiro() {
    Random random = new Random();
    for (int i = 0; i < linhas; i++) {
      for (int j = 0; j < colunas; j++) {
        tabuleiro[i][j] = random.nextInt(2);
      }
    }
  }

  public void imprimirTabuleiro() {
    for (int i = 0; i < linhas; i++) {
      for (int j = 0; j < colunas; j++) {
        System.out.print(tabuleiro[i][j] + " ");
      }
      System.out.println();
    }
  }

  // Borda Infinita
  public void mudarProximaGeracao() {
    int[][] novoTabuleiro = new int[linhas][colunas];

    for (int i = 0; i < linhas; i++) {
      for (int j = 0; j < colunas; j++) {
        int vizinhosVivos = contarVizinhosVivos(i, j);

        if (tabuleiro[i][j] == 1) { // célula viva
          if (vizinhosVivos < 2) {
            novoTabuleiro[i][j] = 0; // morte por solidão
          } else if (vizinhosVivos > 3) {
            novoTabuleiro[i][j] = 0; // morte por superpopulação
          } else {
            novoTabuleiro[i][j] = 1; // célula sobrevive
          }
        } else { // célula morta
          if (vizinhosVivos == 3) {
            novoTabuleiro[i][j] = 1; // célula nasce
          } else {
            novoTabuleiro[i][j] = 0; // célula permanece morta
          }
        }
      }
    }

    tabuleiro = novoTabuleiro;
  }

  
  private int contarVizinhosVivos(int linha, int coluna) {
    int vizinhosVivos = 0;

    // Verifica vizinho ao norte
    int linhaVizinha = (linha - 1 + linhas) % linhas;
    vizinhosVivos += tabuleiro[linhaVizinha][coluna];

    // Verifica vizinho ao sul
    linhaVizinha = (linha + 1) % linhas;
    vizinhosVivos += tabuleiro[linhaVizinha][coluna];

    // Verifica vizinho ao leste
    int colunaVizinha = (coluna + 1) % colunas;
    vizinhosVivos += tabuleiro[linha][colunaVizinha];

    // Verifica vizinho ao oeste
    colunaVizinha = (coluna - 1 + colunas) % colunas;
    vizinhosVivos += tabuleiro[linha][colunaVizinha];

    return vizinhosVivos;
}
}