import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MainClass {

    public static void main(String[] args) throws IOException {

        FileReader fr = new FileReader("C:\\Users\\schue\\eclipse-workspace\\PraktischeInformatik2\\Abgabe4\\daten.txt");
        BufferedReader in = new BufferedReader(fr);
        int objCounter = Integer.parseInt(in.readLine());
        Mensch[] objectArray = new Mensch[objCounter];

        for (int i = 0; i < objCounter; i++) {
            //creates
            objectArray[i] = new Mensch(in.readLine(), Double.parseDouble(in.readLine()), Integer.parseInt(in.readLine()));
        }

        for (int i = 0; i < objectArray.length; i++) {
            objectArray[i].printAttributes();
        }

        fr.close();
        in.close();

    }

}
