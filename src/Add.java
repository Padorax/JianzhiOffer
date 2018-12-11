//add two num without using + - * /
public class Add {

    public int Add(int num1, int num2) {
        while ( num1 != 0) {
            int carry = (num1 & num2) << 1;
            num2 = num1 ^ num2;
            num1 = carry;
        }
        return num2;
    }


}
