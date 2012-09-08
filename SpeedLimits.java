

public class SpeedLimits {
	
	public int getSpeedLimit(String stype)
	{
		int speedLimit=0;
		if(stype.equals("S"))
			speedLimit=30;
		if(stype.equals("H"))
			speedLimit = 65;
		//future street types and speed limits can be added here
		
		return speedLimit;
	}

}
