package com.apalya.security;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TokenInMemoryAuth {

	private static final Logger log = LoggerFactory.getLogger(TokenInMemoryAuth.class);

	public final Map<Long, String> auth = new HashMap<>();

	public String storeToken(String userid) {
		long token = generateToken();
		for (Entry<Long, String> entry : auth.entrySet()) {
			if (entry.getValue().equals(userid)) {
				auth.remove(entry.getKey());
			}
		}
		auth.put(token, userid);
		log.info("Token generated :" + token + " for userid : " + userid);
		return String.valueOf(token);
	}

	private long generateToken() {
		return System.currentTimeMillis();
	}

	public String getToken(String token) {
		String userid = null;
		if (token != null) {
			if (auth.get(token) != null) {
				userid = auth.get(token);
			}
		}
		return userid;
	}

	public void remove(String token) {
		if (token != null) {
			if (auth.get(token) != null) {
				log.info("Token removed :" + token);
				auth.remove(token);
			}
		}
	}

}
