package com.cegeka;

import org.ethereum.geth.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GethApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(GethApplication.class, args);
	}

	@Override
    public void run(String... args) {
        NodeConfig conf = Geth.newNodeConfig();
        Context ctx = Geth.newContext();

        try {
            Node node = Geth.newNode("ethereum", conf);
            node.start();

            NodeInfo info = node.getNodeInfo();
            System.out.println("My name: " + info.getName());
            System.out.println("My address: " + info.getListenerAddress());
            System.out.println("My protocols: " + info.getProtocols());

            EthereumClient client = node.getEthereumClient();
            System.out.println("Latest block: " + client.getBlockByNumber(ctx, -1));
        } catch (Exception ex) {
            System.out.println("Crashed: " + ex.getMessage());
        }
    }
}
