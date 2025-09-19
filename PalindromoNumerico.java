
/**
 * Write a description of class ghjg here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Scanner;

public class PalindromoNumerico {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("=== PALINDROMO NUMERICO ===");
        System.out.print("Ingrese un numero entero positivo: ");
        int num = in.nextInt();

        boolean resultado = esPalindromo(num);
        System.out.println("¿El numero " + num + " es palindromo? -> " + resultado);
    }

    // Función para verificar si un número es palindromo
    public static boolean esPalindromo(int n) {
        int original = n;
        int invertido = 0;

        while (n > 0) {
            int digito = n % 10;
            invertido = invertido * 10 + digito;
            n /= 10;
        }

        return original == invertido;
    }
}
