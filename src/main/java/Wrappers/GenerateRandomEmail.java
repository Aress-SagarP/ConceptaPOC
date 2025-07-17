package Wrappers;

import java.util.Random;

public class GenerateRandomEmail {
	public static String generateRandomEmail() {
		Random random = new Random();
        int number = random.nextInt(10000); // Generates a random number between 0-9999
        return "Conceptauser" + number + "@testmail.com";
	}

}
