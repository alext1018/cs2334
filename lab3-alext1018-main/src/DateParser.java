import java.util.Scanner;
import java.util.ArrayList;
public class DateParser {
   public static int getMonthAsInt(String monthString) {
      int monthInt;
      
      // Java switch/case statement                                                                
      switch (monthString) {
         case "January": 
            monthInt = 1; 
            break;
         case "February": 
            monthInt = 2; 
            break;
         case "March": 
            monthInt = 3; 
            break;
         case "April": 
            monthInt = 4; 
            break;
         case "May": 
            monthInt = 5; 
            break;
         case "June": 
            monthInt = 6; 
            break;
         case "July": 
            monthInt = 7; 
            break;
         case "August": 
            monthInt = 8; 
            break;
         case "September": 
            monthInt = 9; 
            break;
         case "October": 
            monthInt = 10; 
            break;
         case "November": 
            monthInt = 11; 
            break;
         case "December": 
            monthInt = 12; 
            break;
         default: 
            monthInt = 0;
      }
      
      return monthInt;
   }

   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);

      // TODO: Read dates from input, parse the dates to find the ones
      //       in the correct format, and output in m/d/yyyy format
     ArrayList<String> dates = new ArrayList<String>();
        
        String d;
        
        while(true) { 
            d = scnr.nextLine();
            if(d.equals("-1"))
                break;
                
            dates.add(d);
        }
        for(int i = 0; i < dates.size(); i++) { 
            try { 
                String month = dates.get(i).substring(0, dates.get(i).indexOf(" "));
                
                String day = dates.get(i).substring(dates.get(i).indexOf(" ") + 1, dates.get(i).indexOf(","));
                
                String year = dates.get(i).substring(dates.get(i).indexOf(",") + 2, dates.get(i).length());
                
                System.out.println(getMonthAsInt(month) + "/" + day + "/" + year);
            }
            catch (Exception e) { 
                
            }
        }
    }
}





