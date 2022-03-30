import java.util.*;

public class G {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t-- > 0) {
            long n = scanner.nextLong();
            System.out.println(solution(n));
        }
    }

    private static long solution(long n) {
        return n - 1;
    }
}
