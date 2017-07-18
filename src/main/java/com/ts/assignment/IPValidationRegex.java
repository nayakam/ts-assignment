package com.ts.assignment;

import com.ts.assignment.que1.IPValidationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class IPValidationRegex {
    private static Logger logger = LoggerFactory.getLogger(IPValidationRegex.class);
    public static final String IP_ADDRESS_FILE_NAME = "ip_address.txt";

    public static void main(String a[]) throws IOException {

        IPValidationRegex ipValidationRegex = new IPValidationRegex();
        try (Stream<String> stream = Files.lines(Paths.get(ipValidationRegex.loadResourceFile().getPath()))) {
            List<String> validIPList = stream.filter(item -> (IPValidationUtil.isValidIPAddress(item))).collect(Collectors.toList());
            System.out.println("-------- Valid IP Addresses --------");
            validIPList.stream().forEach(System.out::println);
            logger.debug("Valid IP Addresses:" + validIPList);
        } catch (IOException e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
        }
    }

    public File loadResourceFile() {
        ClassLoader classLoader = this.getClass().getClassLoader();
        return new File(classLoader.getResource(IP_ADDRESS_FILE_NAME).getFile());
    }
}
