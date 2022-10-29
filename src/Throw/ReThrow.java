package Throw;

public class ReThrow {
    public static void genException() {
        //The length of "number" exceeds the length of "denom"
        int[] number = {4, 8, 16, 32, 64, 128, 256, 512};
        int[] denom = {2, 0, 4, 4, 0, 8};

        for(int i =0;i<number.length;i++){
            try{
                System.out.println(number[i] + " / " +
                        denom[i] + " equals " +
                        number[i]/denom[i]);
            } catch (ArithmeticException exc) {
                //Intercept exception
                System.out.println("An attempt of dividing by zero");
            } catch (ArrayIndexOutOfBoundsException exc) {
                //Intercept exception
                System.out.println("An appropriate element was not found");
                throw exc; // repeat intercept exception
            }
        }
    }
}

class ReThrowDemo {
    public static void main(String[] args) {
//        try {
//            ReThrow.genException();
//        } catch (ArrayIndexOutOfBoundsException exc) {
//            //Again intercept exception
//            System.out.println("Fatal error - " +
//                    "program execution aborted!");
//        }
        ReThrow.genException();
    }
}