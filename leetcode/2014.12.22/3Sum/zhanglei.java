public class Solution {
    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (num.length < 3) {
            return result;
        }

        Arrays.sort(num);

        for (int i = 0; i < num.length - 2; i++) {
            if (i == 0 || num[i] > num[i - 1]) {
                int j = i + 1;
                int k = num.length - 1;
                while (j < k) {
                    int sum = num[i] + num[j] + num[k];
                    if (sum == 0) {
                        List<Integer> turple = Arrays.asList(num[i], num[j],
                                num[k]);
                        result.add(turple);
                        j++;
                        k--;

                        while (j < k && num[k] == num[k + 1])
                            k--;

                        while (j < k && num[j] == num[j - 1])
                            j++;
                    } else if (sum < 0)
                        j++;
                    else
                        k--;
                }
            }
        }
        return result;
    }
}