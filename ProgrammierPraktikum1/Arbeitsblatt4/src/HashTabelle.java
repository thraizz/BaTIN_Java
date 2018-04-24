import java.io.* ;

public class HashTabelle{
	// Einziges notwendiges Attirbut ist die Größe.
	private int arrayGroesse;
	
	// Das Array wird als klassenvariable initialisiert.
	private String[] hashArray = new String[arrayGroesse];
	
	// Konstruktor 1
	public HashTabelle(int arrayGroesse){
		this.hashArray = new String[arrayGroesse];
	}
	
	// Methode 1
	public boolean store(String string) {
		int hashwert = 0;
		int hashArrayLength = this.hashArray.length;
		for(int i = 0; i<string.length(); i++) {
			hashwert += (char) string.charAt(i);
		}
		hashwert = hashwert % hashArrayLength;
		
		if(this.hashArray[hashwert]==null && hashArrayLength>0) {
			this.hashArray[hashwert] = string;
			return true;
		}
		else{
			return false;
		}
	}
	
	// Methode 2
	public int search(String string) {
		int position = -1;
		int hashwert = 0;
		int hashArrayLength = this.hashArray.length;
		for(int i = 0; i<string.length(); i++) {
			hashwert += (char) string.charAt(i);
		}
		hashwert = hashwert % hashArrayLength;
		if(string.equals(this.hashArray[hashwert])) {
			position = hashwert;
		}
		return position;
	}
	
	// Methode 3
	public void delete(String string) {
		int position = this.search(string);
		if(position!=-1) {
			this.hashArray[position] = null;
		}
	}
	
	public static void main(String args[])throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int choice = 0;
		System.out.println("Welche Größe soll das Array haben ?");
		int arrayGroesse = Integer.parseInt(in.readLine());
		HashTabelle tabelle = new HashTabelle(arrayGroesse);
		
		do {
			  
		    System.out.println();
		    System.out.println("Bitte waehlen:");
		    System.out.println("(1) String speichern.");
		    System.out.println("(2) String suchen.");
		    System.out.println("(3) String löschen.");
		    System.out.println("(0) Ende");
		    choice = Integer.parseInt(in.readLine());
		    System.out.println();

		    switch (choice) {
		    
		      case 1:
		    	  System.out.println("Bitte den zu speichernden String eingeben.");
		    	  String string = in.readLine();
		    	  if(tabelle.store(string)) {
		    		  System.out.println(string+" wurde gespeichert !");
		    		  }
		    	  else {
		    		  System.out.println("Achtung, "+string+" konnte nicht gespeichert werden!");
		    	  }
		    	  break;

		      case 2:
		    	  System.out.println("Bitte den zu suchenden String eingeben.");
		    	  String eingabe = in.readLine();
		    	  int position = tabelle.search(eingabe);
		    	  if(position != -1) {
		    		  System.out.println("Der String " + eingabe + " wurde beim Index " + position + " gefunden.");
		    	  }
		    	  else if(position == -1) {
		    		  System.out.println("Der String " + eingabe + " wurde nicht gefunden.");
		    	  }
		    	  break;

		      case 3:
		    	  System.out.println("Welcher String soll gelöscht werden ?");
		    	  eingabe = in.readLine();
		    	  tabelle.delete(eingabe);
		    	  break;
		    	  }
		    
		    } while (choice!=0);
		}
	}
