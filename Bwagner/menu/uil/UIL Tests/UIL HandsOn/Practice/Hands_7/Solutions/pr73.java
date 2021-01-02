import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class pr73
{
	public static void main (String[] args) throws IOException
	{
		Scanner kb = new Scanner(new File("pr73.dat"));
		// get ArrayList of Strings
		List<String> tags = new ArrayList<String>();
      	tags = Arrays.asList("<html>", "</html>", "<title>", "</title>", "<head>", "</head>", "<b>", "</b>",  
				  			"<body>","</body>","<br>","<table>", "</table>", "<tr>", "</tr>", "<td>", "</td>" );
      	
  	   	
      	ArrayList<StringBuffer> s = new ArrayList<StringBuffer>();
 		// read in text as a string - add to ArrayList of StringBuffers
       	String text = kb.nextLine().trim();
      	while(!text.equals("")) {
      	  	s.add(new StringBuffer(text));
  	  	  	text = kb.nextLine().trim();
	  	}
	  	boolean done = false;
	  	while(!done) {
	  		int count = 0;		// count number of changes
	  		for(int i = 0; i < tags.size(); i++) {
	  			for(int j = 0; j < s.size(); j++) {
	  				String tag = tags.get(i);  // get tag from ArrayList tags
	  				if(s.get(j).indexOf(tag) >= 0) {
	  					int start = s.get(j).indexOf(tag);
	  					s.get(j).delete(start, start + tag.length());  // delete tag
	  			  		count++;
	  				}
	  			}
	  		}
	  		if(count == 0)			// no changes were made
	  			done = true;
	  	}	
	  	for(StringBuffer sb : s)
	  		if(sb.length()>0)	  // don't print blank lines
	  			out.println(sb);   		
   }
}

