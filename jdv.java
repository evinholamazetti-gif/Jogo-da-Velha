import java.util.Random;
import java.util.Scanner;

public class JogoDaVelha{
    public static void main(String[]args){
        Scanner teclado=new Scanner(System.in);
        Random random=new Random();

        char[][] tabuleiro={
            {' ',' ',' '},
            {' ',' ',' '},
            {' ',' ',' '}
        };

        int jogadas=0;
        boolean venceu=false;

        System.out.println("JOGO DA VELHA");

        while(jogadas<9&&!venceu){
            mostrarTabuleiro(tabuleiro);

            int linha,coluna;

            do{
                System.out.print("Linha(0-2): ");
                linha=teclado.nextInt();

                System.out.print("Coluna(0-2): ");
                coluna=teclado.nextInt();

                if(linha<0||linha>2||coluna<0||coluna>2){
                    System.out.println("Posicao invalida!");
                }else if(tabuleiro[linha][coluna]!=' '){
                    System.out.println("Posicao ocupada!");
                }

            }while(linha<0||linha>2||coluna<0||coluna>2||
                   tabuleiro[linha][coluna]!=' ');

            tabuleiro[linha][coluna]='X';
            jogadas++;

            if(verificarVitoria(tabuleiro,'X')){
                mostrarTabuleiro(tabuleiro);
                System.out.println("Voce venceu!");
                venceu=true;
                break;
            }

            if(jogadas<9){
                int linhaComputador;
                int colunaComputador;

                do{
                    linhaComputador=random.nextInt(3);
                    colunaComputador=random.nextInt(3);
                }while(tabuleiro[linhaComputador][colunaComputador]!=' ');

                tabuleiro[linhaComputador][colunaComputador]='O';
                jogadas++;

                System.out.println("Computador jogou!");

                if(verificarVitoria(tabuleiro,'O')){
                    mostrarTabuleiro(tabuleiro);
                    System.out.println("Computador venceu!");
                    venceu=true;
                }
            }
        }

        if(!venceu){
            mostrarTabuleiro(tabuleiro);
            System.out.println("Empate!");
        }

        teclado.close();
    }

    public static void mostrarTabuleiro(char[][]tabuleiro){
        System.out.println();

        for(int i=0;i<3;i++){
            System.out.println(" "+tabuleiro[i][0]+"|"+
                               tabuleiro[i][1]+"|"+
                               tabuleiro[i][2]);

            if(i<2){
                System.out.println("--+-+--");
            }
        }

        System.out.println();
    }

    public static boolean verificarVitoria(char[][]tabuleiro,char jogador){

        for(int i=0;i<3;i++){
            if(tabuleiro[i][0]==jogador&&
               tabuleiro[i][1]==jogador&&
               tabuleiro[i][2]==jogador){
                return true;
            }
        }

        for(int i=0;i<3;i++){
            if(tabuleiro[0][i]==jogador&&
               tabuleiro[1][i]==jogador&&
               tabuleiro[2][i]==jogador){
                return true;
            }
        }

        if(tabuleiro[0][0]==jogador&&
           tabuleiro[1][1]==jogador&&
           tabuleiro[2][2]==jogador){
            return true;
        }

        if(tabuleiro[0][2]==jogador&&
           tabuleiro[1][1]==jogador&&
           tabuleiro[2][0]==jogador){
            return true;
        }

        return false;
    }
}
