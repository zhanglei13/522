public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();

        RandomListNode result = new RandomListNode(0);
        RandomListNode current = result;
        RandomListNode p = head;

        while (p != null) {
            current.next = map.containsKey(p) ? map.get(p) : new RandomListNode(p.label);
            map.put(p, current.next);
            current.next.random = (p.random == null) ? null : (map.containsKey(p.random) ? map.get(p.random) : new RandomListNode(p.random.label));
            map.put(p.random, current.next.random);
            p = p.next;
            current = current.next;
        }

        return result.next;
    }
}
