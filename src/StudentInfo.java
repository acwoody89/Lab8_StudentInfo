import java.util.Scanner;

/**
 * 
 */

/**
 * 
 * Task: Write a program that will recognize invalid inputs when the user
 * requests info about students in a class
 * 
 * @author Alex Wood
 * @version 1.0
 *
 */
public class StudentInfo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Provide information about students in a class
		// parallel arrays.

		Scanner scan = new Scanner(System.in);

		String[] names = { "Michelle", "Tiffany", "Camila", "Joseph" };
		String[] hometowns = { "Hong Kong", "Detroit", "Dearborn", "I Didn't Hear Where" };
		String[] favFoods = { "Sushi", "Olives", "Chocolate", "Pasta" };
		int userNum = 0;
		String input = "";
		String knowMore = "y";
		String anotherStudent = "y";

		do {
			System.out.println("**************************************************");
			userNum = Validator.getInt(scan, "Which student would you like to know more about? "
					+ "\nChoose by entering a number (1-4)" + "\nMichelle(1), Tiffany(2), Camila(3), Joseph(4)\n", 1,
					4);
			System.out.println("**************************************************");
			// scan.nextLine();
			while (knowMore.equalsIgnoreCase("y")) {
				// Give a proper response according to user-submitted information
				System.out.println("Student " + userNum + " is " + names[userNum - 1] + ".");
				System.out.println("What would you like to know about " + names[userNum - 1]);
				System.out.println("Choose Hometown or Food");
				System.out.println("**************************************************");
				input = scan.nextLine();
				input = homeFoodVal(input, scan); // this feels iffy

				// input = Validator.getString(scan, "\"Hometown\" or \"Food\"?");
				switch (input) {
				case "Hometown":
					System.out.println(hometowns[userNum - 1]);
					break;
				case "Food":
					System.out.println(favFoods[userNum - 1]);
					break;
				default:
					System.out.println("Please Enter :\"Hometown\" or \"Food\"");
					break;
				}
				knowMore = Validator.getString(scan, "Would you like to know more about the student\n");
				System.out.println("**************************************************");
			}
			anotherStudent = Validator.getString(scan, "Would you like to know about a DIFFERENT student?\n");
			System.out.println("**************************************************");
		} while (anotherStudent.equalsIgnoreCase("y"));
		System.out.println("GoodBye!");
	}

	
	/*
	 * this will go through once, makes sure they enter hometown or food correctly
	 * will loop until they enter it correctly
	 */
	public static String homeFoodVal(String input, Scanner scan) {
		boolean valid = false;
			do {
			input = scan.nextLine();
			// takes in uppercase or lowercase versions of the words
			if (input.equalsIgnoreCase("Hometown")) {
				valid = true;
				input = "Hometown";
			} else if (input.equalsIgnoreCase("Food")) {
				valid = true;
				input = "Food";
			} else {
				System.out.println("Invalid Selection");
				System.out.println("Choose Hometown or Food");
				System.out.println("***************************************************");
				//System.out.println("Invalid, please enter Hometown, or Food2");
			}
		} while (valid == false);
		return input;

	}
	

}
