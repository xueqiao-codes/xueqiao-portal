package com.longsheng.xueqiao.active.util;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.*;

public class CityTimeZoneMapping {
	private static CityTimeZoneMapping ourInstance = new CityTimeZoneMapping();

	public static CityTimeZoneMapping getInstance() {
		return ourInstance;
	}

	private Map<String, String> cityMap = new LinkedHashMap<>();

	private Map<String, List<String>> utcMap = new HashMap<>();
	
	private List<String> zoneList = new ArrayList<String>();

	private CityTimeZoneMapping() {
		init();
	}

	public Map<String, String> getCityMap() {
		return cityMap;
	}

	public Map<String, List<String>> getUtcMap() {
		return utcMap;
	}
	
	public List<String> getZoneList() {
		return zoneList;
	}

	private void init() {

		zoneList = new ArrayList<>(ZoneId.getAvailableZoneIds());

		// Get all ZoneIds
		Map<String, String> allZoneIds = getAllZoneIds(zoneList);

		// sort map by key
		/*
		 * allZoneIds.entrySet().stream() .sorted(Map.Entry.comparingByKey())
		 * .forEachOrdered(e -> cityMap.put(e.getKey(), e.getValue()));
		 */

		// sort by value, descending order
		allZoneIds.entrySet().stream().sorted(Map.Entry.<String, String>comparingByValue().reversed())
				.forEachOrdered(e -> cityMap.put(e.getKey(), "UTC" + e.getValue()));

		// print map
		cityMap.forEach((k, v) -> {
			// String out = String.format("%35s (%s) %n", k, v);
			// System.out.printf(out);
			List<String> cities = utcMap.get(v);
			if (cities == null) {
				cities = new ArrayList<>();
				utcMap.put(v, cities);
			}
			cities.add(k);
		});

		// System.out.println("\nTotal Zone IDs " + cityMap.size());
		// utcMap.forEach((k, v) ->
		// {
		// System.out.println(k);
		// v.forEach(item ->
		// {
		// System.out.println(item);
		// });
		// });
	}

	private static Map<String, String> getAllZoneIds(List<String> zoneList) {

		Map<String, String> result = new HashMap<>();

		LocalDateTime dt = LocalDateTime.now();

		for (String zoneId : zoneList) {

			ZoneId zone = ZoneId.of(zoneId);
			ZonedDateTime zdt = dt.atZone(zone);
			ZoneOffset zos = zdt.getOffset();

			// replace Z to +00:00
			String offset = zos.getId().replaceAll("Z", "+00:00");

			result.put(zone.toString(), offset);

		}
		return result;

	}
}
