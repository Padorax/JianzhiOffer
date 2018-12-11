public class ReverseSentence {
    public String ReverseSentence(String str) {
        if (str == null) return null;
//        let begin points to the first character of a word, end to the last of a word
        int begin = 0, end = 0;
        char [] chr = str.toCharArray();

//        first reverse whole sentence
        Reverse(chr, 0, chr.length-1);
//        Then reverse every word in sentence
        while (end != chr.length) {
//            while(chr[end] != ' ') {
//                end++;
//            }
//            Reverse(chr, begin, end-1);
//            begin = end;
//            more than one blank space between words? the last chr is []?
            if (chr[begin] == ' ') {
                begin++;
                end++;
            } else if (chr[end] == ' ') {
                Reverse(chr, begin, end-1);
                begin = end;
            } else if(end == chr.length - 1) {
                Reverse(chr, begin, end);
                break;
            } else {
                end++;
            }

        }

        return String.valueOf(chr);
    }

//    reverse str from pos i to j(included)
//    replace string character according to index:
//1. StringBuilder res = new StringBuilder("domanokz");res.setCharAt();
//2. much easier to manipulate char [] and convert to string at the very end
    public void Reverse(char [] str, int i, int j) {
        if (str == null || i < 0 || j >= str.length) return;
        while(i < j) {
//            char temp = str.charAt(i);
            char temp = str[i];
            str[i]  = str[j];
            str[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        ReverseSentence s = new ReverseSentence();
        System.out.print(s.ReverseSentence("  I am   stu. "));
    }
}
