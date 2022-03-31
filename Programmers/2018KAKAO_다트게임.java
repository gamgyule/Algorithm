class Solution {
    public int solution(String dartResult) {
        int resultScore[] = new int[3];
        char[] arr = dartResult.toCharArray();
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= '0' && arr[i] <= '9') {
                index++;
                if (arr[i] == '1' && arr[i + 1] == '0') {
                    resultScore[index] = 10;
                    i++;
                } else {
                    resultScore[index] = arr[i] - '0';
                }
            } else if (arr[i] == 'D') {
                resultScore[index] *= resultScore[index];
            } else if (arr[i] == 'T') {
                resultScore[index] *= resultScore[index] * resultScore[index];
            } else if (arr[i] == '*') {
                if (index > 0) {
                    resultScore[index - 1] *= 2;
                }
                resultScore[index] *= 2;
            } else if (arr[i] == '#') {
                resultScore[index] *= -1;
            }
        }
        return resultScore[0] + resultScore[1] + resultScore[2];
    }
}