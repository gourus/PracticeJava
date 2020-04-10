package leetcode.medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Question from Leetcode
 * 
 * @author sgouru
 *
 */

/* -----------------------------------
 *  WARNING:
 * -----------------------------------
 *  Your code may fail to compile
 *  because it contains public class
 *  declarations.
 *  To fix this, please remove the
 *  "public" keyword from your class
 *  declarations.
 */


//* Definition for singly-linked list.
  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
 
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode head = new ListNode(0);
        
        int carry = 0;
        
        ListNode temp = head;
        
        while ( l1 != null && l2 != null ) {
                
            int first = l1.val;
            int second = l2.val;
            
            int sum = first + second +carry;
            System.out.println(sum);
            temp.val = sum % 10;
            
            carry = sum / 10;
            
            l1 = l1.next;
            l2 = l2.next;
            
            if( l1 != null && l2 != null) {
                temp.next = new ListNode(0);
                temp = temp.next;
            }
        }
        
        if (l1 != null) {
            temp.next = new ListNode(0);
            temp = temp.next;
            temp.val = l1.val;
            temp.next = new ListNode(0);
            l1 = l1.next;
        }
        else if (l2 != null) {
            temp.next = new ListNode(0);
            temp = temp.next;
            temp.val = l2.val;
            temp.next = new ListNode(0);
            l2 = l2.next;
        }
        
        return head;
        
    }
}

public class SumTwoLinkedLists {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
          return new int[0];
        }
    
        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }
    
    public static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);
    
        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for(int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }
    
    public static String listNodeToString(ListNode node) {
        if (node == null) {
            return "[]";
        }
    
        String result = "";
        while (node != null) {
            result += Integer.toString(node.val) + ", ";
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            ListNode l1 = stringToListNode(line);
            line = in.readLine();
            ListNode l2 = stringToListNode(line);
            
            ListNode ret = new Solution().addTwoNumbers(l1, l2);
            
            String out = listNodeToString(ret);
            
            System.out.print(out);
        }
    }
}

