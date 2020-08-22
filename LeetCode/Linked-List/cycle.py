# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def hasCycle(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
        my_set = set()
        while (head is not None):
            if head in my_set:
                return True
            my_set.add(head)
            head = head.next
        return False
        
        # Tortoise and Hare
    # def hasCycle(self, head):
    # """
    # :type head: ListNode
    # :rtype: bool
    # """
    # slow = head
    # fast = head
    # while True:
    #     if fast is None or fast.next is None or fast.next.next is None:
    #         return False;
    #     slow = slow.next
    #     fast = fast.next.next
    #     if fast == slow:
    #         return True
    # return True