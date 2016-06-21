package bioskop;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import java.awt.TextArea;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JScrollPane;

public class PrintTransaksi extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrintTransaksi frame = new PrintTransaksi("B1", "STUDIO 1");
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
	public PrintTransaksi(String id_bangku, String nama_studio) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 358, 409);
		String bangku = id_bangku;
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd - MM - yyyy");
		String tanggal = dateFormat.format(date);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 322, 348);
		contentPane.add(scrollPane);

		TextArea textArea = new TextArea();
		textArea.setText("\t\t   TIKET BIOSKOP\r\n\n" + "\t\t    DOSANMONDI\n"
				+ "             @UNIVERSITAS MULTIMEDIA NUSANTARA\n" + "--------------------------------------------"
				+ "---------------------------------------\n\n" + "\tTANGGAL :  " + tanggal + "\r\n"
				+ "\tSEAT / BANGKU : " + id_bangku + "\r\n\n"
				+ "\tSTUDIO        : "+nama_studio+"\r\n\n"
				+ "\tHARGA         : Rp.45000,00\r\n\n"
				+ "\tJUDUL FILM    : WARCRAFT : THE BEGINNING\r\n\n"
				+ "\tRATING FILM   : Semua Umur (SU)\r\n\n"
				+"--------------------------------------------"
				+"---------------------------------------\n\n"
				+ "transaction     : 111231415122311" );

		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
	}
}
