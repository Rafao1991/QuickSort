import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] numbers = generateNumbers();
        System.out.println(Arrays.toString(numbers));
        quickSort(numbers, 0, numbers.length - 1);
        System.out.println(Arrays.toString(numbers));
    }

    private static int[] generateNumbers() {
        Random random = new Random();
        int[] returnArray = new int[Math.abs(random.nextInt(999))];
        for (int i = 0; i < returnArray.length; i++)
            returnArray[i] = random.nextInt(99);

        return returnArray;
    }

    private static void quickSort(int[] numbers, int leftIndex, int rightIndex) {
        if (leftIndex <= rightIndex) {
            int pivot = findPivot(numbers, leftIndex, rightIndex);
            quickSort(numbers, leftIndex, pivot - 1);
            quickSort(numbers, pivot + 1, rightIndex);
        }
    }

    private static int findPivot(int[] numbers, int leftIndex, int rightIndex) {
        int pivot = numbers[leftIndex];
        int li = leftIndex + 1;
        int ri = rightIndex;

        do {
            if (numbers[li] <= pivot) {
                li++;
            } else if (numbers[ri] > pivot) {
                ri--;
            } else if (li <= ri) {
                swap(numbers, li, ri);
                li++;
                ri--;
            }
        } while (li <= ri);

        swap(numbers, leftIndex, ri);

        return ri;
    }

    private static void swap(int[] numbers, int leftIndex, int rightIndex) {
        int aux = numbers[leftIndex];
        numbers[leftIndex] = numbers[rightIndex];
        numbers[rightIndex] = aux;
    }
}
