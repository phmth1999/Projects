package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.GenKey;
import model.GenSign;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class Sign extends JFrame {
	GenKey genKey = new GenKey();
	GenSign genSign = new GenSign();

	private JPanel contentPane;
	private JTextField textSaveKey;
	private JTextField textFileKey;
	private JTextField textFileInput;
	private JComboBox comboBoxKey;
	private JTextArea textAreaOutputSign;
	
	public Sign() {
		setTitle("Sign");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);

		JPanel Sign = new JPanel();
		tabbedPane.addTab("Sign", null, Sign, null);
		Sign.setLayout(null);

		JLabel label_2 = new JLabel("File key:");
		label_2.setBounds(10, 14, 47, 14);
		Sign.add(label_2);

		textFileKey = new JTextField();
		textFileKey.setColumns(10);
		textFileKey.setBounds(75, 11, 220, 23);
		Sign.add(textFileKey);

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
		btnFileKey.setBounds(305, 11, 99, 23);
		Sign.add(btnFileKey);

		JLabel label_3 = new JLabel("File input:");
		label_3.setBounds(10, 48, 55, 14);
		Sign.add(label_3);

		textFileInput = new JTextField();
		textFileInput.setColumns(10);
		textFileInput.setBounds(75, 45, 220, 23);
		Sign.add(textFileInput);

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
		btnFileInput.setBounds(305, 45, 99, 23);
		Sign.add(btnFileInput);

		JButton btnSign = new JButton("Sign");
		btnSign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					do_btnSign_actionPerformed(e);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}

		});
		btnSign.setBounds(75, 79, 82, 23);
		Sign.add(btnSign);
		
		JLabel label_4 = new JLabel("Output:");
		label_4.setBounds(10, 118, 48, 14);
		Sign.add(label_4);
		
		textAreaOutputSign = new JTextArea();
		textAreaOutputSign.setWrapStyleWord(true);
		textAreaOutputSign.setLineWrap(true);
		textAreaOutputSign.setBounds(75, 118, 329, 73);
		Sign.add(textAreaOutputSign);

		JPanel GenKey = new JPanel();
		tabbedPane.addTab("GenKey", null, GenKey, null);
		GenKey.setLayout(null);

		JLabel label = new JLabel("Size key:");
		label.setBounds(10, 29, 59, 14);
		GenKey.add(label);

		comboBoxKey = new JComboBox();
		comboBoxKey.setModel(new DefaultComboBoxModel(new String[] { "1024", "2048" }));
		comboBoxKey.setBounds(123, 26, 59, 23);
		GenKey.add(comboBoxKey);

		JLabel label_1 = new JLabel("Directory save key:");
		label_1.setBounds(10, 63, 117, 14);
		GenKey.add(label_1);

		textSaveKey = new JTextField();
		textSaveKey.setColumns(10);
		textSaveKey.setBounds(123, 60, 179, 23);
		GenKey.add(textSaveKey);

		JButton btnBrowseKey = new JButton("Browse");
		btnBrowseKey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					do_btnBrowseSaveKey_actionPerformed(e);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}

		});
		btnBrowseKey.setBounds(312, 60, 81, 23);
		GenKey.add(btnBrowseKey);

		JButton btnGenKey = new JButton("Generate File Key");
		btnGenKey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					do_btnBrowseGenKey_actionPerformed(e);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}

		});
		btnGenKey.setBounds(123, 94, 145, 23);
		GenKey.add(btnGenKey);
	}

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

	private void do_btnBrowseSaveKey_actionPerformed(ActionEvent e) {
		textSaveKey.setText(FileChooser());
	}

	private void do_btnBrowseFileKey_actionPerformed(ActionEvent e) {
		textFileKey.setText(FileChooser());
	}

	private void do_btnBrowseFileInput_actionPerformed(ActionEvent e) {
		textFileInput.setText(FileChooser());
	}

	private void do_btnBrowseGenKey_actionPerformed(ActionEvent e) {
		String savekey = textSaveKey.getText();
		try {
			if (!savekey.isEmpty()) {
				String dataComboBoxSizeKey = comboBoxKey.getSelectedItem().toString();
				int n = Integer.parseInt(dataComboBoxSizeKey);
				genKey.GenerateKey(savekey, n);
				JOptionPane.showMessageDialog(this, "Generate successfully");
			} else {
				JOptionPane.showMessageDialog(this, "Directory not found");
			}
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(this, "Directory path not valid");
		}
	}

	private void do_btnSign_actionPerformed(ActionEvent e) {
		String key = textFileKey.getText();
		String input = textFileInput.getText();
		try {
			textAreaOutputSign.setText(genSign.Sign(input, key));
			JOptionPane.showMessageDialog(this, "Sign successfully");

		} catch (Exception e1) {
			JOptionPane.showMessageDialog(this, "ERRO");
		}
	}
}
