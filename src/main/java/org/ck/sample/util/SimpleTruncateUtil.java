package org.ck.sample.util;

import org.springframework.stereotype.Service;

@Service
public class SimpleTruncateUtil implements TruncateUtil {

    public String truncate(final String original, final int size) {
        // truncate contents in the middle to match the length with 'size'
        if (original.length() <= size || truncMessage.length() + 2 > size || truncMessage.length() + 2 > original.length())
            return original;

        // truncate
        int prefix = (size - truncMessage.length()) / 2;
        int suffix = prefix + (size - truncMessage.length()) % 2;
        StringBuilder builder = new StringBuilder();
        builder.append(original.substring(0, prefix));
        builder.append(truncMessage);
        builder.append(original.substring(original.length()-suffix));

        return builder.toString();
    }
}
