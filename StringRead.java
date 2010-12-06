import java.io.*;

public class StringRead {

   public static String read () {
      //  open up standard input
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      String input = null;
      try {
         input = br.readLine();
      } catch (IOException ioe) {
         System.out.println("IO error trying to read input");
         System.exit(1);
      }
	  return input;
   }
}

