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
                    List<int[]> list = new ArrayList<int[]>();
                    list.add(new int[]{i, j});
                    index.put(res, list);
                }
            }
        }

        for (int key : index.keySet()) {
            if (index.containsKey(target - key)) {
                for (int[] first : index.get(key)) {
                    for (int[] second : index.get(target - key)) {
                        if (second[0] > first[1]) {
                            List<Integer> res = Arrays.asList(
                                    num[first[0]], num[first[1]],
                                    num[second[0]], num[second[1]]);

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