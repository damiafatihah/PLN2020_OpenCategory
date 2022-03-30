import java.util.*;
import java.lang.NumberFormatException;

public class A {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.nextLine();
        while(t-- > 0) {
            String s = scanner.next();
            int from = scanner.nextInt();
            int to = scanner.nextInt();
            System.out.println(solution(s, from, to));
        }
    }

    public static String solution(String s, int from, int to) {
        try {
            return Integer.toString(Integer.parseInt(s, from), to);
        } catch(NumberFormatException e) {
            return "INVALID";
        }
    }
}
