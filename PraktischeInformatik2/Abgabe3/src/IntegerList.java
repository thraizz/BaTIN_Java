
interface IntegerList {
	int getLength(); //liefert die Länge der Liste.
	int insertLast(int value); //fügt value am Ende der List ein.
	int getFirst(); //liefert das erste Element der Liste.
	int deleteFirst(); //entfernt das erste Element von der Liste.
	boolean search(int value); //prüft, ob der Wert in der Liste vorhanden ist.
	void print(); //zeigt den Inhalt der Liste an. 
}
