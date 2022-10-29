package ExcpetionHandling;

class ExcDemo4 {
    public static void main(String[] args) {
        // The length of the array "number" exceeds the length of the array "denom"
        int[] number = {4, 8, 16, 32, 64, 128, 256, 512};
        int[] denom = {2, 0, 4, 4, 0, 8};

        for(int i = 0;i< number.length;i++) {
            try {
                System.out.println(number[i] + " / " +
                        denom[i] + " equals " +
                        number[i]/denom[i]);
            } catch (ArithmeticException exc) {
                // Intercept exception
                System.out.println("An attempt of dividing by zero!");
            } catch (ArrayIndexOutOfBoundsException exc) {
                // Intercept exception
                System.out.println("Appropriate element was not found");
            }
        }
    }
}
