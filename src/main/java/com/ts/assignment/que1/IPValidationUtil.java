package com.ts.assignment.que1;

import java.util.regex.Pattern;

public class IPValidationUtil {

    /**
     * IP address validation rules:
     * - String => A.B.C.D
     * --  where A,B,C and D => [0,255]
     * --  leading zero allowed
     * -- length is not greater than 3
     * -- IPv4 address : Valid range [0-255].[0-255].[0-255].[0-255]
     * [00]0-[00]9, [0]10-[0]99, [1]00-[1]99, [2]00-[2]49,[25]0-[25]5
     */
    private static final String IP_ADDRESS_FORMAT =
            "^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.)" +
                    "{3}" + "(([01]?\\d\\d?|2[0-4]\\d|25[0-5]))$";

    private static final Pattern IP_ADDRESS_PATTERN = Pattern.compile(IP_ADDRESS_FORMAT);

    public static boolean isValidIPAddress(final String ipAddress) {
        if (ipAddress == null || ipAddress.trim().isEmpty()) {
            return false;
        }
        return IP_ADDRESS_PATTERN.matcher(ipAddress).matches();
    }
}
