import java.io.*;

public class StackHauptklasse {

	protected int top;
	protected int[] stackArray;

	public StackHauptklasse(int groesse) {
		this.stackArray = new int[groesse];
		this.top = -1;

	}

	public int push(int ablagewert) {
		if (this.top + 1 <= this.stackArray.length) {
				this.stackArray[this.top + 1] = ablagewert;
				this.top++;
				return 0;
			
		} else {
			return -1;
		}
	}

	public int pop() {
		if (this.top > 0) {
			this.top = this.top - 1;
			return this.stackArray[this.top+1];
		} else {
			return -1;
		}

	}

	public void printStack() {
		for (int i = this.top; i >= 0; i--) {
			if (i == this.top) {
				System.out.println("Oberstes Element: " + this.stackArray[i]);
			}
			else {
				System.out.println("Naechstes Element: " + this.stackArray[i]);
			}
		}
		if(this.top==-1) {
			System.out.println("Der Stack ist leer");
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Ein Stack mit der Laenge 7 und dem Startwert 1 wird erzeugt.");
		StackSubklasse testSubklasse = new StackSubklasse(7, 1);


		int choice = 0;

		do {
			System.out.println();
			System.out.println("Bitte waehlen:");
			System.out.println("(1) Zahl hinzufuegen");
			System.out.println("(2) Demo-Array hinzufuegen");
			System.out.println("(3) Wert entfernen");
			System.out.println("(4) Stack anzeigen");
			System.out.println("(5) Stack auf Inhalt pruefen");
			System.out.println("(6) Mehrere Werte entfernen");
			System.out.println("(0) Ende");
			choice = Integer.parseInt(in.readLine());
			System.out.println();

			switch (choice) {

			case 1:
				System.out.println("Bitte geben Sie den Wert ein");
				int exitcode = testSubklasse.push(Integer.parseInt(in.readLine()));
				if (exitcode == -1) {
					System.out.println("Der Wert konnte nicht gespeichert werden, da der Stack voll ist.");
				}
				break;
			case 2:
				System.out.println("Das Demo-Array {4,2,3} wird dem Stack hinzugefuegt.");
				int[] demoArray = {4,2,3};
				if(testSubklasse.push(demoArray)==-1) {
					System.out.println("Das Array konnte dem Stack nicht hinzugefuegt werden, da der Platz fehlt.");
				}
				else {
					System.out.println("Das Array wurde dem Stack hinzugefuegt.");
				}
			
			case 3:
				int returnValue = testSubklasse.pop();
				if(returnValue!=-1) {
					System.out.println("Der oberste Wert war " + returnValue + " und wurde entfernt.");
				}
				else {
					System.out.println("Das Array ist leer.");
				}
				break;

			case 4:
				testSubklasse.printStack();
				break;
				
			case 5:
				if(testSubklasse.isStackEmpty()) {
					System.out.println("Der Stack ist leer.");
				}
				else {
					System.out.println("Der Stack ist nicht leer.");
				}
				break;
			
			case 6:
				System.out.println("Wie viele Werte sollen entfernt werden?");
				int n = Integer.parseInt(in.readLine());
				int returnWert = testSubklasse.pop(n);
				if(returnWert==-1) {
					System.out.println("Die Werte konnten nicht entfernt werden.");
				}
				else {
					System.out.println("Die Werte wurden entfernt, "+returnWert+" war der letzte Wert.");
				}
			}
		} while (choice != 0);
	}
}
