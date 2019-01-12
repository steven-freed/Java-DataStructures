import java.util.*;

/*
  Binary Tree
*/
class Node {
  int key;
  Node left;
  Node right;

  public Node (int key) {
    this.key = key;
    this.left = this.right = null;
  }
}

class Algorithm
{

  public static Node root;

  public static void main (String[] args)
  {
    Algorithm a = new Algorithm();

    /*
      Max Words in a String of sentences

    String S = "W.e teach CV... Do you kno.w Code!?";
    int res = a.maxWords(S);
    */

    /*
      Binary Tree creation

    a.root = new Node(2);
    a.root.left = new Node(1);
    a.root.right = new Node(5);
    a.root.left.left = new Node(4);
    a.root.left.right = new Node(3);

    a.visualCount();
    */

  }

  /*
    Count of 'visual' nodes
    'visual': root node is always 'visual', any nodes with a value less than the root node are considered 'visual'
  */
  public int visualCount()
  {
      if (root == null)
        return 0;

        int count = 0;
        Stack<Node> s = new Stack<Node>();
        Node curr = root;

        // traverse the tree
        while (curr != null || s.size() > 0)
        {

            /* Reach the left most Node of the
            curr Node */
            while (curr !=  null)
            {
                /* place pointer to a tree node on
                   the stack before traversing
                  the node's left subtree */
                if (root.key < curr.key)
                  count++;

                s.push(curr);
                curr = curr.left;
            }

            /* Current must be NULL at this point */
            curr = s.pop();

            System.out.println(curr.key + " ");

            /* we have visited the node and its
               left subtree.  Now, it's right
               subtree's turn */
            curr = curr.right;
        }
        return count;
  }

  /*
      Gets max words per sentence given a string of sentences
      - sentences end in '.', '?', '!'
      - words can be delimited by ' 's
  */
  public int maxWords(String s)
  {
    String[] sentences = s.split("\\.|\\?|\\!");

    int max_words = 0;
    // iterate through sentences
    for (int i = 0; i < sentences.length; i++)
    {
      String[] words = sentences[i].split(" "); // split sentence by spaces into words
      int words_len = words.length; // adjusted words length for sentence

      int j = 0;
      // decrements words_len if an array of words contains a blank space
      while (j < words.length)
      {
        if (words[j].length() == 0)
        {
            words_len--;
        }
        j++;
      }

      // assigns the max word length to variable holding the max words per sentence
      if (max_words < words_len)
      {
        max_words = words_len;
      }
    }

    return max_words;
  }
}

/*
  Checks if 2 binary trees are equivilant
*/
public boolean isSameTree(TreeNode p, TreeNode q) {

   // if both nodes are null
   if(p == null && q == null) return true;
   // if one node is null trees cannot possibly match
   if(p == null || q == null) return false;

   // if nodes values match we recurse left and right
     if(p.val == q.val)
     {
       return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
     }

     // if none of the conditions above match and nodes are not null but values are just not equal
     return false;
   }


   /*
    Checks if a binary tree is is symmetric
   */
   public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
      }
      public boolean isMirror(TreeNode t1, TreeNode t2)
      {
          if (t1 == null && t2 == null) return true;
          if (t1 == null || t2 == null) return false;
          return (t1.val == t2.val)
              && isMirror(t1.right, t2.left)
              && isMirror(t1.left, t2.right);
      }


      /*
        Removes element from array and fills last item in array with -1
      */
      public int removeElement(int[] nums, int val) {

       int i = 0;
       for (int j = 0; j < nums.length; j++) {
           if (nums[j] != val) {
               nums[i] = nums[j];
               i++;
           }
       }
       nums[nums.length-1] = -1;

       return i;
       }

       /*
          Removes duplicates from a sorted array
       */
      public int removeDuplicates(int[] nums) {

          // if the array has no elements
          if (nums.length == 0)
              return 0;

          // iterates through array
          // if fast runner j has non-dup i is assigned j's value
          int i = 0;
          for (int j = 1; j < nums.length; j++)
          {
                  if (nums[i] != nums[j])
                  {
                      i++;
                      nums[i] = nums[j];
                  }
          }
          return i+1;
      }

      /*
        Returns true if sets of braces match with an open and closed brace
      */
      public boolean isValid(String s) {

         HashMap<Character, Character> mappings = new HashMap<Character, Character>();
          mappings.put(')', '(');
          mappings.put('}', '{');
          mappings.put(']', '[');

          Stack<Character> stack = new Stack<Character>();

          for (int i = 0; i < s.length(); i++)
          {
              char c = s.charAt(i);

          if (mappings.containsKey(c))
          {
              char topElement = stack.empty() ? '#' : stack.pop();

              if (topElement != mappings.get(c))
                  return false;
          } else {
              stack.push(c);
          }

          }
          return stack.isEmpty();
      }

      /*
        Finds longest common prefix in an array of strings
      */
      public String longestCommonPrefix(String[] strs) {

        // no strings in the array means no prefix at all
        if (strs.length == 0)
            return "";

        String common = strs[0];

        // goes through array of strings
        for (int i = 0; i < strs.length; i++)
        {
            // while it cannot find the common substring at an index in the current string
            while (strs[i].indexOf(common) != 0)
            {
                // assigns common string to itself minus the right most character
                common = common.substring(0, common.length()-1);
                if (common.isEmpty())
                    return "";
            }
        }

        return common;
    }

    /*
      Finds out whether an integer is a Palindrome or not
    */
    public boolean isPalindrome(int x)
    {
      // if number is negative or if number contains a 0 at the end and x is not 0
      if (x < 0 || x % 10 == 0 && x != 0)
      {
        return false;
      }

      int reverse = 0;
      while (x > reverse)
      {
        // adds a decimal spot by multiplying by 10 and makes that spot the remainder
        reverse = reverse * 10 + x % 10;
        // gets rid of most right decimal spot
        x /= 10;
      }

      // returns true if reverse is equal to number
      // if number is odd /10 to chop off last digit (makes odd to even amount of digits)
      return reverse == x || reverse == x/10;
    }
