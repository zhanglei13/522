public class Solution {
    public List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (num.length < 4) {
            return result;
        }

        Set<List<Integer>> set = new HashSet<List<Integer>>();
        Arrays.sort(num);

        for (int i = 0; i < num.length; i++) {
            for (int j = i + 1; j < num.length; j++) {
                int start = j + 1;
                int end = num.length - 1;

                while (start < end) {
                    int sum = num[i] + num[j] + num[start] + num[end];
                    if (sum == target) {
                        List<Integer> turple = Arrays.asList(
                                num[i], num[j], num[start], num[end]);

                        if (!set.contains(turple)) {
                            set.add(turple);
                            result.add(turple);
                        }

                        start++;
                        end--;
                    } else if (sum > target) {
                        end--;
                    } else
                        start++;
                }
            }
        }

        return result;
    }
}