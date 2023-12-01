package org.example.converter;

import java.util.function.ToIntFunction;

public class IpConverter implements ToIntFunction<CharSequence> {
    @Override
    public int applyAsInt(CharSequence ipAddress) {
        String[] octets = ipAddress.toString().split("\\.");
        int ip = 0;
        for (int i = 0; i < octets.length; i++) {
            int octet = Integer.parseInt(octets[i]);
            if (octet < 0 || octet > 255) {
                throw new IllegalArgumentException("Invalid IP address: " + ipAddress);
            }
            ip |= octet << (i * 8);
        }
        return ip;
    }
}