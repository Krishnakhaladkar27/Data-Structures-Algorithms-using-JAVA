import java.util.*;

class SpecialStack {
    private Deque<Long> st;
    private long min;

    public SpecialStack() {
        st = new ArrayDeque<>();
    }

    // Push operation
    public void push(long x) {
        if (st.isEmpty()) {
            st.push(x);
            min = x;
        } else if (x < min) {
            // Encode previous min
            st.push(2 * x - min);
            min = x;
        } else {
            st.push(x);
        }
    }

    // Pop operation
    public void pop() {
        if (st.isEmpty()) return;

        long top = st.pop();
        if (top < min) {
            // Decode previous min
            min = 2 * min - top;
        }
    }

    // Peek operation
    public long peek() {
        if (st.isEmpty()) return -1;

        long top = st.peek();
        return (top < min) ? min : top;
    }

    // Get minimum in O(1)
    public long getMin() {
        return st.isEmpty() ? -1 : min;
    }

    // Check if empty
    public boolean isEmpty() {
        return st.isEmpty();
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        SpecialStack s = new SpecialStack();
        List<String> output = new ArrayList<>();

        for (int i = 0; i < q; i++) {
            int type = sc.nextInt();
            switch (type) {
                case 1 -> { // push
                    long x = sc.nextLong();
                    s.push(x);
                }
                case 2 -> s.pop();
                case 3 -> output.add(String.valueOf(s.peek()));
                case 4 -> output.add(String.valueOf(s.getMin()));
                case 5 -> output.add(String.valueOf(s.isEmpty()));
                default -> throw new IllegalArgumentException("Invalid query type");
            }
        }

        System.out.println(output);
