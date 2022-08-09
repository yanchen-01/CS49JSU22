package edu.sjsu.assignment1;

public class Matrix {
    private final int[][] matrix;

    public Matrix(int[][] matrix) {
        this.matrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            this.matrix[i] = matrix[i].clone();
        }
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public Matrix multiply(Matrix other) {
        //If A (this matrix) is an m × n matrix
        // and B (other matrix) is an n × p matrix,
        int m = this.matrix.length; // number of rows of this matrix
        int n = this.matrix[0].length; // number of columns of this matrix
        int p = other.matrix[0].length;// number of columns of the other matrix
        //the matrix product C = AB
        // is defined to be the m × p matrix
        int[][] result = new int[m][p];
        // result_{ij}=\sum _{k=1}^{n}this_{ik}other_{kj}
        //for i = 1, ..., m and j = 1, ..., p, k = 1 ...., n
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < p; j++) {
                for (int k = 0; k < n; k++) {
                    result[i][j] += this.matrix[i][k] * other.matrix[k][j];
                }
            }
        }

        return new Matrix(result);
    }
}
