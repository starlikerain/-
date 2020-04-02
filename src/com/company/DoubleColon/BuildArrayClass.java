package com.company.DoubleColon;

public class BuildArrayClass {
    public static int[] createArray(int len, Arraybuilder arrayBuilder) {
        return arrayBuilder.arrayBuilder(len);
    }

    public static void main(String[] args) {
        int[] arr1 = createArray(9, int[]::new);

        System.out.println(arr1.length);


        int[] arr2 = createArray(8, int[]::new);
        System.out.println(arr2.length);
    }
}
