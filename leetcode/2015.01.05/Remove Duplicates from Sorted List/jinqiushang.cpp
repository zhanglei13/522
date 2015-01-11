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
    ListNode *deleteDuplicates(ListNode *head) {
        if(head == NULL){  
            return NULL;  
        } 
        ListNode *p=head;
        ListNode *q=p->next;
        while(q!=NULL){
            if(p->val==q->val){
                p->next=q->next;
                delete q;
                q=p->next;
            }
            else{
                p=q;
                q=q->next;
            }
            
        }
        return head;
        
    }
};