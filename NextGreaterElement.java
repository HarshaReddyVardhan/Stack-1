/*
Time Complexity (TC)
O(n): Each element is pushed and popped from the stack once in the worst case.
Space Complexity (SC)
O(n): Stack can store up to n indices in the worst case, and ans array takes O(n).
Approach in 3 Sentences
Iterate through the array twice (2n iterations) to simulate the circular nature.
Use a monotonic stack to track indices of elements for which the next greater element hasn't been found yet.
For each number, pop from the stack while the current number is greater than the number at the stack's top index, then record the current number as the next greater element.
  */
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        int []ans = new int[n];
        Arrays.fill(ans,-1);
        for(int i=0;i<2*n;++i){
            while(!st.isEmpty() && nums[i%n] > nums[st.peek()]){
                ans[st.peek()] = nums[i%n];
                st.pop();
            }
            if(i < n)
                st.push(i);
        }
        return ans;
    }
}
