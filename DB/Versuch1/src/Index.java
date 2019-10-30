import java.util.Collections;

public class Index implements Comparable<Index>{
    private int artnr;
    private int offset;

    public Index(int artnr, int offset){
        this.artnr = artnr;
        this.offset = offset;
    }

    public String getLine(){
        return this.artnr+","+this.offset+"\n";
    }

    public int getArtnr() {
        return artnr;
    }

    public int getOffset() {
        return offset;
    }

    @Override
    public int compareTo(Index i) {
        return Integer.compare(this.artnr, i.artnr);
    }
}

