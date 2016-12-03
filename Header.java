
public class Header extends Node {

	String[] lines=null;
	int lineNum=0;
	String size=null;
	String htmlCode=null;
	String content=null;
	public Header(Line line)
	{
		lineNum=line.getIndex();
		for(int i=0; i<lineNum; i++)
		{
			lines[i]=line.getSentence(i);
			
			
		}

		
	}
	
	public String toHTML()
	{
		int i=0;
		while(i<lineNum)
		{
		 
			if(lines[i].contains("###### ")){
				size="h6";
				content=lines[i].substring(7, lines[i].length());
			}
			else if(lines[i].contains("##### "))
			{
				size="h5";
				content=lines[i].substring(6, lines[i].length());
			}
			else if(lines[i].contains("#### "))
			{
				size="h4";
				content=lines[i].substring(5, lines[i].length());
			}
			else if(lines[i].contains("### "))
			{
				size="h3";
				content=lines[i].substring(4, lines[i].length());
			}
			else if(lines[i].contains("## "))
			{
				size="h2";
				content=lines[i].substring(3, lines[i].length());
			}
			else if(lines[i].contains("# "))
			{
				size="h1";
				content=lines[i].substring(2, lines[i].length());
			}
				
		}
		
		
		
		htmlCode="<"+size+">"+content+"</"+size+">";
		
		return htmlCode;
		
	}
	
	public Token createToken()
	{
		
		if(content.contains("*"))// header 안에 list가 있을 경우는 없으니까
			return new Emphasis(content);
		else 
			return new PlainText(content);// 아무 것도 해당 사항 없으면 plain text이다
		

	}
	
	
}
