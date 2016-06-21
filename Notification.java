package bioskop;

import javax.swing.*;
import javax.swing.JOptionPane;

public class Notification {

	public void notfikasi() {
		JOptionPane.showMessageDialog(null, "Data berhasil Di Update / Di Masukkan", "Information Message",
				JOptionPane.INFORMATION_MESSAGE);
	}

	public void login(String nama_user) {
		JOptionPane.showMessageDialog(null, "Hallo " + nama_user + ", Selamat bekerja", "Information Message",
				JOptionPane.INFORMATION_MESSAGE);
	}

	public void ubahHuruf(JLabel a) {

	}
}
