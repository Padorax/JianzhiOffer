import com.sun.javafx.image.IntPixelGetter;

import java.util.ArrayList;

/*only support square matrix
fix*/

public class printMatrix {

    public ArrayList<Integer> PrintClockwise (int[][] mat, int col, int row) {
        if(mat == null || col <= 0 || row <= 0) return null;

        int start = 0;
        ArrayList<Integer> res = new ArrayList();

        while(col > start * 2 && row > start * 2) {
            PrintInCircle(res, mat, col, row, start);
            ++ start;
        }

        return res;
    }

    public void PrintInCircle(ArrayList<Integer> res, int[][] mat, int col, int row, int start) {
        int endX = col - 1 - start, endY = row - 1 - start;

//        print a row from left to right
        for (int i = start; i <= endY; i++) {
            int num = mat[start][i];
            System.out.print(num);
            res.add(num);
        }
//        print a col from up do bottom
        if(start < endY) {
            for(int i = start + 1; i <= endY; i++) {
                int num = mat[i][endX];
                System.out.print(num);
                res.add(num);
            }
        }
//        print a row from right to left
        if (start < endX && start < endY) {
            for (int i = endX - 1; i >= start; i--) {
                int num = mat[endY][i];
                System.out.print(num);
                res.add(num);
            }
        }
//        print a row from bot to up
        if(start < endX && start < endY - 1) {
            for (int i = endY - 1; i >= start+1; i--) {
                int num = mat[i][start];
                System.out.print(num);
                res.add(num);
            }
        }
    }

    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList p = PrintClockwise(matrix, matrix[0].length, matrix.length);
        return p;
    }

    public static void main(String[] args) {
        printMatrix s = new printMatrix();
        int[][] a = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
        ArrayList<Integer> l = s.printMatrix(a);
    }
}
