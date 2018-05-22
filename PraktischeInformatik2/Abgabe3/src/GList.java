
interface GList {
	int getLength(); //liefert die L�nge der Liste.
	Object insertLast(int value); //f�gt value am Ende der List ein.
	Object getFirst(); //liefert das erste Element der Liste.
	Object deleteFirst(); //entfernt das erste Element von der Liste.
	boolean search(Object value); //pr�ft, ob der Wert in der Liste vorhanden ist.
	void print(); //zeigt den Inhalt der Liste an. 
}
