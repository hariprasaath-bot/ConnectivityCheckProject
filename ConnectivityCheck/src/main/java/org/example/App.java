package org.example;

import com.jcraft.jsch.JSchException;
import org.example.icmp.IcmpPing;
import org.example.ssh.SshPing;
import java.io.IOException;

public class App 
{
    public static void main( String[] args ) throws IOException, JSchException {

        IcmpPing icmpping = new IcmpPing();
        boolean icmp_result = icmpping.pingHost("192.168.78.177");
        boolean ssh_result = true;
        SshPing sshping = new SshPing();
        ssh_result = sshping.sshPing("root","root","192.168.15.20");

        if(icmp_result && ssh_result){
            System.out.println("Connectivity is success");
        }else {
            System.out.println("Connectivity Failed");
        }
    }
}
