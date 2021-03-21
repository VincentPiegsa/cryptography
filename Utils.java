package verschl�sselung;

public class Utils {
	
	/*
	 * Diese Klasse beinhaltet Werkzeuge, die zur Verarbeitung der Daten genutzt werden
	 */
	
	static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	public static String filterSymbols(String text)
	{
		/*
		 * Methode, die alle Sonderzeichen (�, �, �, �) aus dem Text filtert und durch entsprechenden 
		 * Buchstabenkombinationen (ae, oe, ue, ss) ersetzt. �bernimmt Zahlen, Leerzeichen und Satzzeichen.
		 */
		
		text = text.toUpperCase();
		String filtered_text = "";
		
		for (int index = 0; index < text.length(); index++)
		{
			String character = Character.toString(text.charAt(index));
			
			switch (character) {
			case "�":
				filtered_text += "AE";
				break;
			case "�":
				filtered_text += "OE";
				break;
			case "�":
				filtered_text += "UE";
				break;
			case "�":
				filtered_text += "SS";
				break;
			default:
				filtered_text += character;
				break;
			}
		}
		
		return filtered_text;
	}
	
	public static String strictFilterSymbols(String text)
	{
		/*
		 * Methode, die alle Sonderzeichen (�, �, �, �) aus dem Text filtert und durch entsprechenden 
		 * Buchstabenkombinationen (ae, oe, ue, ss) ersetzt. �bernimmt keine Zahlen, Leerzeichen und Satzzeichen.
		 */
		
		text = text.toUpperCase();
		String filtered_text = "";
		
		for (int index = 0; index < text.length(); index++)
		{
			String character = Character.toString(text.charAt(index));
			
			if (alphabet.contains(character)) {
				filtered_text += character;
			} 
			
			switch (character) {
			case "�":
				filtered_text += "AE";
				break;
			case "�":
				filtered_text += "OE";
				break;
			case "�":
				filtered_text += "UE";
				break;
			case "�":
				filtered_text += "SS";
				break;
			}
			
		}
		
		return filtered_text;
	}
	
	public static boolean isPrime(int number)
	{
		/*
		 * Simpler Algorithmus um zu pr�fen, ob eine Zahl eine Primzahl ist
		 */
		
		for (int i = 2; i < number; i++) {
			
			if ((number % i) == 0) {
				return false;
			}
			
		}
		
		return true;
	}

	public static int greatestCommonDivisor(int a, int b) 
	{
		/*
		 * Simpler Algorithmus um den gr��ten gemeinsamen Teiler zweier Zahlen a und b zu ermitteln
		 */
		
		for (int divisor = Math.min(a, b); divisor > 0; divisor--) {
			
			if (((a % divisor) == 0) && ((b % divisor) == 0)) {
				return divisor;
			}
			
		}
		
		return 1;
	}
	
	public static int[] StringToInt(String text)
	{
		/*
		 * Methode, um einen String auf Grundlage der ASCII-Tabelle in ein integer array umzuwandeln 
		 */
		
		char[] char_array = text.toCharArray();
		int[] converted_array = new int[char_array.length];
		
		for (int i = 0; i < char_array.length; i++) {
			converted_array[i] = (int) char_array[i];
		}
		
		return converted_array;
	}
	
	public static String IntToString(int[] array)
	{
		/*
		 * Methode, um ein integer array auf Grundlage der ASCII-Tabelle in einen String umzuwandeln 
		 */
		
		String text = "";
		
		for (int i = 0; i < array.length; i++) {
			text += (char) array[i];
		}
		
		return text;
	}
	
}
