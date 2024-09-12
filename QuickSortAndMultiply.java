
import java.util.Arrays;

public class QuickSortAndMultiply {
    
    // QuickSort Algorithm with First Element as Pivot
    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    // Partition function
    public static int partition(int[] array, int low, int high) {
        int pivot = array[low];  // First element as pivot
        int i = low + 1;

        for (int j = low + 1; j <= high; j++) {
            if (array[j] < pivot) {
                swap(array, i, j);
                i++;
            }
        }
        swap(array, low, i - 1);  // Move pivot to the correct position
        return i - 1;
    }

    // Swap function
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // Pseudo code (already implemented in functions)
    public static void pseudoCode() {
        System.out.println("Pseudo Code for QuickSort:");
        System.out.println("1. Choose the first element as the pivot.");
        System.out.println("2. Partition the array around the pivot.");
        System.out.println("3. Recursively apply QuickSort on the subarrays.");
    }

    // Time complexity is O(n log n) for average case, O(n^2) for worst case

    // Divide and Conquer Multiplication Technique (Karatsuba Algorithm)
    public static long karatsubaMultiply(long x, long y) {
        if (x < 10 || y < 10) {
            return x * y;
        }

        int n = Math.max(Long.toString(x).length(), Long.toString(y).length());
        int halfN = n / 2;

        long a = x / (long) Math.pow(10, halfN);
        long b = x % (long) Math.pow(10, halfN);
        long c = y / (long) Math.pow(10, halfN);
        long d = y % (long) Math.pow(10, halfN);

        long ac = karatsubaMultiply(a, c);
        long bd = karatsubaMultiply(b, d);
        long abcd = karatsubaMultiply(a + b, c + d);

        return ac * (long) Math.pow(10, 2 * halfN) + (abcd - ac - bd) * (long) Math.pow(10, halfN) + bd;
    }

    public static void main(String[] args) {
        int[] arr = {5, 1, 8, 11, 3, 7, 2, 9, 4};

        // QuickSort
        System.out.println("Original Array: " + Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println("Sorted Array using QuickSort: " + Arrays.toString(arr));

        // Pseudo code
        pseudoCode();

        long num1 = 6754;
        long num2 = 2154;
        long result = karatsubaMultiply(num1, num2);
        System.out.println("Multiplication of " + num1 + " and " + num2 + " using Divide and Conquer: " + result);
    }
}
