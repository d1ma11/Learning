package MultiCatch;
//Using a group exception capture tool
//note: to compile this code JDK7 required
//or later version of developer set
public class MultiCatch {
    public static void main(String[] args) {
        int a = 88, b = 0;
        int result;
        char[] chrs = {'A','B','C'};

        for(int i= 0;i<2;i++){
            try {
                if(i==0) {
                    //Generate ArithmeticException
                    result = a/b;
                } else {
                    //Generate ArrayIndexOutOfBoundsException
                    chrs[5] = 'X';
                }
            }
            //both exception intercept
            // is organized in this operator 'catch'
            catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Intercepted exception: " + e);
            }
        }
        System.out.println("After group exception capture");
    }
}
