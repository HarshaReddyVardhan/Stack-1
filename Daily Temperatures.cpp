// TC : O(N)
// SC : O(N)
// Approach : 
// Use a monotonic decreasing stack to keep track of indices of unresolved temperatures.
// For each day's temperature, pop from the stack while the current temperature is higher, and record the difference in days.
// After processing, any remaining indices in the stack have no warmer days ahead, so their value remains zero.

class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& temp) {
        int n = temp.size();
        vector<int> ans(n,0);
        stack<int> st;
        st.push(0);
        for(int i=1;i<n;++i){
            while(!st.empty() && temp[i] > temp[st.top()]){
                ans[st.top()] = i - st.top();
                st.pop();
            }
            st.push(i);
        }
        return ans;
    }
};
