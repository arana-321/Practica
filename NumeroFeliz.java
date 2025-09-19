
/**
 * Write a description of class dgdfsg here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.HashSet;
import java.util.Scanner;

public class NumeroFeliz {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("=== NUMERO FELIZ ===");
        System.out.print("Ingrese un numero: ");
        int num = in.nextInt();

        boolean resultado = esNumeroFeliz(num);
        System.out.println("¿El numero " + num + " es feliz? -> " + resultado);
    }

    public static boolean esNumeroFeliz(int n) {
        HashSet<Integer> visitados = new HashSet<>();

        while (n != 1 && !visitados.contains(n)) {
            visitados.add(n);
            n = sumaCuadrados(n);
        }
        return n == 1;
    }

    private static int sumaCuadrados(int n) {
        int suma = 0;
        while (n > 0) {
            int digito = n % 10;
            suma += digito * digito;
            n /= 10;
        }
        return suma;
    }
}
