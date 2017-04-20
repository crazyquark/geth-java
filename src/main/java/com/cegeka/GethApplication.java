package com.cegeka;

import go.geth.Geth;
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
        Geth.NodeConfig conf = Geth.NewNodeConfig();
        conf.setEthereumNetworkID(3); // Ropsten?

        Geth.Context ctx = Geth.NewContext();

        try {
            Geth.Node node = Geth.NewNode(".ethereum", conf);
            node.Start();

            Geth.NodeInfo info = node.GetNodeInfo();
            System.out.println("My name: " + info.GetName());
            System.out.println("My address: " + info.GetListenerAddress());
            System.out.println("My protocols: " + info.GetProtocols());

            Geth.EthereumClient client = node.GetEthereumClient();
            System.out.println("Latest block: " + client.GetBlockByNumber(ctx, -1));
        } catch (Exception ex) {
            System.out.println("Crashed: " + ex.getMessage());
        }
    }
}
