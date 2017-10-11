package collection;

/**
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 * <p>
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * <p>
 * For example,
 * Given input array nums = [1,1,2],
 * <p>
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.
 *
 * @author: liuluming
 * @CreatedDate: 2017/10/11 上午11:04
 */
public class CountUniqueElementArray {

    /**
     * 思路：
     * 1、用一个指针，循环遍历所有元素。
     * 2、把不重复的元素放在一起，用一个指针指向最后一个不重复的元素；
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        // 不重复元素的总数
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                // 把不重复元素放在一起
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
