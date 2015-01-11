/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode *addTwoNumbers(ListNode *l1, ListNode *l2) {
        int carry = 0;  
        ListNode* head = new ListNode(0);  
        ListNode* ptr = head;  
          
        while(l1 != NULL || l2 != NULL){  
            int val1 = 0;  
            if(l1 != NULL){  
                val1 = l1->val;  
                l1 = l1->next;  
            }  
              
            int val2 = 0;  
            if(l2 != NULL){  
                val2 = l2->val;  
                l2 = l2->next;  
            }  
              
            int tmp = val1 + val2 + carry;  
            ptr->next = new ListNode(tmp % 10);  
            carry = tmp / 10;  
            ptr = ptr->next;  
        }  
          
        if(carry == 1){  
            ptr->next = new ListNode(1);  
        }  
        return head->next;  
        
    }
};