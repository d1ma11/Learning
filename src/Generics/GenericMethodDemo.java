package Generics;

public class GenericMethodDemo {
    static <T extends Comparable<T>, V extends T> boolean arraysEqual(T[] x, V[] y) {
        // Массивы, имеющие разную длину, не могут быть одинаковыми
        if (x.length != y.length) return false;

        for (int i = 0; i < x.length; i++) {
            if (!x[i].equals(y[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Integer[] nums = {1,2,3,4,5};
        Integer[] nums1 = {1,2,3,4,5};
        Integer[] nums2 = {1,2,7,4,5};
        Integer[] nums3 = {1,2,7,4,5,6};

        if(arraysEqual(nums,nums))
            System.out.println("nums equals nums");

        if(arraysEqual(nums,nums1))
            System.out.println("nums equals nums1");

        if(arraysEqual(nums,nums2))
            System.out.println("nums equals nums2");

        if(arraysEqual(nums, nums3))
            System.out.println("nums equals nums3");

        Double[] dValues = {1.1,2.2,3.3,4.4,5.5};

        /* Следующая строка не будет скомпилирована, так как
        типы массивов nums и dValues не совпадают

        if (arraysEqual(nums,dValues))
            System.out.println("nums equals dValues");
         */
        }
}