package stratego;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;

import javax.swing.JTextField;


/***
 * This class servers as a conversation connection for messages and moves
 * between the players
 * 
 * @author Delbaen Lionel
 * 
 */
public class Messages implements Runnable{

	JTextField input; 
	
	public Messages() throws IOException {

		System.out.println("Player 1 will go first"); 
		
		//converting the input stream to a string 
		Messages ists= new Messages();    
		InputStream is = Client.getSocketInputStream(); 
		String a = ists.convertinputStreamToString(is);
		
		//deciphering between messages and moves 
		//0 signifies a move -- handling a move 
		if(a.startsWith("0")){
			
		}
		//1 specifies a message-- should just be printed to the player
		if(a.startsWith("1")){
			System.out.println(a); 
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	public JTextField input(){
		return input; 
	}

	/***
	 * Converts the input stream to a string 
	 * @param is
	 * @return
	 * @throws IOException
	 */
	
	public String convertinputStreamToString(InputStream is)
			throws IOException {

		if (is != null) {
			Writer writer = new StringWriter(); 
			
			char[] buffer = new char[1024]; 
			try{
				Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
				int n; 
				while((n = reader.read(buffer)) != -1){
					writer.write(buffer, 0, n);
				}//end while
			} finally{
				is.close(); 
			}
			return writer.toString(); 
			
		} else{
			return ""; 
		}
	}//end method 
	
	
}// end class


