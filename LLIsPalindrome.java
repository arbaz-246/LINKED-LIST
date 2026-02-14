public class LLIsPalindrome {

    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node head;
    public Node tail;

    // Add at last
    public void addLast(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }

    // Print Linked List
    public void print() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Find Middle
    public Node FindMid(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Check Palindrome
    public boolean CheckPalindrome() {

        if (head == null || head.next == null) {
            return true;
        }

        // Step 1: Find mid
        Node midNode = FindMid(head);

        // Step 2: Reverse second half
        Node prev = null;
        Node curr = midNode;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node right = prev; // reversed half
        Node left = head;

        // Step 3: Compare
        while (right != null) {
            if (left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;
    }

    // Main method
    public static void main(String[] args) {

        LLIsPalindrome ll = new LLIsPalindrome();

        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(2);
        ll.addLast(1);

        ll.print();

        if (ll.CheckPalindrome()) {
            System.out.println("LL is Palindrome");
        } else {
            System.out.println("LL is NOT Palindrome");
        }
    }
}
