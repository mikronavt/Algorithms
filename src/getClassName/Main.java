package getClassName;

/**
 * Created by User on 06.10.2015.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(getCallerClassAndMethodName());
        kukarek();
    }

    public static void kukarek(){
        System.out.println(getCallerClassAndMethodName());
    }

    public static String getCallerClassAndMethodName() {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        if(stackTraceElements.length < 4) return null;
        else {
            StackTraceElement s = stackTraceElements[3];

            // your implementation here
            return s.getClassName() + "#" + s.getMethodName();
        }
    }
}
