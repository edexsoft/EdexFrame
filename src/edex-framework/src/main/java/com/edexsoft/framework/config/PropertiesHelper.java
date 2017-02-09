package com.edexsoft.framework.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;


public class PropertiesHelper {
	private static Logger logger = Logger.getLogger(PropertiesHelper.class);

	public static Properties load(String filePath) {
		ClassLoader loader = PropertiesHelper.class.getClassLoader();
		if (loader == null) {
			loader = Thread.currentThread().getContextClassLoader();
		}
		if (loader == null) {
			loader = ClassLoader.getSystemClassLoader();
		}

		InputStream propStreams = null;
		Properties properties = new Properties();
		try {
			propStreams = loader.getResourceAsStream(filePath);
			// propStreams = new FileInputStream(File.separator + filePath); // 加/表示从classpath根目录下查找,否则从当前包下查找.
			properties.load(propStreams);
		} catch (Exception e) {
			logger.error("Could not load configuration file: " + filePath, e);
		} finally {
			if (propStreams != null) {
				try {
					propStreams.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}

		// Enumeration<?> e = properties.propertyNames();
		// while (e.hasMoreElements()) {
		// String key = (String) e.nextElement();
		// String value = properties.getProperty(key);
		// System.out.println("Key : " + key + ", Value : " + value);
		// }

		return properties;
	}

//	public static void save(String propertiesFileName, Properties properties) {
//		OutputStream output = null;
//		try {
//			output = new FileOutputStream(propertiesFileName);
//			properties.store(output, null);
//		} catch (IOException io) {
//			io.printStackTrace();
//		} finally {
//			if (output != null) {
//				try {
//					output.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//
//		}
//	}
}
