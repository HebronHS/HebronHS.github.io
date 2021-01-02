import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class same {
	public static void main(String[] args) throws FileNotFoundException{
		Scanner sc = new Scanner(new File("same.in"));
		int n = sc.nextInt();
		while(n-- > 0){
			String s1 = sc.next();
			String s2 = sc.next();
			System.out.println(check(new String[]{s1, s2}));
		}
	}
	public static String check(String[] words) 
	{ 
		int i , j , k , l , m , n , count = 0 ;
	 
	    n = words.length ;
	    for ( i = 0 ; i < n ; i ++ ) {
	    	for ( j = i+1 ; j < n ; j ++ )
	    	{
	    		int [] mapsto = new int [256] ;
	    		int [] mapsfrom = new int [256] ;
	    		boolean match = true ;
	    		for ( k = 0 ; k < words[i].length() ; k ++ )
	    		{
	    			if ( mapsto[words[i].charAt(k)] == 0 )
	    				mapsto[words[i].charAt(k)] = words[j].charAt(k) ;
	    			if ( mapsfrom[words[j].charAt(k)] == 0 )
	    				mapsfrom[words[j].charAt(k)] = words[i].charAt(k) ;
	    			if ( mapsto[words[i].charAt(k)] != words[j].charAt(k) )
	    				match = false ;
	    			if ( mapsfrom[words[j].charAt(k)] != words[i].charAt(k) )
	    				match = false ;
	    		}
	    		if ( match ) 
	    			return "SAME";
	       }
	    }
	    return "USELESS";
	}
}
