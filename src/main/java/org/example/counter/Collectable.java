package org.example.counter;

import java.util.function.BiConsumer;
import java.util.function.ObjIntConsumer;
import java.util.function.Supplier;

public interface Collectable extends
        Supplier<Collectable>,
        ObjIntConsumer<Collectable>,
        BiConsumer<Collectable, Collectable> {
    long countUnique();

}
