package Finally;

//Using "finally" block
public class UseFinally {
    public static void genException(int what) {
        int t;
        int[] nums = new int[2];

        System.out.println("Received: " + what);
        try {
            switch (what) {
                case 0 -> t = 10 / what; //generate an error (dividing by zero)
                case 1 -> nums[4] = 4; //generate an error (index is out of array range
                case 2 -> {
                    return; //return from block "try"
                }
            }
        } catch (ArithmeticException exc) {
            //Intercept exception
            System.out.println("An attempt of dividing by zero");
            return; // return from block "catch"
        } catch (ArrayIndexOutOfBoundsException exc) {
            //Intercept exception
            System.out.println("An appropriate element was not found");
        } finally {
            System.out.println("Exit from block 'try'");
        }
    }
}

class FinallyDemo {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            UseFinally.genException(i);
            System.out.println();
        }
    }
}