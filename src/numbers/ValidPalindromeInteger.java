package numbers;

/**
 *
 Determine whether an integer is a palindrome. Do this without extra space.

 Some hints:
 Could negative integers be palindromes? (ie, -1)

 If you are thinking of converting the integer to string, note the restriction of using extra space.

 You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?

 There is a more generic way of solving this problem.

 * @author: liuluming
 * @CreatedDate: 2017/10/11 上午9:01
 */
public class ValidPalindromeInteger {

    /**
     *
     思路：

     想到的第一个想法是将数字转换为字符串，并检查字符串是否为回文，但这将需要额外的非常量空间来创建问题描述不允许的字符串。

     第二个想法是恢复数字本身，然后将数字与原始数字进行比较，如果它们相同，则数字是回文。但是，如果反转数大于\ {文字} int.MAXint.MAX，我们会命中整数溢出问题。

     遵循第二个想法的想法，为了避免翻转数字的溢出问题，如果我们只恢复一半的 \ {文字INT}int数字？毕竟，回文最后一半的倒数应该与前一半的数字相同，如果数字是回文。

     例如，如果输入是1221，如果我们可以将数字“12 21 ” 的最后一部分从“ 21 ” 还原为“ 12 ”，并将其与数字“12”的前半部分进行比较，因为12是相同的作为12，我们知道这个数字是一个回文。

     让我们看看我们如何将这个想法转化成一个算法。

     算法实现：

     首先我们应该照顾一些边缘案件。所有负数不是回文，例如：-123不是回文，因为' - '不等于'3'。所以我们可以为所有负数返回false。

     现在让我们考虑如何恢复上一半的数字。对于号码1221，如果我们这样做1221 % 10，我们得到最后一个数字1，得到第二个数字，我们需要删除最后一个数字1221，我们可以通过将它除以10来实现1221 / 10 = 122。然后我们可以通过将模数乘以10得到最后一个数字122 % 10 = 2，如果我们将最后一位乘以10，并添加第二个最后一个数字1 * 10 + 2 = 12，则它给出我们想要的还原数。继续这个过程将给我们更多的数字的恢复的数字。

     现在的问题是，我们怎么知道我们已经达到了这个数字的一​​半？

     由于我们将数字除以10，并将反转数乘以10，当原始数字小于反转数时，这意味着我们已经处理了一半数字。
     * @param x
     * @return
     */
    public  boolean  IsPalindrome(int  x ){
        //特殊情况：
        //如上所述，当x <0时，x不是回文。
        //如果数字的最后一位数字为0，为了成为回文，
        //数字的第一位数字也需要为0.
        //只有0满足此属性。
        if(x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while(x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        //当长度为奇数，就可以摆脱由revertedNumber / 10的中间位的
        //例如当输入为12321，在while循环我们得到X = 12，revertedNumber = 123的端部，
        //因为中间数字并不重要（它将永远等于自己），我们可以简单地摆脱它。
        return x == revertedNumber || x == revertedNumber/10;
    }
}
