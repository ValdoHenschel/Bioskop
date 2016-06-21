package bioskop;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Toolkit;

public class ListStudioAdmin extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListStudioAdmin frame = new ListStudioAdmin();
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
	 * @throws ParseException
	 * @throws SQLException
	 */
	public ListStudioAdmin() throws ParseException, SQLException {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\valdo\\Pictures\\bioskop.jpg"));
		Database db = new Database();
		setTitle("BIOSKOP PA 2");

		DateFormat jam = new SimpleDateFormat("HH:mm");
		Date date = new Date();
		SimpleDateFormat parser = new SimpleDateFormat("HH:mm");
		Date j12 = parser.parse("12:00");
		Date j15 = parser.parse("15:00");
		Date j18 = parser.parse("18:00");
		Date j20 = parser.parse("20:00");
		Date j24 = parser.parse("24:00");

		Date userDate = parser.parse(jam.format(date));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 687, 414);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton button_1 = new JButton("JUDUL FILM");
		String id_studio = "S001";
		String nama = db.judul(id_studio);
		button_1.setText(nama);
		button_1.setHorizontalAlignment(SwingConstants.LEFT);
		button_1.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 22));
		button_1.setBounds(26, 105, 240, 52);
		contentPane.add(button_1);

		JButton button_2 = new JButton("JUDUL FILM");
		String id_studio2 = "S002";
		String nama2 = db.judul(id_studio2);
		button_2.setText(nama2);
		button_2.setHorizontalAlignment(SwingConstants.LEFT);
		button_2.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 22));
		button_2.setBounds(26, 171, 240, 52);
		contentPane.add(button_2);

		JButton button_3 = new JButton("JUDUL FILM");
		String id_studio3 = "S003";
		String nama3 = db.judul(id_studio3);
		button_3.setText(nama3);
		button_3.setHorizontalAlignment(SwingConstants.LEFT);
		button_3.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 22));
		button_3.setBounds(26, 234, 240, 52);
		contentPane.add(button_3);

		JButton button_4 = new JButton("JUDUL FILM");
		String id_studio4 = "S004";
		String nama4 = db.judul(id_studio4);
		button_4.setText(nama4);
		button_4.setHorizontalAlignment(SwingConstants.LEFT);
		button_4.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 22));
		button_4.setBounds(26, 297, 240, 52);
		contentPane.add(button_4);

		JLabel label1 = new JLabel("12.00");
		if (userDate.after(j12) && userDate.before(j24)) {
			label1.setForeground(Color.red);
		}
		label1.setFont(new Font("Tahoma", Font.BOLD, 24));
		label1.setBackground(new Color(51, 204, 255));
		label1.setBounds(308, 116, 68, 36);
		contentPane.add(label1);

		JLabel label2 = new JLabel("15.00");
		if (userDate.after(j15) && userDate.before(j24)) {
			label2.setForeground(Color.red);
		}
		label2.setFont(new Font("Tahoma", Font.BOLD, 24));
		label2.setBackground(new Color(51, 204, 255));
		label2.setBounds(386, 116, 68, 36);
		contentPane.add(label2);

		JLabel label = new JLabel("18.00");
		if (userDate.after(j18) && userDate.before(j24)) {
			label.setForeground(Color.red);
		}
		label.setFont(new Font("Tahoma", Font.BOLD, 24));
		label.setBackground(new Color(51, 204, 255));
		label.setBounds(464, 116, 68, 36);
		contentPane.add(label);

		JLabel label_1 = new JLabel("20.00");
		if (userDate.after(j20) && userDate.before(j24)) {
			label_1.setForeground(Color.red);
		}
		label_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		label_1.setBackground(new Color(51, 204, 255));
		label_1.setBounds(542, 116, 68, 36);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("12.00");
		if (userDate.after(j12) && userDate.before(j24)) {
			label_2.setForeground(Color.red);
		}
		label_2.setFont(new Font("Tahoma", Font.BOLD, 24));
		label_2.setBackground(new Color(51, 204, 255));
		label_2.setBounds(308, 182, 68, 36);
		contentPane.add(label_2);

		JLabel label_3 = new JLabel("15.00");
		if (userDate.after(j15) && userDate.before(j24)) {
			label_3.setForeground(Color.red);
		}
		label_3.setFont(new Font("Tahoma", Font.BOLD, 24));
		label_3.setBackground(new Color(51, 204, 255));
		label_3.setBounds(386, 182, 68, 36);
		contentPane.add(label_3);

		JLabel label_4 = new JLabel("18.00");
		if (userDate.after(j18) && userDate.before(j24)) {
			label_4.setForeground(Color.red);
		}
		label_4.setFont(new Font("Tahoma", Font.BOLD, 24));
		label_4.setBackground(new Color(51, 204, 255));
		label_4.setBounds(464, 182, 68, 36);
		contentPane.add(label_4);

		JLabel label_5 = new JLabel("20.00");
		if (userDate.after(j20) && userDate.before(j24)) {
			label_5.setForeground(Color.red);
		}
		label_5.setFont(new Font("Tahoma", Font.BOLD, 24));
		label_5.setBackground(new Color(51, 204, 255));
		label_5.setBounds(542, 182, 68, 36);
		contentPane.add(label_5);

		JLabel label_6 = new JLabel("12.00");
		if (userDate.after(j12) && userDate.before(j24)) {
			label_6.setForeground(Color.red);
		}
		label_6.setFont(new Font("Tahoma", Font.BOLD, 24));
		label_6.setBackground(new Color(51, 204, 255));
		label_6.setBounds(308, 244, 68, 36);
		contentPane.add(label_6);

		JLabel label_7 = new JLabel("15.00");
		if (userDate.after(j15) && userDate.before(j24)) {
			label_7.setForeground(Color.red);
		}
		label_7.setFont(new Font("Tahoma", Font.BOLD, 24));
		label_7.setBackground(new Color(51, 204, 255));
		label_7.setBounds(386, 244, 68, 36);
		contentPane.add(label_7);

		JLabel label_8 = new JLabel("18.00");
		if (userDate.after(j18) && userDate.before(j24)) {
			label_8.setForeground(Color.red);
		}
		label_8.setFont(new Font("Tahoma", Font.BOLD, 24));
		label_8.setBackground(new Color(51, 204, 255));
		label_8.setBounds(464, 244, 68, 36);
		contentPane.add(label_8);

		JLabel label_9 = new JLabel("20.00");
		if (userDate.after(j20) && userDate.before(j24)) {
			label_9.setForeground(Color.red);
		}
		label_9.setFont(new Font("Tahoma", Font.BOLD, 24));
		label_9.setBackground(new Color(51, 204, 255));
		label_9.setBounds(542, 244, 68, 36);
		contentPane.add(label_9);

		JLabel label_10 = new JLabel("12.00");
		if (userDate.after(j12) && userDate.before(j24)) {
			label_10.setForeground(Color.red);
		}
		label_10.setFont(new Font("Tahoma", Font.BOLD, 24));
		label_10.setBackground(new Color(51, 204, 255));
		label_10.setBounds(308, 302, 68, 36);
		contentPane.add(label_10);

		JLabel label_11 = new JLabel("15.00");
		if (userDate.after(j15) && userDate.before(j24)) {
			label_11.setForeground(Color.red);
		}
		label_11.setFont(new Font("Tahoma", Font.BOLD, 24));
		label_11.setBackground(new Color(51, 204, 255));
		label_11.setBounds(386, 302, 68, 36);
		contentPane.add(label_11);

		JLabel label_12 = new JLabel("18.00");
		if (userDate.after(j18) && userDate.before(j24)) {
			label_12.setForeground(Color.red);
		}
		label_12.setFont(new Font("Tahoma", Font.BOLD, 24));
		label_12.setBackground(new Color(51, 204, 255));
		label_12.setBounds(464, 302, 68, 36);
		contentPane.add(label_12);

		JLabel label_13 = new JLabel("20.00");
		if (userDate.after(j20) && userDate.before(j24)) {
			label_13.setForeground(Color.red);
		}
		label_13.setFont(new Font("Tahoma", Font.BOLD, 24));
		label_13.setBackground(new Color(51, 204, 255));
		label_13.setBounds(542, 302, 68, 36);
		contentPane.add(label_13);

		JLabel lblBioskopPa = new JLabel("BIOSKOP PA2");
		lblBioskopPa.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 30));
		lblBioskopPa.setBounds(26, 22, 207, 63);
		contentPane.add(lblBioskopPa);

		DateFormat dateFormat = new SimpleDateFormat("EEEE, yyyy-MM-dd HH:mm");
		JLabel lblNewLabel = new JLabel("TANGGAL");
		lblNewLabel.setText(dateFormat.format(date));
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 19));
		lblNewLabel.setBounds(308, 24, 224, 63);
		contentPane.add(lblNewLabel);

		JButton btnLogout = new JButton("KEMBALI");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnLogout.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 17));
		btnLogout.setBounds(574, 11, 87, 63);
		contentPane.add(btnLogout);
	}

}
