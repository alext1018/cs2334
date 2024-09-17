import java.util.ArrayList;
import java.io.*;
public class Playlist {
    private ArrayList<Song> songs;

    public Playlist() {
        songs = new ArrayList<>();
    }

    
    public Playlist(String filename) {
        this();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line ;
            while ((line = br.readLine()) != null){
                Song song = new Song(line);
                songs.add(song);
            }
            br.close();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

  
    public int getNumSongs() {
        return songs.size();
    }

    
    public Song getSong(int index) {
        return songs.get(index);
    }

   
    public Song[] getSongs() {
        return (Song[]) songs.toArray();
    }

    public boolean addSong(Song song) {
        return songs.add(song);
    }

    public boolean addSong(int index, Song song) {
        if(song == null || index <0 || index>songs.size())
            return false;
        songs.add(index, song);
        return true;
    }

    public int addSongs(Playlist playlist) {
        if (playlist == null)
            return 0;
        songs.addAll(playlist.songs);
        return playlist.songs.size();
    }

    public int addSongs(String filename) {
        int count = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line ;

            while ((line = br.readLine()) != null){
                Song song = new Song(line);
                songs.add(song);
                count++;
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return count;
    }

   
    public Song removeSong() {
        return songs.remove(0);
    }

   
    public Song removeSong(int index) {
        return songs.remove(index);
    }

    public void saveSongs(String filename) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
            bw.write(this.toString());
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        String str = "";
        for (Song song:songs){
            str += song.toString();
        }
        return str;
    }

    public int[] getTotalTime() {
        int seconds = 0;
        int mins = 0;
        int hrs = 0;
        for (Song song : songs) {
            int[] time = song.getTime();
            if (time.length >= 3) {
                hrs += time[0];
                mins += time[1];
                seconds += time[2];
            } else if (time.length == 2) {
                hrs += time[0];
                mins += time[1];
            } else if (time.length == 1) {
                hrs += time[0];
            }
        }
        if (seconds > 60) {
            mins += (seconds / 60);
            seconds = seconds % 60;
        }
        if (mins > 60) {
            hrs += (mins / 60);
            mins = mins % 60;
        }
        int[] result = new int[3];
        result[0] = hrs;
        result[1] = mins;
        result[2] = seconds;
        return result;
    }
}