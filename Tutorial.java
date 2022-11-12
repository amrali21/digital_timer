import java.util.Timer;
import java.util.TimerTask;

// in this script i made a digital timer

public class Tutorial {
	
public static void main(String[] args) {
    Tutorial tut = new Tutorial();
    tut.runTimer();
}
    
Timer timer = new Timer();
int i = 0;
TimerTask task = new TimerTask(){
	public void run(){
		String time = getTime(i);
		System.out.println(time);
		i++;
	}
};

public void runTimer(){
	timer.schedule(task, 0, 1000 );
}

static String getTime(int sec)
{
    //if we have hours minutes and seconds
    int hours = 0;
    int remainderOfHours = 0;
    int minutes = 0;
    int seconds = 0;

    if (sec >= 3600) // if we have an hour or more     
    {
        hours = sec / 3600;               
        remainderOfHours = sec % 3600;        // could be more or less than a min

        if (remainderOfHours >= 60)   //check if remainder is more or equal to a min
        {
            minutes = remainderOfHours / 60;
            seconds = remainderOfHours % 60;
        }
        else
        {                       // if it's less than a min
            seconds = remainderOfHours;
        }
    }
    // if we have a min or more
    else if (sec >= 60)                
    {
        hours = 0;               
        minutes = sec / 60;
        seconds = sec % 60;
    }
    //if we have just seconds
    else if (sec < 60)
    {
        hours = 0;
        minutes = 0;
        seconds = sec;
    }

    //i get integer hour minuite second. i want to transform them to strings:
    String strHours;
    String strMins; 
    String strSecs; 

    if(seconds < 10)
    	strSecs = "0" + Integer.toString(seconds);
    else
    	strSecs = Integer.toString(seconds);
   
    if(minutes < 10)
   	 strMins = "0" + Integer.toString(minutes);
    else
	   strMins = Integer.toString(minutes);
    
    if(hours < 10)
        strHours = "0" + Integer.toString(hours);
    else
    	strHours = Integer.toString(hours);
    	
    String time = strHours + ":" + strMins + ":" + strSecs;
    return time;
}
}
