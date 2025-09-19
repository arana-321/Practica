
/**
 * Write a description of class dfgdfg here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Scanner;

public class NumeroArmstrong {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("=== NUMERO ARMSTRONG ===");
        System.out.print("Ingrese un numero: ");
        int num = in.nextInt();

        boolean resultado = esArmstrong(num);
        System.out.println("¿El numero " + num + " es Armstrong? -> " + resultado);
    }

    public static boolean esArmstrong(int n) {
        String numeroStr = String.valueOf(n);
        int digitos = numeroStr.length();
        int suma = 0;
        int temp = n;

        while (temp > 0) {
            int digito = temp % 10;
            suma += Math.pow(digito, digitos);
            temp /= 10;
        }
        return suma == n;
    }
}
