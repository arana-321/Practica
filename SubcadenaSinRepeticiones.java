
/**
 * Write a description of class fbfbf here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SubcadenaSinRepeticiones {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("=== LONGITUD SUBCADENA SIN REPETICIONES ===");
        System.out.print("Ingrese una cadena: ");
        String s = in.nextLine();

        Result resultado = longestUniqueSubstr(s);
        System.out.println("Longitud maxima: " + resultado.length);
        System.out.println("Una subcadena valida: \"" + resultado.substring + "\"");
    }

    static class Result {
        int length;
        String substring;
        Result(int length, String substring) {
            this.length = length;
            this.substring = substring;
        }
    }

    public static Result longestUniqueSubstr(String s) {
        if (s == null || s.isEmpty()) return new Result(0, "");

        Map<Character, Integer> lastIndex = new HashMap<>(); 
        int left = 0;            
        int maxLen = 0;
        int startOfMax = 0;      

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (lastIndex.containsKey(c)) {
                left = Math.max(left, lastIndex.get(c) + 1);
            }
            
            lastIndex.put(c, right);

            int windowLen = right - left + 1;
            if (windowLen > maxLen) {
                maxLen = windowLen;
                startOfMax = left;
            }
        }

        String bestSubstr = s.substring(startOfMax, startOfMax + maxLen);
        return new Result(maxLen, bestSubstr);
    }
}

