public class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;

        // PHASE 1: Build Max-Heap
        // Start from the last parent node (n/2 - 1) up to the root (0)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(nums, n, i);
        }

        // PHASE 2: Extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Swap current root (largest) to end of array
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;

            // Restore heap property for reduced array size `i`
            heapify(nums, i, 0);
        }

        return nums;
    }

    // Restores max-heap property iteratively (O(1) auxiliary space)
    private void heapify(int[] nums, int length, int i) {
        while (true) {
            int largest = i;
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            if (left < length && nums[left] > nums[largest]) {
                largest = left;
            }

            if (right < length && nums[right] > nums[largest]) {
                largest = right;
            }

            // If a child was larger than parent, swap and continue down
            if (largest != i) {
                int temp = nums[i];
                nums[i] = nums[largest];
                nums[largest] = temp;
                
                i = largest; // Move pointer down to child position
            } else {
                break; // Parent is larger than both children -> heap rule satisfied
            }
        }
    }
}