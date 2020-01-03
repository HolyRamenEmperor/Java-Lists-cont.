// Name: J4-18
// Date: 12/3/19

/**
 * Implements the cheat sheet's List interface.  Implements generics.
 * The backing array is an array of (E[]) new Object[10];
 * @override toString()
 */ 
public class TJArrayList<E>
{
   private int size;							//stores the number of objects
   private E[] myArray;
   public TJArrayList()                //default constructor makes 10 cells
   {
      myArray = (E[]) new Object[10];
      size = 0;
   }
   public int size()
   {
      return size;
   }
 	/* appends obj to end of list; increases size;
      must be an O(1) operation when size < array.length, 
         and O(n) when it doubles the length of the array.
	  @return true  */
   public boolean add(E obj)
   {
      size++;
      if(size <= myArray.length)
      {
         myArray[size - 1] = obj;
      }
      else
      {
         E[] arr2 = (E[]) new Object[myArray.length * 2];
         for(int i = 0; i < myArray.length; i++)
         {
            arr2[i] = myArray[i];
         }
         arr2[size - 1] = obj;
         myArray = arr2;
      }
      return true;
   }
   /* inserts obj at position index.  increments size. 
		*/
   public void add(int index, E obj) throws IndexOutOfBoundsException  //this the way the real ArrayList is coded
   {
      if(index > size || index < 0)
         throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
      size++;
      if(size > myArray.length)
      {
         E[] arr2 = (E[]) new Object[myArray.length * 2];
         for(int i = 0; i < myArray.length; i++)
         {
            arr2[i] = myArray[i];
         }
         myArray = arr2;
      }
      for(int i = size + 1; i > index; i--)
      {
         myArray[i] = myArray[i-1];
      }
      myArray[index] = obj;
   }

   /* return obj at position index.  
		*/
   public E get(int index) throws IndexOutOfBoundsException
   {
      if(index >= size || index < 0)
         throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
      return myArray[index];
   
   }
   /**
    * Replaces obj at position index. 
    * @return the object is being replaced.
    */  
   public E set(int index, E obj) throws IndexOutOfBoundsException  
   { 
      if(index >= size || index < 0)
         throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
      E prev = myArray[index];
      myArray[index] = obj;
      return prev;
      
   }
 /*  removes the node from position index. shifts elements 
     to the left.   Decrements size.
	  @return the object at position index.
	 */
   public E remove(int index) throws IndexOutOfBoundsException  
   {
      if(index >= size || index < 0)
         throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
      E prev = myArray[index];
      size--;
      if(index != size)
      {
         for(int i = index; i < size; i++)
         {
            myArray[i] = myArray[i + 1];
         }
         myArray[size] = null;
      }
      else
      {
         myArray[size] = null;
      }
      return prev; 
   }
	   /*
		   This method compares objects.
         Must use .equals(), not ==
     	*/
   public boolean contains(E obj)
   {
      for(int i = 0; i < size; i++)
      {
         if(obj.equals(myArray[i]))
         {
            return true;
         }
      }
      return false;
   }
	 /*returns a String of E objects in the array with 
       square brackets and commas.
     	*/
   public String toString()
   {
      String str = "";
      str += "[";
      for (int i = 0; i < myArray.length; i++)
      {
         if (i == (size - 1))
         {
            str += myArray[i];
            str += "]";
            return str;
         }
         str += myArray[i] + ", ";
      }
      return str;
   }
}