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

/**
 * PART II.
 * Provide a subclass of Clock named WorldClock whose constructor
 * accepts a time offset. For example, if you live in California,
 * a new WorldClock(3) should show the time in New York, three
 * time zones ahead. You should not override getTime.
 */
public class WorldClock extends Clock
{	
	private int wCurrentHours;
	
	public WorldClock(int offset) {
		wCurrentHours = Integer.parseInt(super.getHours())+offset;
		if(wCurrentHours>=24) {
			wCurrentHours -= 24;
		}
		currentHours = String.valueOf(wCurrentHours);
	}
	@Override
	public String getHours() {
		//Get substring of currentTime and add to hours string.
		return currentHours; //Return string
	}
}
