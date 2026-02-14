public class RemoveCycleInLL {

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;

    public static void RemoveCycle() {

        // Step 1: Detect Cycle
        Node slow = head;
        Node fast = head;
        boolean cycle = false;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                cycle = true;
                break;
            }
        }

        if (!cycle) {
            return;
        }

        // Step 2: Find start of cycle
        slow = head;
        Node prev = null;

        while (slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }

        // Step 3: Remove cycle
        prev.next = null;
    }

    public static void main(String args[]) {

        head = new Node(1);
        Node temp = new Node(2);

        head.next = temp;
        head.next.next = new Node(3);
        head.next.next.next = temp; // creating cycle

        RemoveCycle();

        System.out.println("Cycle Removed Successfully");
    }
}
