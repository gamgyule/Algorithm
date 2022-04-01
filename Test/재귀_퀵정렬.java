import java.util.Arrays;

public class Main {

    public static void main(String args[]) {
        int arr[] = new int[] { 1, 4, 3, 6, 8, 9, 5, 2, 7 };

        System.out.println(Arrays.toString(arr));
        quickSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    static void quickSort(int arr[]) {
        quickSort(arr, 0, arr.length - 1);
    }

    static void quickSort(int arr[], int start, int end) {
        int part2 = partitioning(arr, start, end);
        if (start < part2 - 1) {
            quickSort(arr, start, part2 - 1);
        }

        if (part2 < end) {
            quickSort(arr, part2, end);
        }
    }

    static int partitioning(int arr[], int start, int end) {
        int pivot = arr[start + (end - start) / 2];
        while (start <= end) {
            while (arr[start] < pivot)
                start++;
            while (arr[end] > pivot)
                end--;

            if (start <= end) {
                swap(arr, start, end);
                start++;
                end--;
            }

        }
        return start;
    }

    static void swap(int arr[], int start, int end) {
        int temp = arr[end];
        arr[end] = arr[start];
        arr[start] = temp;

    }
}