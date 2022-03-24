class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] rowCount = new int[mat.length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1)
                    rowCount[i]++;
            }
        }
        int[] result = new int[k];
        for (int j = 0; j < k; j++) {
            int min = 99;
            int minI = 0;
            for (int i = 0; i < rowCount.length; i++) {
                if (min > rowCount[i]) {
                    min = rowCount[i];
                    minI = i;
                }
            }
            result[j] = minI;
            rowCount[minI] = 99;
        }
        return result;
    }
}