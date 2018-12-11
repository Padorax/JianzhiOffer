//use pointer is much easier; python can copy array--match(str[i:], pattern[j+2:];
//java can use array index as sort of 'pointer' or copy array--Arrays.copyOfRange()
public class RegrexMatch {
    public boolean match(char[] str, char[] pattern) {
//        if (str == null && pattern == null) return true;
//        if (str != null && pattern == null) return false;
        int strIndex = 0, patternIndex = 0;
        return matchHelper(str, pattern, strIndex, patternIndex);
    }

    private boolean matchHelper(char[] str, char[] pattern, int s, int p) {
        if (s >= str.length && p >= pattern.length) return true;
        if (s < str.length && p >= pattern.length) return false;

        //        if next character in pattern is not '*'
        if (p <= pattern.length-1 || pattern[p+1] != '*') {
            //            match current char
            if(str[s] == pattern[p] || (s < str.length && pattern[p] == '.')) {
                return matchHelper(str, pattern, s++, p++);
            } else {
                return false;
            }
        //        if next pattern is '*'
        } else{
        //      * match 1 or more, s
            if (str[s] == pattern[p] || (s < str.length && pattern[p] == '.')) {
                return matchHelper(str, pattern, s, p+2) || matchHelper(str, pattern, s+1, p);
            } else {
        //      * match 0--s stays, p move forward 2 steps
                return matchHelper(str, pattern, s, p+2);
            }
        }
    }
/*************************************************************************/
    public boolean match2(char[] str, char[] pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        int strIndex = 0;
        int patternIndex = 0;
        return matchCore(str, strIndex, pattern, patternIndex);
    }

    public boolean matchCore(char[] str, int strIndex, char[] pattern, int patternIndex) {
        //有效性检验：str到尾，pattern到尾，匹配成功
        if (strIndex == str.length && patternIndex == pattern.length) {
            return true;
        }
        //pattern先到尾，匹配失败
        if (strIndex != str.length && patternIndex == pattern.length) {
            return false;
        }
        //模式第2个是*，且字符串第1个跟模式第1个匹配,分3种匹配模式；如不匹配，模式后移2位
        if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
            if ((strIndex != str.length && pattern[patternIndex] == str[strIndex]) || (pattern[patternIndex] == '.' && strIndex != str.length)) {
                return matchCore(str, strIndex, pattern, patternIndex + 2)//模式后移2，视为x*匹配0个字符
                        || matchCore(str, strIndex + 1, pattern, patternIndex + 2)//视为模式匹配1个字符
                        || matchCore(str, strIndex + 1, pattern, patternIndex);//*匹配1个，再匹配str中的下一个
            } else {
                return matchCore(str, strIndex, pattern, patternIndex + 2);
            }
        }
        //模式第2个不是*，且字符串第1个跟模式第1个匹配，则都后移1位，否则直接返回false
        if ((strIndex != str.length && pattern[patternIndex] == str[strIndex]) || (pattern[patternIndex] == '.' && strIndex != str.length)) {
            return matchCore(str, strIndex + 1, pattern, patternIndex + 1);
        }
        return false;
    }

    public static void main(String[] args) {
        RegrexMatch s = new RegrexMatch();
        char[] a1 = {'a','a','a'};
        char[] a2 = {'a','.','a'};
        char[] a3 = {'a','b','*','a','c','*','a'};
        char[] a4 = {'a','a','.','a'};
        char[] a5 = {'a','b','*','a'};
        System.out.print(s.match2(a1, a4));
    }
}
