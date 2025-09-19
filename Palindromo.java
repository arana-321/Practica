/**
 * Write a description of class sudcadena here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Scanner;

public class Palindromo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Ingrese una cadena: ");
        String s = in.nextLine();
        if (s == null || s.length() == 0) {
            System.out.println("Salida: \"\" (cadena vacia)");
            return;
        }

        String resultado = Palindromo(s);
        System.out.println("Subcadena palindroma: " + resultado);

            }

    public static String Palindromo(String s) {
        int start = 0, end = 0; 
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);

            if (len > (end - start + 1)) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        
        return right - left - 1;
    }
}

