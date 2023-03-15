import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    
    boolean continuar;
    int qualGeracaoEsta = 1;
    Scanner scanner = new Scanner(System.in);
    System.out.println("Informe o tamanho da matriz:");
    int linhas = scanner.nextInt();

    scanner.nextLine();

    int colunas = linhas;

    Tabuleiro tabuleiro = new Tabuleiro(linhas, colunas);
    
    tabuleiro.aleatorizarTabuleiro();
    tabuleiro.imprimirTabuleiro();

    System.out.println("Digite algo para continuar (ou 0 para encerrar):");
    String mudarGeracao = scanner.nextLine();

    if (!mudarGeracao.equals("0")) {
    continuar = true;
    }

    while (!mudarGeracao.equals("0")){
      
      System.out.println("Geração " + qualGeracaoEsta + ":");
      tabuleiro.mudarProximaGeracao();
      tabuleiro.imprimirTabuleiro();
      
      System.out.println("Digite algo para continuar (ou 0 para encerrar):");
      mudarGeracao = scanner.nextLine();
      qualGeracaoEsta++;
      
      if (mudarGeracao.equals("0")) {
        continuar= false;
      }
    }
  scanner.close();
  }
}