class Solution {
public:
    int longestSubarray(vector<int>& nums, int limit) {
        deque<int> maxDq; // decreasing -> front is maximum
        deque<int> minDq; // increasing -> front is minimum

        int left = 0;
        int ans = 0;

        for (int right = 0; right < nums.size(); right++) {

            // Maintain decreasing deque for maximum
            while (!maxDq.empty() && nums[maxDq.back()] <= nums[right]) {
                maxDq.pop_back();
            }
            maxDq.push_back(right);

            // Maintain increasing deque for minimum
            while (!minDq.empty() && nums[minDq.back()] >= nums[right]) {
                minDq.pop_back();
            }
            minDq.push_back(right);

            // Shrink window if invalid
            while (nums[maxDq.front()] - nums[minDq.front()] > limit) {

                if (maxDq.front() == left) {
                    maxDq.pop_front();
                }

                if (minDq.front() == left) {
                    minDq.pop_front();
                }

                left++;
            }

            ans = max(ans, right - left + 1);
        }

        return ans;
    }
};
