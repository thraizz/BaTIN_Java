import java.io.*;

public class MainClass {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Input/Output:");
        System.out.println("--------------------------------------------------------------");
        // Create filereader, bufferedreader, count objects and initialize array with space for all objects

        FileReader fr = new FileReader("daten.txt");
        BufferedReader in = new BufferedReader(fr);
        int objCounter = Integer.parseInt(in.readLine());
        Mensch[] objectArray = new Mensch[objCounter];

        // Fill array at index i with parsed values
        for (int i = 0; i < objCounter; i++) {
            //creates
            objectArray[i] = new Mensch(in.readLine(), Double.parseDouble(in.readLine()), Integer.parseInt(in.readLine()));
        }

        // Close the stream
        fr.close();
        in.close();

        // Use printAttributes method to print read objects
        for (int i = 0; i < objectArray.length; i++) {
            objectArray[i].printAttributes();
        }
        System.out.println("Serialized:");
        System.out.println("--------------------------------------------------------------");
        System.out.println("");

        // Create fileoutputstream and let objectoutputstream use it
        FileOutputStream out = new FileOutputStream("daten2.txt");
        ObjectOutputStream objout = new ObjectOutputStream(out);

        // Write all created objects serialized into file, close the stream
        for (Mensch mensch : objectArray) {
            objout.writeObject(mensch);
        }

        // Close the streams
        out.close();
        objout.close();


        // Create readers for the new file and array for its content
        ObjectInputStream objin = new ObjectInputStream(new FileInputStream("daten2.txt"));
        Mensch[] objectArray2 = new Mensch[objCounter];

        // Cheat and use objcounter as value of how many objects should be printed
        for (int i = 0; i < objCounter; i++) {
            objectArray2[i] = (Mensch) objin.readObject();
        }

        for (int i = 0; i < objectArray2.length; i++) {
            objectArray2[i].printAttributes();
        }




    }

}
