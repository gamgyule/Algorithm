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
// 중간값을 구한 후 리스트 리버스를한 후 값이 같은지 확인하기