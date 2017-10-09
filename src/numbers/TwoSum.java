package numbers;

import java.util.HashMap;
import java.util.Map;

/**
 *
 Given an array of integers, return indices of the two numbers such that they add up to a specific target.

 You may assume that each input would have exactly one solution, and you may not use the same element twice.

 Example:
 Given nums = [2, 7, 11, 15], target = 9,

 Because nums[0] + nums[1] = 2 + 7 = 9,
 return [0, 1].
 *
 * @author: liuluming
 * @CreatedDate: 2017/10/9 上午11:04
 */
public class TwoSum {

    /**
     * 双重遍历法。
     * 这是最容易想到的方法，暴力且愚蠢。我当初解题时只想到了这个方法，惭愧。
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums, int target) {
        if(nums.length<2){
            throw new IllegalArgumentException("the number array is illegal!");
        }
        int[] result=new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                int sum=nums[i]+nums[j];
                if(sum==target){
                    result[0]=i;
                    result[1]=j;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * List 转 Map，通过高效的Map.containsKey( )来匹配想要的数据。
     * 遍历了两次。
     * @param nums
     * @param target
     * @return
     */

    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    //

    /**
     * 推荐解法：
     * 在方法2的基础上，将数组转Map的动作，跟遍历数组的动作，合二为一，使代码更简洁。
     * 只需要遍历一次。
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
/**
 * 总结：
 *
 1. 尽量避免残忍暴力的解决方法（方法1）。
 2. 在做遍历的时候，优先考虑将需要遍历的数组，放入到Map中，通过高效的Map.containsKey( )来匹配想要的数据（方法2）。
 3. 将数组转Map的动作，跟遍历数组的动作，合二为一，使代码更简洁（方法3）。
 *
 */