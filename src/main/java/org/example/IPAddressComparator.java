package org.example;

import java.util.Comparator;
import java.util.StringTokenizer;

public class IPAddressComparator implements Comparator<String> {
    @Override
    public int compare(String ip1, String ip2) {
        StringTokenizer tokenizer1 = new StringTokenizer(ip1, ".");
        StringTokenizer tokenizer2 = new StringTokenizer(ip2, ".");

        int octet1, octet2;
        for (int i = 0; i < 4; i++) {
            octet1 = Integer.parseInt(tokenizer1.nextToken());
            octet2 = Integer.parseInt(tokenizer2.nextToken());

            if (octet1 < octet2) {
                return -1;
            } else if (octet1 > octet2) {
                return 1;
            }
        }

        return 0;
    }
}
