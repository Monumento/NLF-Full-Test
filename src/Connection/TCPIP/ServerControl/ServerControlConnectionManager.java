package Connection.TCPIP.ServerControl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import Connection.Helpclasses.BufferMessage;
import Connection.TCPIP.ClientThread;
import Connection.TCPIP.Server.ClientControl;

public class ServerControlConnectionManager {

	public ClientThread systemControl;
	public ClientControl serverControl;
	// threadpool
	public ExecutorService pool;
	public int threadCount;
	public int startPort;
	public String startIp;
	// internal messages

	// Connection Messages
	public ServerControlConnectionManager(String startIp, int startPort) {
		this.startPort = startPort;
		this.startIp = startIp;
		serverControl = new ClientControl(startPort);
		threadCount = 0;
	}
	// send update to systemControl

	public void updateServerControl(String message) {
		systemControl.messageOut.updateMessage(message);
	}
	// get update from systemControl

	public String getUpdateFromServerControl() {
		return systemControl.messageIn.getUpdateMessage();
	}

	// get update to clients
	public String[] getUpdateClients() {
		return serverControl.getUpdateFromClients();
	}
	// send update to clients

	public void updateToClients(String[] message) {
		serverControl.updateToClients(message);
	}


	public void startServerControlManager() {
		pool = Executors.newCachedThreadPool();
		// connect to SystemControl
		// TODO
		// serverControl = new ClientThread("", 1);
		// pool.execute(serverControl);
		//

		pool.execute(serverControl);
		threadCount++;
		System.out.println("ServerConnectionManager läuft...");
		
	}
}
