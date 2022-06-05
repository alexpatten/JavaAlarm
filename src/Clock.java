/** 
*  Title:           AlexanderPattenA3
*  Semester:        COP3337 – Summer 20XX 
*  @author          Alexander Patten
*   
*  I affirm that this program is entirely my own work  
*  and none of it is the work of any other person. 
* 
*  Description of program, & explanation of programming  
*  concept(s) being  applied in the program  
*/ 

import java.awt.Toolkit;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.net.URI;

/**
 * Part I: Implement a class Clock whose getHours, getMinutes and
 * getTime methods return the current time at your location.
 * Return the time as a string.
 *
 * There are two ways to retrieve the current time as a String:
 *
 * 1) Before Java 8 use new Date().toString()
 * 2) With Java 8, you can use 3 classes in the java.time package:
 *    Instant, LocalDateTime and ZoneId. Here's how you do it:
 *    String timeString = LocalDateTime.ofInstant(Instant.now(),
 *                            ZoneId.systemDefault()).toString()
 *
 * With either method, you'll need to extract the hours and
 *   minutes as a substring.
 *
 *
 * Add an alarm feature to the Clock class.
 * When setAlarm(hours, minutes) is called, the clock
 * stores the alarm. When you call getTime, and the alarm
 * time has been reached or exceeded, return the time followed
 * by the string "Alarm" and clear the alarm.
*/
public class Clock
{
	protected String currentHours; //String for current hours
	private String currentMinutes; //String for current minutes
	private String alarmTime; //String for alarm time
	private boolean alarm; //Boolean variable to turn alarm on and off
	private String currentTime; //Get current time, also used to clear alarm
	//Variable for alarm sound
	private final Runnable alarmSound = (Runnable) Toolkit.getDefaultToolkit().getDesktopProperty("win.sound.exclamation");
   /**
    * Sets the alarm.
    * @param hours hours for alarm
    * @param minutes minutes for alarm
    */
   public void setAlarm(int hours, int minutes)
   {
      // If current time is equal to or greater than alarm time
      if(hours<=Integer.parseInt(currentHours) && minutes<=Integer.parseInt(currentMinutes) ) {
    	  alarm = true; //Set alarm variable to true
      }
      //If alarmTime is null
      else if(alarmTime == "") {
    	  alarmTime = currentTime; //Set the alarm time as currentTime
      }
   }

   /**
    * gets current time composed of hours and minutes
    * @return time in string;
    */
   public String getTime()
   {
	  //If the alarm is set to true
      if(alarm) {
    	  alarmSound.run(); //Trigger 1st alarm sound
    	  try {
    		  URI uri = new URI("https://www.youtube.com/watch?v=dQw4w9WgXcQ"); //URL for alarm sound
    		  java.awt.Desktop.getDesktop().browse(uri); //Sound the alarm
    	  }
    	  catch (Exception e) {e.printStackTrace();} //Print any errors with URI
    	  currentTime = currentHours + ":" + currentMinutes + " Alarm"; //Update currentTime string
    	  alarm = false; //Clear alarm
    	  return currentTime; //Return string
      }
      currentTime = currentHours + ":" + currentMinutes; //Update currentTime string
      return currentTime; //Return string
   }

   /**
    * gets hours
    * @return hours of current time in string
   */
   public String getHours()
   {	   
	   //Get substring of currentTime and add to hours string.
	   this.currentHours = currentTime().substring(11, 13); 
	   return currentHours; //Return string
   }

   /**
    * gets minutes
    * @return hours of current time in string
   */
   public String getMinutes()
   {
	   //Get substring of currentTime and add to minutes string.
	   this.currentMinutes = currentTime().substring(14, 16);
	   return currentMinutes; //Return string
   }

   /**
      Returns the current Date and Time as a String.
   */
   private String currentTime()
   {
      return LocalDateTime.ofInstant(Instant.now(),
         ZoneId.systemDefault()).toString();
   }
}
