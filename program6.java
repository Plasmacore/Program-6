// Benjamin Clayton
// Program 6, Lists

import java.util.*;

class Link
{
   public Object data;
   public Link next;
   
   
   public boolean equals(Object other)
   {
      return (data.equals(other));
   }
   public String toString()
   {
      String s = data.toString() ;
      return s;
   }
   
}


class List
{
   private Link _head;
   private Link _tail;
   private int _count;
   public List()
   {
      _tail = null;
      _head = _tail;
      _count = 0;
   }
   
   // Complete
   public void Insert(Object item, int pos)
   {
      Link add = new Link();
      
      if (pos == _count + 1)
      {
         InsertatEnd(item);
         return;
         
      }
      
      else if (pos > _count + 1  )
      {
         System.out.println("Out of bounds");
         return;
      }
      
      else if (_count == 0)
      {
         System.out.println("Count = 0");
         add.data = item;
         add.next = null;
         _head = add;
         //System.out.println("Head = add!");
         _tail = _head;
         return;
         
      }
      else if (_count == 1)
      {
         System.out.println("Count = 1");
         add.data = item;
         add.next = null;
         _head.next = add;
         return;
         
      }
      
      else
      {
      
         Link lead = _head.next;
         Link tail = _head;
         
         for ( int j = 1; j <= pos; ++j)
         {  
            if (j == pos)
            {
               add.data = item;
               add.next = _tail.next;
               tail.next = add;
               ++_count;
               return;
            }
            else
            {
               _tail = lead;
               lead = lead.next;
            }
            
         }
         
      }
      System.out.println("Error");
   }
  // Complete
   public void InsertatEnd(Object item)
   {
      
      Link add = new Link();
      add.data = item;
      add.next = null;
      _tail = add;
      if (_count == 0)
      {
         _head = add;
      }
      System.out.println("Added at end");
      ++_count;
      
   }
   
   public void DeleteRange(int start, int stop)
   {
      if (start > _count) 
         return;
      
      else if (stop <= _count)
      {
         Link startL = _head;
         Link stopL;
         _count = _count - (stop-start + 1);
      
         for (int j = 1; j <= start; ++ j)
         {
            startL = startL.next;
         }
         stopL = startL;
         
         for (int i = start; i <= stop; ++i)
         {
            stopL = stopL.next;
         }
         
         startL.next = stopL;
      
      }
   }
   
   // Complete
   public void deleteItem(Object item)
   {
      if (_count == 0)
         return;
      
      else if (_count == 1)
      {
         if (_head.data.equals(item))
         {
            System.out.println("Deleting head!");
            _head = null;
            _tail = _head;
         }
      }
      
      else
      {
         Link lead = _head.next;
         Link tail = _head;
         int numdel = 0;
         for (int j = 1; j <= _count; ++j)
         {
            if (lead.data == item)
            {
               ++numdel;
               if (lead.next == null)
               {
                  tail.next = null;
               }
               
               else
               {
                  tail = lead.next;
                  lead = tail.next;
               }
            }
            
            else
            {
               tail = lead;
               lead = lead.next;
            }
         }
         
         _count -= numdel;
      }
   }
   
   public Object Retrieve(int pos)
   {
      Link temp = _head;
      
      if (_count < 1)
      {
         return null;
      }
      
      else if (pos > _count)
      {
         return null;
      }
      
      else
      {
         for (int j = 1; j <= pos; ++j)
         {
            
            if (j == pos)
            {
               return temp;
            }
            else
            {
               if (temp.next != null)
               {
                  temp = temp.next;
               }
               else 
                  return null;
            }
         }
      }
      
      return null;
   }
   
  // Complete
   public int[] Find(Object item)
   {
      int pos = 1;
      Link temp = _head;
      int[] loc;
      if (_count > 0)
      {
         loc = new int[_count];
         loc[0] = -1;
      }
      
      else
      {
         loc = new int[1];
         loc[0] = -1;
         return loc;
      }
      int numfound = 0;
      
      for (int j = 1; j <= _count; ++j)
      {
         System.out.println("Looking... " + j);
         if (temp.equals(item)) 
         {
            System.out.println("Item found\n" + j);
            loc[numfound] = j;
            ++numfound;
         }
         
         temp = temp.next;
               
      }
      
      if (numfound > 0)
      {
         for (int j = numfound ; j < _count; ++j)
         {  
            loc[j] = -1;
               
         }
      }
      
      
      return loc;
   }
   // Complete
   public int getSize()
   {
      return _count;
      /*int size = 0;
      
      if (_head.equals(null)) 
         return 0;
      
      else
      {
         Link temp = _head;
         do
         {
            ++size;
            temp = temp.next;
            
         }while (!temp.equals(null));
      }
      
      return size;*/
   }
   
   public String toString()
   {
      String s = "";
      
      if (_head == null) 
      {
         return s;
         
      }
      else
      {
         for (Link temp = _head; temp != null; temp=temp.next)
         {
            s += temp + "\n";
         }
         /*Link temp = _head;
         do
         {
            System.out.println("To Stringing List");
            s += temp + "\n";
            temp = temp.next;
         }while (temp != null);
         System.out.println("No longer Stringing List");*/
      }
      
      return s;
   }
}

class Inventory
{
   private String _name;
   private int _quantity;
   private double _unitprice;
   
   public Inventory(String name, int quantity, double unitprice)
   {
      _name = name;
      _quantity = quantity;
      _unitprice = unitprice;
   }
   
   public String getName()
   {
      return _name;
   }
   
   public int getQuantity()
   {
      return _quantity;
   }
   
   public double getUnitPrice()
   {
      return _unitprice;
   }
   
   public boolean equals(Object other)
   {
      if (other instanceof Inventory)
      {
         Inventory test = (Inventory)other; 
         return test._name.equals(_name);
      }
      
      else 
         return false;
   }
   
   public String toString()
   {
      String s = "Name: " + _name + "\nQuantity: " + _quantity + "\nUnit Price: " 
         + _unitprice + "\n";
      return s;
   }
}


public class program6
{
   public static Scanner keyboard = new Scanner( System.in);
   
   public static void main(String[] args)
   {
      int MenuOpt, ListOpt;
      boolean Inventory = false;
      
      List sendList = new List();
      List StringList = new List();
      List InventoryOne = new List();
      List InventoryTwo = new List();
      
      
      do
      {
         
         System.out.println("Menu:\n\t1. Initialize empty list" +
            "\n\t2. Insert at a position" + "\n\t3. Insert at the end" +
            "\n\t4. Delete a range of items" + "\n\t5. Delete an item" + 
            "\n\t6. Retrieve the item at a position" + "\n\t7. Find the positions of an item" +
            "\n\t8. Get the size of the list" + "\n\t9. Display what the contents of the list"+
            "\n\t10. Get the total value of the inventory\n\t11. Quit");
            
         MenuOpt = keyboard.nextInt();
         
         do
         {
            if (MenuOpt < 1 || MenuOpt > 11)
            {
               System.out.println("Error. Select an item from the list");
               MenuOpt = keyboard.nextInt();
            }
         
         }while (MenuOpt < 1 || MenuOpt >11);
         
         if (MenuOpt == 1)
         {
            ListOpt = Lists();
            if (ListOpt == 1)
            {
               StringList = new List();
            }
            
            else if (ListOpt == 2)
            {
               InventoryOne = new List();
            }
            
            else
            {
               InventoryTwo = new List();  
            }
            
            System.out.println("List reset");
         }
         
         
         else if (MenuOpt == 2)
         {
            ListOpt = Lists();
            if (ListOpt == 1)
            {
               sendList = StringList;
               Inventory = false;
            }
            
            else if (ListOpt == 2)
            {
               sendList = InventoryOne;
               Inventory = true;
            }
            
            else
            {
               sendList = InventoryTwo;
               Inventory = true;   
            }
            
         
            Insert(sendList, Inventory);
         }
         
         else if (MenuOpt == 3)
         {  
            ListOpt = Lists();
            if (ListOpt == 1)
            {
               sendList = StringList;
               Inventory = false;
            }
            
            else if (ListOpt == 2)
            {
               sendList = InventoryOne;
               Inventory = true;
            }
            
            else
            {
               sendList = InventoryTwo;
               Inventory = true;   
            }
                        
            InsertatEnd(sendList, Inventory);
         }
         
         else if (MenuOpt == 4)
         {
            ListOpt = Lists();
            if (ListOpt == 1)
            {
               sendList = StringList;
               Inventory = false;
            }
            
            else if (ListOpt == 2)
            {
               sendList = InventoryOne;
               Inventory = true;
            }
            
            else
            {
               sendList = InventoryTwo;
               Inventory = true;   
            }
            
         
            deleteRange(sendList);
         }
         
         else if (MenuOpt == 5)
         {
            ListOpt = Lists();
            if (ListOpt == 1)
            {
               sendList = StringList;
               Inventory = false;
            }
            
            else if (ListOpt == 2)
            {
               sendList = InventoryOne;
               Inventory = true;
            }
            
            else
            {
               sendList = InventoryTwo;
               Inventory = true;   
            }
            
         
            deleteItem(sendList);
         }
         
         else if (MenuOpt == 6)
         {
            ListOpt = Lists();
            if (ListOpt == 1)
            {
               sendList = StringList;
               Inventory = false;
            }
            
            else if (ListOpt == 2)
            {
               sendList = InventoryOne;
               Inventory = true;
            }
            
            else
            {
               sendList = InventoryTwo;
               Inventory = true;   
            }
            
         
            Retrieve(sendList);
         }
         
         else if (MenuOpt == 7)
         {
            ListOpt = Lists();
            if (ListOpt == 1)
            {
               sendList = StringList;
               Inventory = false;
            }
            
            else if (ListOpt == 2)
            {
               sendList = InventoryOne;
               Inventory = true;
            }
            
            else
            {
               sendList = InventoryTwo;
               Inventory = true;   
            }
            
         
            Find(sendList, Inventory);
         }
         
         else if (MenuOpt == 8)
         {
            ListOpt = Lists();
            if (ListOpt == 1)
            {
               sendList = StringList;
               Inventory = false;
            }
            
            else if (ListOpt == 2)
            {
               sendList = InventoryOne;
               Inventory = true;
            }
            
            else
            {
               sendList = InventoryTwo;
               Inventory = true;   
            }
            
         
            getSize(sendList, Inventory);
         }
         
         else if (MenuOpt == 9)
         {
            ListOpt = Lists();
            if (ListOpt == 1)
            {
               sendList = StringList;
               Inventory = false;
            }
            
            else if (ListOpt == 2)
            {
               sendList = InventoryOne;
               Inventory = true;
            }
            
            else
            {
               sendList = InventoryTwo;
               Inventory = true;   
            }
            
         
            Show(sendList);
         }
         
         else if (MenuOpt == 10)
         {
            ListOpt = Lists();
           
            while (ListOpt == 1)
            {
               Inventory = false;
               System.out.println("Error. Select an inventory list");
               ListOpt = Lists();
            }
              
            if (ListOpt == 2)
            {
               sendList = InventoryOne;
               Inventory = true;
            }
            
            else
            {
               sendList = InventoryTwo; 
               Inventory = true;  
            }
            
            ComputeTotal(sendList, Inventory);
         }
         
         else if (MenuOpt == 11)
         {
            Quit();
         }
      }while (MenuOpt != 11);
      
   }
   // Complete
   public static void Initialize(List list)
   {
      list = new List();
      
      System.out.println("List reset");
   }
  // Complete
   public static void Insert(List list, boolean Inventory)
   {
      
      if (Inventory)
      {
         System.out.println("What would you like to insert?");
         String name = keyboard.next();
         
         System.out.println("How many?");
         int quantity = keyboard.nextInt();
         
         System.out.println("What is the unit price?");
         double price = keyboard.nextDouble();
         
         Inventory item = new Inventory(name, quantity, price);
         
         System.out.println("Where would you like to put it?");
         int pos = keyboard.nextInt();
      
         list.Insert(item, pos);
      }
      
      else
      {
         System.out.println("What would you like to insert?");
         Object item = keyboard.next();
         
         System.out.println("Where would you like to put it?");
         int pos = keyboard.nextInt();
      
         list.Insert(item, pos);
      }
      
      
      
      
      
   }
   // Complete
   public static void InsertatEnd(List list, boolean Inventory)
   {
      if (Inventory)
      {
         System.out.println("What would you like to insert?");
         String name = keyboard.next();
         
         System.out.println("How many?");
         int quantity = keyboard.nextInt();
         
         System.out.println("What is the unit price?");
         double price = keyboard.nextDouble();
         
         Inventory item = new Inventory(name, quantity, price);
         
         list.InsertatEnd(item);
         
      }
      
      else
      {
         System.out.println("What would you like to insert?");
         Object item = keyboard.next();
         
         list.InsertatEnd(item);
      }
      
      
   }
   //WIP
   public static void deleteRange(List list)
   {
      System.out.println("Where would you like to start deleting?");
      int start = keyboard.nextInt();
      
      System.out.println("Where would you like to stop deleting?");
      int stop = keyboard.nextInt();
      
      list.DeleteRange(start, stop);
   }
    // F
   public static void deleteItem(List list)
   {
      System.out.println("What item would you like to delete?");
      Object item = keyboard.next();
      
      list.deleteItem(item);
      
      System.out.println(item + " has been removed from the list");
   }
   // F
   public static void Retrieve(List list)
   {
      System.out.println("What position would you like to retrieve the item from?");
      int pos = keyboard.nextInt();
      
      Object item = list.Retrieve(pos);
      
      if (item == null)
      {
         System.out.println("Failure to retrieve");
      }
      
      else
      {
         System.out.println("You retrieved: " + item);
      }
   }
   // WIP
   public static void Find(List list, boolean Inventory)
   {
      System.out.println("What item do you want do search for?");
      Object item = keyboard.next();
      
      int[] loc = new int[list.getSize()];
      
      loc = list.Find(item);
      
      if (loc[0] == -1)
      {
         System.out.println("Item not found");
      }
      
      else
      {
         String s = "Found at: \n";
         for (int ix = 0; ix < list.getSize(); ++ix)
         {
            System.out.println("Looking...");
            
            if (loc[ix] > 0 && loc[ix] <= list.getSize())
               s += loc[ix] + "\n";
         }
         
         System.out.println(s);
      }
   }
   
   public static void Show(List list)
   {
      System.out.println("Contents: ");
      System.out.println(list);
   }
   
   public static void getSize(List list, boolean Inventory)
   {
      System.out.println("Size: " + list.getSize() );
   }
   
   public static void Quit()
   {
      System.out.println("Goodbye");
   }
   
   public static int Lists()
   {
      System.out.println("Which list do you want to act on?\n" +
         "1. A List of Strings\n2. First list of Inventory\n3. Second list of Inventory");
      int choice = keyboard.nextInt();
      
      return choice;
   }
   // Incomplete
   public static void ComputeTotal (List list, boolean Inventory)
   {
      if (!Inventory)
      {
         System.out.println("Error. Not an inventory list");
         return;
      }
      
      else
      {
         Inventory temp;
         double sum = 0;
         for (int j = 1; j <= list.getSize(); ++j )
         {
            temp = (Inventory)list.Retrieve(j);
            sum += temp.getUnitPrice() * temp.getQuantity();    
         }
      
         System.out.println("Total Value: " + sum);
      }
       
   }
   
}