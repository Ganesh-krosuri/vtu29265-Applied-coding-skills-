class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        int totalSum = 0;

        // Find total sum of all elements
        for (int num : nums) {
            totalSum += num;
        }

        int leftSum = 0;

        for (int i = 0; i < n; i++) {
            int leftCount = i;
            int rightCount = n - i - 1;

            // Contribution from elements on the left
            int left = nums[i] * leftCount - leftSum;

            // Sum of elements on the right
            int rightSum = totalSum - leftSum - nums[i];

            // Contribution from elements on the right
            int right = rightSum - nums[i] * rightCount;

            result[i] = left + right;

            leftSum += nums[i];
        }

        return result;
    }
}