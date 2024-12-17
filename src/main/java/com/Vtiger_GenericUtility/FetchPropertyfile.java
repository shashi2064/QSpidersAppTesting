package com.Vtiger_GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class FetchPropertyfile {

	FileInputStream fi = null;

	FileOutputStream fos = null;

	public String getDataFrompropertyfile(String key) {

		try {

			fi = new FileInputStream("./src/test/resources/Properties/contact.properties");

		} catch (FileNotFoundException e) {

			System.out.println("Failed to Fetch the File");
		}

		Properties p = new Properties();

		try {

			p.load(fi);

		} catch (IOException e) {

			System.out.println("Check the Dependencys");
		}

		String data = p.getProperty(key);
		return data;

	}

	public void WriteDataBackTopropertyfile(String Key, String value, String updatedmessage) {

		try {

			fi = new FileInputStream("./src/test/resources/Properties/contact.properties");

		} catch (FileNotFoundException e) {

			System.out.println("Failed to Fetch the File");
		}

		Properties p = new Properties();

		try {

			p.load(fi);

		} catch (IOException e) {

			System.out.println("Check the Dependencys");
		}

		p.put(Key, value);

		try {
			fos = new FileOutputStream("./src/test/resources/Properties/contact.properties");

			try {
				p.store(fos, updatedmessage);
			} catch (Exception e) {
				System.out.println("Check the Dependencys");
			}
		} catch (FileNotFoundException e) {
			System.out.println("Failed to Fetch the File");
		}
	}

}
