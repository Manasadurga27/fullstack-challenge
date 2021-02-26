package com.codingChallenge.demo.util;

import java.nio.ByteBuffer;
import java.util.Base64;
import java.util.UUID;

public class CodingChallengeUtil {
	public static String getShortGUID() {
	    final UUID uuid = UUID.randomUUID();

	    final long lsb = uuid.getLeastSignificantBits();
	    final long msb = uuid.getMostSignificantBits();
	    final byte[] uuidBytes = ByteBuffer.allocate(16).putLong(msb).putLong(lsb).array();

	    return Base64.getEncoder().encodeToString(uuidBytes).substring(0, 22).replace("/", "_").replace("+", "-");
	  }

}
