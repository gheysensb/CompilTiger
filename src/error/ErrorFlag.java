package error;

public class ErrorFlag {

    private static boolean error=false;

    public static void raiseError(){
        ErrorFlag.error=true;
    }

    public static boolean getError(){
        return ErrorFlag.error;
    }

}
