package verschl�sselung;

public class Viginere {
	
	/*
	 * Diese Klasse beinhaltet die Verschl�sselung und Entschl�sselung mit
	 * dem Viginere-Chiffre, einem polyalphabetischen Verschl�sselungsverfahren
	 */

	private static String alphabet = Utils.alphabet;
	
	public static String encrypt(String text, String key)
	{
		char character;					// Einzelner Buchstabe der Nachricht
		int alphabet_index;				// Index des Buchstaben im Alphabet
		int shift;						// Verschiebung, Index des korrespondierenden Buchstaben des Schl�ssels
		int shifted_index;				// Addition des Index des Buchstaben mit der Verschiebung
		String encrypted_text = "";		// Verschl�sselte Nachricht als R�ckgabewert der Methode
		
		for (int index = 0; index < text.length(); index++) 
		{
			character = text.charAt(index);		// Iterieren durch die Nachricht, Buchstabe an Position des Index
			
			alphabet_index = alphabet.indexOf(character);					// Index des Buchstaben im Alphabet
			shift = alphabet.indexOf(key.charAt(index % key.length()));		// Index des korrespondierenden Schl�sselbuchstabens
			shifted_index = (alphabet_index + shift) % 26;					// Addieren der Position mit dem Schl�sselwert
			
			encrypted_text += alphabet.charAt(shifted_index);
		}
		
		return encrypted_text;		// R�ckgabe der verschl�sselten Nachricht
	}
	
	public static String decrypt(String cipher, String key)
	{
		char character;					// Einzelner Buchstabe der Nachricht
		int alphabet_index;				// Index des Buchstaben im Alphabet
		int shift;						// Verschiebung, Index des korrespondierenden Buchstaben des Schl�ssels
		int shifted_index;				// Addition des Index des Buchstaben mit der Verschiebung
		String decrypted_text = "";		// Entschl�sselte Nachricht als R�ckgabewert der Methode
		
		for (int index = 0; index < cipher.length(); index++)
		{
			character = cipher.charAt(index);		// Iterieren durch den Geheimtext, Buchstabe an Position des Index
			
			alphabet_index = alphabet.indexOf(character);					// Index des Buchstaben im Alphabet
			shift = alphabet.indexOf(key.charAt(index % key.length()));		// Index des korrespondierenden Schl�sselbuchstabens
			shifted_index = (alphabet_index - shift) % 26;					// Subtrahieren des Schl�ssels von der Position
			
			if (shifted_index < 0) {			// F�r negative Indizes
				shifted_index += 26;			// n-ter Buchstabe von hinten im Alphabet
			}
			
			decrypted_text += Character.toString(alphabet.charAt(shifted_index));
		}
		
		return decrypted_text;		// R�ckgabe des entschl�sselten Geheimtexts
	}
}
