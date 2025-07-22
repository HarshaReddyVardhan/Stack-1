/*
Time Complexity (TC)
O(n): Each temperature index is pushed and popped from the stack at most once, leading to linear time.

Space Complexity (SC)
O(n): In the worst case, the stack may hold all indices if the array is in strictly decreasing order.

Approach:
Use a stack of pairs to keep track of temperatures along with their indices, maintaining a decreasing sequence.
For each temperature, if it is greater than the temperature at the top of the stack, pop and record the number of days waited in the answer array.
Push the current temperature and index onto the stack and repeat until the end of the array.

  */
class Solution {

    class Pair {
        int val;
        int index;

        public Pair(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }

    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Pair> st = new Stack<>();
        int n = temperatures.length;
        int []ans = new int[n];
        st.push(new Pair(temperatures[0],0));
        for(int i=1;i<n;++i){
            while(!st.isEmpty() && st.peek().val < temperatures[i]){
                ans[st.peek().index] = i - st.peek().index;
                st.pop();
            }
            st.push(new Pair(temperatures[i],i));
        }
        return ans;
    }
}
