package controller;

public class Validator {

	
	public static boolean checkImePre(String input) {
		String regex = "[A-Ž][a-ž]+";
		if(input.matches(regex)) {
			return true;
		}else {
			return false;
		}
	}
}
