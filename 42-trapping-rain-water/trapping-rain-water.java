class Solution {

    public int trap(int[] ar) {

        int leftMax[] = new int[ar.length];
        int rightMax[] = new int[ar.length];

        // Maximum from left
        leftMax[0] = ar[0];

        for (int i = 1; i < ar.length; i++) {
            leftMax[i] = Math.max(ar[i], leftMax[i - 1]);
        }

        // Maximum from right
        rightMax[ar.length - 1] = ar[ar.length - 1];

        for (int j = ar.length - 2; j >= 0; j--) {
            rightMax[j] = Math.max(ar[j], rightMax[j + 1]);
        }

        int area = 0;

        for (int k = 0; k < ar.length; k++) {

            int waterLevel = Math.min(leftMax[k], rightMax[k]);

            area += waterLevel - ar[k];
        }

        return area;
    }
}