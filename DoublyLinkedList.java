class DNode {
    int data;
    DNode prev, next;

    DNode(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class DoublyLinkedList {
    DNode head;

    public void insertAtBeginning(int data) {
        DNode newNode = new DNode(data);
        if (head != null) {
            newNode.next = head;
            head.prev = newNode;
        }
        head = newNode;
    }

    public void insertAtEnd(int data) {
        DNode newNode = new DNode(data);
        if (head == null) {
            head = newNode;
            return;
        }
        DNode temp = head;
        while (temp.next != null) temp = temp.next;
        temp.next = newNode;
        newNode.prev = temp;
    }

    public void insertAtPosition(int pos, int data) {
        if (pos == 1) {
            insertAtBeginning(data);
            return;
        }
        DNode newNode = new DNode(data);
        DNode temp = head;
        for (int i = 1; i < pos - 1 && temp != null; i++) temp = temp.next;
        if (temp == null) {
            System.out.println("Invalid Position");
            return;
        }
        newNode.next = temp.next;
        if (temp.next != null) temp.next.prev = newNode;
        temp.next = newNode;
        newNode.prev = temp;
    }

    public void deleteAtBeginning() {
        if (head != null) {
            head = head.next;
            if (head != null) head.prev = null;
        }
    }

    public void deleteAtEnd() {
        if (head == null || head.next == null) {
            head = null;
            return;
        }
        DNode temp = head;
        while (temp.next != null) temp = temp.next;
        temp.prev.next = null;
    }

    public void deleteAtPosition(int pos) {
        if (pos == 1) {
            deleteAtBeginning();
            return;
        }
        DNode temp = head;
        for (int i = 1; i < pos && temp != null; i++) temp = temp.next;
        if (temp == null) {
            System.out.println("Invalid Position");
            return;
        }
        if (temp.prev != null) temp.prev.next = temp.next;
        if (temp.next != null) temp.next.prev = temp.prev;
    }

    public void display() {
        DNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ⇄ ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insertAtBeginning(100);
        list.insertAtEnd(200);
        list.insertAtPosition(2, 150);
        list.display();

        list.deleteAtBeginning();
        list.display();

        list.deleteAtEnd();
        list.display();

        list.deleteAtPosition(1);
        list.display();
    }
}
