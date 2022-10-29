package ExcpetionHandling;

public class NestTries {
    public static void main(String[] args) {
        //The length of "number" exceeds the length of "denom"
        int[] number = {4, 8, 16, 32, 64, 128, 256, 512};
        int[] denom = {2, 0, 4, 4, 0, 8};

        try { //outer block
            for(int i =0;i<number.length;i++) {
                try { //inner block
                    System.out.println(number[i] + " / " +
                            denom[i] + " equals " +
                            number[i] / denom[i]);
                } catch (ArithmeticException exc) {
                    //Intercept exception
                    System.out.println("An attempt of dividing by zero");
                }
            }
        } catch (ArrayIndexOutOfBoundsException exc) {
            //Intercept exception
            System.out.println("An appropriate element was not found");
            System.out.println("Fatal error - program execution aborted");
        }
    }
}
