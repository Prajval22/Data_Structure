public class Main {
    public static void main(String args[]){
        Node head = null;
        head = Node.insert(10,head);
        head = Node.insert(800,head);
        head = Node.insert(320,head);
        head = Node.insertAtPosition(40, 3, head);
        head = Node.insertAtPosition(156, 4, head);
        head = Node.insertAtPosition(60, 5, head);

        
        
        Node.print(head);
        // head = Node.erase(70,head);
        // System.out.print(Node.binarySeach(-5, head));
        head = Node.mergeSort(head);
        Node.print(head);
    }
}
