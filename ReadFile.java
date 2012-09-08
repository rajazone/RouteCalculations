
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class ReadFile {
	String ipFile;
	ReadFile(String inputFile) throws IOException
	{
		this.ipFile = inputFile;
	}
	
	public HashMap<String, Streets> read() throws IOException
	{
	
		BufferedReader buf = new BufferedReader(new FileReader(this.ipFile));
		String line;
		HashMap<String,Streets> hm = new HashMap<String,Streets>();
			while((line=buf.readLine())!=null)
			{
				String[] elements = line.split(",");
				String sName = elements[0];
				String sType = elements[1];
				double sLength = Double.parseDouble(elements[2]);
				SpeedLimits sl = new SpeedLimits();
				int speedLimit = sl.getSpeedLimit(sType,0);
				System.out.println("Street Name:"+sName+", Street Type:"+sType+", SpeedLimit:"+speedLimit);
				System.out.println("Any weather change and need to change the speed? Y or N");
				BufferedReader b = getUserInput();
				String weatherChange = b.readLine();
				if(weatherChange.equals("Y"))
				{
					System.out.println("Enter the change of speed");
					BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
					String spchange = sc.readLine();
					int newSpeed = Integer.parseInt(spchange);
					speedLimit = sl.getSpeedLimit(sType,newSpeed);
					
				}
				Streets stObj = new Streets();
				stObj.setsName(sName);
				stObj.setsLength(sLength);
				stObj.setSpeedLimit(speedLimit);
				stObj.setsType(sType);
				hm.put(sName, stObj);
			}
			buf.close();
		return hm;
	}
	
	public BufferedReader getUserInput()
	{
		return new BufferedReader(new InputStreamReader(System.in));
	}
	
	

}
