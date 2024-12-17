package com.Vtiger_GenericUtility;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class FetchJsonFile {

	Object obj = null;

	public void getdatafromJson() {

		JSONParser parse = new JSONParser();

		try {

			obj = parse.parse(new FileReader(""));

		} catch (Exception e) {

			System.out.println("Jason File reading error");
		}

		JSONObject jo = (JSONObject) obj;

	}

}
