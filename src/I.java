import java.util.*;

public class I {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();
        while(t-- > 0) {
            String s = scanner.nextLine();
            solution(s);
        }
    }

    public static void solution(String s) {
        Stack<Character> stack = new Stack<>();
        int count = 0, count1 = 0;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '{') stack.push(s.charAt(i));
            else if(!stack.empty() && s.charAt(i) == '}') stack.pop();
            else if (stack.empty() && s.charAt(i) == '}') {
                stack.push('{');
                count++;
            }
        }
        while(!stack.empty()) {
            count1++;
            stack.pop();
        }
        int x = count1 / 2;
        System.out.println(count + x);
    }
}
