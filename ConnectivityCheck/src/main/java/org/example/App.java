package org.example;

import com.jcraft.jsch.JSchException;
import org.example.icmp.IcmpPing;
import org.example.ssh.SshPing;
import java.io.IOException;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args ) throws IOException, JSchException {

        Scanner sc  = new Scanner(System.in);
        System.out.print("Enter host for test: ");
        String host = sc.next();
        IcmpPing icmpping = new IcmpPing();
        boolean icmp_result = icmpping.pingHost(host);

        System.out.println(" Entering ssh test ");
        SshPing sshping = new SshPing();
        System.out.print("Enter Username: ");
        String user = sc.next();
        System.out.print("Enter Password: ");
        String pass = sc.next();
        boolean ssh_result = sshping.sshPing(user,pass,host);

        if(icmp_result && ssh_result){
            System.out.println("Connectivity is success");
        }else {
            System.out.println("Connectivity Failed");
        }
    }
}
