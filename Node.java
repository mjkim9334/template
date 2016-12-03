
public class Node {

	public Node()
	{
		
	}
	
	public static Node instance(Line line)
	{
		switch(line.getmode()){
		case "Header":
			return new Header(line);
			
		default: 
			return null;
			
			
		}
	}
}
