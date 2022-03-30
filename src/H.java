import java.util.*;

public class H {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t-- > 0) {
            int n = scanner.nextInt();
            int m  = scanner.nextInt();
            int[][] arr = new int[n][m];
            for(int i=0; i<n; i++) {
                for(int j=0; j<m; j++) {
                    arr[i][j] = scanner.nextInt();
                }
            }
            System.out.println(solution(arr));
        }
    }
    public static int solution(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        for(int i=1; i<n; i++) arr[i][0] += arr[i-1][0];
        for(int j=1; j<m; j++) arr[0][j] += arr[0][j-1];
        for(int i=1; i<n; i++) {
            for(int j=1; j<m; j++) {
                arr[i][j] += Math.max(arr[i-1][j], arr[i][j-1]);
            }
        }
        return arr[n-1][m-1];
    }
}
