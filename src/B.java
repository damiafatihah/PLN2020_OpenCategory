import java.util.*;

public class B {
    // code from Sam
    static Scanner scanner = new Scanner(System.in);
    static Map<Integer, Node> map = new HashMap<>();
    static Map<Integer, Long> dp = new HashMap<>();

    public static void main(String[] args) {
        int n = scanner.nextInt();
        int q = scanner.nextInt();

        map.put(0, new Node(0, 0, -1));
        for (int i = 0; i < n; i++) {
            int pid = scanner.nextInt();
            int ppid = scanner.nextInt();
            int memory = scanner.nextInt();
            map.put(pid, new Node(pid, memory, ppid));
            map.get(ppid).children.add(pid);
        }

        for (int i = 0; i < q; i++) {
            solution();
        }
    }
    public static void solution() {
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        Set<Integer> process1 = new HashSet<>();
        Set<Integer> process2 = new HashSet<>();
        process1.add(a);
        process2.add(b);
        do {
            if(process1.contains(b)) {
                System.out.println(map.get(b).getMemory());
                break;
            }
            else if (process2.contains(a)) {
                System.out.println(map.get(a).getMemory());
                break;
            }
            a = map.get(a).ppid;
            b = map.get(b).ppid;
            process1.add(map.get(a).ppid);
            process2.add(map.get(b).ppid);
        } while(true);
    }

    // code from Sam
    static class Node {
        int pid;
        int ppid;
        int memory;
        List<Integer> children;

        public Node(int pid, int memory, int ppid) {
            this.pid = pid;
            this.ppid = ppid;
            this.memory = memory;
            children = new ArrayList<>();
        }

        public long getMemory() {
            if (dp.containsKey(pid))
                return dp.get(pid);

            long sum = memory;
            for (int id : children)
                sum += map.get(id).getMemory();
            dp.put(pid, sum);
            return sum;
        }
    }
}
