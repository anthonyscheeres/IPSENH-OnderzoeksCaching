package Ipsenh.onderzoek;


public class App {
    
    public static void main(String[] args) {
    	
		   try {
			Program program = new Program(Integer.parseInt(args[0]), 100 );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
    
}
