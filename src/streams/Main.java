package streams;

/**
 * Created by User on 22.10.2015.
 */
public class Main {
    public static void main(String[] args) throws Throwable{
        int b;
        int z = -1;
        System.out.println((int)'Ы');
        //int[] bytes = {123, 0, 13, 10, 123, 10, 13};
        while((b = System.in.read()) > 0){
        //for(int i = 0; i < bytes.length; i++){
        //    b = bytes[i];
            if(z == 13){
                if(b == 10){
                    System.out.write(b);
                    z = -1;
                }
                else if(b == 13){
                    System.out.write(b);
                }
                else{
                    System.out.write(z);
                    System.out.write(b);
                    z = -1;
                }
            }
            else{
                if(b == 13){
                    z = 13;
                }
                else{
                    System.out.write(b);
                }
            }

        }
        if(z == 13) System.out.write(z);


    }
}
