package com.Vtiger_GenericUtility;

import java.util.Random;

public class RandomInt {

	public int Randomnumbergeneration() {

		Random random = new Random();

		int randint = random.nextInt(1000);

		return randint;

	}

}
