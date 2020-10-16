


public class IsPalindrome {

	public static Boolean isPalindrome(String text) {
		int length = text.length();
		int halfLen = length >> 1;
		for (int i = 0; i < halfLen; i++) {
			if (text.charAt(i) != text.charAt(length - i - 1)) {
				return false;
			}
		}
		return true;
	}
}