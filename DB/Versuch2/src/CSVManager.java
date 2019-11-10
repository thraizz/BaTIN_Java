import db.Kunde;

import java.io.*;
import java.util.ArrayList;

public class CSVManager {
    private String path;
    private ArrayList<Kunde> k;

    public CSVManager(String path) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader(this.path));
        String line;
        this.k = new ArrayList<>();
        int i = 0;
        while((line = f.readLine()) != null) {
            String[] o = line.split(",");
            k.add(new Kunde(i, o[0], Integer.parseInt(o[1]), o[2], o[3]));
        }
    };

    public ArrayList<Kunde> getKunden() {
        return this.k;
    }

    public void printKunden(){
        for (Kunde kunde : this.k) {
            System.out.println(kunde.getFormattedAttributes());
        }
    }
}
