package string;

/**
 * Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
 * <p>
 * Example 1:
 * Input: "aba"
 * Output: True
 * <p>
 * Example 2:
 * Input: "abca"
 * Output: True
 * Explanation: You could delete the character 'c'.
 * <p>
 * Note:
 * The string will only contain lowercase characters a-z. The maximum length of the string is 50000.
 *
 * @author: liuluming
 * @CreatedDate: 2017/10/9 下午3:12
 */
public class ValidPalindrome2 {

    public static void main(String[] args) {
        ValidPalindrome2 validPalindrome2=new ValidPalindrome2();
        System.out.println("the result is :"+validPalindrome2.validPalindrome("abca"));

    }

    /**
     * 我的解法：
     * 粗鲁暴力解法。
     *
     * @param s
     * @return
     */

    public boolean validPalindrome1(String s) {

        if (s.length() > 50000) {
            throw new IllegalArgumentException("the length of argument is not allow to be larger than 50000!");
        }
        if (isPalindrome1(s) == false) {
            StringBuilder sb = new StringBuilder(s);
            for (int i = 0; i < sb.length(); i++) {
                Character c = sb.charAt(i);
                sb.deleteCharAt(i);
                if (isPalindrome1(sb)) return true;
                sb.insert(i, c);
            }
            return false;
        } else {
            return true;
        }
    }

    private boolean isPalindrome1(CharSequence s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 推荐解法：
     * 利用贪心算法求解。
     *
     * @param s
     * @param i
     * @param j
     * @return
     */

    public boolean isPalindromeRange(String s, int i, int j) {
        for (int k = i; k <= i + (j - i) / 2; k++) {
            if (s.charAt(k) != s.charAt(j - k + i)) return false;
        }
        return true;
    }
    public boolean validPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                int j = s.length() - 1 - i;
                return (isPalindromeRange(s, i+1, j) ||
                        isPalindromeRange(s, i, j-1));
            }
        }
        return true;
    }

}
