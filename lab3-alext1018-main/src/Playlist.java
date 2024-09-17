
public class Playlist {
	private Song[] songs;
	private int numSongs;
	private int MIN_CAPICITY =3;
	Playlist() {
		numSongs =0;
		songs = new Song[MIN_CAPICITY];
	}
	Playlist(int capacity) {
		numSongs=0;
		if(capacity<MIN_CAPICITY) {
			songs= new Song[MIN_CAPICITY];
		}
		else {
			songs=new Song[capacity];
		}
	}
	public int getCapacity() {
		return songs.length;

	}
	public int getNumSongs() {
		return numSongs;
	}
	public Song getSong(int index) {
		if(index<0||index>=numSongs) {
			return null;
		}
		return songs[index];
	}
	public Song[] getSongs() {
		return songs.clone();
	}
	public boolean addSong(Song song) {
		if(numSongs == songs.length||song == null) {
			return false;
		}
		songs[numSongs++]=song;
		return true;
	}
	public boolean addSong(int index, Song song) {
			if(numSongs == songs.length|| index<0||index==(numSongs+1)|| song==null){
			return false;
			}
			for(int i =numSongs; i>index; i--) {
				songs[i]=songs[i-1];
				
			}
			songs[index]=song;
			numSongs++;
			return true;
	}
	public int addSongs(Playlist playlist) {
		if(playlist==null) {
			return 0;
		}
		int a = 0;
		while(a<playlist.numSongs&&numSongs<songs.length) {
			songs[numSongs++]=playlist.songs[a++];
			System.out.println(playlist.numSongs);
			
		}
		return a;
	
	}
	public Song removeSong() {
		if(numSongs==0) {
			return null;
		}
		numSongs--;
		return songs[numSongs];
	}
	public Song removeSong(int index) {
		if(index>numSongs) {
			return null;
		}
		Song a=songs[index];
		for(int i =index;i<songs.length-1;i++) {
			songs[i]=songs[i+1];
		}
		numSongs--;
		return a;
	}
	
}