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

        // Count how many tasks have the maximum frequency
        int maxCount = 0;

        for (int count : freq) {
            if (count == maxFreq) {
                maxCount++;
            }
        }

        // Calculate minimum intervals
        int intervals = (maxFreq - 1) * (n + 1) + maxCount;

        // If there are enough different tasks to fill the gaps,
        // no idle time is needed.
        return Math.max(intervals, tasks.length);
    }
}
