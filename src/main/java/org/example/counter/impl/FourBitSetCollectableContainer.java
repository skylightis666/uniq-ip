package org.example.counter.impl;

import org.example.counter.Collectable;

import java.util.BitSet;

public class FourBitSetCollectableContainer implements Collectable {
    private final BitSet positive = new BitSet(Integer.MAX_VALUE);
    private final BitSet positiveTwicePlusOccur = new BitSet(Integer.MAX_VALUE);
    private final BitSet negative = new BitSet(Integer.MAX_VALUE);
    private final BitSet negativeTwicePlusOccur = new BitSet(Integer.MAX_VALUE);


    @Override
    public long countUnique() {
        return (long) (positive.cardinality() - positiveTwicePlusOccur.cardinality()) +
                (negative.cardinality() - negativeTwicePlusOccur.cardinality());
    }

    @Override
    public void accept(Collectable collectable, Collectable collectable2) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void accept(Collectable collectable, int value) {
        if (value >= 0) {
            if (positive.get(value))
                positiveTwicePlusOccur.set(value);
            positive.set(value);
        } else {
            if (negative.get(~value))
                negativeTwicePlusOccur.set(~value);
            negative.set(~value);
        }
    }

    @Override
    public Collectable get() {
        return this;
    }
}
