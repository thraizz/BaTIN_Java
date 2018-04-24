import java.io.*;
public class Portnummern {

 public static void main(String[] args) throws IOException
 {
	 
 int port = 1;
 String eingabe;
 BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

 
 
  do{
  System.out.println();
  System.out.println("Das Programm wird nun ihren Port prüfen. Die Eingabe 'stop' beendet das Programm.");
  System.out.println("Bitte Portnummer eingeben: ");
  eingabe = in.readLine();
  
  if(eingabe.matches("stop")) {
	  System.out.println("Das Programm wird beendet.");
//	  break;
  }
  
  else{
	  port = Integer.parseInt(eingabe);
  
  if(0 <= port && port <= 1023){
   System.out.println("Der eingegebene Port ist ein 'well-known' Port.");
  }
  
  else if(1024 <= port && port <= 49151){
   System.out.println("Der eingegebene Port ist ein 'registered' Port.");
  }
  
  else if(49152 <= port && port <= 65535){
   System.out.println("Der eingegebene Port ist ein 'dynamic' Port.");
   }
	 
  else {
   System.out.println("Sonstiger Dienst.");
   }
  }
  
 }while(!eingabe.matches("stop"));
 }
 

}