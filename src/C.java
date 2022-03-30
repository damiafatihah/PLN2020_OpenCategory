import java.util.*;

public class C {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t-- > 0) {
            int n = scanner.nextInt();
            solution(n);
        }
    }

    public static void solution(int n) {
        long ws = (long) (3*n*(Math.pow((n + 1), 2)));
        long p = (long) Math.pow((n + 1), 3);
        System.out.print(ws + " " + p);
    }
}
