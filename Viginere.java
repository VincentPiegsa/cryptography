package verschlüsselung;

public class Viginere {
	
	/*
	 * Diese Klasse beinhaltet die Verschlüsselung und Entschlüsselung mit
	 * dem Viginere-Chiffre, einem polyalphabetischen Verschlüsselungsverfahren
	 */

	private static String alphabet = Utils.alphabet;
	
	public static String encrypt(String text, String key)
	{
		char character;					// Einzelner Buchstabe der Nachricht
		int alphabet_index;				// Index des Buchstaben im Alphabet
		int shift;						// Verschiebung, Index des korrespondierenden Buchstaben des Schlüssels
		int shifted_index;				// Addition des Index des Buchstaben mit der Verschiebung
		String encrypted_text = "";		// Verschlüsselte Nachricht als Rückgabewert der Methode
		
		for (int index = 0; index < text.length(); index++) 
		{
			character = text.charAt(index);		// Iterieren durch die Nachricht, Buchstabe an Position des Index
			
			alphabet_index = alphabet.indexOf(character);					// Index des Buchstaben im Alphabet
			shift = alphabet.indexOf(key.charAt(index % key.length()));		// Index des korrespondierenden Schlüsselbuchstabens
			shifted_index = (alphabet_index + shift) % 26;					// Addieren der Position mit dem Schlüsselwert
			
			encrypted_text += alphabet.charAt(shifted_index);
		}
		
		return encrypted_text;		// Rückgabe der verschlüsselten Nachricht
	}
	
	public static String decrypt(String cipher, String key)
	{
		char character;					// Einzelner Buchstabe der Nachricht
		int alphabet_index;				// Index des Buchstaben im Alphabet
		int shift;						// Verschiebung, Index des korrespondierenden Buchstaben des Schlüssels
		int shifted_index;				// Addition des Index des Buchstaben mit der Verschiebung
		String decrypted_text = "";		// Entschlüsselte Nachricht als Rückgabewert der Methode
		
		for (int index = 0; index < cipher.length(); index++)
		{
			character = cipher.charAt(index);		// Iterieren durch den Geheimtext, Buchstabe an Position des Index
			
			alphabet_index = alphabet.indexOf(character);					// Index des Buchstaben im Alphabet
			shift = alphabet.indexOf(key.charAt(index % key.length()));		// Index des korrespondierenden Schlüsselbuchstabens
			shifted_index = (alphabet_index - shift) % 26;					// Subtrahieren des Schlüssels von der Position
			
			if (shifted_index < 0) {			// Für negative Indizes
				shifted_index += 26;			// n-ter Buchstabe von hinten im Alphabet
			}
			
			decrypted_text += Character.toString(alphabet.charAt(shifted_index));
		}
		
		return decrypted_text;		// Rückgabe des entschlüsselten Geheimtexts
	}
}
