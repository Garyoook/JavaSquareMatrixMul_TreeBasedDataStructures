package generalmatrices.pair;

import generalmatrices.operators.RingElement;

public class PairWithOperators extends Pair implements RingElement<PairWithOperators> {

    public PairWithOperators(Integer coordX, Integer coordY) {
        super(coordX, coordY);
    }

    @Override
    public PairWithOperators sum(PairWithOperators other) {
        return new PairWithOperators(this.getCoordX() + other.getCoordX(),
                this.getCoordY() + other.getCoordY());
    }

    @Override
    public PairWithOperators product(PairWithOperators other) {
        return new PairWithOperators(this.getCoordX() * other.getCoordX(),
                this.getCoordY() * other.getCoordY());
    }


    // TODO: populate as part of Question 2

}
