Randomized-Queues-and-Deques
============================
/**********************************************************************
 *  Randomized Queues and Deques
 **********************************************************************/

Name: Zhongjie Chen
NetID: zc22

Partner name: null
Partner NetID: null

Hours to complete assignment (optional):


/**********************************************************************
 *  Explain briefly how you implemented the randomized queue and deque.
 *  Which data structure did you choose (array, linked list, etc.)
 *  and why?
 **********************************************************************/

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

/**********************************************************************
 *  Describe whatever help (if any) that you received.
 *  Don't include readings, lectures, and precepts, but do
 *  include any help from people (including course staff, lab TAs,
 *  classmates, and friends) and attribute them by name.
 **********************************************************************/

 
/**********************************************************************
 *  If you did NOT work with a partner, please state below
 *  that you worked alone
 *  If you worked with a partner, assert below that you followed
 *  the protocol as described on the assignment page. Give one
 *  sentence explaining what each of you contributed.
 **********************************************************************/
 
 I work alone.




