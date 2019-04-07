package com.anand.array;

public class BinarySearch {
    private int[] array;

    public BinarySearch(int[] array) {
        this.array = array;
    }

    public int searchElement(int n, int start, int end) {
        int middleIndex = (start + end) / 2;

        if (array[middleIndex] == n) {
            return middleIndex;
        } else if (array[middleIndex] > n) {
            return searchElement(n, start, middleIndex);
        } else {
            return searchElement(n, middleIndex, end);
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 4, 5, 8, 22, 45};
        BinarySearch binarySearch = new BinarySearch(array);
        System.out.println(binarySearch.searchElement(22, 0, array.length));
    }
}
