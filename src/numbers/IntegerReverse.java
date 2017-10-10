package numbers;

/**
 * Reverse digits of an integer.
 * <p>
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 * <p>
 * click to show spoilers.
 * <p>
 * Have you thought about this?
 * Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!
 * <p>
 * If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.
 * <p>
 * Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. How should you handle such cases?
 * <p>
 * For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 * <p>
 * Note:
 * The input is assumed to be a 32-bit signed integer. Your function should return 0 when the reversed integer overflows.
 *
 * @author: liuluming
 * @CreatedDate: 2017/10/10 上午10:39
 */
public class IntegerReverse {

    public static void main(String[] args) {
        int i = -4, j = 3;
        int k = i % j;
        System.out.println("k=" + k);
    }

    /**
     * 我的解法。
     * 思路：先将数字转化为字符串，然后将字符串倒序输出，并转回数字。记得需要去除首部多余的0。
     * 复杂度：时间 O(n) 空间 O(n)
     *
     * @param x
     * @return
     */
    public int reverse(int x) {
        StringBuilder sb = new StringBuilder();
        String s = Integer.toString(x);
        if (s.startsWith("-")) {
            sb.append("-");
        }

        char[] chars = s.toCharArray();
        boolean isHeadZero = true;
        for (int i = chars.length - 1; i > -1; i--) {
            // 去除头部0
            if (chars[i] != 0) {
                isHeadZero = false;
            }
            if (isHeadZero == false && chars[i] != ('-')) {
                sb.append(chars[i]);
            }
        }
        long result = Long.parseLong(sb.toString());
        if (result > Integer.MAX_VALUE) {
            return 0;
        } else if (result < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) result;
    }

    /**
     * 对10取余法。
     * 思路：对10取余得到它的最低位。
     * 复杂度：时间 O(n) 空间 O(1)
     *
     * @param x
     * @return
     */
    public int reverse2(int x) {
         // 初始化为个位。
        long result = 0;
        int tmp = Math.abs(x);
        while (tmp > 0) {
            // result向高位进一位。
            result *= 10;
            // 取余。
            result += tmp % 10;
            if (result > Integer.MAX_VALUE) {
                return 0;
            }
            // 取整，让tmp往高位进一位。
            tmp /= 10;
        }
        // 如果原数小于0，在结果上加个负号。
        return (int) (x >= 0 ? result : -result);
    }
}
