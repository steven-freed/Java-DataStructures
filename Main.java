class Main
{
  public static void main(String[] args)
  {
    /*
      Hash Table
    */
    HashTable ht = new HashTable(2);
    ht.probe("first", "steve");
    ht.probe("last", "frank");
    ht.probe("city", "new york city");
    ht.chain("state", "NY");
    ht.chain("zip", "daniel");
    ht.toString();
    System.out.println("size: " + ht.size() + " count: " + ht.count() + "\n");

    ht.chain("first", "franco");
    ht.chain("state", "NJ");
    ht.chain("country", "u.s.");
    ht.toString();
    System.out.println("size: " + ht.size() + " count: " + ht.count());
    System.out.println("\nGet: state=" + ht.get("state") + "\n");

    /*
      Linked List
    */
    LinkedList ll = new LinkedList();
    ll.append(1);
    ll.append(4);
    ll.append(2);
    ll.remove(1);
    ll.reverse();
    ll.toString();

    /*
      Binary Search Tree
    */
    Tree t = new Tree();

    /*
    Binary Search Tree creation
    */
    t.iterativeInsert(3);
    t.iterativeInsert(4);
    t.iterativeInsert(45);
    t.iterativeInsert(4);
    t.iterativeInsert(99);
    t.iterativeInsert(7);


    /*
      Binary Tree creation

    t.root = new Node(2);
    t.root.left = new Node(1);
    t.root.right = new Node(5);
    t.root.left.left = new Node(4);
    t.root.left.right = new Node(3);
    */

  //  System.out.println("Count: " + t.count());

    //t.inOrder(root);

    if (t.find(4) == true)
      System.out.println("found!");
    else
      System.out.println("not found");

  }
}
