package org.example.icmp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IcmpPing {
    public boolean pingHost(String host) throws IOException {
        String preprop = "cmd.exe";
        String command = "ping "+host;
        ProcessBuilder processBuilder = new ProcessBuilder(preprop, "/c", command);
        Process process = processBuilder.start();
        System.out.println("ICMP Test: Running ping test...");
        try (BufferedReader standardOutput = new BufferedReader(new InputStreamReader(process.getInputStream())))
        {
            String outputLine;
            while ((outputLine = standardOutput.readLine()) != null)
            {
                if (outputLine.toLowerCase().contains("destination host unreachable") || outputLine.contains("Request timed out.") )
                {
                    System.out.println("ICMP Test: Failed");
                    return false;
                }
            }
        }
        System.out.println("ICMP Test: Success");
        return true;
    }
}
