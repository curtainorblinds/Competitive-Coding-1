class FindMissing {
    /*
    https://www.geeksforgeeks.org/find-the-missing-number-in-a-sorted-array/
    If no elements was missing, element's value = it's index + 1. If one element
    is missing we are looking for first occurance of value - index = 2. This can be done using
    binary search. For 2 edge cases where first or last element is missing, result will be 1 or
    last element value + 1
    Time: O(log n) Space: O(n)
     */
    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 2, 3, 5, 6};
        System.out.println(findMissing(arr1));

        arr1 = new int[]{1, 3, 4, 5, 6, 7, 8};
        System.out.println(findMissing(arr1));

        arr1 = new int[]{1, 2 ,3, 4};
        System.out.println(findMissing(arr1));

        arr1 = new int[]{2, 3, 4, 5, 6, 7, 8};
        System.out.println(findMissing(arr1));
    }

    public static int findMissing(int[] arr) {
        int low = 0;
        int high = arr.length - 1;

        //first element is missing
        if (arr.length == 0 || (arr[0] == 2)) {
            return 1;
        }

        //last element is missing
        if (arr[arr.length - 1] - (arr.length - 1) == 1) {
            return arr.length + 1;
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if((arr[mid] - mid) == 2) { //found part by which element is missing
                //check if element is missing at the mid index
                if (mid != 0 && (arr[mid - 1] - (mid - 1)) == 1) {
                    return mid + 1;
                } else { //move left and discard right side as we want to find 1st occurance of element missing
                    high = mid - 1;
                }
            } else { // not found a missed element at mid, discard left, move right
                low = mid + 1;
            }
        }
        return -1;
    }
}
