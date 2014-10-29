Randomized-Queues-and-Deques
============================
Name: Zhongjie Chen
NetID: zc22

Deque is implemented via linked list, since it can guarantee operations
accomplished in O(1) time for worst cases, which is proposed as a perf-
ormance requirement of deque in the assignment. Implementation of deque
has two pointers, first points to the front and last points to the tail, 
node needs prev and next pointers because removelast() calls for the 
node previous to the tail. Besides, to release the memory, we should pay
attention to cleaning a useless object reference, that is prev and next
are both set to null after an element has been taken.

Randomized queue is imlemented via array since linked list. Random ope-
ration is required for swaping node to [size-1] and shuffle the index of
the array. 







