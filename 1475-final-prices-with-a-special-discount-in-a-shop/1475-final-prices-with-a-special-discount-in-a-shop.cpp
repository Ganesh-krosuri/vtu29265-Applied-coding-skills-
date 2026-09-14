class Solution {
public:
    vector<int> finalPrices(vector<int>& prices) {
        stack<int> st;

        for (int i = 0; i < prices.size(); i++) {
            while (!st.empty() && prices[st.top()] >= prices[i]) {
                int idx = st.top();
                st.pop();

                prices[idx] -= prices[i];
            }

            st.push(i);
        }

        return prices;
    }
};
