import java.util.*;

//////////////////////////////////////////////
//////////////////////////////////////////////
//////////// Binary Search Tree //////////////
//////////////////////////////////////////////
//////////////////////////////////////////////

class Tree {

  class Node {
    int key;
    Node left;
    Node right;

    Node (int key) {
      this.key = key;
      this.left = this.right = null;
    }
  }

  static Node root;

  /*
    Count of Binary Search Tree & Binary Tree Nodes
  */
  public int count()
  {
      if (root == null)
        return 0;

        int count = 0;
        Stack<Node> s = new Stack<Node>();
        Node curr = root;

        // traverse the tree
        while (curr != null || s.size() > 0)
        {
            // Creates a stack of all left most nodes
            while (curr !=  null)
            {
                /* place pointer to a tree node on
                   the stack before traversing
                  the node's left subtree */
                s.push(curr);
                count++;
                curr = curr.left;
            }

            // iterates backwards
            curr = s.pop();

            // visits each right subtree
            curr = curr.right;
        }
        return count;
  }

  /*
      Find a node in BST

      Steps:
        - make node ptr (so bst is not tampered with)
        - while the node ptr is not null...
            if the node ptr key is less than given key: traverse left
            if the node ptr key is greater than given key: traverse right
            if node ptr key is niether greater than or less than given key: key must be the same as the given key
        - if the node ptr is null then there was no matching key
  */
  public boolean find (int key)
  {
    Node curr = root;

    while (curr != null)
    {
      if (key < curr.key)
      {
        curr = curr.left;
      }
      else if (key > curr.key)
      {
        curr = curr.right;
      }
      else
      {
          return true;
      }
    }

    return false;
  }

  /*
      BST Insert

      Steps:
        - make a node ptr for the parent and for the current node you are at
        - if the root is null, insert a new node as the root
        - while the current ptr is not null...
            if given key is less than the current ptr key:
                assign the parent ptr to the current ptr, this way we can now assign the current ptr to the current ptr's left
            if given key is greater than the current ptr key:
                assign the parent ptr to the current ptr, this way we can now assign the current ptr to the current ptr's right
            if keys are equal theres a duplicate and we do not insert
        - if the current ptr is null:
            if the key is less than the parent ptr's key we assign the parent ptr's left to the new node
            if the key is less than the parent ptr's key we assign the parent ptr's left to the new node
  */
  public boolean iterativeInsert (int key)
  {
    // parent slow runner
    // curr fast runner
    Node curr = root;
    Node parent = null;

    // new root node
    if (root == null)
    {
      root = new Node(key);
      return true;
    }

    // traversing tree until curr fast runner is null
    while (curr != null)
    {
      if (key < curr.key)
      {
        parent = curr;
        curr = curr.left;
      }
      else if (key > curr.key)
      {
        parent = curr;
        curr = curr.right;
      }
      else
      {
        // duplicate
        return false;
      }
    }

    if (key < parent.key)
    {
        parent.left = new Node(key);
    }
    else
    {
      parent.right = new Node(key);
    }

    return true;
  }

  // BST In Order Traversal
  public void inOrder(Node root)
  {
    // if no root node just return
    if (root == null) return;

    // traverse left side of tree
    inOrder(root.left);
    // print left side of tree
    System.out.println(root.key + " ");
    // traverse right side of tree
    inOrder(root.right);
  }

}
