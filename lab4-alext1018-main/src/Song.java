import java.util.Arrays;

public class Song {
    private String title;
    private String artist;
    private int[] time;
    private String INFO_DELIMITER = "; ";
    private String TIME_DELIMITER = ":";
    private int IDX_TITLE = 0;
    private int IDX_ARTIST = 1;
    private int IDX_TIME = 2;

   
    public Song(String title, String artist, int[] time) {
        this.title = title;
        this.artist = artist;
        this.time = time;
    }

   
    public Song(String info) {
        String[] songInfo = info.split(INFO_DELIMITER);
        this.title = songInfo[IDX_TITLE];
        this.artist = songInfo[IDX_ARTIST];
        String[] times = songInfo[IDX_TIME].split(TIME_DELIMITER);
        int timeData[] = new int[times.length];
        
       if(times.length==1) {
    	   timeData[0]= Integer.parseInt(times[0]);
    	  
       }
       else {
    	   for(int i = times.length-1;i>=0;i--) {
    		   timeData[i]=Integer.parseInt(times[i]);
    		   System.out.println(timeData[i]);
    	   }
       }
        this.time = timeData;
    }
    

    
    public String getTitle() {
        return title;
    }

    
    public String getArtist() {
        return artist;
    }

   
    public int[] getTime() {
        return time;
    }

  
    
    	
    		 public String toString() {
    		        String timeStr = ""+time[0];
    		        for(int i=1; i<time.length; i++){
    		            timeStr += TIME_DELIMITER+time[i];
    		        }
    		        return  title+INFO_DELIMITER+artist+INFO_DELIMITER+timeStr;
    		    }
    	    }
    	



        

