package string;

/**
 *
 Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

 Notice

 Have you consider that the string might be empty? This is a good question to ask during an interview.

 For the purpose of this problem, we define empty string as valid palindrome.

 Example
 "A man, a plan, a canal: Panama" is a palindrome.

 "race a car" is not a palindrome.
 * @author: liuluming
 * @CreatedDate: 2017/10/9 下午2:50
 */
public class ValidPalindrome {

    /**
     * 我的解法：
     * 设定两个指针，从两边往中间读。
     *
     * 如果是大写字母，转为小写；
     *
     * 遇到标点符号则跳过；
     *
     * 判断左右两个指针的值是否相等，如果不相等，立即返回false；
     *
     */
    public boolean isPalindrome1(String s) {

        if(s==null || s.equals("")){
            return true;
        }

        boolean flag=true;
        int leftIndex=0;
        int rightIndex=s.length()-1;
        while(leftIndex<rightIndex){
            Character left=s.charAt(leftIndex);
            Character right=s.charAt(rightIndex);
            //如果是大写字母,转为小写。
            if(left>64 && left<91){
                left=Character.toLowerCase(left);
            }
            //如果不是数字也不是小写字母
            else if(left<47 || (left>58&&left<96) || left>123){
                leftIndex++;
                continue;
            }
            //如果是大写字母,转为小写。
            if(right>64 && right<91){
                right=Character.toLowerCase(right);
            }
            //如果不是数字也不是小写字母
            else if(right<47 || (right>58&&right<96) || right>123){
                rightIndex--;
                continue;
            }
            //判断left和right是否相等。
            if(!left.equals(right)){
                flag=false;
                break;
            }
            leftIndex++;
            rightIndex--;
        }
        return flag;
    }

}
