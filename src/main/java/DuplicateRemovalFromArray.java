//Remove Duplicates from the array
public class DuplicateRemovalFromArray {
        public static void main(String[] args) {
            int arr[] = new int[] { 1, 2, 3, 4, 5, 6, 7, 2, 3, 4, 9 };
            int size = arr.length;
            for (int i = 0; i < size; i++) {
                for (int j = i+1; j < size; j++) {
                    if (arr[i] == arr[j]) {
                        while (j < (size) - 1) {
                            arr[j] = arr[j + 1];
                            j++;
                        }
                        size--;
                    }
                }
            }
            for (int i = 0; i < size; i++) {
                System.out.print(arr[i] + "  ");
            }
        }
}