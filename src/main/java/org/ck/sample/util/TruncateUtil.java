package org.ck.sample.util;

/**
 * Created by kitha on 4/19/2017.
 */
public interface TruncateUtil {

    String truncMessage = " ... (truncated) ... ";

    String truncate(final String original, final int size);

}
