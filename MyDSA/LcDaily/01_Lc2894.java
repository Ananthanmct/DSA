class Solution {
    public int differenceOfSums(int n, int m) {
        int tf = n/m;
        int sum = (tf*(tf + 1))/2;
        int divSum = m*sum;
        int nonDivSum = (n*(n+1)/2) - divSum;
        return nonDivSum - divSum;
    }
}
