package cokoliv.support;

public class Base64Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String orig = "cz819465";
		String encoded = StringOperations.getInstance().base64EncodedString(orig);
		String decoded = StringOperations.getInstance().base64DecodedString(encoded);
		System.out.println("Original: " + orig);
		System.out.println("Encoded: " + encoded);
		System.out.println("Decoded: " + decoded);
	}

}
