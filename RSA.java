package verschl�sselung;

import java.math.BigInteger;

public class RSA {
	
	/*
	 * Diese Klasse beinhaltet die Verschl�sselung und Entschl�sselung mit
	 * dem RSA-Verfahren
	 */
	
	private int p;
	private int q;
	private int n;
	private int phi;
	private int e;
	private int d;
	
	public RSA(int prime_p, int prime_q, int public_key) 
	{
		/*
		 * Konstruktor, errechnet zus�tzlich den Private Key
		 */
		
		p = prime_p;
		q = prime_q;
		
		//Verifizierung der Primzahlen
		if (!Utils.isPrime(p) || !Utils.isPrime(q)) {
			System.out.println("Die angegebenen Primzahlen sind ung�ltig.");
		}
		
		n = calculate_n();
		phi = calculate_phi();
		e = public_key;
		d = inverse_mod_d();
		
		// Verifizierung der Schl�ssel
		if (!verify()) {
			System.out.println("Falscher Schl�ssel.");
		}
	}
	
	public RSA(int prime_p, int prime_q, int public_key, int private_key) 
	{
		/*
		 * Konstruktor, �bernimmt den gegebenen Private Key
		 */
		
		p = prime_p;
		q = prime_q;
		
		//Verifizierung der Primzahlen
		if (!Utils.isPrime(p) || !Utils.isPrime(q)) {
			System.out.println("Die angegebenen Primzahlen sind ung�ltig.");
		}
		
		n = calculate_n();
		phi = calculate_phi();
		e = public_key;
		d = private_key;
		
		// Verifizierung der Schl�ssel
		if (!verify()) {
			System.out.println("Falscher Schl�ssel.");
		}
		
	}
	
	private int calculate_n() 
	{
		// Berechnet das Produkt n beider Primzahlen
		
		return p * q;
	}
	
	private int calculate_phi() 
	{
		// Berechnet die Eulersche Funktion phi aus beiden Primzahlen 
		
		return (p - 1) * (q - 1);
	}
	
	private int inverse_mod_d()
	{
		// Berechnet den Privaten Schl�ssel d mit dem erweiterten Euklidischen Algorithmus
		
		BigInteger d = BigInteger.valueOf(e).modInverse(BigInteger.valueOf(phi));
		return d.intValue();
	}
	
	public int get_d()
	{
		// Gibt den Privaten Schl�ssel d aus
		
		return d;
	}

	private int brute_force_d()
	{
		/*
		 * Methode, um den Privaten Schl�ssel mit der Brute-Force Methode zu errechnen. 
		 * Sehr ineffizient, funktioniert nur bei kleinen Zahlen.
		 */
		
		int d = 1;
		boolean d_calculated = false;
		
		while (!d_calculated)
		{
			if ((e*d % phi) == 1) {
				d_calculated = true;
			} else {
				d++;
			}
		}
		
		return d;
	}
	
	private boolean verify()
	{
		// Verifiziert, dass der Public und Private Key g�ltig sind
		
		if ((e > 1) && (phi > e) && (Utils.greatestCommonDivisor(phi, e) == 1)) {
			
			if ((e * d) % phi == 1) {
				return true;
			}
			
		}
		
		return false;
	}
	
	public int encrypt(int message)
	{
		/*
		 * Methode zum Verschl�sseln einzelner Nachrichten (int)
		 * C = M^(e) % n
		 */
		
		BigInteger calculation = BigInteger.valueOf(message).pow(e).mod(BigInteger.valueOf(n));
		return calculation.intValue();
	}
	
	public int[] encrypt(int[] message)
	{
		// Methode zum Verschl�sseln gro�er Nachrichten (arrays)
		
		int[] cipher = new int[message.length];
		
		for (int i = 0; i < message.length; i++)
		{
			cipher[i] = encrypt(message[i]);
		}
		
		return cipher;
	}
	
	public int decrypt(int cipher)
	{
		/*
		 * Methode zum Entschl�sseln einzelner Geheimtexte (int)
		 * M = C^(e) % n
		 */
		
		BigInteger calculation = BigInteger.valueOf(cipher).pow(d).mod(BigInteger.valueOf(n));
		return calculation.intValue();
	}
	
	public int[] decrypt(int[] cipher)
	{
		// Methode zum Entschl�sseln gro�er Geheimtexte (arrays)
		
		int[] message = new int[cipher.length];
		
		for (int i = 0; i < cipher.length; i++)
		{
			message[i] = decrypt(cipher[i]);
		}
		
		return message;
	}
	
}
