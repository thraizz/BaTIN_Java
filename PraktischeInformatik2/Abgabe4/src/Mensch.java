import java.io.Serializable;

public class Mensch implements Serializable {
	
	private String name;
	private double groesse;
	private int alter;

    public Mensch(String name, double groesse, int alter) {
		this.name=name;
		this.groesse=groesse;
		this.alter=alter;
	}
	
	public void printAttributes() {
		System.out.println("Name: "+this.name);
		System.out.println("Groesse: "+this.groesse);
		System.out.println("Alter: "+this.alter);
	}
	
}
