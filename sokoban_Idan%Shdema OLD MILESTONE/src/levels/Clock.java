package levels;

import java.io.Serializable;

/**
 * Clock that counts time to finish level.
 * @author שדמה
 *
 */
public class Clock implements Serializable{
	
	long time[] = new long[3];
	long startTime;
	long stopTime;
	
	Clock()
	{
		startTime = System.nanoTime();
		stopTime = System.nanoTime();
	}
	
	public long getStartTime() {
		return startTime;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	public long getStopTime() {
		return stopTime;
	}

	public void setStopTime(long stopTime) {
		this.stopTime = stopTime;
	}

	public void setTime(long[] time) {
		this.time = time;
	}

	public void start()
	{
		startTime = System.nanoTime();
	}
	
	public void stop()
	{
		stopTime = System.nanoTime();

	}
	
	public long[] getTime()
	{
		long total = stopTime - startTime;
		total /= 1000000000; //change to seconds
		time[2] = (total % 60);
		total /= 60;
		time[1] = (total % 60);
		time[0] = total / 60;
		
		return time;
	}
	public void printTime()
	{
		if (time[0]<10)
			System.out.print("Time: 0" + time[0]);
		else
			System.out.print("Time: " + time[0]);
		if (time[1]<10)
			System.out.print(":0"+time[1]);
		else
			System.out.print(":" + time[1]);
		if (time[2]<10)
			System.out.print(":0"+time[2]);
		else
			System.out.print(":" + time[2]);
		System.out.println();
	}
}
