package sort;

public class Test {
    public static void main(String[] args) {
        //int[] num = {};
        //int[] num = {2};
        int[] num = {13, 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51};
        Solution solution = new SelectSort();

        for (int i : solution.sort(num)) {
            System.out.print(i + " ");
        }
    }
}
