package Throw;
//Using methods of Throwable class
public class ExcTest {
    static void genException() {
        int[] nums = new int[4];
        System.out.println("Before genException");

        //Generate exception due to
        //index out of array bound
        nums[7] = 10;
        System.out.println("This line will not show");
    }
}

class UseThrowableMethods {
    public static void main(String[] args) {
        try {
            ExcTest.genException();
        } catch (ArrayIndexOutOfBoundsException exc) {
            //Intercept exception
            System.out.println("Standard message: ");
            System.out.println(exc);
            System.out.println("\nMethods stack: ");
            exc.printStackTrace();
        }
        System.out.println("After operator catch");
    }
}
