public class InitException extends NullPointerException {
    private String trouble  = " не проинициализировано";
    InitException(){
        trouble = "Непроинициализированная сущность";
    }
    InitException(String s){
        super(s);
        trouble = s + trouble;
    }
    InitException(String s, String s1){
        super(s);
        trouble = s + s1;
    }
    public String getE() {
        return trouble;
    }
}