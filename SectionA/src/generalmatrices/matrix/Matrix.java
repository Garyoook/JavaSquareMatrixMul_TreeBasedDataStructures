package generalmatrices.matrix;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;

public class Matrix<T> {
    // TODO: populate as part of Question 1 and Question 3

    private double order;
    private List<T> list;

    public Matrix(List<T> list) {
        this.list = list;
        int k = list.size();
        if (list.isEmpty()) {
            throw new IllegalArgumentException();
        }
        else {
            this.order = Math.sqrt((k));
        }
    }

    public T get(int row, int col) {
        return list.get((int) (row * order + col));
    }

    public int getOrder() {
        return (int) order;
    }

    public String toString() {
        StringBuilder resString = new StringBuilder();
        resString.append("[");
        for (int i = 0; i < order; i++) {
            resString.append("[");
            for (int j = 0; j < order; j++) {
                if (j == order - 1) {
                    resString.append(get(i, j));
                }
                else {
                    resString.append(get(i, j) + " ");
                }
            }
            resString.append("]");
        }
        resString.append("]");
        return resString.toString();
    }

    public Matrix<T> sum(Matrix<T> other, BinaryOperator<T> elementSum) {
        List<T> newMatList = new ArrayList<>();
        for (int i = 0; i < order; i++){
            for (int j = 0; j < order; j++) {
                newMatList.add(elementSum.apply(this.get(i, j), other.get(i, j)));
            }
        }
        return new Matrix<T>(newMatList);
    }

    public Matrix<T> product(Matrix<T> other, BinaryOperator<T> elementSum, BinaryOperator<T> elementProduct) {
        List<T> newMatList = new ArrayList<>();
        for (int i = 0; i < order; i++){
            for (int j = 0; j < order; j++) {
                for (int k = 0; k < order - 1; k++) {
                    newMatList.add(elementSum.apply(
                            elementProduct.apply(this.get(i, j), other.get(i, k))
                            , elementProduct.apply(this.get(i, k + 1), other.get(k + 1, j))
                    ));
                }
            }
        }
        return new Matrix(newMatList);
    }
}
