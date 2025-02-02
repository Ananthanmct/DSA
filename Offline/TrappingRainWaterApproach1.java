class Solution {
    public int trap(int[] height) {
        int [] pMax = new int[height.length];
        int [] sMax = new int[height.length];

        int i = 0;
        int j = height.length - 1;

        while(i < height.length && j >= 0){
            if(i == 0){
                pMax[0] = height[0];
                sMax[height.length - 1] = height[height.length - 1];
            }else{
                pMax[i] = Math.max(height[i], pMax[i - 1]);
                sMax[j] = Math.max(height[j], sMax[j + 1]);
            }
            i++;
            j--;
        }

        int totalWaterLogged = 0;

        for(i  = 0; i < height.length; i++ ){
            int lMax = pMax[i];
            int rMax = sMax[i];
            totalWaterLogged += Math.min(lMax, rMax) - height[i];
        }

        return totalWaterLogged;


    }
}
