package com.ts.assignment.que1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class IPValidationUtilTest {
    private Map<String, Boolean> checkIPaddress = new HashMap<>();

    @Before
    public void loadTestData() {
        checkIPaddress.put("", false);
        checkIPaddress.put("  ", false);
        checkIPaddress.put(null, false);
        checkIPaddress.put("1234.123.123.123", false);
        checkIPaddress.put("234.1234.123.123", false);
        checkIPaddress.put("a.12b.12c.d", false);
        checkIPaddress.put("a.b.c.d", false);
        checkIPaddress.put("213.123.12.a", false);
        checkIPaddress.put("-213.123.12.4", false);
        checkIPaddress.put("123", false);
        checkIPaddress.put("0.0.0.0", true);
        checkIPaddress.put("001.012.123.234", true);
        checkIPaddress.put("255.255.255.255", true);
        checkIPaddress.put("000.000.000.000", true);
        checkIPaddress.put("23.232.134", false);
        checkIPaddress.put("0.12.124.245", true);
        checkIPaddress.put("213.123.12.4", true);
    }

    @Test
    public void validateIPAddress() {
        checkIPaddress.entrySet().stream().forEach(item -> {
                    Assert.assertEquals("Validate ip :" + item.getKey(), item.getValue(), IPValidationUtil.isValidIPAddress(item.getKey()));
                }
        );
    }

    @Test
    public void isValidIP() {
        checkIPaddress.entrySet().stream().forEach(item -> {
                    Assert.assertEquals("Validate ip :" + item.getKey(), item.getValue(), IPValidationUtilTest.isValidIP(item.getKey()));
                }
        );
    }

    private static boolean isValidIP(String ipAddress) {
        if (ipAddress == null || ipAddress.trim().isEmpty() || ipAddress.length() > 15) {
            return false;
        }
        try {
            String[] masks = ipAddress.split("\\.");
            if (masks.length != 4) {
                return false;
            }
            for (int i = 0; i < masks.length; i++) {
                int num = Integer.parseInt(masks[i]);
                if (num > 255 || num < 0) {
                    return false;
                }
            }
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
