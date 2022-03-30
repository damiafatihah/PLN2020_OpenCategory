import java.util.*;

public class F {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t-- > 0) {
            int n = scanner.nextInt();
            scanner.nextLine();
            Set<String> wordList = new HashSet<>();
            for(int i=0; i<n; i++) {
                wordList.add(scanner.nextLine());
            }
            int query = scanner.nextInt();
            scanner.nextLine();
            for(int i=0; i<query; i++) {
                String startingWord = scanner.next();
                String endingWord = scanner.next();
                System.out.println(startingWord + " " + endingWord + " " + solution(startingWord, endingWord, wordList));
            }
        }
    }

    public static int solution(String startingWord, String endingWord, Set<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        Queue<String> visited = new LinkedList<>();
        visited.offer(startingWord);
        int steps = 0;
        while (!visited.isEmpty()) {
            for (int i=0; i<visited.size(); i++) {
                String current = visited.poll();
                for (int j=0; j<endingWord.length(); j++) {
                    for (char letter='a'; letter<='z'; letter++) {
                        StringBuilder newWord = new StringBuilder(current);
                        newWord.setCharAt(j, letter);
                        if (wordSet.contains(newWord.toString())) {
                            if (newWord.toString().equals(endingWord)) return steps + 1;
                            wordSet.remove(newWord.toString());
                            visited.offer(newWord.toString());
                        }
                    }
                }

            }
            steps++;
        }
        return 0;
    }
}
