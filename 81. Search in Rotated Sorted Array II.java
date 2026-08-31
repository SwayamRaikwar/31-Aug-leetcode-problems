class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return true;
            }

            // Handle duplicates: when left, mid, and right are all equal,
            // we cannot determine which half is sorted. Shrink the search space.
            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                left++;
                right--;
            }
            // Left half is sorted
            else if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1; // Target lies in the left half
                } else {
                    left = mid + 1;  // Target lies in the right half
                }
            }
            // Right half is sorted
            else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;  // Target lies in the right half
                } else {
                    right = mid - 1; // Target lies in the left half
                }
            }
        }

        return false;
    }
}
