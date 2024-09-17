
public class Song {
	private String title;
	private String artist;
	private int[] time;
	private int[] array;
	
	public Song(String title, String artist, int[] time) {
		this.title = title;
		this.artist =artist;
		array=time.clone();
		this.time = new int[time.length];
	
	}
	public String getTitle() {
		return title;
	}
	
	public String getArtist() {
		return artist;
	}
	public int[] getTime() {
		time = array.clone();
		return time;
	}
}
