package views;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.security.SecureRandom;

import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.Asymmetric.RSA;
import model.Asymmetric.RSAWithAES;
import model.Hash.MD5;
import model.Hash.SHA;
import model.Symmetric.AlgorithmSymmetric;

public class Algorithms extends JFrame {

	AlgorithmSymmetric as = new AlgorithmSymmetric();
	RSA rsa = new RSA();
	RSAWithAES rsaWithAES = new RSAWithAES();
	MD5 md5 = new MD5();
	SHA sha = new SHA();

	private JPanel contentPane;
	// SymmetricText -----------------------------------------
	private static JComboBox comboBoxAlgorithm;
	private JComboBox comboBoxMode;
	private JComboBox comboBoxPadding;
	private JComboBox comboBoxSizeKey;

	private JTextField textKey;
	private JTextArea textAreaInput;
	private JTextArea textAreaOutput;
	// SymmetricFile -----------------------------------------
	private JComboBox comboBoxAlgorithmFile;
	private JComboBox comboBoxModeFile;
	private JComboBox comboBoxPaddingFile;
	private JComboBox comboBoxSizeFileKey;

	private JTextField textFileKey;
	private JTextField textFileInput;
	// SymmetricGenerateKey -----------------------------------------
	private JComboBox comboBoxAlgorithmGenerateFile;
	private JTextField textDirectorySaveKey;
	// AsymmetricText -----------------------------------------
	private JComboBox comboBoxSizeFileKeyA;
	private JComboBox comboBoxAlgorithmA;
	private JComboBox comboBoxModeA;
	private JComboBox comboBoxPaddingA;

	private JTextField textKeyA;
	private JTextArea textAreaInputA;
	private JTextArea textAreaOutputA;
	// AsymmetricFile -----------------------------------------
	private JComboBox comboBoxAlgorithmFileA;
	private JComboBox comboBoxModeFileA;
	private JComboBox comboBoxPaddingFileA;

	private JTextField textFileKeyA;
	private JTextField textFileInputA;
	// AsymmetricGenerateKey -----------------------------------------
	private JTextField textDirectorySaveKeyA;

	// Hash------------------------------------------------------------
	// Text------------------------------------------------------
	private JTextArea textAreaTextHashInput;
	private JTextArea textAreaTextHashOutput;

	private JComboBox comboBoxAlgorythmTextHash;
	// File-------------------------------------------------------
	private JTextField textFiledHashInput;
	private JTextArea textAreaFileHashOutput;

	private JComboBox comboBoxAlgorythmFileHash;

	public Algorithms() {
		setTitle("Algorithms");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		// Symmetric--------------------------------------------------------------------------------------------------------------------
		JPanel Symmetric = new JPanel();
		tabbedPane.addTab("Symmetric", null, Symmetric, null);
		Symmetric.setLayout(new BorderLayout(0, 0));

		JTabbedPane tabbedPaneSymmetric = new JTabbedPane(JTabbedPane.TOP);
		Symmetric.add(tabbedPaneSymmetric, BorderLayout.CENTER);
		// TextSymmetric-------------------------------------------------------------------------------------------------------------------
		JPanel TextSymmetric = new JPanel();
		tabbedPaneSymmetric.addTab("Text", null, TextSymmetric, null);
		TextSymmetric.setLayout(null);

		JLabel lblAlgorithm = new JLabel("Choose the algorithms:");
		lblAlgorithm.setBounds(10, 11, 134, 23);
		TextSymmetric.add(lblAlgorithm);

		comboBoxAlgorithm = new JComboBox();
		comboBoxAlgorithm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String dataComboBoxAlgorithm = comboBoxAlgorithm.getSelectedItem().toString();
				if (dataComboBoxAlgorithm.endsWith("DES")) {
					comboBoxSizeKey.setModel(new DefaultComboBoxModel(new String[] { "56", "64" }));
					textKey.setText("");
				}
				if (dataComboBoxAlgorithm.endsWith("TripleDES")) {
					comboBoxSizeKey.setModel(new DefaultComboBoxModel(new String[] { "112", "168" }));
					textKey.setText("");
				}
				if (dataComboBoxAlgorithm.endsWith("AES") || dataComboBoxAlgorithm.endsWith("ARIA")) {
					comboBoxSizeKey.setModel(new DefaultComboBoxModel(new String[] { "128", "192", "256" }));
					textKey.setText("");
				}
				if (dataComboBoxAlgorithm.endsWith("Blowfish")) {
					comboBoxSizeKey
							.setModel(new DefaultComboBoxModel(new String[] { "32", "64", "128", "256", "448" }));
					textKey.setText("");
				}
				if (dataComboBoxAlgorithm.endsWith("RC2")) {
					comboBoxSizeKey
							.setModel(new DefaultComboBoxModel(new String[] { "40", "64", "128", "256", "1024" }));
					textKey.setText("");
				}
				if (dataComboBoxAlgorithm.endsWith("RC5") || dataComboBoxAlgorithm.endsWith("RC6")) {
					comboBoxSizeKey.setModel(new DefaultComboBoxModel(
							new String[] { "8", "16", "32", "64", "128", "256", "512", "1024", "2048", "4096" }));
					textKey.setText("");
				}
				if (dataComboBoxAlgorithm.endsWith("TEA") || dataComboBoxAlgorithm.endsWith("XTEA")) {
					comboBoxSizeKey.setModel(new DefaultComboBoxModel(new String[] { "128" }));
					textKey.setText("");
				}
			}
		});
		comboBoxAlgorithm.setBounds(148, 11, 59, 21);
		comboBoxAlgorithm.setModel(new DefaultComboBoxModel(
				new String[] { "DES", "TripleDES", "AES", "Blowfish", "RC2", "RC5", "RC6", "TEA", "XTEA", "ARIA" }));
		TextSymmetric.add(comboBoxAlgorithm);

		comboBoxMode = new JComboBox();
		comboBoxMode.setModel(new DefaultComboBoxModel(new String[] { "ECB", "CBC" }));
		comboBoxMode.setBounds(217, 11, 61, 21);
		TextSymmetric.add(comboBoxMode);

		comboBoxPadding = new JComboBox();
		comboBoxPadding.setModel(new DefaultComboBoxModel(new String[] { "PKCS5Padding", "ISO10126Padding" }));
		comboBoxPadding.setBounds(288, 11, 116, 21);
		TextSymmetric.add(comboBoxPadding);

		JLabel lblKey = new JLabel("Key:");
		lblKey.setBounds(10, 44, 30, 14);
		TextSymmetric.add(lblKey);

		textKey = new JTextField();
		textKey.setBounds(68, 44, 162, 23);
		textKey.setColumns(10);
		TextSymmetric.add(textKey);

		comboBoxSizeKey = new JComboBox();
		comboBoxSizeKey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String dataComboBoxSizeKey = comboBoxSizeKey.getSelectedItem().toString();
				int n = Integer.parseInt(dataComboBoxSizeKey);
				if (n == 8 || n == 16 || n == 32 || n == 56 || n == 64 || n == 112 || n == 128 || n == 168 || n == 192
						|| n == 256 || n == 448 || n == 1024 || n == 2048 || n == 4096) {
					textKey.setText("");
				}
			}
		});
		comboBoxSizeKey.setModel(new DefaultComboBoxModel(new String[] { "56", "64" }));
		comboBoxSizeKey.setBounds(234, 44, 52, 23);
		TextSymmetric.add(comboBoxSizeKey);

		JButton btnGenerateKey = new JButton("Generate Key");
		btnGenerateKey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					do_btnGenerateKeyText_actionPerformed(e);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnGenerateKey.setBounds(288, 44, 116, 23);
		TextSymmetric.add(btnGenerateKey);

		JLabel lblInput = new JLabel("Input:");
		lblInput.setBounds(10, 70, 38, 14);
		TextSymmetric.add(lblInput);

		textAreaInput = new JTextArea();
		textAreaInput.setBounds(68, 70, 336, 39);
		textAreaInput.setWrapStyleWord(true);
		textAreaInput.setLineWrap(true);
		TextSymmetric.add(textAreaInput);

		JLabel lblOutput = new JLabel("Output:");
		lblOutput.setBounds(10, 115, 48, 14);
		TextSymmetric.add(lblOutput);

		textAreaOutput = new JTextArea();
		textAreaOutput.setBounds(68, 115, 336, 40);
		textAreaOutput.setWrapStyleWord(true);
		textAreaOutput.setLineWrap(true);
		TextSymmetric.add(textAreaOutput);

		JButton btnEncryptSymmetric = new JButton("Encrypt");
		btnEncryptSymmetric.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					do_btnEncryptSymmetricText_actionPerformed(e);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnEncryptSymmetric.setBounds(68, 161, 82, 23);
		TextSymmetric.add(btnEncryptSymmetric);

		JButton btnDecryptSymmetric = new JButton("Decrypt");
		btnDecryptSymmetric.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					do_btnDecryptSymmetricText_actionPerformed(e);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnDecryptSymmetric.setBounds(158, 161, 82, 23);
		TextSymmetric.add(btnDecryptSymmetric);

		// FileSymmetric-------------------------------------------------------------------------------------------------------------------
		JPanel FileSymmetric = new JPanel();
		tabbedPaneSymmetric.addTab("File", null, FileSymmetric, null);
		FileSymmetric.setLayout(null);

		JLabel labAlgorithmsFile = new JLabel("Choose the algorithms:");
		labAlgorithmsFile.setBounds(10, 11, 134, 23);
		FileSymmetric.add(labAlgorithmsFile);

		comboBoxAlgorithmFile = new JComboBox();
		comboBoxAlgorithmFile.setModel(new DefaultComboBoxModel(
				new String[] { "DES", "TripleDES", "AES", "Blowfish", "RC2", "RC5", "RC6", "TEA", "XTEA", "ARIA" }));
		comboBoxAlgorithmFile.setBounds(148, 12, 59, 21);
		FileSymmetric.add(comboBoxAlgorithmFile);

		comboBoxModeFile = new JComboBox();
		comboBoxModeFile.setModel(new DefaultComboBoxModel(new String[] { "ECB", "CBC" }));
		comboBoxModeFile.setBounds(217, 11, 61, 21);
		FileSymmetric.add(comboBoxModeFile);

		comboBoxPaddingFile = new JComboBox();
		comboBoxPaddingFile.setModel(new DefaultComboBoxModel(new String[] { "PKCS5PADDING", "ISO10126Padding" }));
		comboBoxPaddingFile.setBounds(288, 11, 116, 21);
		FileSymmetric.add(comboBoxPaddingFile);

		JLabel lblFileKey = new JLabel("File key:");
		lblFileKey.setBounds(10, 49, 47, 14);
		FileSymmetric.add(lblFileKey);

		textFileKey = new JTextField();
		textFileKey.setBounds(75, 46, 220, 23);
		textFileKey.setColumns(10);
		FileSymmetric.add(textFileKey);

		JButton btnFileKey = new JButton("Browse");
		btnFileKey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					do_btnBrowseFileKey_actionPerformed(e);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnFileKey.setBounds(305, 46, 99, 23);
		FileSymmetric.add(btnFileKey);

		JLabel lblFileInput = new JLabel("File input:");
		lblFileInput.setBounds(10, 83, 55, 14);
		FileSymmetric.add(lblFileInput);

		textFileInput = new JTextField();
		textFileInput.setBounds(75, 80, 220, 23);
		textFileInput.setColumns(10);
		FileSymmetric.add(textFileInput);

		JButton btnFileInput = new JButton("Browse");
		btnFileInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					do_btnBrowseFileInput_actionPerformed(e);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnFileInput.setBounds(305, 80, 99, 23);
		FileSymmetric.add(btnFileInput);

		JButton btnEncryptSymmetricFile = new JButton("Encrypt");
		btnEncryptSymmetricFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					do_btnEncryptSymmetricFile_actionPerformed(e);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnEncryptSymmetricFile.setBounds(75, 114, 82, 23);
		FileSymmetric.add(btnEncryptSymmetricFile);

		JButton btnDecryptSymmetricFile = new JButton("Decrypt");
		btnDecryptSymmetricFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					do_btnDecryptSymmetricFile_actionPerformed(e);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnDecryptSymmetricFile.setBounds(163, 114, 82, 23);
		FileSymmetric.add(btnDecryptSymmetricFile);

		// GenerateFile-------------------------------------------------------------------------------------------------------------------
		JPanel GenerateFileKey = new JPanel();
		tabbedPaneSymmetric.addTab("Generate File Key", null, GenerateFileKey, null);
		GenerateFileKey.setLayout(null);

		JLabel label_1 = new JLabel("Choose the algorithms:");
		label_1.setBounds(10, 11, 134, 23);
		GenerateFileKey.add(label_1);

		comboBoxAlgorithmGenerateFile = new JComboBox();
		comboBoxAlgorithmGenerateFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String dataComboBoxAlgorithm = comboBoxAlgorithmGenerateFile.getSelectedItem().toString();
				if (dataComboBoxAlgorithm.endsWith("DES")) {
					comboBoxSizeFileKey.setModel(new DefaultComboBoxModel(new String[] { "56", "64" }));
				}
				if (dataComboBoxAlgorithm.endsWith("TripleDES")) {
					comboBoxSizeFileKey.setModel(new DefaultComboBoxModel(new String[] { "112", "168" }));
				}
				if (dataComboBoxAlgorithm.endsWith("AES") || dataComboBoxAlgorithm.endsWith("ARIA")) {
					comboBoxSizeFileKey.setModel(new DefaultComboBoxModel(new String[] { "128", "192", "256" }));
				}
				if (dataComboBoxAlgorithm.endsWith("Blowfish")) {
					comboBoxSizeFileKey
							.setModel(new DefaultComboBoxModel(new String[] { "32", "64", "128", "256", "448" }));
				}
				if (dataComboBoxAlgorithm.endsWith("RC2")) {
					comboBoxSizeFileKey
							.setModel(new DefaultComboBoxModel(new String[] { "40", "64", "128", "256", "1024" }));
				}
				if (dataComboBoxAlgorithm.endsWith("RC5") || dataComboBoxAlgorithm.endsWith("RC6")) {
					comboBoxSizeFileKey.setModel(new DefaultComboBoxModel(
							new String[] { "8", "16", "32", "64", "128", "256", "512", "1024", "2048", "4096" }));
				}
				if (dataComboBoxAlgorithm.endsWith("TEA") || dataComboBoxAlgorithm.endsWith("XTEA")) {
					comboBoxSizeKey.setModel(new DefaultComboBoxModel(new String[] { "128" }));
				}
			}
		});
		comboBoxAlgorithmGenerateFile.setModel(new DefaultComboBoxModel(
				new String[] { "DES", "TripleDES", "AES", "Blowfish", "RC2", "RC5", "RC6", "TEA", "XTEA", "ARIA" }));
		comboBoxAlgorithmGenerateFile.setBounds(148, 12, 59, 21);
		GenerateFileKey.add(comboBoxAlgorithmGenerateFile);
		JLabel lblSizeFileKey = new JLabel("Size key:");
		lblSizeFileKey.setBounds(213, 15, 59, 14);
		GenerateFileKey.add(lblSizeFileKey);

		comboBoxSizeFileKey = new JComboBox();
		comboBoxSizeFileKey.setModel(new DefaultComboBoxModel(new String[] { "56", "64" }));
		comboBoxSizeFileKey.setBounds(265, 11, 52, 23);
		GenerateFileKey.add(comboBoxSizeFileKey);

		JLabel lblDirectorySaveKey = new JLabel("Directory save key:");
		lblDirectorySaveKey.setBounds(10, 48, 117, 14);
		GenerateFileKey.add(lblDirectorySaveKey);

		textDirectorySaveKey = new JTextField();
		textDirectorySaveKey.setColumns(10);
		textDirectorySaveKey.setBounds(123, 45, 179, 23);
		GenerateFileKey.add(textDirectorySaveKey);

		JButton btnBrowseDirectorySaveKey = new JButton("Browse");
		btnBrowseDirectorySaveKey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					do_btnBrowseGenerateFileKey_actionPerformed(e);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnBrowseDirectorySaveKey.setBounds(312, 45, 81, 23);
		GenerateFileKey.add(btnBrowseDirectorySaveKey);

		JButton btnGenerateFileKey = new JButton("Generate File Key");
		btnGenerateFileKey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					do_btnGenerateFileKey_actionPerformed(e);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnGenerateFileKey.setBounds(123, 79, 145, 23);
		GenerateFileKey.add(btnGenerateFileKey);

		// Asymmetric-----------------------------------------------------------------------------------------------------------------
		JPanel Asymmetric = new JPanel();
		tabbedPane.addTab("Asymmetric", null, Asymmetric, null);
		Asymmetric.setLayout(new BorderLayout(0, 0));

		JTabbedPane tabbedPaneA = new JTabbedPane(JTabbedPane.TOP);
		Asymmetric.add(tabbedPaneA, BorderLayout.CENTER);
		// TextAsymmetric-------------------------------------------------------------------------------------------------------------------------
		JPanel TextAsymmetric = new JPanel();
		tabbedPaneA.addTab("Text", null, TextAsymmetric, null);
		TextAsymmetric.setLayout(null);

		JLabel lblAlgorithmA = new JLabel("Choose the algorithms:");
		lblAlgorithmA.setBounds(10, 11, 134, 23);
		TextAsymmetric.add(lblAlgorithmA);

		comboBoxAlgorithmA = new JComboBox();
		comboBoxAlgorithmA.setModel(new DefaultComboBoxModel(new String[] { "RSA" }));
		comboBoxAlgorithmA.setBounds(148, 11, 59, 21);
		TextAsymmetric.add(comboBoxAlgorithmA);

		comboBoxModeA = new JComboBox();
		comboBoxModeA.setModel(new DefaultComboBoxModel(new String[] { "ECB" }));
		comboBoxModeA.setBounds(217, 11, 61, 21);
		TextAsymmetric.add(comboBoxModeA);

		comboBoxPaddingA = new JComboBox();
		comboBoxPaddingA.setModel(new DefaultComboBoxModel(new String[] { "PKCS1PADDING" }));
		comboBoxPaddingA.setBounds(288, 11, 116, 21);
		TextAsymmetric.add(comboBoxPaddingA);

		JLabel lblKeyA = new JLabel("Key:");
		lblKeyA.setBounds(10, 44, 30, 14);
		TextAsymmetric.add(lblKeyA);

		textKeyA = new JTextField();
		textKeyA.setColumns(10);
		textKeyA.setBounds(68, 44, 210, 23);
		TextAsymmetric.add(textKeyA);

		JButton btnKeyA = new JButton("Browse");
		btnKeyA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					do_btnBrowseKeyA_actionPerformed(e);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnKeyA.setBounds(288, 44, 116, 23);
		TextAsymmetric.add(btnKeyA);

		JLabel lblInputA = new JLabel("Input:");
		lblInputA.setBounds(10, 70, 38, 14);
		TextAsymmetric.add(lblInputA);

		textAreaInputA = new JTextArea();
		textAreaInputA.setWrapStyleWord(true);
		textAreaInputA.setLineWrap(true);
		textAreaInputA.setBounds(68, 70, 336, 39);
		TextAsymmetric.add(textAreaInputA);

		JLabel lblOutputA = new JLabel("Output:");
		lblOutputA.setBounds(10, 115, 48, 14);
		TextAsymmetric.add(lblOutputA);

		textAreaOutputA = new JTextArea();
		textAreaOutputA.setWrapStyleWord(true);
		textAreaOutputA.setLineWrap(true);
		textAreaOutputA.setBounds(68, 115, 336, 40);
		TextAsymmetric.add(textAreaOutputA);

		JButton btnEncryptAsymmetric = new JButton("Encrypt");
		btnEncryptAsymmetric.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					do_btnEncryptAsymmetric_actionPerformed(e);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnEncryptAsymmetric.setBounds(68, 161, 82, 23);
		TextAsymmetric.add(btnEncryptAsymmetric);

		JButton btnDecryptAsymmetric = new JButton("Decrypt");
		btnDecryptAsymmetric.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					do_btnDecryptAsymmetric_actionPerformed(e);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnDecryptAsymmetric.setBounds(158, 161, 82, 23);
		TextAsymmetric.add(btnDecryptAsymmetric);
		// FileAsymmetric--------------------------------------------------------------------------------------------------------------------------------
		JPanel FileAsymmetric = new JPanel();
		tabbedPaneA.addTab("File", null, FileAsymmetric, null);
		FileAsymmetric.setLayout(null);

		JLabel lblAlgorithmFileA = new JLabel("Choose the algorithms:");
		lblAlgorithmFileA.setBounds(10, 11, 134, 23);
		FileAsymmetric.add(lblAlgorithmFileA);

		comboBoxAlgorithmFileA = new JComboBox();
		comboBoxAlgorithmFileA.setModel(new DefaultComboBoxModel(new String[] { "RSA", "RSAWithAES" }));
		comboBoxAlgorithmFileA.setBounds(148, 12, 94, 21);
		FileAsymmetric.add(comboBoxAlgorithmFileA);

		comboBoxModeFileA = new JComboBox();
		comboBoxModeFileA.setModel(new DefaultComboBoxModel(new String[] { "ECB" }));
		comboBoxModeFileA.setBounds(245, 12, 61, 21);
		FileAsymmetric.add(comboBoxModeFileA);

		comboBoxPaddingFileA = new JComboBox();
		comboBoxPaddingFileA.setModel(new DefaultComboBoxModel(new String[] { "PKCS1PADDING" }));
		comboBoxPaddingFileA.setBounds(310, 11, 94, 21);
		FileAsymmetric.add(comboBoxPaddingFileA);

		JLabel lblFileKeyA = new JLabel("File key:");
		lblFileKeyA.setBounds(10, 49, 47, 14);
		FileAsymmetric.add(lblFileKeyA);

		textFileKeyA = new JTextField();
		textFileKeyA.setColumns(10);
		textFileKeyA.setBounds(75, 46, 220, 23);
		FileAsymmetric.add(textFileKeyA);

		JButton btnFileKeyA = new JButton("Browse");
		btnFileKeyA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					do_btnBrowseFileKeyA_actionPerformed(e);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnFileKeyA.setBounds(305, 46, 99, 23);
		FileAsymmetric.add(btnFileKeyA);

		JLabel lblFileInputA = new JLabel("File input:");
		lblFileInputA.setBounds(10, 83, 55, 14);
		FileAsymmetric.add(lblFileInputA);

		textFileInputA = new JTextField();
		textFileInputA.setColumns(10);
		textFileInputA.setBounds(75, 80, 220, 23);
		FileAsymmetric.add(textFileInputA);

		JButton btnFileInputA = new JButton("Browse");
		btnFileInputA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					do_btnBrowseFileInputA_actionPerformed(e);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnFileInputA.setBounds(305, 80, 99, 23);
		FileAsymmetric.add(btnFileInputA);

		JButton btnEncryptAsymmetricFile = new JButton("Encrypt");
		btnEncryptAsymmetricFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					do_btnEncryptAsymmetricFile_actionPerformed(e);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnEncryptAsymmetricFile.setBounds(75, 114, 82, 23);
		FileAsymmetric.add(btnEncryptAsymmetricFile);

		JButton btnDecryptAsymmetricFile = new JButton("Decrypt");
		btnDecryptAsymmetricFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					do_btnDecryptAsymmetricFile_actionPerformed(e);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnDecryptAsymmetricFile.setBounds(163, 114, 82, 23);
		FileAsymmetric.add(btnDecryptAsymmetricFile);
		// GeneratePublicAndPrivateKey--------------------------------------------------------------------------------------------------------------------
		JPanel GeneratePublicAndPrivateKey = new JPanel();
		tabbedPaneA.addTab("Generate Public And Private Key", null, GeneratePublicAndPrivateKey, null);
		GeneratePublicAndPrivateKey.setLayout(null);

		JLabel lblSizeKeyA = new JLabel("Size key:");
		lblSizeKeyA.setBounds(10, 14, 59, 14);
		GeneratePublicAndPrivateKey.add(lblSizeKeyA);

		comboBoxSizeFileKeyA = new JComboBox();
		comboBoxSizeFileKeyA.setModel(new DefaultComboBoxModel(new String[] {"1024"}));
		comboBoxSizeFileKeyA.setBounds(123, 11, 59, 23);
		GeneratePublicAndPrivateKey.add(comboBoxSizeFileKeyA);

		JLabel lblDirectorySaveKeyA = new JLabel("Directory save key:");
		lblDirectorySaveKeyA.setBounds(10, 46, 117, 14);
		GeneratePublicAndPrivateKey.add(lblDirectorySaveKeyA);

		textDirectorySaveKeyA = new JTextField();
		textDirectorySaveKeyA.setColumns(10);
		textDirectorySaveKeyA.setBounds(123, 43, 179, 23);
		GeneratePublicAndPrivateKey.add(textDirectorySaveKeyA);

		JButton btnDirectorySaveKeyA = new JButton("Browse");
		btnDirectorySaveKeyA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					do_btnBrowseDirectorySaveKeyA_actionPerformed(e);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnDirectorySaveKeyA.setBounds(312, 43, 81, 23);
		GeneratePublicAndPrivateKey.add(btnDirectorySaveKeyA);

		JButton btnGenerateFileKeyA = new JButton("Generate File Key");
		btnGenerateFileKeyA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					do_btnGenerateFileKeyA_actionPerformed(e);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnGenerateFileKeyA.setBounds(123, 77, 145, 23);
		GeneratePublicAndPrivateKey.add(btnGenerateFileKeyA);
		// Hash--------------------------------------------------------------------------------------------------------------
		JPanel Hash = new JPanel();
		tabbedPane.addTab("Hash", null, Hash, null);
		Hash.setLayout(new BorderLayout(0, 0));

		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		Hash.add(tabbedPane_1, BorderLayout.CENTER);
		// TextHash-----------------------------------------------------------------------------------------------------------------
		JPanel Text = new JPanel();
		tabbedPane_1.addTab("TextHash", null, Text, null);
		Text.setLayout(null);

		JLabel lblTextHash = new JLabel("Choose the algorithms:");
		lblTextHash.setBounds(10, 11, 134, 23);
		Text.add(lblTextHash);

		comboBoxAlgorythmTextHash = new JComboBox();
		comboBoxAlgorythmTextHash.setModel(new DefaultComboBoxModel(new String[] { "MD5", "SHA" }));
		comboBoxAlgorythmTextHash.setBounds(148, 11, 56, 21);
		Text.add(comboBoxAlgorythmTextHash);

		JLabel lblTextHashInput = new JLabel("Input:");
		lblTextHashInput.setBounds(10, 44, 38, 14);
		Text.add(lblTextHashInput);

		textAreaTextHashInput = new JTextArea();
		textAreaTextHashInput.setWrapStyleWord(true);
		textAreaTextHashInput.setLineWrap(true);
		textAreaTextHashInput.setBounds(68, 44, 336, 39);
		Text.add(textAreaTextHashInput);

		JLabel lblTextHashOutput = new JLabel("Output:");
		lblTextHashOutput.setBounds(10, 89, 48, 14);
		Text.add(lblTextHashOutput);

		textAreaTextHashOutput = new JTextArea();
		textAreaTextHashOutput.setWrapStyleWord(true);
		textAreaTextHashOutput.setLineWrap(true);
		textAreaTextHashOutput.setBounds(68, 89, 336, 40);
		Text.add(textAreaTextHashOutput);

		JButton btnGenerateText = new JButton("Generate");
		btnGenerateText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					do_btnGenerateTextHash_actionPerformed(e);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnGenerateText.setBounds(68, 143, 89, 23);
		Text.add(btnGenerateText);
		// FileHash--------------------------------------------------------------------------------------------------------------
		JPanel File = new JPanel();
		tabbedPane_1.addTab("FileHash", null, File, null);
		File.setLayout(null);

		JLabel lblFileHash = new JLabel("Choose the algorithms:");
		lblFileHash.setBounds(10, 11, 134, 23);
		File.add(lblFileHash);

		comboBoxAlgorythmFileHash = new JComboBox();
		comboBoxAlgorythmFileHash.setModel(new DefaultComboBoxModel(new String[] { "MD5", "SHA" }));
		comboBoxAlgorythmFileHash.setBounds(148, 11, 55, 21);
		File.add(comboBoxAlgorythmFileHash);

		JLabel lblFileHashInput = new JLabel("File Input:");
		lblFileHashInput.setBounds(10, 48, 55, 14);
		File.add(lblFileHashInput);

		textFiledHashInput = new JTextField();
		textFiledHashInput.setColumns(10);
		textFiledHashInput.setBounds(75, 45, 220, 23);
		File.add(textFiledHashInput);

		JLabel label = new JLabel("Output:");
		label.setBounds(10, 79, 48, 14);
		File.add(label);

		textAreaFileHashOutput = new JTextArea();
		textAreaFileHashOutput.setWrapStyleWord(true);
		textAreaFileHashOutput.setLineWrap(true);
		textAreaFileHashOutput.setBounds(75, 79, 329, 40);
		File.add(textAreaFileHashOutput);

		JButton btnFileHashBrowse = new JButton("Browse");
		btnFileHashBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					do_btnBrowseHashFile_actionPerformed(e);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnFileHashBrowse.setBounds(305, 45, 99, 23);
		File.add(btnFileHashBrowse);

		JButton btnGenerateFileHash = new JButton("Generate");
		btnGenerateFileHash.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					do_btnGenerateFileHash_actionPerformed(e);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnGenerateFileHash.setBounds(75, 130, 89, 23);
		File.add(btnGenerateFileHash);

	}

	// Các nút xử lý
	// Chọn file
	public String FileChooser() {
		JFileChooser fileChooser = new JFileChooser("D://");
		fileChooser.setDialogTitle("Select file");
		fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		int result = fileChooser.showOpenDialog(null);
		if (result == fileChooser.APPROVE_OPTION)
			fileChooser.setMultiSelectionEnabled(false);
		File file = fileChooser.getSelectedFile();
		return file.getPath();
	}

	// iv
	public static IvParameterSpec generateIv(int n) {
		byte[] iv = new byte[n];
		new SecureRandom().nextBytes(iv);
		return new IvParameterSpec(iv);
	}

	IvParameterSpec iv_8 = generateIv(8);
	IvParameterSpec iv_16 = generateIv(16);

	// Symmetric-------------------------------------------------------------------------------------------------------------
	// TextSymmetric------------------------------------------------------------------------------------------------
	// Nút Generate Key của tab TextSymmetric
	protected void do_btnGenerateKeyText_actionPerformed(ActionEvent e) throws Exception {
		String dataComboBoxAlgorithm = comboBoxAlgorithm.getSelectedItem().toString();

		String dataComboBoxSizeKey = comboBoxSizeKey.getSelectedItem().toString();
		int n = Integer.parseInt(dataComboBoxSizeKey);

		SecretKey key = as.GenerateKey(n, dataComboBoxAlgorithm);
		String k = as.ConvertSecretKeyToString(key);
		textKey.setText(k);
	}

	// Nút Encrypt của tab TextSymmetric
	protected void do_btnEncryptSymmetricText_actionPerformed(ActionEvent e) throws Exception {
		String key = textKey.getText();
		String dataComboBoxAlgorithm = comboBoxAlgorithm.getSelectedItem().toString();
		String dataComboBoxMode = comboBoxMode.getSelectedItem().toString();
		String dataComboBoxPadding = comboBoxPadding.getSelectedItem().toString();
		try {
			if (dataComboBoxMode.endsWith("ECB")) {
				SecretKey k = as.ConvertStringToSecretKey(key, dataComboBoxAlgorithm);
				textAreaOutput.setText(as.Encrypt(textAreaInput.getText(), k, dataComboBoxAlgorithm, dataComboBoxMode,
						dataComboBoxPadding));
			}
			if (dataComboBoxMode.endsWith("CBC")) {
				SecretKey k = as.ConvertStringToSecretKey(key, dataComboBoxAlgorithm);
				if (dataComboBoxAlgorithm.endsWith("AES") || dataComboBoxAlgorithm.endsWith("RC6")
						|| dataComboBoxAlgorithm.endsWith("ARIA")) {
					textAreaOutput.setText(as.EncryptCBC(textAreaInput.getText(), k, iv_16, dataComboBoxAlgorithm,
							dataComboBoxMode, dataComboBoxPadding));
				} else {
					textAreaOutput.setText(as.EncryptCBC(textAreaInput.getText(), k, iv_8, dataComboBoxAlgorithm,
							dataComboBoxMode, dataComboBoxPadding));
				}
			}
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(this, "ERRO");
		}

	}

	// Nút Decrypt của tab TextSymmetric
	protected void do_btnDecryptSymmetricText_actionPerformed(ActionEvent e) throws Exception {
		String key = textKey.getText();
		String dataComboBoxAlgorithm = comboBoxAlgorithm.getSelectedItem().toString();
		String dataComboBoxMode = comboBoxMode.getSelectedItem().toString();
		String dataComboBoxPadding = comboBoxPadding.getSelectedItem().toString();
		try {
			if (dataComboBoxMode.endsWith("ECB")) {
				SecretKey k = as.ConvertStringToSecretKey(key, dataComboBoxAlgorithm);
				textAreaOutput.setText(as.Decrypt(textAreaInput.getText(), k, dataComboBoxAlgorithm, dataComboBoxMode,
						dataComboBoxPadding));
			}
			if (dataComboBoxMode.endsWith("CBC")) {
				SecretKey k = as.ConvertStringToSecretKey(key, dataComboBoxAlgorithm);
				if (dataComboBoxAlgorithm.endsWith("AES") || dataComboBoxAlgorithm.endsWith("RC6")
						|| dataComboBoxAlgorithm.endsWith("ARIA")) {
					textAreaOutput.setText(as.DecryptCBC(textAreaInput.getText(), k, iv_16, dataComboBoxAlgorithm,
							dataComboBoxMode, dataComboBoxPadding));
				} else {
					textAreaOutput.setText(as.DecryptCBC(textAreaInput.getText(), k, iv_8, dataComboBoxAlgorithm,
							dataComboBoxMode, dataComboBoxPadding));
				}
			}
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(this, "ERRO");
		}
	}

	// FileSymmetric---------------------------------------------------------------------------------------------------------------------
	// Nút Browse File Key của tab FileSymmetric
	protected void do_btnBrowseFileKey_actionPerformed(ActionEvent e) throws Exception {
		textFileKey.setText(FileChooser());
	}

	// Nút Browse File Input của tab FileSymmetric
	protected void do_btnBrowseFileInput_actionPerformed(ActionEvent e) throws Exception {
		textFileInput.setText(FileChooser());
	}

	// Nút Encrypt của tab FileSymmetric
	protected void do_btnEncryptSymmetricFile_actionPerformed(ActionEvent e) throws Exception {
		String key = textFileKey.getText();
		String input = textFileInput.getText();
		String dataComboBoxAlgorithmFile = comboBoxAlgorithmFile.getSelectedItem().toString();
		String dataComboBoxModeFile = comboBoxModeFile.getSelectedItem().toString();
		String dataComboBoxPaddingFile = comboBoxPaddingFile.getSelectedItem().toString();
		try {
			if (dataComboBoxModeFile.endsWith("ECB")) {
				as.EncryptFile(input, key, dataComboBoxAlgorithmFile, dataComboBoxModeFile, dataComboBoxPaddingFile);
				JOptionPane.showMessageDialog(this, "Encrypt successfully");
			}
			if (dataComboBoxModeFile.endsWith("CBC")) {
				if (dataComboBoxAlgorithmFile.endsWith("AES") || dataComboBoxAlgorithmFile.endsWith("RC6")
						|| dataComboBoxAlgorithmFile.endsWith("ARIA")) {
					as.EncryptFileCBC(input, key, iv_16, dataComboBoxAlgorithmFile, dataComboBoxModeFile,
							dataComboBoxPaddingFile);
					JOptionPane.showMessageDialog(this, "Encrypt successfully");
				} else {
					as.EncryptFileCBC(input, key, iv_8, dataComboBoxAlgorithmFile, dataComboBoxModeFile,
							dataComboBoxPaddingFile);
					JOptionPane.showMessageDialog(this, "Encrypt successfully");
				}
			}
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(this, "ERRO");
		}
	}

	// Nút Decrypt của tab FileSymmetric
	protected void do_btnDecryptSymmetricFile_actionPerformed(ActionEvent e) throws Exception {
		String key = textFileKey.getText();
		String input = textFileInput.getText();
		String dataComboBoxAlgorithmFile = comboBoxAlgorithmFile.getSelectedItem().toString();
		String dataComboBoxModeFile = comboBoxModeFile.getSelectedItem().toString();
		String dataComboBoxPaddingFile = comboBoxPaddingFile.getSelectedItem().toString();
		try {
			if (dataComboBoxModeFile.endsWith("ECB")) {
				as.DecryptFile(input, key, dataComboBoxAlgorithmFile, dataComboBoxModeFile, dataComboBoxPaddingFile);
				JOptionPane.showMessageDialog(this, "Decrypt successfully");
			}
			if (dataComboBoxModeFile.endsWith("CBC")) {
				if (dataComboBoxAlgorithmFile.endsWith("AES") || dataComboBoxAlgorithmFile.endsWith("RC6")
						|| dataComboBoxAlgorithmFile.endsWith("ARIA")) {
					as.DecryptFileCBC(input, key, iv_16, dataComboBoxAlgorithmFile, dataComboBoxModeFile,
							dataComboBoxPaddingFile);
					JOptionPane.showMessageDialog(this, "Decrypt successfully");
				} else {
					as.DecryptFileCBC(input, key, iv_8, dataComboBoxAlgorithmFile, dataComboBoxModeFile,
							dataComboBoxPaddingFile);
					JOptionPane.showMessageDialog(this, "Decrypt successfully");
				}
			}
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(this, "ERRO");
		}
	}

	// GenerateFileKey----------------------------------------------------------------------------------------------------------------------
	// Nút Browse Directory save key của tab GenerateFileKey
	protected void do_btnBrowseGenerateFileKey_actionPerformed(ActionEvent e) {
		textDirectorySaveKey.setText(FileChooser());

	}

	// Nút GenerateFileKey của tab GenerateFileKey
	protected void do_btnGenerateFileKey_actionPerformed(ActionEvent e) throws Exception {
		String dataComboBoxAlgorithm = comboBoxAlgorithmGenerateFile.getSelectedItem().toString();
		String dataComboBoxSizeKey = comboBoxSizeFileKey.getSelectedItem().toString();
		int n = Integer.parseInt(dataComboBoxSizeKey);
		String savekey = textDirectorySaveKey.getText();
		try {
			if (!savekey.isEmpty()) {
				as.KeyFile(savekey, n, dataComboBoxAlgorithm);
				JOptionPane.showMessageDialog(this, "Generate successfully");
			} else {
				JOptionPane.showMessageDialog(this, "Directory not found");
			}
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(this, "ERRO");
		}
	}

	// Asymmetric--------------------------------------------------------------------------------------------------------------------
	// TextAsymmetric----------------------------------------------------------------------------------------------------------------------
	// nút BrowseKey của tab TextAsymmetric
	protected void do_btnBrowseKeyA_actionPerformed(ActionEvent e) {
		textKeyA.setText(FileChooser());
	}

	// nút Encrypt của tab TextAsymmetric
	protected void do_btnEncryptAsymmetric_actionPerformed(ActionEvent e) {
		String publicKey = textKeyA.getText();
		String dataComboBoxAlgorithmA = comboBoxAlgorithmA.getSelectedItem().toString();
		String dataComboBoxModeA = comboBoxModeA.getSelectedItem().toString();
		String dataComboBoxPaddingA = comboBoxPaddingA.getSelectedItem().toString();
		try {
			textAreaOutputA.setText(rsa.Encrypt(textAreaInputA.getText(), publicKey, dataComboBoxAlgorithmA,
					dataComboBoxModeA, dataComboBoxPaddingA));
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(this, "ERRO");
			JOptionPane.showMessageDialog(this,
					"Maybe the data is too big for the algorithm. RSA use PublicKey to Encrypt, PrivateKey to Decrypt. RSAWithAES use PrivateKey to Encrypt, PublicKey to Decrypt");
		}
	}

	// nút Decrypt của tab TextAsymmetric
	protected void do_btnDecryptAsymmetric_actionPerformed(ActionEvent e) {
		String privateKey = textKeyA.getText();
		String dataComboBoxAlgorithmA = comboBoxAlgorithmA.getSelectedItem().toString();
		String dataComboBoxModeA = comboBoxModeA.getSelectedItem().toString();
		String dataComboBoxPaddingA = comboBoxPaddingA.getSelectedItem().toString();
		try {
			textAreaOutputA.setText(rsa.Decrypt(textAreaInputA.getText(), privateKey, dataComboBoxAlgorithmA,
					dataComboBoxModeA, dataComboBoxPaddingA));
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(this, "ERRO");
			JOptionPane.showMessageDialog(this,
					"Maybe the data is too big for the algorithm. RSA use PublicKey to Encrypt, PrivateKey to Decrypt. RSAWithAES use PrivateKey to Encrypt, PublicKey to Decrypt");
		}
	}

	// FileAsymmetric-------------------------------------------------------------------------------------------------------------------
	// nút Browse File key của tab FileAsymmetric
	protected void do_btnBrowseFileKeyA_actionPerformed(ActionEvent e) {
		textFileKeyA.setText(FileChooser());
	}

	// nút Browse File input của tab FileAsymmetric
	protected void do_btnBrowseFileInputA_actionPerformed(ActionEvent e) {
		textFileInputA.setText(FileChooser());
	}

	// nút Encrypt của tab FileAsymmetric
	protected void do_btnEncryptAsymmetricFile_actionPerformed(ActionEvent e) {
		String key = textFileKeyA.getText();
		String input = textFileInputA.getText();
		String dataComboBoxAlgorithmFileA = comboBoxAlgorithmFileA.getSelectedItem().toString();
		String dataComboBoxModeFileA = comboBoxModeFileA.getSelectedItem().toString();
		String dataComboBoxPaddingFileA = comboBoxPaddingFileA.getSelectedItem().toString();
		try {
			if (dataComboBoxAlgorithmFileA.endsWith("RSA")) {
				rsa.EncryptFile(input, key, dataComboBoxAlgorithmFileA, dataComboBoxModeFileA,
						dataComboBoxPaddingFileA);
				JOptionPane.showMessageDialog(this, "Encrypt successfully");
			}
			if (dataComboBoxAlgorithmFileA.endsWith("RSAWithAES")) {
				rsaWithAES.EncryptFileRSAWithAES(input, key, "RSA", dataComboBoxModeFileA, dataComboBoxPaddingFileA);
				JOptionPane.showMessageDialog(this, "Encrypt successfully");
			}

		} catch (Exception e1) {
			JOptionPane.showMessageDialog(this, "ERRO");
			JOptionPane.showMessageDialog(this,
					"Maybe the data is too big for the algorithm. RSA use PublicKey to Encrypt, PrivateKey to Decrypt. RSAWithAES use PrivateKey to Encrypt, PublicKey to Decrypt");
		}
	}

	// nút Decrypt của tab FileAsymmetric
	protected void do_btnDecryptAsymmetricFile_actionPerformed(ActionEvent e) {
		String key = textFileKeyA.getText();
		String input = textFileInputA.getText();
		String dataComboBoxAlgorithmFileA = comboBoxAlgorithmFileA.getSelectedItem().toString();
		String dataComboBoxModeFileA = comboBoxModeFileA.getSelectedItem().toString();
		String dataComboBoxPaddingFileA = comboBoxPaddingFileA.getSelectedItem().toString();
		try {
			if (dataComboBoxAlgorithmFileA.endsWith("RSA")) {
				rsa.DecryptFile(input, key, dataComboBoxAlgorithmFileA, dataComboBoxModeFileA,
						dataComboBoxPaddingFileA);
				JOptionPane.showMessageDialog(this, "Decrypt successfully");
			}
			if (dataComboBoxAlgorithmFileA.endsWith("RSAWithAES")) {
				rsaWithAES.DecryptFileRSAWithAES(input, key, "RSA", dataComboBoxModeFileA, dataComboBoxPaddingFileA);
				JOptionPane.showMessageDialog(this, "Decrypt successfully");
			}
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(this, "ERRO");
			JOptionPane.showMessageDialog(this,
					"Maybe the data is too big for the algorithm. RSA use PublicKey to Encrypt, PrivateKey to Decrypt. RSAWithAES use PrivateKey to Encrypt, PublicKey to Decrypt");
		}
	}

	// GeneratePublicAndPrivateKey--------------------------------------------------------------------------------------------------------------------
	// nút Browse Directory Save Key của tab GeneratePublicAndPrivateKey
	protected void do_btnBrowseDirectorySaveKeyA_actionPerformed(ActionEvent e) {
		textDirectorySaveKeyA.setText(FileChooser());

	}

	// nút Generate File Key của tab GeneratePublicAndPrivateKey
	protected void do_btnGenerateFileKeyA_actionPerformed(ActionEvent e) {
		String savekey = textDirectorySaveKeyA.getText();
		try {
			if (!savekey.isEmpty()) {
				String dataComboBoxSizeKeyA = comboBoxSizeFileKeyA.getSelectedItem().toString();
				int n = Integer.parseInt(dataComboBoxSizeKeyA);
				rsa.GenerateKey(savekey, n);
				JOptionPane.showMessageDialog(this, "Generate successfully");
			} else {
				JOptionPane.showMessageDialog(this, "Directory not found");
			}
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(this, "Directory path not valid");
		}
	}

	// Hash---------------------------------------------------------------------------------------------------------------
	// TextHash------------------------------------------------------------------------------------------------------------
	protected void do_btnGenerateTextHash_actionPerformed(ActionEvent e) {
		String input = textAreaTextHashInput.getText();
		String dataComboBoxAlgorithmTextHash = comboBoxAlgorythmTextHash.getSelectedItem().toString();
		try {
			if (dataComboBoxAlgorithmTextHash.endsWith("MD5")) {
				textAreaTextHashOutput.setText(md5.getMD5Text(input));
			}
			if (dataComboBoxAlgorithmTextHash.endsWith("SHA")) {
				textAreaTextHashOutput.setText(sha.getSHAHashText(input));
			}
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(this, "Algorithm not valid");
		}

	}

	// FileHash----------------------------------------------------------------------------------------------------------------
	private void do_btnBrowseHashFile_actionPerformed(ActionEvent e) {
		textFiledHashInput.setText(FileChooser());

	}

	protected void do_btnGenerateFileHash_actionPerformed(ActionEvent e) {
		String input = textFiledHashInput.getText();
		File file = new File(input);
		String dataComboBoxAlgorithmFileHash = comboBoxAlgorythmFileHash.getSelectedItem().toString();
		try {
			if (dataComboBoxAlgorithmFileHash.endsWith("MD5")) {
				textAreaFileHashOutput.setText(md5.getMD5File(file));
			}
			if (dataComboBoxAlgorithmFileHash.endsWith("SHA")) {
				textAreaFileHashOutput.setText(sha.getSHAHashFile(file));
			}
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(this, "Algorithm not valid");
		}
	}
}
