package bioskop;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Database {
	private Connection koneksi = null;
	private Statement stmt = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	Notification notif = new Notification();
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/bioskopdb";
	static final String user = "root";
	static final String pass = "";

	public void openDatabase() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			koneksi = DriverManager.getConnection(DB_URL, user, pass);

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} /**
			 * finally { // finally block used to close resources try { if (stmt
			 * != null) stmt.close(); } catch (SQLException se2) { } // nothing
			 * we can do try { if (koneksi != null) koneksi.close(); } catch
			 * (SQLException se) { se.printStackTrace(); } // end finally try }
			 * // end try
			 **/
	}

	public void close() {
		try {
			if (rs != null) {
				rs.close();
			}

			if (rs != null) {
				rs.close();
			}

			if (koneksi != null) {
				koneksi.close();
			}

		} catch (Exception e) {

		}
	}

	public boolean validasi(String user, String pass) {

		Notification notif = new Notification();
		try {
			openDatabase();
			String sql = "SELECT id_user,password,nama_user FROM tb_user WHERE id_user=? and password=?";
			ps = koneksi.prepareStatement(sql);
			ps.setString(1, user);
			ps.setString(2, pass);
			rs = ps.executeQuery();
			if (rs.next()) {
				notif.login(rs.getString("nama_user"));

				return true;
			} else
				return false;

		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	public String judul(String id_studio) throws SQLException {
		openDatabase();
		String sql = "SELECT judul_film FROM tb_studio a, tb_film b WHERE id_studio=? and a.id_film = b.id_film";
		String temp = "";
		ps = koneksi.prepareStatement(sql);
		ps.setString(1, id_studio);
		rs = ps.executeQuery();
		while (rs.next()) {
			temp = rs.getString("judul_film");

			return temp;
		}

		return temp;
	}

	public List<String> isiboxstudio() throws SQLException {
		openDatabase();
		String sql = "SELECT nm_studio FROM tb_studio";
		ps = koneksi.prepareStatement(sql);
		rs = ps.executeQuery();
		List<String> FilmList = new ArrayList<>();
		String inner = "";
		while (rs.next()) {
			inner = rs.getString("nm_studio");
			FilmList.add(inner);
			// System.out.println(inner);
		}

		return FilmList;
	}

	public void updateFilm(String judul, String studio) throws SQLException {
		openDatabase();
		String t_studio = id_studio(studio);
		String t_judul = judulFilm(judul);
		stmt = koneksi.createStatement();
		String sql = "UPDATE tb_studio set id_film=? WHERE id_studio =?";
		ps = koneksi.prepareStatement(sql);
		ps.setString(1, t_judul);
		ps.setString(2, t_studio);
		try {

			ps.executeUpdate();
			// System.out.println("Berhasil diubah");
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public String id_studio(String studio) throws SQLException {
		openDatabase();
		String sql = "SELECT id_studio FROM tb_studio WHERE nm_studio=?";
		String temp = "";
		ps = koneksi.prepareStatement(sql);
		ps.setString(1, studio);
		rs = ps.executeQuery();
		while (rs.next()) {
			temp = rs.getString("id_studio");

			return temp;
		}

		return temp;
	}

	public String judulFilm(String judul) throws SQLException {
		openDatabase();
		String sql = "SELECT id_film FROM tb_film WHERE judul_film=?";
		String temp = "";
		ps = koneksi.prepareStatement(sql);
		ps.setString(1, judul);
		rs = ps.executeQuery();
		while (rs.next()) {
			temp = rs.getString("id_film");

			return temp;
		}

		return temp;
	}

	public String status(String id_kursi, String id_studio) throws SQLException {
		close();
		openDatabase();
		String sql = "SELECT st_kursi FROM tb_kursi WHERE id_kursi=? and id_studio=?";
		ps = koneksi.prepareStatement(sql);
		String temp = "N";
		ps.setString(1, id_kursi);
		ps.setString(2, id_studio);
		rs = ps.executeQuery();
		while (rs.next()) {
			temp = rs.getString("st_kursi");
			return temp;
		}
		close();
		return temp;

	}

	public void clearKursi(String id_studio) throws SQLException {
		openDatabase();
		stmt = koneksi.createStatement();
		String sql = "UPDATE tb_kursi set st_kursi='Y' WHERE id_studio=?";
		ps = koneksi.prepareStatement(sql);
		ps.setString(1, id_studio);
		if (JOptionPane.showConfirmDialog(null, "Merapikan Studio Ini ?", "WARNING",
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			try {
				ps.executeUpdate();
				notif.notfikasi();
				close();
				// System.out.println("Berhasil diubah");
			} catch (Exception e) {
				// TODO: handle exception
			} // yes option
		} else {
			// no option
		}

	}

	public void beliKursi(String id_kursi, String id_studio) throws SQLException {
		openDatabase();
		String temp = "";
		temp = status(id_kursi, id_studio);
		stmt = koneksi.createStatement();
		if (temp.equals("Y")) {
			String sql = "UPDATE tb_kursi set st_kursi='N' WHERE id_studio=? and id_kursi=?";
			ps = koneksi.prepareStatement(sql);
			ps.setString(1, id_studio);
			ps.setString(2, id_kursi);
			if (JOptionPane.showConfirmDialog(null, "Yakin Memesan Kursi ini?", "WARNING",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				try {
					ps.executeUpdate();
					close();
				} catch (Exception e) {
					// TODO: handle exception
				} // yes option
			} else {
				// no option
			}

		}

	}

	public List<String> isiboxjudul() throws SQLException {
		openDatabase();
		String sql = "SELECT judul_film FROM tb_film";
		ps = koneksi.prepareStatement(sql);
		rs = ps.executeQuery();
		List<String> FilmList = new ArrayList<>();
		String inner = "";
		while (rs.next()) {
			inner = rs.getString("judul_film");
			// System.out.println(inner);
			FilmList.add(inner);
			// System.out.println(inner);
		}

		return FilmList;
	}

	public List<ListFilm> tableFilm() throws SQLException {
		openDatabase();
		String sql = "SELECT * FROM tb_film";
		ps = koneksi.prepareStatement(sql);
		rs = ps.executeQuery();
		List<ListFilm> FilmList = new ArrayList<ListFilm>();

		while (rs.next()) {
			ListFilm lf = new ListFilm();
			String id_film = rs.getString("id_film");
			String judul_film = rs.getString("judul_film");
			String deskripsi = rs.getString("deskripsi");
			String status = rs.getString("status");
			String Genre = rs.getString("Genre");
			String Rating = rs.getString("Rating");

			lf.setId_film(id_film);
			lf.setJudul_film(judul_film);
			lf.setDeskripsi(deskripsi);
			lf.setStatus(status);
			lf.setGenre(Genre);
			lf.setRating(Rating);

			FilmList.add(lf);
			// System.out.println(FilmList);
		}
		// for (int i = 0; i < FilmList.size(); i++) {
		// System.out.println(FilmList.get(i).getId_film());
		// }
		return FilmList;
	}

	public void insert(String id_film, String judul_film, String deskripsi, String status, String Genre, String Rating)
			throws SQLException {
		try {
			openDatabase();

			String sql = "INSERT INTO tb_film VALUE (?,?,?,?,?,?)";
			ps = koneksi.prepareStatement(sql);
			ps.setString(1, id_film);
			ps.setString(2, judul_film);
			ps.setString(3, deskripsi);
			ps.setString(4, status);
			ps.setString(5, Genre);
			ps.setString(6, Rating);

			ps.execute();
			notif.notfikasi();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Data gagal Masuk, Data masih salah", "Information Message",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void update(String id_film, String judul_film, String deskripsi, String status, String Genre,
			String Rating) {
		try {
			openDatabase();

			String sql = "UPDATE tb_film set judul_film=?,deskripsi=?,status=?,Genre=?,Rating=? WHERE id_film =?";
			ps = koneksi.prepareStatement(sql);
			ps.setString(1, judul_film);
			ps.setString(2, deskripsi);
			ps.setString(3, status);
			ps.setString(4, Genre);
			ps.setString(5, Rating);
			ps.setString(6, id_film);

			ps.executeUpdate();
			notif.notfikasi();
			new AdminSetting().setAutoRequestFocus(true);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Data gagal Masuk, Data masih salah", "Information Message",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void delete(String id_film) {
		try {
			openDatabase();
			String sql = "DELETE FROM tb_film WHERE id_film=?";
			ps = koneksi.prepareStatement(sql);
			ps.setString(1, id_film);
			ps.executeUpdate();
			notif.notfikasi();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Data gagal Masuk, Data masih salah", "Information Message",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void insertUser(String id_user, String password, String nama_user, String status) throws SQLException {

		openDatabase();
		try {
			String sql = "INSERT into tb_user VALUES(?,?,?,?)";
			ps = koneksi.prepareStatement(sql);
			ps.setString(1, id_user);
			ps.setString(2, password);
			ps.setString(3, nama_user);
			ps.setString(4, status);

			ps.execute();
			notif.notfikasi();

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void updateUser(String id_user, String password, String nama_user, String status) {
		try {
			openDatabase();

			String sql = "UPDATE tb_user set password=?,nama_user=?,status=? WHERE id_user =?";
			ps = koneksi.prepareStatement(sql);
			ps.setString(1, password);
			ps.setString(2, nama_user);
			ps.setString(3, status);
			ps.setString(4, id_user);

			ps.executeUpdate();
			notif.notfikasi();
			new AdminSetting().setAutoRequestFocus(true);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Data gagal Masuk, Data masih salah", "Information Message",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void deleteUser(String id_user) {
		try {
			openDatabase();
			String sql = "DELETE FROM tb_user WHERE id_user=?";
			ps = koneksi.prepareStatement(sql);
			ps.setString(1, id_user);
			ps.executeUpdate();
			notif.notfikasi();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Data gagal Masuk, Data masih salah", "Information Message",
					JOptionPane.ERROR_MESSAGE);
		}
	}
}
