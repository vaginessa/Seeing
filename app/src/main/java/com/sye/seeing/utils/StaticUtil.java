package com.sye.seeing.utils;

import java.text.DecimalFormat;
import java.util.regex.Pattern;

/**
 * @author Secray
 * @date 2016.11.11
 */
public class StaticUtil {
    public static String FormatFileSize(long fileSize) {
        DecimalFormat df = new DecimalFormat("#.00");
        String fileSizeString;
        String wrongSize = "0B";
        if (fileSize == 0) {
            return wrongSize;
        }
        if (fileSize < 1024) {
            fileSizeString = df.format((double) fileSize);
            fileSizeString = fileSizeString.substring(0, fileSizeString.length() - 3) + " B";
        } else if (fileSize < 1048576) {
            fileSizeString = df.format((double) fileSize / 1024) + " KB";
        } else if (fileSize < 1073741824) {
            fileSizeString = df.format((double) fileSize / 1048576) + " MB";
        } else {
            fileSizeString = df.format((double) fileSize / 1073741824) + " GB";
        }
        return fileSizeString;
    }

    public static long bytes2Long(byte[] byteNum) {
        long num = 0;
        for (int ix = 0; ix < 8; ++ix) {
            num <<= 8;
            num |= (byteNum[ix] & 0xff);
        }
        return num;
    }

    public static boolean isDigit(String input) {
        Pattern p = Pattern.compile("[1-9]");
        return p.matcher(input).matches();
    }
}
