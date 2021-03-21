package verschlüsselung;

public class CaesarChiffre {
	
	/* 
	 * Diese Klasse beinhaltet die Verschlüsselung und Entschlüsselung mit 
	 * dem Cäsar-Chiffre, einer monoalphabetischen Verschlüsselungsmethode
	 */
	
	private static String alphabet = Utils.alphabet;

	public static String encrypt(String text, int key)
	{
		/*
		 * Methode zum Verschlüsseln einer Nachricht text (String)
		 * mit einem ausgewählten Schlüssel key (int)
		 */
		
		key = Math.abs(key) % 26;		// mod 26, da das Alphabet 26 Buchstaben hat
		char character;					// Einzelner Buchstabe in der Nachricht
		int alphabet_index;				// Index des Buchstaben im Alphabet
		int shifted_index;				// Verschobener Index des Buchstaben
		String encrypted_text = "";		// Verschlüsselte Nachricht als Rückgabewert der Methode
		
		for (int index = 0; index < text.length(); index++) 
		{
			character = text.charAt(index);		// Iterieren durch die Nachricht, Buchstabe an Position des Index
			
			if (alphabet.contains(Character.toString(character))) {		// Für alle Zeichen, die im Alphabet enthalten sind und verschlüsselt werden können
				alphabet_index = alphabet.indexOf(character);		// Position des Buchstaben im Alphabet
				shifted_index = (alphabet_index + key) % 26;		// Addieren der Position mit dem Schlüsselwert
				
				encrypted_text += Character.toString(alphabet.charAt(shifted_index));
			} else {													// Sonstige Zeichen, die nicht verschlüsselt werden können
				encrypted_text += Character.toString(character);
			}		
		}
		
		return encrypted_text;		// Rückgabe der verschlüsselten Nachricht
	}
	
	public static String decrypt(String cipher, int key)
	{
		/*
		 * Methode zum Entschlüsseln einer Nachricht text (String)
		 * mit einem ausgewählten Schlüssel key (int)
		 */
		
		key = Math.abs(key) % 26;		// mod 26, da das Alphabet 26 Buchstaben hat
		char character;					// Einzelner Buchstabe in der Nachricht
		int alphabet_index;				// Index des Buchstaben im Alphabet
		int shifted_index;				// Verschobener Index des Buchstaben
		String decrypted_text = "";		// Entschlüsselte Nachricht als Rückgabewert der Methode
		
		for (int index = 0; index < cipher.length(); index++)
		{
			character = cipher.charAt(index);		// Iterieren durch den Geheimtext, Buchstabe an Position des Index
			
			if (alphabet.contains(Character.toString(character))) {		// Alle Zeichen, die im Alphabet enthalten sind und entschlüsselt werden können
				alphabet_index = alphabet.indexOf(character);		// Position des Buchstaben im Alphabet
				shifted_index = (alphabet_index - key) % 26;		// Subtrahieren des Schlüssels von der Position
				
				if (shifted_index < 0) {								// Für negative Indizes
					shifted_index += 26;					// n-ter Buchstabe von hinten im Alphabet
				}
				
				decrypted_text += Character.toString(alphabet.charAt(shifted_index));
			} else {													// Sonstige Zeichen, die nicht entschlüsselt werden können
				decrypted_text += Character.toString(character);
			}
		}
		
		return decrypted_text;		// Rückgabe des entschlüsselten Geheimtexts
	}
	
}
