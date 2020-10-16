


public class IsProperly{

   public  static Boolean isProperly(String sequence) {
		int numOpening = 0; // number of opening brackets
		for (int i = 0; i < sequence.length(); i++) {
			if (sequence.charAt(i) == '(') {
				numOpening++;
			} else if (sequence.charAt(i) == ')') {
				if (numOpening > 0) {// pair closing bracket to opening bracket seen before
					numOpening--;
				} else { // there is no opening brackets left
					return false;
				}
			} else {
				// wrong sequence of chars
			}
		}
		return numOpening==0;
	}
}