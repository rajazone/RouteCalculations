

public class SpeedLimits {
	
	public int getSpeedLimit(String stype,int change)
	{
		int speedLimit=0;
		if(stype.equals("S"))
			speedLimit=30+change;
		if(stype.equals("H"))
			speedLimit = 65+change;
		//future street types and speed limits can be added here
		
		return speedLimit;
	}

}
