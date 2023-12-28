package com.MyntraProject.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Config {
	public static String getBrowserName() {
		String base = System.getProperty("user.dir");
		String filepath = base + "/src/main/resources/application.Properties";
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(filepath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Properties prop = new Properties();
		String value = null;
		try {
			prop.load(fis);
			value = prop.getProperty("browser_name");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;

	}

	public static String getAppUrl(String env) {
		String base = System.getProperty("user.dir");
		String filepath = base + "/src/main/resources/application.Properties";
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(filepath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Properties prop = new Properties();
		String value = null;
		try {
			prop.load(fis);
			value = prop.getProperty("app." + env + ".url");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;

	}
}
