package acptTests;

import bridgeProject.BridgeProject;
import bridgeProject.BridgeProxy;
import bridgeProject.BridgeReal;

public abstract class Driver {

	public static BridgeProject getBridge() {

		BridgeProxy bridge = new BridgeProxy();
		BridgeReal bridgeReal = new BridgeReal();
		bridge.setRealBridge(bridgeReal); // add real bridge here
		return bridge;
	}	
}