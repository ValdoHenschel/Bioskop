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
import java.awt.TextField;
import java.awt.TextArea;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class SettingFilm extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SettingFilm frame = new SettingFilm();
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
	public SettingFilm() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\valdo\\Pictures\\bioskop.jpg"));
		setTitle("MANAGE FILM");
		Database db = new Database();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 449, 613);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblManageFilm = new JLabel("Manage Film");
		lblManageFilm.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 25));
		lblManageFilm.setBounds(10, 11, 195, 46);
		contentPane.add(lblManageFilm);

		JPanel panel = new JPanel();
		panel.setBounds(10, 68, 413, 495);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblIdFilm = new JLabel("ID Film");
		lblIdFilm.setBounds(10, 11, 98, 46);
		panel.add(lblIdFilm);
		lblIdFilm.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 23));

		JLabel lblJudulFilm = new JLabel("Judul Film");
		lblJudulFilm.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 23));
		lblJudulFilm.setBounds(10, 55, 98, 46);
		panel.add(lblJudulFilm);

		JLabel lblDeskripsi = new JLabel("Deskripsi");
		lblDeskripsi.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 23));
		lblDeskripsi.setBounds(10, 96, 98, 46);
		panel.add(lblDeskripsi);

		JLabel lblStatus = new JLabel("Status");
		lblStatus.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 23));
		lblStatus.setBounds(10, 182, 98, 46);
		panel.add(lblStatus);

		JLabel lblGenre = new JLabel("Genre");
		lblGenre.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 23));
		lblGenre.setBounds(10, 239, 98, 46);
		panel.add(lblGenre);

		JLabel lblRating = new JLabel("Rating");
		lblRating.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 23));
		lblRating.setBounds(10, 296, 98, 46);
		panel.add(lblRating);

		JButton btnSettingFilm = new JButton("INSERT");
		btnSettingFilm.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 19));
		btnSettingFilm.setBounds(10, 373, 108, 61);
		panel.add(btnSettingFilm);

		JButton btnDelete = new JButton("DELETE");

		btnDelete.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 19));
		btnDelete.setBounds(295, 373, 108, 61);
		panel.add(btnDelete);

		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 19));
		btnUpdate.setBounds(150, 373, 108, 61);
		panel.add(btnUpdate);

		JComboBox status = new JComboBox();
		status.setBackground(Color.LIGHT_GRAY);
		status.addItem("GO");
		status.addItem("NO");
		status.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
		status.setBounds(170, 182, 233, 46);
		panel.add(status);

		JComboBox genre = new JComboBox();
		genre.setBackground(Color.LIGHT_GRAY);
		genre.addItem("Action");
		genre.addItem("Sci-fi");
		genre.addItem("Drama");
		genre.addItem("Comedy");
		genre.addItem("Animation");
		genre.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
		genre.setBounds(170, 239, 233, 46);
		panel.add(genre);

		JComboBox rating = new JComboBox();
		rating.setBackground(Color.LIGHT_GRAY);
		rating.addItem("SU");
		rating.addItem("R");
		rating.addItem("D");
		rating.addItem("BO");
		rating.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
		rating.setBounds(170, 296, 233, 46);
		panel.add(rating);

		TextField judul_film = new TextField();
		judul_film.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 16));
		judul_film.setBounds(170, 55, 233, 35);
		panel.add(judul_film);

		TextArea deskripsi = new TextArea();
		deskripsi.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 16));
		deskripsi.setBounds(170, 96, 233, 75);
		panel.add(deskripsi);

		TextField id_film = new TextField();
		id_film.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 16));
		id_film.setBounds(170, 11, 233, 35);
		panel.add(id_film);

		btnSettingFilm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					db.insert(id_film.getText(), judul_film.getText(), deskripsi.getText(),
							status.getSelectedItem().toString(), genre.getSelectedItem().toString(),
							rating.getSelectedItem().toString());
					id_film.setText(null);
					judul_film.setText(null);
					deskripsi.setText(null);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				db.update(id_film.getText(), judul_film.getText(), deskripsi.getText(),
						status.getSelectedItem().toString(), genre.getSelectedItem().toString(),
						rating.getSelectedItem().toString());
				id_film.setText(null);
				judul_film.setText(null);
				deskripsi.setText(null);
			}
		});
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				db.delete(id_film.getText());
				id_film.setText(null);
			}
		});
	}
}
