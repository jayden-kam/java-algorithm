package jayden.learn.ds;

public class BinarySearch {

    public static int search(int[] searchable, int target) {
        int left = 0, right = searchable.length;
        while (right > left) {
            int mid = (left + right) / 2;
            int midValue = searchable[mid];
            if (midValue == target) {
                return mid;
            } else if (midValue < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return -1;
    }
}
