public class ListNode {
  int val;
  ListNode next;
  ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        
        ListNode current = head;
        
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                // Skip the next node since it's a duplicate
                current.next = current.next.next;
            } else {
                // Move to the next distinct element
                current = current.next;
            }
        }
        
        return head;
    }

  // Helper method to create a linked list from an array
  public static ListNode createList(int[] arr) {
      ListNode dummy = new ListNode(0);
      ListNode current = dummy;
      for(int num : arr) {
          current.next = new ListNode(num);
          current = current.next;
      }
      return dummy.next;
  }

  // Helper method to print the linked list
  public static void printList(ListNode head) {
      ListNode current = head;
      while(current != null) {
          System.out.print(current.val);
          if(current.next != null) System.out.print(" -> ");
          current = current.next;
      }
      System.out.println();
  }

  // Example usage
  public static void main(String[] args) {
      Solution sol = new Solution();
      
      // Example for Problem 83
      int[] arr1 = {1, 1, 2};
      ListNode head1 = createList(arr1);
      System.out.print("Original List: ");
      printList(head1);
      ListNode result1 = sol.deleteDuplicates(head1);
      System.out.print("After Removing Duplicates: ");
      printList(result1);
      
      // Example for Problem 82
      // Uncomment the appropriate deleteDuplicates method before running
      /*
      int[] arr2 = {1, 2, 3, 3, 4, 4, 5};
      ListNode head2 = createList(arr2);
      System.out.print("Original List: ");
      printList(head2);
      ListNode result2 = sol.deleteDuplicates(head2);
      System.out.print("After Removing All Duplicates: ");
      printList(result2);
      */
  }
}
