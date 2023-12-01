package org.example.counter.impl;

import org.example.converter.IpConverter;
import org.example.counter.Collectable;
import org.example.counter.Counter;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BitSetCounter<T extends Collectable> implements Counter {
    private static final Logger logger = Logger.getLogger(BitSetCounter.class.getName());

    private final File file;
    private final T col;

    public BitSetCounter(File file, T col) {
        this.file = file;
        this.col = col;
    }

    @Override
    public BigInteger count() {

        var ans = BigInteger.ZERO;

        try (var ips = Files.lines(file.toPath())) {
            ans = BigInteger.valueOf(
                    ips
                            .mapToInt(new IpConverter())
                            .collect(col::get,
                                    col::accept,
                                    col::accept)
                            .countUnique());

        } catch (IOException e) {
            logger.log(Level.SEVERE, "Trouble with %s", file.getAbsolutePath());
            e.printStackTrace();
        }

        return ans;
    }
}
