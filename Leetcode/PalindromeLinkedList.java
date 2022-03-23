import java.util.Stack;
class Solution {
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<>();

        ListNode nextNode = head;
        ListNode firstNode = head;
        while (nextNode != null && nextNode.next != null) {
            stack.add(nextNode.val);
            nextNode = nextNode.next;
        }

        if (firstNode.val != nextNode.val) {
            return false;
        }

        while (firstNode.next != null) {
            firstNode = firstNode.next;
            if (firstNode.val != stack.pop()) {
                return false;
            }
        }
        return true;
    }
}

// 이중포인터 런너를 사용해서 중간위치 구해보기
// 중간값을 구한 후 리버스하고 서로 비교

// class Solution {
//     public static ListNode reverseNode(ListNode head) {
//         if (head == null && head.next == null)
//             return head;

//         ListNode prev = null;
//         while (head != null) {
//             ListNode temp = head.next;
//             head.next = prev;
//             prev = head;
//             head = temp;
//         }
//         return prev;
//     }
//     public boolean isPalindrome(ListNode head) {
//         ListNode slow = head, fast = head;
//         while (fast != null && fast.next != null) {
//             slow = slow.next;
//             fast = fast.next.next;
//         }
//         ListNode reverseHead = null;

//         reverseHead = reverseNode(slow);

//         while (head != null && reverseHead != null) {
//             if (head.val != reverseHead.val) {
//                 return false;
//             }
//             head = head.next;
//             reverseHead = reverseHead.next;
//         }

//         return true;
//     }
// }