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
            Kunde k;
            try{
                int plz = Integer.parseInt(o[1]);
                if(plz>0){
                    k = new Kunde(i, o[0], plz, o[2], o[3]);
                }
                else{
                    System.out.println("Kunde in Zeile "+(i+1)+" enthält ungültige Werte.");
                    k = null;
                }
            }
            catch(Exception e){
                System.out.println("Kunde in Zeile "+(i+1)+" enthält ungültige Werte.");
                k = null;
            }
            if(k != null){
                kunde.add(k);
            }
            i++;
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
