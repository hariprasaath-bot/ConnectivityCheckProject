package org.example.ssh;
import com.jcraft.jsch.*;
public class SshPing {
    public boolean sshPing(String user, String password, String host) {
        int port = 22;
        try {
            JSch jsch = new JSch();
            Session session = jsch.getSession(user, host, port);
            session.setPassword(password);
            session.setConfig("StrictHostKeyChecking", "no");
            System.out.println("SSH Test: Establishing Connection...");
            session.connect();
            System.out.println("SSH Test: Connection established.");
            session.disconnect();
        } catch (JSchException ss) {
            System.out.println("SSH Test: failed\n "+"  "+ss);
            return false;
        }
        System.out.println("SSH Test: Success");
        return true;
    }
}
