package verschl�sselung;

public class CaesarChiffre {
	
	/* 
	 * Diese Klasse beinhaltet die Verschl�sselung und Entschl�sselung mit 
	 * dem C�sar-Chiffre, einer monoalphabetischen Verschl�sselungsmethode
	 */
	
	private static String alphabet = Utils.alphabet;

	public static String encrypt(String text, int key)
	{
		/*
		 * Methode zum Verschl�sseln einer Nachricht text (String)
		 * mit einem ausgew�hlten Schl�ssel key (int)
		 */
		
		key = Math.abs(key) % 26;		// mod 26, da das Alphabet 26 Buchstaben hat
		char character;					// Einzelner Buchstabe in der Nachricht
		int alphabet_index;				// Index des Buchstaben im Alphabet
		int shifted_index;				// Verschobener Index des Buchstaben
		String encrypted_text = "";		// Verschl�sselte Nachricht als R�ckgabewert der Methode
		
		for (int index = 0; index < text.length(); index++) 
		{
			character = text.charAt(index);		// Iterieren durch die Nachricht, Buchstabe an Position des Index
			
			if (alphabet.contains(Character.toString(character))) {		// F�r alle Zeichen, die im Alphabet enthalten sind und verschl�sselt werden k�nnen
				alphabet_index = alphabet.indexOf(character);		// Position des Buchstaben im Alphabet
				shifted_index = (alphabet_index + key) % 26;		// Addieren der Position mit dem Schl�sselwert
				
				encrypted_text += Character.toString(alphabet.charAt(shifted_index));
			} else {													// Sonstige Zeichen, die nicht verschl�sselt werden k�nnen
				encrypted_text += Character.toString(character);
			}		
		}
		
		return encrypted_text;		// R�ckgabe der verschl�sselten Nachricht
	}
	
	public static String decrypt(String cipher, int key)
	{
		/*
		 * Methode zum Entschl�sseln einer Nachricht text (String)
		 * mit einem ausgew�hlten Schl�ssel key (int)
		 */
		
		key = Math.abs(key) % 26;		// mod 26, da das Alphabet 26 Buchstaben hat
		char character;					// Einzelner Buchstabe in der Nachricht
		int alphabet_index;				// Index des Buchstaben im Alphabet
		int shifted_index;				// Verschobener Index des Buchstaben
		String decrypted_text = "";		// Entschl�sselte Nachricht als R�ckgabewert der Methode
		
		for (int index = 0; index < cipher.length(); index++)
		{
			character = cipher.charAt(index);		// Iterieren durch den Geheimtext, Buchstabe an Position des Index
			
			if (alphabet.contains(Character.toString(character))) {		// Alle Zeichen, die im Alphabet enthalten sind und entschl�sselt werden k�nnen
				alphabet_index = alphabet.indexOf(character);		// Position des Buchstaben im Alphabet
				shifted_index = (alphabet_index - key) % 26;		// Subtrahieren des Schl�ssels von der Position
				
				if (shifted_index < 0) {								// F�r negative Indizes
					shifted_index += 26;					// n-ter Buchstabe von hinten im Alphabet
				}
				
				decrypted_text += Character.toString(alphabet.charAt(shifted_index));
			} else {													// Sonstige Zeichen, die nicht entschl�sselt werden k�nnen
				decrypted_text += Character.toString(character);
			}
		}
		
		return decrypted_text;		// R�ckgabe des entschl�sselten Geheimtexts
	}
	
}
