

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

public class Routes {
	
	public static void main(String args[]) throws IOException
	{
		
		ReadFile rfObj = new ReadFile(args[0]);
		HashMap<String,Streets> hm = rfObj.read();
		Routes rt = new Routes();
		String[] result = rt.calculateTimeDistance(hm,rfObj);
		String finalTime= result[0];
		String finalDistance = result[1];
		System.out.println("Distance:"+ finalDistance+"\n"+ "Time: "+finalTime);
	}
	
	public String[] calculateTimeDistance(HashMap<String,Streets> hm2,ReadFile rf) throws IOException
	{
		Iterator<String> iterator = hm2.keySet().iterator();
		String[] result=new String[2];
		String time=" hrs";
		String dist=" mi";
		double totalDistance=0;
		double totalTime=0;
		while(iterator.hasNext())
		{
			String sname = iterator.next();
			Streets st = hm2.get(sname);
			totalDistance+=st.getsLength();
			double travelTime=(st.getsLength()/st.getSpeedLimit());
			if(st.getsType().equals("H")&&travelTime<1/60)
				travelTime=1/60;
			totalTime+=travelTime;			
		}
		System.out.println("Want the final distance in Miles or KM ? M or K");
		BufferedReader buf =rf.getUserInput();
		String uip = buf.readLine();
		if(uip.equals("K"))
		{
			dist=" km";
			totalDistance*=1.609;
		}
		double finalDistance = Math.round( totalDistance * 100.0 ) / 100.0;
		double finalTime = Math.round( totalTime * 100.0 ) / 100.0;
		
		result[0]=finalTime+time;
		result[1]=finalDistance+dist;
		return result;		
	}

}
