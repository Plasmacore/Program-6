//Mikaelie Odom
import java.util.*;
public class program6
{
   public static Scanner keyboard = new Scanner(System.in);
   public static void main(String[] args)
   {
      int menuOpt, position, start, end;
      Inventory inventory = new Inventory(null, 0, 0.0);
      List list = new List();
      Object item;
      char repeat;
   	/*list.insert('d', 1);
   	list.insert('c', 1);
   	list.insert('b', 1);
   	list.insert('a', 1);*/
   	
      do
      {
         menu();
         menuOpt = keyboard.nextInt();
         if(menuOpt == 1)
         {
            list = new List();
            System.out.println("Empty list has been created.");
         }
         else if(menuOpt == 2)
         {
            System.out.print("What item would you like to insert?:");
            item = keyboard.next();
            System.out.print("What position do you want to insert the item in?:");
            position = keyboard.nextInt();
            list.insert(item, position);
            System.out.println(list.toString());
         }
         else if(menuOpt == 3)
         {
            System.out.print("What item would you like to insert at the end?:");
            item = keyboard.next();
            list.insertAtEnd(item);
            System.out.println(list.toString());
         }
         else if(menuOpt == 4)
         {
            System.out.println("What range do you want to delete...");
            System.out.print("Start:");
            start = keyboard.nextInt();
            System.out.print("End:");
            end = keyboard.nextInt();
            list.deleteRange(start, end);
            System.out.println(list.toString());
         }
         else if(menuOpt == 5)
         {
            System.out.print("What item would you like to delete all occurrences of?:");
            item = keyboard.next();
            list.deleteItem(item);
         }
         else if(menuOpt == 6)
         {
            System.out.print("Return the item at what position?:");
            position = keyboard.nextInt();
            item = list.retrieve(position);
            System.out.println(item);
         }
         else if(menuOpt == 7)
         {
            int[] list1;
            System.out.print("What item would you like to find?:");
            item = keyboard.next();
            list1 = list.find(item);
            for(int ix = 0; ix < list1.length; ++ix)
            {
               System.out.print(list1[ix]+" ");
            }
            System.out.println("");
         }
         else if(menuOpt == 8)
         {
            list.getSize();
         }
         else
         {
            System.out.println(list.toString());
         }
         System.out.print("Repeat?(y/n):");
         repeat = keyboard.next().charAt(0);
      }
      while(repeat == 'y');
   }
   public static void menu()
   {
      System.out.print("(1) initialize: create an empty list\n"+
         "(2) insert a given item at a given position in the list\n"+
         "(3) insert a given item at the end of the list\n"+
         "(4) delete all the items from a given range\n"+
         "(5) delete all occurrences of a given item\n"+
         "(6) return the item at a given position\n"+
         "(7) return a list of the positions of a chosen item\n"+
         "(8) returns the number of items in the list\n"+
         "(9) shows the contents of the list\n"+
         "Choice:");
   }
}
class Inventory
{
   private String _name;
   private int _quantity;
   private double _cost;
	
   public Inventory(String name, int quantity, double cost)
   {
      _name = name;
      _quantity = quantity;
      _cost = cost;
   }
   public String getName()
   {
      return _name;
   }
   public int getQuantity()
   {
      return _quantity;
   }
   public double getCost()
   {
      return _cost;
   }
   public boolean equals(Object other)
   {
      other = (Inventory)other;
      if(_name.equals(other))
         return true;
      else
         return false;
   }
   public String toString()
   {
      return "Name: "+_name+"\nQuantity: "+_quantity+"\nCost: "+_cost+"\n";
   }
}
class List
{
   private Link _head;
   private Link _tail;
   private int _count;
	
   public List()
   {
      _head = null;
      _tail = null;
      _count = 0;
   }
   public void insert(Object item, int position)
   {
      Link curr = _head;
      Link prev = null;
      Link add = new Link();
      add.data = item;
   
      if(position == 1)
      {
         add.next = _head;
         _head = add;
         if(_count == 0)
            _tail = add;
      }
      else if(position == _count+1)
      {
         insertAtEnd(item);
         --_count;
      }
      else
      {
         for(int ix = 1; ix < position; ++ix)
         {
            prev = curr;
            curr = curr.next;
         }
         add.next = curr;
         prev.next = add;
      }
   	//System.out.println("Current: "+curr.data+"\nPrevious: "+prev.data);
   	//System.out.println("Tail: "+_tail);
   	//System.out.println("Head: "+_head);
      ++_count;
      System.out.println("Count: "+_count);
   }
   public void insertAtEnd(Object item)
   {
      Link add = new Link();
      add.data = item;
   	
      if(_tail == null)
      {
         insert(item, 1);
         --_count;
      }
      else
      {
         _tail.next = add;
         _tail = add;
      }
      System.out.println("Tail: "+_tail);
      System.out.println("Head: "+_head);
      ++_count;
   }
   public void deleteRange(int start, int end)
   {
      Link curr = _head, begin, finish;
   	
      if(curr == null)
         return;
      else if(_count < 4 || end > start || _count < start)
         return;
      else
      {
         if(end > _count)
            end = _count;
         for(int ix = 1; ix < start; ++ix)
         {
            curr = curr.next;
         }
         begin = curr;
      	//System.out.println("Start: "+curr);
         for(int n = start; n < end && curr != null; ++n)
         {
            curr = curr.next;
         }
         finish = curr;
      	//System.out.println("End: "+curr);
         begin.next = finish;
      }
   }
   public void deleteItem(Object item)
   {
      Link curr = _head;
      Link prev = null;
   	//deletes all occurrences of data
      while(curr != null && !curr.data.equals(item))
      {
         prev = curr;
         curr = curr.next;
      }
      if(curr == null)
         return;
      if(prev != null)
         prev.next = curr.next;
      else
         _head = curr.next;
   	
      --_count;
   }
   public Object retrieve(int position)
   {
      Link curr = _head;
      for(int i = 1; i < position; ++i)
      {
         curr = curr.next;
      }
      return curr.data;
   }
   public int[] find(Object item)
   {
      Link found = new Link();
      int[] list = new int[_count];
      Link curr = _head;
      int ix = 0, position = 1;
   	
      found.data = item;
      if(curr == null) 
         return list;
      while(curr != null)
      {
         if(curr.data.equals(item))
         {
            list[ix] = position;
            ++ix;
         }
         curr = curr.next;
         ++position;
      }
      if(ix < _count-1)
      {
         int[] temp = new int[ix];
         for(int n = 0; n < ix; ++n)
         {
            temp[n] = list[n];
         }
         return temp;
      }
      return list;
   }
   public int getSize()
   {
      return _count;
   }
   public String toString()
   {
      String s="";
      for( Link curr = _head; curr != null; curr = curr.next)
         s = s+""+curr.data;
      return s;
   }
}
class Link
{
   public Object data;
   public Link next;
	
   public boolean equals(Object other)
   {
      if(data.equals(other))
         return true;
      else
         return false;
   }
   public String toString()
   {
      return "Data: "+data;
   }
}
