package manager;

import dbObjekte.Kunde;

import java.io.*;
import java.util.ArrayList;

public class CSVManager {
    //private String path;
    private ArrayList<Kunde> kunde;

    public CSVManager(BufferedReader fr) throws IOException {
        //assert this.path != null;
        BufferedReader f = fr;
        String line;
        this.kunde = new ArrayList<>();
        int i = 0;
        while ((line = f.readLine()) != null) {
            String[] o = line.split(",");
            kunde.add(new Kunde(i, o[0], Integer.parseInt(o[1]), o[2], o[3]));
        }
    }

    public ArrayList<Kunde> getKunden() {
        return this.kunde;
    }

//    public void printKunden() {
//        for (Kunde kunde : this.kunde) {
//            System.out.println(kunde.getFormattedAttributes());
//        }
//    }
}
