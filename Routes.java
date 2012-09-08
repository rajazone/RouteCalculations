

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

public class Routes {
	
	public static void main(String args[]) throws IOException
	{
		
		ReadFile rfObj = new ReadFile(args[0]);
		HashMap<String,Streets> hm = rfObj.read();
		Iterator<String> iterator = hm.keySet().iterator();
		double distance=0.0;
		double totalTime=0;
		while(iterator.hasNext())
		{
			String sname = iterator.next();
			Streets st = hm.get(sname);
			//System.out.println("Name:"+st.getsName()+" Type:"+st.getsType()+" Length:"+
			//st.getsLength()+" Speed Limit:"+st.getSpeedLimit());
			distance+=st.getsLength();
			totalTime+=(st.getsLength()/st.getSpeedLimit());
			
		}
		double finalDistance = Math.round( distance * 100.0 ) / 100.0;
		double finalTime = Math.round( totalTime * 100.0 ) / 100.0;
		System.out.println("Distance:"+ finalDistance+ "mi"+"\n"+ "Time: "+finalTime+" hr");
	}

}
