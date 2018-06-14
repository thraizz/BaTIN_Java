
interface GList {
	int getLength(); //liefert die Länge der Liste.
	Object insertLast(int value); //fügt value am Ende der List ein.
	Object getFirst(); //liefert das erste Element der Liste.
	Object deleteFirst(); //entfernt das erste Element von der Liste.
	boolean search(Object value); //prüft, ob der Wert in der Liste vorhanden ist.
	void print(); //zeigt den Inhalt der Liste an. 
}
