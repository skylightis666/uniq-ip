package org.example;

import java.io.*;
import java.math.BigInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IpCounter {
    private static final Logger logger = Logger.getLogger(IpCounter.class.getName());

    private final File file;


    public IpCounter(File file) {
        this.file = file;
    }

    public BigInteger count() {
        var lines = new String[3];
        var ans = BigInteger.ZERO;
        int lineNumber = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            String line1;
            String line2;

            //read first and second lines
            line1 = br.readLine(); //TODO if file contains less then 3 lines?
            line2 = br.readLine();

            if (!line1.equals(line2))
                ans = ans.add(BigInteger.ONE);

            lines[1] = line1;
            lines[2] = line2;

            //read the rest
            while ((line = br.readLine()) != null) {
                lines[0] = lines[1];
                lines[1] = lines[2];
                lines[2] = line;
                lineNumber++;

                if (!(lines[1].equals(lines[0]) || lines[1].equals(lines[2])))
                    ans = ans.add(BigInteger.ONE);
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Trouble at {0} line", lineNumber);
            e.printStackTrace();
        }

        return ans;
    }
}
