class Solution {
    public int findKthNumber(int n, int k) {
        int current = 1;
        k--;

        while (k > 0) {
            int count = countSteps(n, current, current + 1);
            if (count <= k) {
                current++;
                k -= count;
            } else {
                current *= 10;
                k--;
            }
        }

        return current;
    }

    private int countSteps(int n, long start, long end) {
        int steps = 0;
        while (start <= n) {
            steps += Math.min(n + 1, end) - start;
            start *= 10;
            end *= 10;
        }
        return steps;
    }
}