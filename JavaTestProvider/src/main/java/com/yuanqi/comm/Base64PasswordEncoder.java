package com.yuanqi.comm;

import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by fengqiang on 2019/7/22.
 */
public class Base64PasswordEncoder {

    private static final char HEX_DIGITS[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd',
            'e', 'f' };

    private static final String suffixFixString = "!2#$PB.<<)778;:AD.12Qgt~*^WE12g";
    // private static final String suffixFixString ="1234";
    private static final String encodingAlgorithm = "SHA";
    private static String characterEncoding = "UTF-8";

    public static String encode(String password) {
        if (password == null)
            return null;
        password = password + suffixFixString;
        byte digest[];
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(encodingAlgorithm);
            if (hasText(characterEncoding))
                messageDigest.update(password.getBytes(characterEncoding));
            else
                messageDigest.update(password.getBytes());
            digest = messageDigest.digest();
            return getFormattedText(digest);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            throw new SecurityException(e);
        }
    }

    private static String getFormattedText(byte bytes[]) {
        StringBuilder buf = new StringBuilder(bytes.length * 2);
        //buf.append("{").append(encodingAlgorithm).append("}");
        BASE64Encoder e = new BASE64Encoder();
        String buf2 = e.encode(bytes);
        for (int j = 0; j < bytes.length; j++) {
            buf.append(HEX_DIGITS[bytes[j] >> 4 & 0xf]);
            buf.append(HEX_DIGITS[bytes[j] & 0xf]);
        }

        // System.out.println((new
        // StringBuilder("Final: ")).append(buf2).toString());
        // System.out.println((new
        // StringBuilder(String.valueOf(encodingAlgorithm))).append(": ").append(buf).toString());
        return buf.toString();
    }

    private static boolean hasLength(CharSequence str) {
        return (str != null && str.length() > 0);
    }

    private static boolean hasText(CharSequence str) {
        if (!hasLength(str)) {
            return false;
        }
        int strLen = str.length();
        for (int i = 0; i < strLen; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return true;
            }
        }
        return false;
    }
}
