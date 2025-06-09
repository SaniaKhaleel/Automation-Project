package sania.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	static Properties prop;

	public static Properties getProperties() {
		if (prop == null) {
			prop = new Properties();
			try {
				FileInputStream fis = new FileInputStream("src\\main\\java\\sania\\resources\\config.properties");
				prop.load(fis);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return prop;
	}

	public static String get(String key) {
		return getProperties().getProperty(key);

	}
}
