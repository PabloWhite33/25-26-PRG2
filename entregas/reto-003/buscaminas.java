import java.util.Scanner;
import java.util.Random;

public class buscaminas {

    public static void imprimirTablero(char[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        char[][] tablero = new char[5][7];

        for(int i=0;i<5;i++){
            for(int j=0;j<7;j++){
                tablero[i][j] = '-';
            }
        }

        imprimirTablero(tablero);
    }
}
