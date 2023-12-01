package org.example;

import org.example.counter.impl.BitSetCounter;
import org.example.counter.impl.FourBitSetCollectableContainer;

import java.io.File;
import java.time.Duration;
import java.time.Instant;

public class Main {
    private static final System.Logger logger = System.getLogger("MainLog");

    public static void main(String[] args) {
        var startTime = Instant.now();

        var ipCounter = new BitSetCounter<>(new File(args[0]), new FourBitSetCollectableContainer());
        logger.log(System.Logger.Level.INFO, "Answer: {0}", ipCounter.count());
        var endTime = Instant.now();

        logger.log(System.Logger.Level.INFO, "That took {0} milliseconds", (Duration.between(startTime, endTime)));
    }
}