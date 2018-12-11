import java.util.ArrayList;

public class multiply {
    public int[] multiply(int [] A) {
        int [] B = new int[A.length];

//        lower left triangle
        B[0] = 1;
        for (int i = 1; i < A.length; i++) {
            B[i] = B[i-1] * A[i-1];
        }

//        upper right triangle
        int temp = 1;
        for (int j = A.length - 2; j >= 0; j--) {
            temp *= A[j+1];
            B[j] *= temp;
        }

        return B;
    }

    public static void main(String[] args) {
        int [] l = {1, 2, 3, 4, 5};
        multiply sol = new multiply();
        sol.multiply(l);
    }
}
