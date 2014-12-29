public class Solution {
    public List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (num.length < 4) {
            return result;
        }

        Arrays.sort(num);
        Map<Integer, List<int[]>> index = new HashMap<Integer, List<int[]>>();
        Set<List<Integer>> uniqueRes = new HashSet<List<Integer>>();

        for (int i = 0; i < num.length; i++) {
            for (int j = i + 1; j < num.length; j++) {
                int res = num[i] + num[j];
                if (index.containsKey(res)) {
                    index.get(res).add(new int[]{i, j});
                } else {
                    List<int[]> set = new ArrayList<int[]>();
                    set.add(new int[]{i, j});
                    index.put(res, set);
                }
            }
        }

        for (int i = 0; i < num.length; i++) {
            for (int j = i + 1; j < num.length; j++) {
                int key = target - num[i] - num[j];
                if (index.containsKey(key)) {
                    for (int[] pairs : index.get(key)) {
                        if (i > pairs[1]) {
                            List<Integer> res = Arrays.asList(
                                    num[pairs[0]], num[pairs[1]], num[i], num[j]);

                            if (!uniqueRes.contains(res)) {
                                uniqueRes.add(res);
                                result.add(res);
                            }
                        }
                    }
                }
            }
        }

        return result;
    }
}