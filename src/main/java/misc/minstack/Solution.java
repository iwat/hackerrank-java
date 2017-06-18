package misc.minstack;

import java.util.*;

public class Solution {
    Stack<Integer> data = new Stack();
    Stack<Integer> min = new Stack();

    void push(int n) {
        data.push(n);
        if (min.size() > 0) {
            min.push(min.peek() > n ? n : min.peek());
        } else {
            min.push(n);
        }
    }

    int pop() {
        min.pop();
        return data.pop();
    }

    int min() {
        return min.peek();
    }
}

