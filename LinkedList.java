
//////////////////////////////////////////////
//////////////////////////////////////////////
////////////// LinkedLists ///////////////////
//////////////////////////////////////////////
//////////////////////////////////////////////

class LinkedList {

  class Node {
    int data;
    Node next;

    Node (int data) {
      this.data = data;
      this.next = null;
    }
  }

  static Node head;

  public static void main (String[] args)
  {
    LinkedList ll = new LinkedList();
    ll.append(1);
    ll.append(4);
    ll.append(2);
    ll.remove(1);
    ll.reverse();
    ll.toString();
  //  int i = 1;
  //  System.out.println("Get index " + i + ": " + ll.get(i));
  }

  public static void reverse ()
  {
      // prev and next are in a null space
       Node prev = null;
       Node next = null;
       Node current = head;

       while (current != null)
       {
           next = current.next; // assigns next to node infront of current
           current.next = prev; // points current to previous node
           prev = current; // moves previous to current
           current = next; // moves current to next
       }
       head = prev; // assigns head to previous which is now at the head of the list
   }

  public static int get (int index)
  {
    if (head == null)
      return -1;

    if (index == 0)
    {
      return head.data;
    }

    Node curr = head;
    int i = 0;
    while (curr != null)
    {
      if (i == index)
      {
        return curr.data;
      }
      curr = curr.next;
      i++;
    }
    return -1;
  }

  public boolean append (int value)
  {
    if (head == null)
    {
      head = new Node(value);
      return true;
    }

    Node curr = head;
    while (curr.data != value)
    {
      if (curr.next == null)
      {
        curr.next = new Node(value);
      }
      else if (curr.data == value)
      {
        // duplicate
        return false;
      }
      curr = curr.next;
    }
    return true;
  }

  public boolean remove (int index)
  {

    Node curr = head;
    Node prev = null;

    if (head == null)
      return false;

    if (index == 0)
    {
      head = curr.next;
      return true;
    }

    int i = 0;
    while (curr != null)
    {
      if (index == i)
      {
        prev.next = curr.next;
      }


      prev = curr;
      curr = curr.next;
      i++;
    }

    return true;

  }

  @Override
  public String toString()
  {
    Node curr = head;
    while (curr != null)
    {
      System.out.println(curr.data);
      curr = curr.next;
    }
    return null;
  }

}
