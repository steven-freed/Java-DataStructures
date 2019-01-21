import java.util.*;

/*
  Node used to represent a piece of data
*/
class Node <T>
{
  final T key;
  public T value;
  Node<T> next;

  Node (T key, T value)
  {
    this.key = key;
    this.value = value;
    this.next = null;
  }
}

class HashTable
{
  private int count; // total element count
  private final int size; // array size initialized
  private Node[] data; // array of nodes

  /*
    Uninitiallized array size is defaulted to 25
    Size of array should be around half of the number of total elements expected to be stored
    25 - expected default elements ~50
  */
  HashTable ()
  {
    this.data = new Node[25];
    this.size = 25;
  }

  /*
    Initialized array to user's specified size
  */
  HashTable (int size)
  {
    this.data = new Node[size];
    this.size = size;
  }

  /*
    Size of the array
  */
  public int size()
  {
    return this.size;
  }

  /*
    Number of total elements in hashtable
  */
  public int count()
  {
    return this.count;
  }

  /*
    Add an element using linear probing
    Collision occurs - look to store element at next available index
  */
  public <T> void probe (T key, T value)
  {
    int index = hash(key);

    if (this.data[index] == null) // if index is open
    {
      this.data[index] = new Node<T>(key, value);
      this.count++;
    }
    else // index occupied, linear probing
    {
      Node<T> new_n = new Node<T>(key, value);
      int i = index;
      boolean keyExists = false;

      while (i < this.size)
      {
        if (this.data[i] != null && this.data[i].key == key) // if a key already exists change its value
        {
          this.data[i].value = value;
          break;
        }
        else if (this.data[i] == null) // if no data exists at the index
        {
          this.data[i] = new_n;
          this.count++;
          break;
        }
        else if (this.size == this.count) // if the array is holding its max number of elements
        {
          return;
        }
        else if (i+1 == this.size) // if no indexes are open from hashed index to size, start from beginning of array and check for open spot
        {
          i = -1;
        }
        i++;
      }

    }
  }

  /*
    Add an element using chaining
    Collision occurs - push new element into index of array and
    point it to the old element, creating a linked list at that index
  */
  public <T> void chain (T key, T value)
  {
    int index = hash(key);

    if (this.data[index] == null) // if index is open
    {
      this.data[index] = new Node<T>(key, value);
      this.count++;
    }
    else
    {
      Node<T> new_n = new Node<T>(key, value);
      Node<T> curr = (Node<T>) this.data[index];

      if (!find(index, key)) // if key exists at the index
      {
        new_n.next = this.data[index];
        this.data[index] = new_n;
        this.count++;
        return;
      }
      else // modify a value for an existing key
      {
        while (curr != null)
        {
          if (curr.key == key)
          {
            curr.value = value;
          }
          curr = curr.next;
        }
      }

    }

  }

  /*
    Checks if key exists for collision chaining
  */
  private <T> boolean find (int index, T key)
  {
    Node<T> curr = (Node<T>) this.data[index];
    while (curr != null)
    {
      if (curr.key == key)
      {
        return true;
      }
      curr = curr.next;
    }
    return false;
  }

  /*
    Get element value given a key
  */
  public <T> Object get (T key)
  {
    int index = hash(key);
    Node<T> curr = (Node<T>) this.data[index];

    while (curr != null)
    {
      if (curr.key == key)
      {
        return curr.value;
      }
      curr = curr.next;
    }

    return null;
  }

  /*
    Hash to place value at index
  */
  public <T> int hash (T data)
  {
    int index = Math.abs(data.hashCode() % this.size);
    return index;
  }

  /*
    Converts hashtable to a string
  */
  @Override
  public String toString()
  {
    System.out.print("{\n");
    for (int i = 0; i < this.size; i++)
    {
      Node curr = this.data[i];

      while (curr != null)
      {
        System.out.print("'" + curr.key + "': '" + curr.value + "'\n");
        curr = curr.next;
      }
    }
    System.out.println("}");
    return null;
  }
}
