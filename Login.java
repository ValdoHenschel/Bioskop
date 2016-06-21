package bioskop;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.*;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.JPasswordField;
import javax.swing.border.BevelBorder;
import java.awt.Toolkit;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textUser;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\valdo\\Pictures\\bioskop.jpg"));
		Database db = new Database();

		setTitle("LOGIN");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 354, 275);
		contentPane = new JPanel();
		contentPane.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 29));
		lblLogin.setBounds(43, 41, 233, 47);
		contentPane.add(lblLogin);

		JLabel lblUser = new JLabel("User");
		lblUser.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 19));
		lblUser.setBounds(43, 112, 46, 14);
		contentPane.add(lblUser);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 19));
		lblPassword.setBounds(43, 137, 63, 25);
		contentPane.add(lblPassword);

		textUser = new JTextField();
		textUser.setBounds(134, 109, 185, 25);
		contentPane.add(textUser);
		textUser.setColumns(10);

		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String user = textUser.getText();
				String pass = passwordField.getText();
				String a = user.substring(0, 1);

				if (user.length() == 0 || pass.length() == 0) {
					JOptionPane.showInternalMessageDialog(contentPane, "Username / Password Anda Masih Kosong",
							"EMPTY INPUT ?", JOptionPane.WARNING_MESSAGE);
				} else if (db.validasi(user, pass)) {

					try {
						if (a.equals("u")) {
							dispose();
							new StudioList().setVisible(true);
						} else if (a.equals("a")) {
							dispose();
							new AdminSetting().setVisible(true);
						}

					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(contentPane, "Username / Password Anda masih Salah");
				}
			}
		});
		textUser.addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent e) {

				String user = textUser.getText();
				String pass = passwordField.getText();

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					if (user.length() == 0 || pass.length() == 0) {
						JOptionPane.showInternalMessageDialog(contentPane, "Username / Password Anda Masih Kosong",
								"EMPTY INPUT ?", JOptionPane.WARNING_MESSAGE);
					} else if (db.validasi(user, pass)) {
						try {
							String a = user.substring(0, 1);
							if (a.equals("u")) {
								dispose();
								new StudioList().setVisible(true);
							} else if (a.equals("a")) {
								dispose();
								new AdminSetting().setVisible(true);
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} else {
						JOptionPane.showMessageDialog(contentPane, "Username / Password Anda masih Salah");
					}
				}
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
		btnLogin.addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent e) {

				String user = textUser.getText();
				String pass = passwordField.getText();

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					if (user.length() == 0 || pass.length() == 0) {
						JOptionPane.showInternalMessageDialog(contentPane, "Username / Password Anda Masih Kosong",
								"EMPTY INPUT ?", JOptionPane.WARNING_MESSAGE);
					} else if (db.validasi(user, pass)) {
						try {
							String a = user.substring(0, 1);
							if (a.equals("u")) {
								dispose();
								new StudioList().setVisible(true);
							} else if (a.equals("a")) {
								dispose();
								new AdminSetting().setVisible(true);
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} else {
						JOptionPane.showMessageDialog(contentPane, "Username / Password Anda masih Salah");
					}
				}
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		btnLogin.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		btnLogin.setBounds(230, 175, 89, 31);
		contentPane.add(btnLogin);

		passwordField = new JPasswordField();
		passwordField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = textUser.getText();
				String pass = passwordField.getText();
				String a = user.substring(0, 1);
				if (user.length() == 0 || pass.length() == 0) {

					JOptionPane.showInternalMessageDialog(contentPane, "Username / Password Anda Masih Kosong",
							"EMPTY INPUT ?", JOptionPane.WARNING_MESSAGE);
				} else if (db.validasi(user, pass)) {
					try {
						if (a.equals("u")) {
							dispose();
							new StudioList().setVisible(true);
						} else if (a.equals("a")) {
							dispose();
							new AdminSetting().setVisible(true);
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(contentPane, "Username / Password Anda masih Salah");
				}

			}

		});
		passwordField.setBounds(134, 139, 185, 25);
		contentPane.add(passwordField);
	}
}
