package com.piggsoft.commons.config;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.apache.commons.configuration.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConfigFactory {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	private static Configuration CONFIGURATION;

	public ConfigFactory(Configuration configuration) {
		if (null == configuration) {
			logger.error("configuration can not be null");
		}
		CONFIGURATION = configuration;
	}

	public Configuration subset(String prefix) {
		return CONFIGURATION.subset(prefix);
	}

	public static boolean isEmpty() {
		return CONFIGURATION.isEmpty();
	}

	static boolean containsKey(String key) {
		return CONFIGURATION.containsKey(key);
	}

	public static void addProperty(String key, Object value) {
		CONFIGURATION.addProperty(key, value);
	}

	public static void setProperty(String key, Object value) {
		CONFIGURATION.setProperty(key, value);
	}

	public static void clearProperty(String key) {
		CONFIGURATION.clearProperty(key);
	}

	public static void clear() {
		CONFIGURATION.clear();
	}

	public static Object getProperty(String key) {
		return CONFIGURATION.getProperty(key);
	}

	public static Iterator<?> getKeys(String prefix) {
		return CONFIGURATION.getKeys(prefix);
	}

	public static Iterator<?> getKeys() {
		return CONFIGURATION.getKeys();
	}

	public static Properties getProperties(String key) {
		return CONFIGURATION.getProperties(key);
	}

	public static boolean getBoolean(String key) {
		return CONFIGURATION.getBoolean(key);
	}

	public static boolean getBoolean(String key, boolean defaultValue) {
		return CONFIGURATION.getBoolean(key, defaultValue);
	}

	public static Boolean getBoolean(String key, Boolean defaultValue) {
		return CONFIGURATION.getBoolean(key, defaultValue);
	}

	public static byte getByte(String key) {
		return CONFIGURATION.getByte(key);
	}

	public static byte getByte(String key, byte defaultValue) {
		return CONFIGURATION.getByte(key, defaultValue);
	}

	public static Byte getByte(String key, Byte defaultValue) {
		return CONFIGURATION.getByte(key, defaultValue);
	}

	public static double getDouble(String key) {
		return CONFIGURATION.getDouble(key);
	}

	public static double getDouble(String key, double defaultValue) {
		return CONFIGURATION.getDouble(key, defaultValue);
	}

	public static Double getDouble(String key, Double defaultValue) {
		return CONFIGURATION.getDouble(key, defaultValue);
	}

	public static float getFloat(String key) {
		return CONFIGURATION.getFloat(key);
	}

	public static float getFloat(String key, float defaultValue) {
		return CONFIGURATION.getFloat(key, defaultValue);
	}

	public static Float getFloat(String key, Float defaultValue) {
		return CONFIGURATION.getFloat(key, defaultValue);
	}

	public static int getInt(String key) {
		return CONFIGURATION.getInt(key);
	}

	public static int getInt(String key, int defaultValue) {
		return CONFIGURATION.getInt(key, defaultValue);
	}

	public static Integer getInteger(String key, Integer defaultValue) {
		return CONFIGURATION.getInteger(key, defaultValue);
	}

	public static long getLong(String key) {
		return CONFIGURATION.getLong(key);
	}

	public static long getLong(String key, long defaultValue) {
		return CONFIGURATION.getLong(key, defaultValue);
	}

	public static Long getLong(String key, Long defaultValue) {
		return CONFIGURATION.getLong(key, defaultValue);
	}

	public static short getShort(String key) {
		return CONFIGURATION.getShort(key);
	}

	public static short getShort(String key, short defaultValue) {
		return CONFIGURATION.getShort(key, defaultValue);
	}

	public static Short getShort(String key, Short defaultValue) {
		return CONFIGURATION.getShort(key, defaultValue);
	}

	public static BigDecimal getBigDecimal(String key) {
		return CONFIGURATION.getBigDecimal(key);
	}

	public static BigDecimal getBigDecimal(String key, BigDecimal defaultValue) {
		return CONFIGURATION.getBigDecimal(key, defaultValue);
	}

	public static BigInteger getBigInteger(String key) {
		return CONFIGURATION.getBigInteger(key);
	}

	public static BigInteger getBigInteger(String key, BigInteger defaultValue) {
		return CONFIGURATION.getBigInteger(key, defaultValue);
	}

	public static String getString(String key) {
		return CONFIGURATION.getString(key);
	}

	public static String getString(String key, String defaultValue) {
		return CONFIGURATION.getString(key, defaultValue);
	}

	public static String[] getStringArray(String key) {
		return CONFIGURATION.getStringArray(key);
	}

	public static List<?> getList(String key) {
		return CONFIGURATION.getList(key);
	}

	public static List<?> getList(String key, List<?> defaultValue) {
		return CONFIGURATION.getList(key);
	}
}