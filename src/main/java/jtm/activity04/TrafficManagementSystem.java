package jtm.activity04;

public class TrafficManagementSystem {
	static Transport[] transports;
	static Road[] roads;

	/**
	 * This method is called to set up TransportManagementSystem
	 * 
	 * @param roads
	 * @param transports
	 */
	public static void initSystem(int roads, int transports) {
		addRoads(roads);
		addTransport(transports);
	}

	public static Transport[] getTransports() {
		// return required value
		return TrafficManagementSystem.transports;
	}

	public static void addTransport(int i) {
		// create new array of transports in size of passed value
		TrafficManagementSystem.transports = new Transport[i];
	}

	public static void setVehicle(Transport transport, int i) {
		// set passed transport into transports array cell of passed index
		TrafficManagementSystem.transports[i] = transport;
	}

	public static void addRoads(int i) {
		// create new array of roads in size of passed value
		TrafficManagementSystem.roads = new Road[i];
	}

	public static Road[] getRoads() {
		// return required value
		return TrafficManagementSystem.roads;
	}

	public static void setRoad(Road road, int i) {
		// set passed road into passed cell of roads array
		TrafficManagementSystem.roads[i] = road;
	}

}
