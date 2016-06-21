package bioskop;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Panel;
import java.awt.Color;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.Toolkit;

public class studio2 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					studio2 frame = new studio2("S002");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws SQLException
	 */
	public studio2(String id_studio) throws SQLException {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\valdo\\Pictures\\bioskop.jpg"));
		Database db = new Database();
		String temp = "";

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 702, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Panel panel = new Panel();
		panel.setBackground(new Color(0, 255, 0));
		panel.setBounds(10, 10, 666, 58);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JLabel lblLayar = new JLabel("LAYAR");
		lblLayar.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 28));
		lblLayar.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblLayar, BorderLayout.CENTER);

		Button button1 = new Button("A4");
		temp = db.status(button1.getLabel(), id_studio);
		if (temp.equals("N")) {
			button1.setBackground(Color.RED);
		} else {
			button1.setBackground(new Color(135, 206, 250));

		}

		button1.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		button1.setBounds(112, 123, 41, 46);
		contentPane.add(button1);

		Button button = new Button("A3");
		temp = db.status(button.getLabel(), id_studio);
		if (temp.equals("N")) {
			button.setBackground(Color.RED);
		} else {
			button.setBackground(new Color(135, 206, 250));

		}

		button.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		button.setBounds(159, 123, 41, 46);
		contentPane.add(button);

		Button button_1 = new Button("A2");
		temp = db.status(button_1.getLabel(), id_studio);
		if (temp.equals("N")) {
			button_1.setBackground(Color.RED);
		} else {
			button_1.setBackground(new Color(135, 206, 250));
		}

		button_1.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		button_1.setBounds(206, 123, 41, 46);
		contentPane.add(button_1);

		Button button_2 = new Button("A1");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					db.beliKursi(button_2.getLabel(), id_studio);
					// System.out.println(button_2.getLabel());
					dispose();
					new studio2(id_studio).setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		temp = db.status(button_2.getLabel(), id_studio);
		if (temp.equals("N")) {
			button_2.setBackground(Color.RED);
		} else {
			button_2.setBackground(new Color(135, 206, 250));

		}

		button_2.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		button_2.setBounds(253, 123, 41, 46);
		contentPane.add(button_2);

		Button button_3 = new Button("B4");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					db.beliKursi(button_3.getLabel(), id_studio);
					// System.out.println(button_2.getLabel());
					dispose();
					new studio2(id_studio).setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		temp = db.status(button_3.getLabel(), id_studio);
		if (temp.equals("N")) {
			button_3.setBackground(Color.RED);
		} else {
			button_3.setBackground(new Color(135, 206, 250));

		}

		button_3.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		button_3.setBounds(112, 175, 41, 46);
		contentPane.add(button_3);

		Button button_4 = new Button("B3");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					db.beliKursi(button_4.getLabel(), id_studio);
					// System.out.println(button_2.getLabel());
					dispose();
					new studio2(id_studio).setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		temp = db.status(button_4.getLabel(), id_studio);
		if (temp.equals("N")) {
			button_4.setBackground(Color.RED);
		} else {
			button_4.setBackground(new Color(135, 206, 250));
		}

		button_4.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		button_4.setBounds(159, 175, 41, 46);
		contentPane.add(button_4);

		Button button_5 = new Button("B2");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					db.beliKursi(button_5.getLabel(), id_studio);
					// System.out.println(button_2.getLabel());
					dispose();
					new studio2(id_studio).setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		temp = db.status(button_5.getLabel(), id_studio);
		if (temp.equals("N")) {
			button_5.setBackground(Color.RED);
		} else {
			button_5.setBackground(new Color(135, 206, 250));

		}

		button_5.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		button_5.setBounds(206, 175, 41, 46);
		contentPane.add(button_5);

		Button button_6 = new Button("B1");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					db.beliKursi(button_6.getLabel(), id_studio);
					new PrintTransaksi(button_6.getLabel(), id_studio);
					dispose();
					new studio2(id_studio).setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		temp = db.status(button_6.getLabel(), id_studio);
		if (temp.equals("N")) {
			button_6.setBackground(Color.RED);
		} else {
			button_6.setBackground(new Color(135, 206, 250));

		}
		// button_6.addActionListener(listener_6);
		button_6.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		button_6.setBounds(253, 175, 41, 46);
		contentPane.add(button_6);

		Button button_7 = new Button("C4");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					db.beliKursi(button_2.getLabel(), id_studio);
					// System.out.println(button_2.getLabel());
					dispose();
					new studio2(id_studio).setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		temp = db.status(button_7.getLabel(), id_studio);
		if (temp.equals("N")) {
			button_7.setBackground(Color.RED);
		} else {
			button_7.setBackground(new Color(135, 206, 250));

		}

		button_7.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		button_7.setBounds(112, 227, 41, 46);
		contentPane.add(button_7);

		Button button_8 = new Button("C3");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					db.beliKursi(button_8.getLabel(), id_studio);
					dispose();
					new studio2(id_studio).setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		temp = db.status(button_8.getLabel(), id_studio);
		if (temp.equals("N")) {
			button_8.setBackground(Color.RED);
		} else {
			button_8.setBackground(new Color(135, 206, 250));

		}

		button_8.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		button_8.setBounds(159, 227, 41, 46);
		contentPane.add(button_8);

		Button button_9 = new Button("C2");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					db.beliKursi(button_9.getLabel(), id_studio);
					dispose();
					new studio2(id_studio).setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		temp = db.status(button_9.getLabel(), id_studio);
		if (temp.equals("N")) {
			button_9.setBackground(Color.RED);
		} else {
			button_9.setBackground(new Color(135, 206, 250));

		}

		button_9.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		button_9.setBounds(206, 227, 41, 46);
		contentPane.add(button_9);

		Button button_10 = new Button("C1");
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					db.beliKursi(button_10.getLabel(), id_studio);
					dispose();
					new studio2(id_studio).setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		temp = db.status(button_10.getLabel(), id_studio);
		if (temp.equals("N")) {
			button_10.setBackground(Color.RED);
		} else {
			button_10.setBackground(new Color(135, 206, 250));

		}

		button_10.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		button_10.setBounds(253, 227, 41, 46);
		contentPane.add(button_10);

		Button button_11 = new Button("D4");
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					db.beliKursi(button_11.getLabel(), id_studio);
					dispose();
					new studio2(id_studio).setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		temp = db.status(button_11.getLabel(), id_studio);
		if (temp.equals("N")) {
			button_11.setBackground(Color.RED);
		} else {
			button_11.setBackground(new Color(135, 206, 250));

		}
		button_11.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		button_11.setBounds(112, 279, 41, 46);
		contentPane.add(button_11);

		Button button_12 = new Button("D3");
		button_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					db.beliKursi(button_12.getLabel(), id_studio);
					dispose();
					new studio2(id_studio).setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		temp = db.status(button_12.getLabel(), id_studio);
		if (temp.equals("N")) {
			button_12.setBackground(Color.RED);
		} else {
			button_12.setBackground(new Color(135, 206, 250));

		}

		button_12.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		button_12.setBounds(159, 279, 41, 46);
		contentPane.add(button_12);

		Button button_13 = new Button("D2");
		button_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					db.beliKursi(button_13.getLabel(), id_studio);
					dispose();
					new studio2(id_studio).setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		temp = db.status(button_13.getLabel(), id_studio);
		if (temp.equals("N")) {
			button_13.setBackground(Color.RED);
		} else {
			button_13.setBackground(new Color(135, 206, 250));

		}

		button_13.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		button_13.setBounds(206, 279, 41, 46);
		contentPane.add(button_13);

		Button button_14 = new Button("D1");
		button_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					db.beliKursi(button_14.getLabel(), id_studio);
					dispose();
					new studio2(id_studio).setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		temp = db.status(button_14.getLabel(), id_studio);
		if (temp.equals("N")) {
			button_14.setBackground(Color.RED);
		} else {
			button_14.setBackground(new Color(135, 206, 250));

		}

		button_14.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		button_14.setBounds(253, 279, 41, 46);
		contentPane.add(button_14);

		Button button_15 = new Button("E4");
		button_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					db.beliKursi(button_15.getLabel(), id_studio);
					dispose();
					new studio2(id_studio).setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		temp = db.status(button_15.getLabel(), id_studio);
		if (temp.equals("N")) {
			button_15.setBackground(Color.RED);
		} else {
			button_15.setBackground(new Color(135, 206, 250));

		}
		button_15.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		button_15.setBounds(112, 331, 41, 46);
		contentPane.add(button_15);

		Button button_16 = new Button("E3");
		button_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					db.beliKursi(button_16.getLabel(), id_studio);
					dispose();
					new studio2(id_studio).setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		temp = db.status(button_16.getLabel(), id_studio);
		if (temp.equals("N")) {
			button_16.setBackground(Color.RED);
		} else {
			button_16.setBackground(new Color(135, 206, 250));

		}
		button_16.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		button_16.setBounds(159, 331, 41, 46);
		contentPane.add(button_16);

		Button button_17 = new Button("E2");
		button_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					db.beliKursi(button_17.getLabel(), id_studio);
					dispose();
					new studio2(id_studio).setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		temp = db.status(button_17.getLabel(), id_studio);
		if (temp.equals("N")) {
			button_17.setBackground(Color.RED);
		} else {
			button_17.setBackground(new Color(135, 206, 250));

		}
		button_17.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		button_17.setBounds(206, 331, 41, 46);
		contentPane.add(button_17);

		Button button_18 = new Button("E1");
		button_18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					db.beliKursi(button_18.getLabel(), id_studio);
					dispose();
					new studio2(id_studio).setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		temp = db.status(button_18.getLabel(), id_studio);
		if (temp.equals("N")) {
			button_18.setBackground(Color.RED);
		} else {
			button_18.setBackground(new Color(135, 206, 250));

		}
		button_18.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		button_18.setBounds(253, 331, 41, 46);
		contentPane.add(button_18);

		Button button_19 = new Button("A5");
		button_19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					db.beliKursi(button_19.getLabel(), id_studio);
					dispose();
					new studio2(id_studio).setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		temp = db.status(button_19.getLabel(), id_studio);
		if (temp.equals("N")) {
			button_19.setBackground(Color.RED);
		} else {
			button_19.setBackground(new Color(135, 206, 250));

		}
		button_19.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		button_19.setBounds(373, 123, 41, 46);
		contentPane.add(button_19);

		Button button_20 = new Button("A6");
		button_20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					db.beliKursi(button_20.getLabel(), id_studio);
					dispose();
					new studio2(id_studio).setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		temp = db.status(button_20.getLabel(), id_studio);
		if (temp.equals("N")) {
			button_20.setBackground(Color.RED);
		} else {
			button_20.setBackground(new Color(135, 206, 250));

		}
		button_20.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		button_20.setBounds(420, 123, 41, 46);
		contentPane.add(button_20);

		Button button_21 = new Button("A7");
		button_21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					db.beliKursi(button_21.getLabel(), id_studio);
					dispose();
					new studio2(id_studio).setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		temp = db.status(button_21.getLabel(), id_studio);
		if (temp.equals("N")) {
			button_21.setBackground(Color.RED);
		} else {
			button_21.setBackground(new Color(135, 206, 250));

		}
		button_21.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		button_21.setBounds(467, 123, 41, 46);
		contentPane.add(button_21);

		Button button_22 = new Button("A8");
		button_22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					db.beliKursi(button_22.getLabel(), id_studio);
					dispose();
					new studio2(id_studio).setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		temp = db.status(button_22.getLabel(), id_studio);
		if (temp.equals("N")) {
			button_22.setBackground(Color.RED);
		} else {
			button_22.setBackground(new Color(135, 206, 250));

		}
		button_22.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		button_22.setBounds(514, 123, 41, 46);
		contentPane.add(button_22);

		Button button_23 = new Button("A9");
		button_23.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					db.beliKursi(button_23.getLabel(), id_studio);
					dispose();
					new studio2(id_studio).setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		temp = db.status(button_23.getLabel(), id_studio);
		if (temp.equals("N")) {
			button_23.setBackground(Color.RED);
		} else {
			button_23.setBackground(new Color(135, 206, 250));

		}
		button_23.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		button_23.setBounds(561, 123, 41, 46);
		contentPane.add(button_23);

		Button button_24 = new Button("B5");
		button_24.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					db.beliKursi(button_24.getLabel(), id_studio);
					dispose();
					new studio2(id_studio).setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		temp = db.status(button_24.getLabel(), id_studio);
		if (temp.equals("N")) {
			button_24.setBackground(Color.RED);
		} else {
			button_24.setBackground(new Color(135, 206, 250));

		}
		button_24.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		button_24.setBounds(373, 175, 41, 46);
		contentPane.add(button_24);

		Button button_25 = new Button("B6");
		button_25.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					db.beliKursi(button_25.getLabel(), id_studio);
					dispose();
					new studio2(id_studio).setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		temp = db.status(button_25.getLabel(), id_studio);
		if (temp.equals("N")) {
			button_25.setBackground(Color.RED);
		} else {
			button_25.setBackground(new Color(135, 206, 250));

		}
		button_25.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		button_25.setBounds(420, 175, 41, 46);
		contentPane.add(button_25);

		Button button_26 = new Button("B7");
		button_26.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					db.beliKursi(button_26.getLabel(), id_studio);
					dispose();
					new studio2(id_studio).setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		temp = db.status(button_26.getLabel(), id_studio);
		if (temp.equals("N")) {
			button_26.setBackground(Color.RED);
		} else {
			button_26.setBackground(new Color(135, 206, 250));

		}
		button_26.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		button_26.setBounds(467, 175, 41, 46);
		contentPane.add(button_26);

		Button button_27 = new Button("B8");
		button_27.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					db.beliKursi(button_27.getLabel(), id_studio);
					dispose();
					new studio2(id_studio).setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		temp = db.status(button_27.getLabel(), id_studio);
		if (temp.equals("N")) {
			button_27.setBackground(Color.RED);
		} else {
			button_27.setBackground(new Color(135, 206, 250));

		}
		button_27.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		button_27.setBounds(514, 175, 41, 46);
		contentPane.add(button_27);

		Button button_28 = new Button("B9");
		button_28.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					db.beliKursi(button_28.getLabel(), id_studio);
					dispose();
					new studio2(id_studio).setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		temp = db.status(button_28.getLabel(), id_studio);
		if (temp.equals("N")) {
			button_28.setBackground(Color.RED);
		} else {
			button_28.setBackground(new Color(135, 206, 250));

		}
		button_28.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		button_28.setBounds(561, 175, 41, 46);
		contentPane.add(button_28);

		Button button_29 = new Button("C5");
		button_29.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					db.beliKursi(button_29.getLabel(), id_studio);
					dispose();
					new studio2(id_studio).setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		temp = db.status(button_29.getLabel(), id_studio);
		if (temp.equals("N")) {
			button_29.setBackground(Color.RED);
		} else {
			button_29.setBackground(new Color(135, 206, 250));

		}
		button_29.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		button_29.setBounds(373, 227, 41, 46);
		contentPane.add(button_29);

		Button button_30 = new Button("C6");
		button_30.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					db.beliKursi(button_30.getLabel(), id_studio);
					dispose();
					new studio2(id_studio).setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		temp = db.status(button_30.getLabel(), id_studio);
		if (temp.equals("N")) {
			button_30.setBackground(Color.RED);
		} else {
			button_30.setBackground(new Color(135, 206, 250));

		}
		button_30.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		button_30.setBounds(420, 227, 41, 46);
		contentPane.add(button_30);

		Button button_31 = new Button("C7");
		button_31.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					db.beliKursi(button_31.getLabel(), id_studio);
					dispose();
					new studio2(id_studio).setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		temp = db.status(button_31.getLabel(), id_studio);
		if (temp.equals("N")) {
			button_31.setBackground(Color.RED);
		} else {
			button_31.setBackground(new Color(135, 206, 250));

		}
		button_31.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		button_31.setBounds(467, 227, 41, 46);
		contentPane.add(button_31);

		Button button_32 = new Button("C8");
		button_32.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					db.beliKursi(button_32.getLabel(), id_studio);
					dispose();
					new studio2(id_studio).setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		temp = db.status(button_32.getLabel(), id_studio);
		if (temp.equals("N")) {
			button_32.setBackground(Color.RED);
		} else {
			button_32.setBackground(new Color(135, 206, 250));

		}
		button_32.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		button_32.setBounds(514, 227, 41, 46);
		contentPane.add(button_32);

		Button button_33 = new Button("C9");
		button_33.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					db.beliKursi(button_33.getLabel(), id_studio);
					dispose();
					new studio2(id_studio).setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		temp = db.status(button_33.getLabel(), id_studio);
		if (temp.equals("N")) {
			button_33.setBackground(Color.RED);
		} else {
			button_33.setBackground(new Color(135, 206, 250));

		}
		button_33.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		button_33.setBounds(561, 227, 41, 46);
		contentPane.add(button_33);

		Button button_34 = new Button("D5");
		button_34.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					db.beliKursi(button_34.getLabel(), id_studio);
					dispose();
					new studio2(id_studio).setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		temp = db.status(button_34.getLabel(), id_studio);
		if (temp.equals("N")) {
			button_34.setBackground(Color.RED);
		} else {
			button_34.setBackground(new Color(135, 206, 250));

		}
		button_34.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		button_34.setBounds(373, 279, 41, 46);
		contentPane.add(button_34);

		Button button_35 = new Button("D6");
		button_35.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					db.beliKursi(button_35.getLabel(), id_studio);
					dispose();
					new studio2(id_studio).setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		temp = db.status(button_35.getLabel(), id_studio);
		if (temp.equals("N")) {
			button_35.setBackground(Color.RED);
		} else {
			button_35.setBackground(new Color(135, 206, 250));

		}
		button_35.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		button_35.setBounds(420, 279, 41, 46);
		contentPane.add(button_35);

		Button button_36 = new Button("D7");
		button_36.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					db.beliKursi(button_36.getLabel(), id_studio);
					dispose();
					new studio2(id_studio).setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		temp = db.status(button_36.getLabel(), id_studio);
		if (temp.equals("N")) {
			button_36.setBackground(Color.RED);
		} else {
			button_36.setBackground(new Color(135, 206, 250));

		}
		button_36.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		button_36.setBounds(467, 279, 41, 46);
		contentPane.add(button_36);

		Button button_37 = new Button("D8");
		button_37.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					db.beliKursi(button_37.getLabel(), id_studio);
					dispose();
					new studio2(id_studio).setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		temp = db.status(button_37.getLabel(), id_studio);
		if (temp.equals("N")) {
			button_37.setBackground(Color.RED);
		} else {
			button_37.setBackground(new Color(135, 206, 250));

		}
		button_37.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		button_37.setBounds(514, 279, 41, 46);
		contentPane.add(button_37);

		Button button_38 = new Button("D9");
		button_38.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					db.beliKursi(button_38.getLabel(), id_studio);
					dispose();
					new studio2(id_studio).setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		temp = db.status(button_38.getLabel(), id_studio);
		if (temp.equals("N")) {
			button_38.setBackground(Color.RED);
		} else {
			button_38.setBackground(new Color(135, 206, 250));

		}
		button_38.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		button_38.setBounds(561, 279, 41, 46);
		contentPane.add(button_38);

		Button button_39 = new Button("E5");
		button_39.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					db.beliKursi(button_39.getLabel(), id_studio);
					dispose();
					new studio2(id_studio).setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		temp = db.status(button_39.getLabel(), id_studio);
		if (temp.equals("N")) {
			button_39.setBackground(Color.RED);
		} else {
			button_39.setBackground(new Color(135, 206, 250));

		}
		button_39.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		button_39.setBounds(373, 333, 41, 46);
		contentPane.add(button_39);

		Button button_40 = new Button("E6");
		button_40.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					db.beliKursi(button_40.getLabel(), id_studio);
					dispose();
					new studio2(id_studio).setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		temp = db.status(button_40.getLabel(), id_studio);
		if (temp.equals("N")) {
			button_40.setBackground(Color.RED);
		} else {
			button_40.setBackground(new Color(135, 206, 250));

		}
		button_40.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		button_40.setBounds(420, 333, 41, 46);
		contentPane.add(button_40);

		Button button_41 = new Button("E7");
		button_41.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					db.beliKursi(button_41.getLabel(), id_studio);
					dispose();
					new studio2(id_studio).setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		temp = db.status(button_41.getLabel(), id_studio);
		if (temp.equals("N")) {
			button_41.setBackground(Color.RED);
		} else {
			button_41.setBackground(new Color(135, 206, 250));

		}
		button_41.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		button_41.setBounds(467, 333, 41, 46);
		contentPane.add(button_41);

		Button button_42 = new Button("E8");
		button_42.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					db.beliKursi(button_42.getLabel(), id_studio);
					dispose();
					new studio2(id_studio).setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		temp = db.status(button_42.getLabel(), id_studio);
		if (temp.equals("N")) {
			button_42.setBackground(Color.RED);
		} else {
			button_42.setBackground(new Color(135, 206, 250));

		}
		button_42.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		button_42.setBounds(514, 333, 41, 46);
		contentPane.add(button_42);

		Button button_43 = new Button("E9");
		button_43.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					db.beliKursi(button_43.getLabel(), id_studio);
					dispose();
					new studio2(id_studio).setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		temp = db.status(button_43.getLabel(), id_studio);
		if (temp.equals("N")) {
			button_43.setBackground(Color.RED);
		} else {
			button_43.setBackground(new Color(135, 206, 250));

		}
		button_43.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		button_43.setBounds(561, 333, 41, 46);
		contentPane.add(button_43);

		JButton btnKembali = new JButton("KEMBALI");
		btnKembali.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnKembali.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 19));
		btnKembali.setBounds(10, 397, 113, 53);
		contentPane.add(btnKembali);

		JButton btnClear = new JButton("CLEAR");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					db.clearKursi(id_studio);
					dispose();
					new studio2(id_studio).setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnClear.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 19));
		btnClear.setBounds(514, 397, 88, 53);
		contentPane.add(btnClear);
	}

}
