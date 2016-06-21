package bioskop;

public class ListFilm {
	private String id_film;
	private String judul_film;
	private String deskripsi;
	private String status;
	private String Genre;
	private String Rating;
	
	public String getId_film() {
		return id_film;
	}
	public void setId_film(String id_film) {
		this.id_film = id_film;
	}
	public String getJudul_film() {
		return judul_film;
	}
	public void setJudul_film(String judul_film) {
		this.judul_film = judul_film;
	}
	public String getDeskripsi() {
		return deskripsi;
	}
	public void setDeskripsi(String deskripsi) {
		this.deskripsi = deskripsi;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getGenre() {
		return Genre;
	}
	public void setGenre(String genre) {
		Genre = genre;
	}
	public String getRating() {
		return Rating;
	}
	public void setRating(String rating) {
		Rating = rating;
	}
	
}
