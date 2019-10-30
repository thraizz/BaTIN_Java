public class Index {
    private int artnr;
    private int offset;

    public Index(int artnr, int offset){
        this.artnr = artnr;
        this.offset = offset;
    }
    public String getLine(){
        return this.artnr+","+this.offset;
    }
}

