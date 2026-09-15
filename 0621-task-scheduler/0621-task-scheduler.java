class Solution {
    public int leastInterval(char[] tasks, int n) {

        // Count frequency of each task
        int[] freq = new int[26];

        for (char task : tasks) {
            freq[task - 'A']++;
        }

        // Find the maximum frequency
        int maxFreq = 0;

        for (int count : freq) {
            maxFreq = Math.max(maxFreq, count);
        }

        // Number of tasks having maximum frequency
        int maxCount = 0;

        for (int count : freq) {
            if (count == maxFreq) {
                maxCount++;
            }
        }

        /*
         * Arrange the most frequent tasks first.
         *
         * Example:
         * A A A
         * B B B
         *
         * n = 2
         *
         * A B _ A B _ A B
         *
         * Formula:
         * (maxFreq - 1) * (n + 1) + maxCount
         */
        int result = (maxFreq - 1) * (n + 1) + maxCount;

        // We cannot have fewer intervals than the number of tasks.
        return Math.max(result, tasks.length);
    }
}
