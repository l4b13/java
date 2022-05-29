public class BasicException extends Exception {
    private String e;
    BasicException(String s){
        super(s);
        e = s;
    }
    public String getE() {
        return e;
    }
}