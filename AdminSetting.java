package bioskop;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JDesktopPane;
import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JTable;
import javax.swing.border.SoftBevelBorder;
import javax.swing.ListSelectionModel;
import java.awt.Toolkit;

public class AdminSetting extends JFrame {
	private DefaultTableModel model;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminSetting frame = new AdminSetting();
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
	 * @throws ClassNotFoundException
	 */
	public AdminSetting() throws SQLException, ClassNotFoundException {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\valdo\\Pictures\\bioskop.jpg"));
		setResizable(false);
		Database db = new Database();
		Notification notif = new Notification();

		setTitle("ADMIN SETTING");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 749, 615);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 405, 260);
		panel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), "",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(SystemColor.menu);
		contentPane.add(panel);
		panel.setLayout(null);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 20));
		ArrayList<String> arr = new ArrayList<String>();
		arr.addAll(db.isiboxstudio());
		for (int i = 0; i < arr.size(); i++) {
			comboBox_1.addItem(arr.get(i));
		}
		comboBox_1.setBounds(125, 71, 264, 46);
		panel.add(comboBox_1);

		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 20));
		ArrayList<String> arr2 = new ArrayList<String>();
		arr2.addAll(db.isiboxjudul());
		for (int i = 0; i < arr2.size(); i++) {
			comboBox.addItem(arr2.get(i));
		}
		comboBox.setBounds(125, 144, 264, 46);
		panel.add(comboBox);

		JButton button = new JButton("UBAH FILM");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String judul = comboBox.getSelectedItem().toString();
				String studio = comboBox_1.getSelectedItem().toString();
				try {
					db.updateFilm(judul, studio);
					notif.notfikasi();

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button.setBounds(282, 214, 113, 36);
		panel.add(button);
		button.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 19));

		JLabel label_1 = new JLabel("JUDUL");
		label_1.setBounds(30, 133, 85, 63);
		panel.add(label_1);
		label_1.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 30));

		JLabel label = new JLabel("STUDIO");
		label.setBounds(30, 60, 85, 63);
		panel.add(label);
		label.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 30));

		JLabel lblSettingFilm = new JLabel("Setting Studio");
		lblSettingFilm.setBounds(10, 0, 195, 46);
		panel.add(lblSettingFilm);
		lblSettingFilm.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 25));

		JButton btnLihatStudio = new JButton("LIHAT STUDIO");
		btnLihatStudio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new ListStudioAdmin().setVisible(true);
				} catch (ParseException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnLihatStudio.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 19));
		btnLihatStudio.setBounds(127, 214, 142, 36);
		panel.add(btnLihatStudio);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(464, 11, 259, 260);
		panel_1.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null),
				"SETTING DATABASE", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JButton btnSettingFilm = new JButton("SETTING FILM");
		btnSettingFilm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SettingFilm().setVisible(true);
			}
		});
		btnSettingFilm.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 19));
		btnSettingFilm.setBounds(41, 46, 185, 61);
		panel_1.add(btnSettingFilm);

		JButton btnSettingUser = new JButton("SETTING USER - ADMIN");
		btnSettingUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new UserSetting().setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnSettingUser.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 17));
		btnSettingUser.setBounds(41, 142, 185, 61);
		panel_1.add(btnSettingUser);
		String[] judul = { "ID Film", "Judul Film", "Deskripsi Film", "Status Film", "Genre", "Rating Film" };

		model = new DefaultTableModel(null, judul);

		ArrayList<ListFilm> FilmList = new ArrayList<ListFilm>();
		FilmList.addAll(db.tableFilm());
		for (int i = 0; i < FilmList.size(); i++) {
			String a = FilmList.get(i).getId_film();
			String b = FilmList.get(i).getJudul_film();
			String c = FilmList.get(i).getDeskripsi();
			String d = FilmList.get(i).getStatus();
			String e = FilmList.get(i).getGenre();
			String f = FilmList.get(i).getRating();
			model.addRow(new Object[] { a, b, c, d, e, f });
		}
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 327, 723, 208);
		contentPane.add(scrollPane);
		// "ID Film", "Judul Film", "Deskripsi Film", "Status Film", "Genre",
		// "Rating Film"
		JTable table_1 = new JTable();
		table_1.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 16));
		scrollPane.setViewportView(table_1);
		table_1.setColumnSelectionAllowed(true);
		table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table_1.setModel(model);
		table_1.setModel(model);

		JButton btnRefresh = new JButton("REFRESH");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				try {
					new AdminSetting().setVisible(true);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnRefresh.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 19));
		btnRefresh.setBounds(10, 280, 113, 36);
		contentPane.add(btnRefresh);

		JButton btnLogout = new JButton("LOGOUT");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Login().setVisible(true);
			}
		});
		btnLogout.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 19));
		btnLogout.setBounds(10, 539, 113, 36);
		contentPane.add(btnLogout);
	}

	public void tampil() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Database db = new Database();
		ArrayList<ListFilm> FilmList = new ArrayList<ListFilm>();
		ResultSet rs = (ResultSet) db.tableFilm();
		int i = 0;

		rs.close();
	}
}
