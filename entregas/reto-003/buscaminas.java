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

        int explosiones = 0;
        int descubiertas = 0;
        int seguras = 35 - 5;

        char[][] tablero = new char[5][7];
        boolean[][] minas = new boolean[5][7];
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese X: ");
        int x = sc.nextInt() - 1;

        System.out.print("Ingrese Y: ");
        int y = sc.nextInt() - 1;

        int colocadas = 0;
        while (colocadas < 5) {
            int x = rand.nextInt(5);
            int y = rand.nextInt(7);

            if (!minas[x][y]) {
                minas[x][y] = true;
                colocadas++;
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 7; j++) {
                tablero[i][j] = '-';
            }
        }

        imprimirTablero(tablero);
        if (minas[x][y]) {
            tablero[x][y] = '*';
            System.out.println("Mina!");
        } else {
            tablero[x][y] = '.';
            System.out.println("Libre!");
        }

        imprimirTablero(tablero);
        while (explosiones < 3 && descubiertas < seguras) {

            imprimirTablero(tablero);

            System.out.print("Ingrese X: ");
            int x = sc.nextInt() - 1;

            System.out.print("Ingrese Y: ");
            int y = sc.nextInt() - 1;

            if (tablero[x][y] != '-')
                continue;

            if (minas[x][y]) {
                tablero[x][y] = '*';
                explosiones++;
                System.out.println("Mina!");
            } else {
                tablero[x][y] = '.';
                descubiertas++;
                System.out.println("Libre!");
            }
        }

    }
}
