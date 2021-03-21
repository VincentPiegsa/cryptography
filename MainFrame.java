package verschlüsselung;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class MainFrame {
	
	/*
	 * Diese Klasse beinhaltet die grafische Benutzeroberfläche (GUI)
	 */
	
	JFrame frame;
	JPanel start_panel;
	JPanel caesar_decrypt;
	JPanel caesar_encrypt;
	JPanel viginere_decrypt;
	JPanel viginere_encrypt;
	JPanel rsa_decrypt;
	JPanel rsa_encrypt;
	
	public MainFrame()
	{
		frame = new JFrame();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Verschlüsselung");
		frame.setSize(400, 400);
		frame.setLocation(50, 50);
		frame.setResizable(false);
		frame.setIconImage(new ImageIcon("D:\\Dokumente\\Java\\verschlüsselung\\res\\images\\icon.png").getImage());
		
		start_panel = new JPanel();
		caesar_decrypt = new JPanel();
		caesar_encrypt = new JPanel();
		viginere_decrypt = new JPanel();
		viginere_encrypt = new JPanel();
		rsa_decrypt = new JPanel();
		rsa_encrypt = new JPanel();
		
		frame.add(start_panel);
		
		initialize();
		
		frame.setVisible(true);
	}
	
	private void initialize()
	{
		initializeMenu();
		
		initializeStartPanel();
		
		initializeCaesarEncrypt();
		initializeCaesarDecrypt();
		
		initializeViginereEncrypt();
		initializeViginereDecrypt();
		
		initializeRSAEncrypt();
		initializeRSADecrypt();
	}
	
	private void switchTo(JPanel panel) 
	{
		frame.setContentPane(panel);
		frame.revalidate();
	}
	
	private void initializePanel(JPanel panel, String title)
	{
		panel.setLayout(null);
		
		JLabel title_label = new JLabel(title);
		title_label.setBounds(10, 10, 200, 25);
		title_label.setForeground(Color.gray);
		
		panel.add(title_label);
	}
	
	private void initializeMenu()
	{
		JMenuBar menubar = new JMenuBar();
		
		JMenu start = new JMenu("Start");
		start.addMenuListener(new MenuListener() {
			
			@Override
			public void menuSelected(MenuEvent e) {
				switchTo(start_panel);
			}

			@Override
			public void menuDeselected(MenuEvent e) {}

			@Override
			public void menuCanceled(MenuEvent e) {}
		});
		
		JMenu menu_caesar = new JMenu("Cäsar-Chiffre");
		JMenuItem item_caesar_encrypt = new JMenuItem("Verschlüsseln");
		item_caesar_encrypt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				switchTo(caesar_encrypt);	
			}
		});
		JMenuItem item_caesar_decrypt = new JMenuItem("Entschlüsseln");
		item_caesar_decrypt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				switchTo(caesar_decrypt);			
			}
		});
		menu_caesar.add(item_caesar_encrypt);
		menu_caesar.add(item_caesar_decrypt);
		
		JMenu menu_viginere = new JMenu("Viginere-Chiffre");
		JMenuItem item_viginere_encrypt = new JMenuItem("Verschlüsseln");
		item_viginere_encrypt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				switchTo(viginere_encrypt);
			}
		});
		JMenuItem item_viginere_decrypt = new JMenuItem("Entschlüsseln");
		item_viginere_decrypt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				switchTo(viginere_decrypt);
			}
		});
		menu_viginere.add(item_viginere_encrypt);
		menu_viginere.add(item_viginere_decrypt);
		
		JMenu menu_rsa = new JMenu("RSA");
		JMenuItem item_rsa_encrypt = new JMenuItem("Verschlüsseln");
		item_rsa_encrypt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				switchTo(rsa_encrypt);
			}
		});
		JMenuItem item_rsa_decrypt = new JMenuItem("Entschlüsseln");
		item_rsa_decrypt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				switchTo(rsa_decrypt);
			}
		});
		menu_rsa.add(item_rsa_encrypt);
		menu_rsa.add(item_rsa_decrypt);
		
		menubar.add(start);
		menubar.add(menu_caesar);
		menubar.add(menu_viginere);
		menubar.add(menu_rsa);
		
		frame.setJMenuBar(menubar);		
	}
	
	private void initializeStartPanel()
	{
		initializePanel(start_panel, "Verschlüsselungen");
		
		String content = "<html><body><p>" + 
						"Dieses Programm umfasst die Ver- und Entschlüsselung \n mit Hilfe des Cäsar-Chiffres, des Viginere-Chiffres und des RSA-Verfahrens." +
						"</p><br><p>"+
						"Zum Auswählen der jeweiligen Verschlüsselungsmethode drücken Sie bitte auf den entsprechenden Button aus der Menü-Leiste, und wählen im Sub-Menü das Ent- oder Verschüsseln von Nachrichten aus." + 
						"</p></body></html>";
		JLabel text = new JLabel(content);
		text.setBounds(10, 50, 340, 130);
		start_panel.add(text);
		
		JLabel copy = new JLabel("© Vincent Piegsa 2021");
		copy.setForeground(Color.LIGHT_GRAY);
		copy.setBounds(10, 310, 200, 20);
		start_panel.add(copy);
	}
	
	private void initializeCaesarEncrypt()
	{
		initializePanel(caesar_encrypt, "Caesar-Chiffre: Verschlüsseln");
		caesar_encrypt.setLayout(null);
		
		JLabel label_message = new JLabel("Nachricht");
		label_message.setBounds(10, 50, 100, 25);
		caesar_encrypt.add(label_message);
		
		JTextField text_message = new JTextField("", 25);
		text_message.setBounds(150, 50, 150, 25);
		caesar_encrypt.add(text_message);
		
		JLabel label_key = new JLabel("Schlüssel");
		label_key.setBounds(10, 100, 100, 25);
		caesar_encrypt.add(label_key);
		
		JTextField text_key = new JTextField("", 25);
		text_key.setBounds(150, 100, 150, 25);
		caesar_encrypt.add(text_key);
		
		JLabel label_cipher = new JLabel("Geheimtext");
		label_cipher.setBounds(10, 200, 100, 25);
		caesar_encrypt.add(label_cipher);
		
		JLabel text_cipher = new JLabel("");
		text_cipher.setBounds(150, 200, 150, 25);
		caesar_encrypt.add(text_cipher);
		
		JButton button_encrypt = new JButton("Verschlüsseln!");
		button_encrypt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String message = text_message.getText();
				String key_raw = text_key.getText();
				int key = 0;
				
				try {
					key = Integer.parseInt(key_raw);
					message = Utils.filterSymbols(message);
					
					String cipher = CaesarChiffre.encrypt(message, key);
					
					text_cipher.setText(cipher);
				}
				catch (NumberFormatException e1) {
					System.out.println("Wrong input!");
					text_cipher.setText(message);
				}
				
				
			}
		});
		button_encrypt.setBounds(10, 150, 150, 25);
		caesar_encrypt.add(button_encrypt);
	}
	
	private void initializeCaesarDecrypt()
	{
		initializePanel(caesar_decrypt, "Caesar-Chiffre: Entschlüsseln");
		caesar_decrypt.setLayout(null);
		
		JLabel label_cipher = new JLabel("Geheimtext");
		label_cipher.setBounds(10, 50, 100, 25);
		caesar_decrypt.add(label_cipher);
		
		JTextField text_cipher = new JTextField("", 25);
		text_cipher.setBounds(150, 50, 150, 25);
		caesar_decrypt.add(text_cipher);
		
		JLabel label_key = new JLabel("Schlüssel");
		label_key.setBounds(10, 100, 100, 25);
		caesar_decrypt.add(label_key);
		
		JTextField text_key = new JTextField("", 25);
		text_key.setBounds(150, 100, 150, 25);
		caesar_decrypt.add(text_key);
		
		JLabel label_message = new JLabel("Nachricht");
		label_message.setBounds(10, 200, 100, 25);
		caesar_decrypt.add(label_message);
		
		JLabel text_message = new JLabel("");
		text_message.setBounds(150, 200, 150, 25);
		caesar_decrypt.add(text_message);
		
		JButton button_decrypt = new JButton("Entschlüsseln!");
		button_decrypt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String cipher = text_cipher.getText();
				String key_raw = text_key.getText();
				int key = 0;
				
				try {
					key = Integer.parseInt(key_raw);
					cipher = Utils.filterSymbols(cipher);
					
					String message = CaesarChiffre.decrypt(cipher, key);
					
					text_message.setText(message);
				}
				catch (NumberFormatException e1) {
					System.out.println("Wrong input!");
					text_cipher.setText(cipher);
				}
				
				
			}
		});
		button_decrypt.setBounds(10, 150, 150, 25);
		caesar_decrypt.add(button_decrypt);
	}
	
	private void initializeViginereEncrypt()
	{
		initializePanel(viginere_encrypt, "Viginere-Chiffre: Verschlüsseln");
		viginere_encrypt.setLayout(null);
		
		JLabel label_message = new JLabel("Nachricht");
		label_message.setBounds(10, 50, 100, 25);
		viginere_encrypt.add(label_message);
		
		JTextField text_message = new JTextField("", 25);
		text_message.setBounds(150, 50, 150, 25);
		viginere_encrypt.add(text_message);
		
		JLabel label_key = new JLabel("Schlüssel");
		label_key.setBounds(10, 100, 100, 25);
		viginere_encrypt.add(label_key);
		
		JTextField text_key = new JTextField("", 25);
		text_key.setBounds(150, 100, 150, 25);
		viginere_encrypt.add(text_key);
		
		JLabel label_cipher = new JLabel("Geheimtext");
		label_cipher.setBounds(10, 200, 100, 25);
		viginere_encrypt.add(label_cipher);
		
		JLabel text_cipher = new JLabel("");
		text_cipher.setBounds(150, 200, 150, 25);
		viginere_encrypt.add(text_cipher);
		
		JButton button_encrypt = new JButton("Verschlüsseln!");
		button_encrypt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String message = text_message.getText();
				String key = text_key.getText();
				
				try {
					message = Utils.strictFilterSymbols(message);
					key = Utils.strictFilterSymbols(key);
					
					String cipher = Viginere.encrypt(message, key);
					
					text_cipher.setText(cipher);
				}
				catch (NumberFormatException e1) {
					System.out.println("Wrong input!");
					text_cipher.setText(message);
				}
				
				
			}
		});
		button_encrypt.setBounds(10, 150, 150, 25);
		viginere_encrypt.add(button_encrypt);
	}
	
	private void initializeViginereDecrypt()
	{
		initializePanel(viginere_decrypt, "Viginere-Chiffre: Entschlüsseln");
		viginere_decrypt.setLayout(null);
		
		JLabel label_cipher = new JLabel("Geheimtext");
		label_cipher.setBounds(10, 50, 100, 25);
		viginere_decrypt.add(label_cipher);
		
		JTextField text_cipher = new JTextField("", 25);
		text_cipher.setBounds(150, 50, 150, 25);
		viginere_decrypt.add(text_cipher);
		
		JLabel label_key = new JLabel("Schlüssel");
		label_key.setBounds(10, 100, 100, 25);
		viginere_decrypt.add(label_key);
		
		JTextField text_key = new JTextField("", 25);
		text_key.setBounds(150, 100, 150, 25);
		viginere_decrypt.add(text_key);
		
		JLabel label_message = new JLabel("Nachricht");
		label_message.setBounds(10, 200, 100, 25);
		viginere_decrypt.add(label_message);
		
		JLabel text_message = new JLabel("");
		text_message.setBounds(150, 200, 150, 25);
		viginere_decrypt.add(text_message);
		
		JButton button_decrypt = new JButton("Entschlüsseln!");
		button_decrypt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String cipher = text_cipher.getText();
				String key = text_key.getText();
				
				try {
					cipher = Utils.strictFilterSymbols(cipher);
					key = Utils.strictFilterSymbols(key);
					
					String message = Viginere.decrypt(cipher, key);
					text_message.setText(message);
				} catch (NumberFormatException e1) {
					System.out.println("Wrong input!");
					text_cipher.setText(cipher);
				}
				
				
			}
		});
		button_decrypt.setBounds(10, 150, 150, 25);
		viginere_decrypt.add(button_decrypt);
	}
	
	private void initializeRSAEncrypt()
	{
		initializePanel(rsa_encrypt, "RSA: Verschlüsseln");
		rsa_encrypt.setLayout(null);
		
		JLabel label_message = new JLabel("Nachricht");
		label_message.setBounds(10, 50, 100, 25);
		rsa_encrypt.add(label_message);
		
		JTextField text_message = new JTextField("", 25);
		text_message.setBounds(150, 50, 150, 25);
		rsa_encrypt.add(text_message);
		
		JLabel label_p = new JLabel("Primzahl p");
		label_p.setBounds(10, 100, 100, 25);
		rsa_encrypt.add(label_p);
		
		JTextField text_p = new JTextField("", 25);
		text_p.setBounds(150, 100, 150, 25);
		rsa_encrypt.add(text_p);
		
		JLabel label_q = new JLabel("Primzahl q");
		label_q.setBounds(10, 130, 100, 25);
		rsa_encrypt.add(label_q);
		
		JTextField text_q = new JTextField("", 25);
		text_q.setBounds(150, 130, 150, 25);
		rsa_encrypt.add(text_q);
		
		JLabel label_e = new JLabel("Public Key e");
		label_e.setBounds(10, 160, 100, 25);
		rsa_encrypt.add(label_e);
		
		JTextField text_e = new JTextField("", 25);
		text_e.setBounds(150, 160, 150, 25);
		rsa_encrypt.add(text_e);
		
		JLabel label_d = new JLabel("Private Key d");
		label_d.setBounds(10, 190, 100, 25);
		rsa_encrypt.add(label_d);
		
		JTextField text_d = new JTextField("", 25);
		text_d.setBounds(150, 190, 150, 25);
		rsa_encrypt.add(text_d);
		
		JLabel label_cipher = new JLabel("Geheimtext");
		label_cipher.setBounds(10, 290, 100, 25);
		rsa_encrypt.add(label_cipher);
		
		JLabel text_cipher = new JLabel("");
		text_cipher.setBounds(150, 290, 150, 25);
		rsa_encrypt.add(text_cipher);
		
		JButton button_encrypt = new JButton("Verschlüsseln");
		button_encrypt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String message = text_message.getText();
				String p_raw = text_p.getText();
				String q_raw = text_q.getText();
				String e_raw = text_e.getText();
				String d_raw = text_d.getText();
				
				int p, q, public_key, private_key = 0;
				String cipher = "";
				
				if (d_raw.isBlank()) {
					try {
						p = Integer.parseInt(p_raw);
						q = Integer.parseInt(q_raw);
						public_key = Integer.parseInt(e_raw);
						
						RSA rsa = new RSA(p, q, public_key);
						text_d.setText("" + rsa.get_d());
						cipher = Utils.IntToString(rsa.encrypt(Utils.StringToInt(message)));
						text_cipher.setText(cipher);
					} 
					catch (NumberFormatException e1) {
						System.out.println("Wrong input");
					}
				} else {
					try {
						p = Integer.parseInt(p_raw);
						q = Integer.parseInt(q_raw);
						public_key = Integer.parseInt(e_raw);
						private_key = Integer.parseInt(d_raw);
						
						RSA rsa = new RSA(p, q, public_key, private_key);
						cipher = Utils.IntToString(rsa.encrypt(Utils.StringToInt(message)));
						text_cipher.setText(cipher);
					} 
					catch (NumberFormatException e1) {
						System.out.println("Wrong input");
					}
				}
			}
		});
		button_encrypt.setBounds(10, 240, 150, 25);
		rsa_encrypt.add(button_encrypt);
	}
	
	private void initializeRSADecrypt()
	{
		initializePanel(rsa_decrypt, "RSA: Entschlüsseln");
		rsa_decrypt.setLayout(null);
		
		JLabel label_message = new JLabel("Nachricht");
		label_message.setBounds(10, 50, 100, 25);
		rsa_decrypt.add(label_message);
		
		JTextField text_message = new JTextField("", 25);
		text_message.setBounds(150, 50, 150, 25);
		rsa_decrypt.add(text_message);
		
		JLabel label_p = new JLabel("Primzahl p");
		label_p.setBounds(10, 100, 100, 25);
		rsa_decrypt.add(label_p);
		
		JTextField text_p = new JTextField("", 25);
		text_p.setBounds(150, 100, 150, 25);
		rsa_decrypt.add(text_p);
		
		JLabel label_q = new JLabel("Primzahl q");
		label_q.setBounds(10, 130, 100, 25);
		rsa_decrypt.add(label_q);
		
		JTextField text_q = new JTextField("", 25);
		text_q.setBounds(150, 130, 150, 25);
		rsa_decrypt.add(text_q);
		
		JLabel label_e = new JLabel("Public Key e");
		label_e.setBounds(10, 160, 100, 25);
		rsa_decrypt.add(label_e);
		
		JTextField text_e = new JTextField("", 25);
		text_e.setBounds(150, 160, 150, 25);
		rsa_decrypt.add(text_e);
		
		JLabel label_d = new JLabel("Private Key d");
		label_d.setBounds(10, 190, 100, 25);
		rsa_decrypt.add(label_d);
		
		JTextField text_d = new JTextField("", 25);
		text_d.setBounds(150, 190, 150, 25);
		rsa_decrypt.add(text_d);
		
		JLabel label_cipher = new JLabel("Geheimtext");
		label_cipher.setBounds(10, 290, 100, 25);
		rsa_decrypt.add(label_cipher);
		
		JLabel text_cipher = new JLabel("");
		text_cipher.setBounds(150, 290, 150, 25);
		rsa_decrypt.add(text_cipher);
		
		JButton button_encrypt = new JButton("Entschlüsseln");
		button_encrypt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String message = text_message.getText();
				String p_raw = text_p.getText();
				String q_raw = text_q.getText();
				String e_raw = text_e.getText();
				String d_raw = text_d.getText();
				
				int p, q, public_key, private_key = 0;
				String cipher = "";
				
				if (d_raw.isBlank()) {
					try {
						p = Integer.parseInt(p_raw);
						q = Integer.parseInt(q_raw);
						public_key = Integer.parseInt(e_raw);
						
						RSA rsa = new RSA(p, q, public_key);
						text_d.setText("" + rsa.get_d());
						cipher = Utils.IntToString(rsa.decrypt(Utils.StringToInt(message)));
						text_cipher.setText(cipher);
					} 
					catch (NumberFormatException e1) {
						System.out.println("Wrong input");
					}
				} else {
					try {
						p = Integer.parseInt(p_raw);
						q = Integer.parseInt(q_raw);
						public_key = Integer.parseInt(e_raw);
						private_key = Integer.parseInt(d_raw);
						
						RSA rsa = new RSA(p, q, public_key, private_key);
						cipher = Utils.IntToString(rsa.decrypt(Utils.StringToInt(message)));
						text_cipher.setText(cipher);
					} 
					catch (NumberFormatException e1) {
						System.out.println("Wrong input");
						JOptionPane.showMessageDialog(new JFrame(), "Test");
					}
				}
			}
		});
		button_encrypt.setBounds(10, 240, 150, 25);
		rsa_decrypt.add(button_encrypt);
	}
	
	public static void main(String[] args) {
		
		MainFrame frame = new MainFrame();
		
	}

}
