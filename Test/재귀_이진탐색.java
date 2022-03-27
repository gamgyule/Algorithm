public static int recursiveBinarySearch(int target, int first, int last) {
        int mid = (first + last) / 2;

        if (first > last)
            return -1;

        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] > target) {
            return recursiveBinarySearch(target, first, mid - 1);
        } else {
            return recursiveBinarySearch(target, mid + 1, last);
        }
    }