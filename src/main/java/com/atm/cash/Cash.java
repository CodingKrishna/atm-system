package com.atm.cash;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Cash {

	private static volatile Cash instance;
	private static Object mutex = new Object();
	private static Map<Integer, Integer> cash = new HashMap<>();

	private Cash() {
		loadCash();
	}

	public static Cash getInstance() {
		Cash result = instance;
		if (result == null) {
			synchronized (mutex) {
				result = instance;
				if (result == null)
					instance = result = new Cash();
			}
		}
		return result;
	}

	public static void loadCash() {
		cash.put(2000, Integer.MAX_VALUE);
		cash.put(500, Integer.MAX_VALUE);
		cash.put(250, Integer.MAX_VALUE);
	}

	public static Map<Integer, Integer> getCurrentSystemDinominations() {
		return Collections.unmodifiableMap(cash);
	}

}
