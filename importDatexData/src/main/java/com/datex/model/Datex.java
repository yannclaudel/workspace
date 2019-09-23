package com.datex.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Datex {

	public static final int INTERVAL_IN_MINUTE = 3;

	public static final String TRAFFIC_A1 = "http://www.cita.lu/info_trafic/datex/trafficstatus_a1";
	public static final String TRAFFIC_A3 = "http://www.cita.lu/info_trafic/datex/trafficstatus_a3";
	public static final String TRAFFIC_A4 = "http://www.cita.lu/info_trafic/datex/trafficstatus_a4";
	public static final String TRAFFIC_A6 = "http://www.cita.lu/info_trafic/datex/trafficstatus_a6";
	public static final String TRAFFIC_A7 = "http://www.cita.lu/info_trafic/datex/trafficstatus_a7";
	public static final String TRAFFIC_A13 = "http://www.cita.lu/info_trafic/datex/trafficstatus_a13";
	public static final String TRAFFIC_B40 = "http://www.cita.lu/info_trafic/datex/trafficstatus_b40";

	public static final String TRAFFIC_EVENT = "http://www.cita.lu/info_trafic/datex/situationrecord";

	public static final Map<String, String> RESOURCE_MAP = createMap();
	public static final String RESOURCE_DEFAULT = "out/datexData.csv";

	private static final String RESOURCE_A1 = "out/datexDataA1.csv";
	private static final String RESOURCE_A3 = "out/datexDataA3.csv";
	private static final String RESOURCE_A4 = "out/datexDataA4.csv";
	private static final String RESOURCE_A6 = "out/datexDataA6.csv";
	private static final String RESOURCE_A7 = "out/datexDataA7.csv";
	private static final String RESOURCE_A13 = "out/datexDataA13.csv";
	private static final String RESOURCE_B40 = "out/datexDataB40.csv";

	private static Map<String, String> createMap() {
		Map<String, String> result = new HashMap<String, String>();
		result.put(TRAFFIC_A1, RESOURCE_A1);
		result.put(TRAFFIC_A3, RESOURCE_A3);
		result.put(TRAFFIC_A4, RESOURCE_A4);
		result.put(TRAFFIC_A6, RESOURCE_A6);
		result.put(TRAFFIC_A7, RESOURCE_A7);
		result.put(TRAFFIC_A13, RESOURCE_A13);
		result.put(TRAFFIC_B40, RESOURCE_B40);
		return Collections.unmodifiableMap(result);
	}

}
