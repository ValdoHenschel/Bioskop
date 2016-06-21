package bioskop;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.TextField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.TextArea;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Statement;

import javax.swing.border.BevelBorder;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class UserSetting extends JFrame {
	private DefaultTableModel model;
	private JPanel contentPane;
	private JPasswordField password;
	private JTable table;
	private Connection koneksi = null;
	private Statement stmt = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/bioskopdb";
	static final String user = "root";
	static final String pass = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserSetting frame = new UserSetting();
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
	public UserSetting() throws SQLException {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\valdo\\Pictures\\bioskop.jpg"));
		Database db = new Database();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 893, 423);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), "MANAGE USER",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setLayout(null);
		panel.setBounds(10, 63, 413, 317);
		contentPane.add(panel);

		JLabel lblIdUser = new JLabel("ID User");
		lblIdUser.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 23));
		lblIdUser.setBounds(10, 11, 98, 46);
		panel.add(lblIdUser);

		JLabel lblPassowrd = new JLabel("Password");
		lblPassowrd.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 23));
		lblPassowrd.setBounds(10, 55, 98, 46);
		panel.add(lblPassowrd);

		JLabel lblNamaUser = new JLabel("Nama User");
		lblNamaUser.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 23));
		lblNamaUser.setBounds(10, 96, 98, 46);
		panel.add(lblNamaUser);

		JLabel label_3 = new JLabel("Status");
		label_3.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 23));
		label_3.setBounds(10, 160, 98, 46);
		panel.add(label_3);

		JButton button = new JButton("INSERT");
		button.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 19));
		button.setBounds(10, 230, 108, 61);
		panel.add(button);

		JButton button_1 = new JButton("DELETE");
		button_1.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 19));
		button_1.setBounds(295, 230, 108, 61);
		panel.add(button_1);

		JButton button_2 = new JButton("UPDATE");

		button_2.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 19));
		button_2.setBounds(150, 230, 108, 61);
		panel.add(button_2);

		JComboBox status = new JComboBox();
		status.addItem("admin");
		status.addItem("staff");
		status.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
		status.setBackground(Color.LIGHT_GRAY);
		status.setBounds(170, 160, 233, 46);
		panel.add(status);

		TextField id_user = new TextField();
		id_user.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 16));
		id_user.setBounds(170, 22, 233, 35);
		panel.add(id_user);

		TextField nama_user = new TextField();
		nama_user.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 16));
		nama_user.setBounds(170, 107, 233, 35);
		panel.add(nama_user);

		password = new JPasswordField();
		password.setBounds(170, 64, 233, 35);
		panel.add(password);

		JLabel lblManageUser = new JLabel("Manage User");
		lblManageUser.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 28));
		lblManageUser.setBounds(10, 6, 195, 46);
		contentPane.add(lblManageUser);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(441, 63, 426, 310);
		contentPane.add(scrollPane);

		table = new JTable();
		String judul[] = { "ID USER", "PASSWORD", "NAMA USER", "STATUS USER" };
		model = new DefaultTableModel(null, judul);
		table.setModel(model);
		table.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 16));
		scrollPane.setViewportView(table);
		table.setModel(model);

		JButton button_3 = new JButton("REFRESH");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				try {
					new UserSetting().setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button_3.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 19));
		button_3.setBounds(441, 23, 113, 36);
		contentPane.add(button_3);
		tampilUser();

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					db.insertUser(id_user.getText().toString(), password.getText().toString(),
							nama_user.getText().toString(), status.getSelectedItem().toString());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				db.updateUser(id_user.getText().toString(), password.getText().toString(),
						nama_user.getText().toString(), status.getSelectedItem().toString());
			}
		});
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				db.deleteUser(id_user.getText());
			}
		});
	}

	public void tampilUser() throws SQLException {
		Database db = new Database();
		db.openDatabase();
		koneksi = DriverManager.getConnection(DB_URL, user, pass);
		Statement stmt = (Statement) koneksi.createStatement();
		String sql = "SELECT * FROM tb_user";
		rs = stmt.executeQuery(sql);

		while (rs.next()) {
			String id_user = rs.getString(1);
			String password = rs.getString(2);
			String nama_user = rs.getString(3);
			String status = rs.getString(4);
			String row[] = { id_user, password, nama_user, status };
			model.addRow(row);
		}
		rs.close();
	}
}
