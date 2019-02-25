package generalmatrices.examples;

import generalmatrices.matrix.Matrix;
import generalmatrices.pair.PairWithOperators;

import java.util.List;
import java.util.function.Function;

public class Example {

    public static Matrix<PairWithOperators> multiplyPairMatrices(
            List<Matrix<PairWithOperators>> matrices) {
        // TODO: implement as part of Question 4
        Function<? super Matrix, ?> function = matrix -> matrices;
        matrices.stream().map(function);
        return null;
    }

}
