
public interface GList<T> {
	int getLength(); //liefert die Laenge der Liste.
	int insertLast(T value); //fuegt value am Ende der List ein.
	<T> T getFirst(); //liefert das erste Element der Liste.
	int deleteFirst(); //entfernt das erste Element von der Liste .
	boolean search(T value); //prueft, ob der generische Wert value in der Liste vorhanden ist.
	void print(); //zeigt den Inhalt der Liste an. 
}
