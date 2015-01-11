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
    ListNode *reverseBetween(ListNode *head, int m, int n) {
        ListNode* p = new ListNode(-1);  
        p->next = head;  
          
        ListNode* hook = p;  
          
        int cnt = m - 1;  
        while(cnt > 0)  
        {  
            p = p->next;  
            cnt--;  
        };  
          
        ListNode * cur = p->next;  
        p->next = NULL;  
          
        cnt = n - m + 1;  
        while(cnt-- > 0)  
        {  
            ListNode * t = cur->next;  
            cur->next = p->next;  
            p->next = cur;  
              
            cur = t;  
        };  
          
        while(p->next != NULL)  
        {  
            p = p->next;  
        };  
          
        if(cur != NULL)  
        {  
            p->next = cur;  
        };  
          
       
          
        return hook->next;  
        
    }
};