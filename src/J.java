import java.util.*;

public class J {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] ratings = new int[n];
        for(int i=0; i<n; i++) {
            ratings[i] = scanner.nextInt();
        }
        System.out.println(solution(ratings));
    }

    public static int solution(int[] ratings) {
        if(ratings.length == 0) return 0;
        int[] ans = new int[ratings.length];
        ans[0] = 1;
        for(int i = 1; i<ratings.length; i++){
            if(ratings[i]>ratings[i-1]) ans[i] = ans[i-1]+1;
            else ans[i] = 1;
        }
        int sum = ans[ratings.length-1];
        for(int i = ratings.length-2; i >= 0; i--){
            if(ratings[i]>ratings[i+1]) ans[i] = Math.max(ans[i], ans[i+1]+1);
            sum += ans[i];
        }
        return sum;
    }
}
