
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
				int speedLimit = sl.getSpeedLimit(sType);
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
	
	

}
