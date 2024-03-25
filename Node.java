public class Node {
    public int data;
    public Node next;

    public Node(int val){
        this.data = val;
        this.next = null;
    }

    public Node(int val,Node next){
        this.data = val;
        this.next = next;
    }

    public static Node insertAtHead(int x,Node Head){
        Node temp = new Node(x);
        temp.next = Head;
        return temp;
    }

    public static Node insert(int val,Node Head){
        if(Head==null)
            return insertAtHead(val, Head);
        Node temp = Head;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = new Node(val);
        return Head;
    }

    public static Node insertAtPosition(int x,int pos,Node Head){
        if(pos==0)
            return insertAtHead(x, Head);
        pos--;
        Node temp = Head;
        while(pos!=0 && temp.next!=null){
            pos--;
            temp = temp.next;
        }
        Node newNode = new Node(x,temp.next);
        temp.next = newNode;
        return Head;
    }

    public static void print(Node head){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public static Node eraseAtHead(Node Head){
        return Head.next;
    }

    public static Node eraseAtEnd(Node Head){
        Node temp = Head;
        Node pre = null;
        while(temp!=null && temp.next!=null){
            pre = temp;
            temp = temp.next;
        }
        if(pre==null)
            return null;
        pre.next = null;
        return Head;
    }

    public static Node eraseAtPosition(int pos,Node head){
        if(pos==0)
            return eraseAtHead(head);
        Node temp = head;
        Node pre = head;
        while(pos!=0 && temp!=null && temp.next!=null){
            pre = temp;
            temp = temp.next;
            pos--;
        }
        pre.next = temp.next;
        return head;
    }

    public static Node erase(int value,Node head){
        if(head.data==value)
            return eraseAtHead(head);
        Node temp =  head;
        Node pre = null;
        while(temp!=null){
            if(temp.next!=null && temp.next.data==value){
                pre = temp;
                break;
            }
            temp = temp.next;
        }
        if(pre!=null && pre.next!=null)
            pre.next = pre.next.next;
        return head;
    }

    public static boolean isPresent(int value,Node head){
        Node temp = head;
        while(temp!=null){
            if(temp.data==value)
                return true;
            temp = temp.next;
        }
        return false;
    }

    public static int findIndex(int value,Node head){
        Node temp = head;
        int index = 0;
        while(temp!=null){
            if(temp.data==value)
                return index;
            index++;
            temp = temp.next;
        }
        return -1;
    }

    public static Node findMid(Node low,Node high){
        Node slow = low;
        Node fast = low;
        while(fast.next!=high && fast.next.next!=high){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static boolean binarySeach(int value,Node head){
        Node low = head;
        Node high = null;
        while(low!=high){
            Node mid = findMid(low,high);
            if(mid.data==value)
                return true;
            else if(mid.data>value){
                high = mid;
            }else{
                low = mid.next;
            }
        }
        return false;
    }

    public static Node selectionSort(Node head){
        Node outerLoop = head;
        while(outerLoop!=null){
            Node innerLoop = outerLoop.next;
            while(innerLoop!=null){
                if(outerLoop.data>innerLoop.data){
                    int tempValue = outerLoop.data;
                    outerLoop.data = innerLoop.data;
                    innerLoop.data = tempValue;
                }
                innerLoop = innerLoop.next;
            }
            outerLoop = outerLoop.next;
        }
        return head;
    }

    public static Node merge(Node left,Node right){
        if(left==null)
            return right;
        if(right==null)
            return left;
        Node temp1 = new Node(0);
        Node temp = temp1;
        while(left!=null || right!=null){
            if(left!=null && right!=null){
                if(left.data>right.data){
                    temp.next = right;
                    right = right.next;
                }else{
                    temp.next = left;
                    left = left.next;
                }
            }else if(left!=null){
                temp.next = left;
                left = left.next;
            }else{
                temp.next = right;
                right = right.next;
            }
            temp = temp.next;
        }
        return temp1.next;
    }

    public static Node mergeSort(Node low){
        if(low==null || low.next==null)
            return low;
        Node mid = Node.findMid(low, null);
        Node endMid = mid.next;
        mid.next = null;
        Node left = mergeSort(low);
        Node right = mergeSort(endMid);
    
        return merge(left, right);
    }

}
