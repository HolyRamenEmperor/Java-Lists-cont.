// Name: J4-18
// Date: 12/5/19

import java.io.*;      //the File class
import java.util.*;    //ArrayList & the Scanner class in Java 1.5
 
public class SortingGenerically
{
   public static void main(String[] args) throws Exception
   {
      //Widgets
      List<Comparable> apple = inputWidgets("widgets.txt");
      sort(apple);
      output(apple);
      System.out.println("There are " + apple.size() +" widgets, sorted.");
      
      //Strings
      List<Comparable> strList = inputStrings("strings.txt");
      sort(strList);
      output(strList);
      System.out.println("There are " + strList.size() +" strings, alphabetized.");
   }
   
   public static List<Comparable> inputWidgets(String filename) throws Exception
   {
      Scanner infile = new Scanner( new File(filename) );
      List<Comparable> array = new ArrayList<Comparable>();	
      while(infile.hasNext())    		    
      {								  
         int x = infile.nextInt();
         int y = infile.nextInt();
         array.add(new Widget(x, y));      
      }
      infile.close();
      return array;

   }
   
   public static List<Comparable> inputStrings(String filename) throws Exception
   {
      Scanner infile = new Scanner( new File(filename) );
      List<Comparable> array = new ArrayList<Comparable>();	
      while(infile.hasNext())   		    
      {								  
         array.add(infile.next());      
      }
      infile.close();
      return array;
   }
	
   /*  these methods are all GENERIC   */
   public static <T extends Comparable<T>> void sort(List<T> array)
   {
      int max = 0;
      for(int i = array.size()-1; i >= 0; i--)
      {
         max = findMax(array, i);
         swap(array, i, max);
      }

   } 
   public static <T extends Comparable<T>> int findMax(List<T> array, int upper)
   {
      int index = 0;
      for(int i = 1; i <= upper; i++)
      {
         if((array.get(i)).compareTo(array.get(index)) > 0)
         {
            index = i;
         }
      }
      return index;
   }
   
   public static <T> void swap(List<T> array, int a, int b)
   {
      T temp = array.get(a);
      array.set(a, array.get(b)); 
      array.set(b, temp); 
   }
   
   public static <T> void output(Collection<T> array)
   {
      Iterator<T> iterator = array.iterator();
      while(iterator.hasNext())
      {
         System.out.println(iterator.next());
      }
   }
}

/*************************************
 0 cubits 14 hands
 1 cubits 3 hands
 2 cubits 14 hands
 5 cubits 14 hands
 10 cubits 14 hands
 11 cubits 11 hands
 12 cubits 0 hands
 12 cubits 7 hands
 13 cubits 9 hands
 15 cubits 12 hands
 17 cubits 5 hands
 18 cubits 13 hands
 19 cubits 13 hands
 19 cubits 13 hands
 22 cubits 6 hands
 23 cubits 7 hands
 24 cubits 15 hands
 24 cubits 15 hands
 26 cubits 2 hands
 28 cubits 5 hands
 28 cubits 12 hands
 29 cubits 15 hands
 31 cubits 0 hands
 32 cubits 1 hands
 32 cubits 11 hands
 32 cubits 11 hands
 32 cubits 12 hands
 35 cubits 3 hands
 39 cubits 2 hands
 39 cubits 5 hands
 41 cubits 10 hands
 43 cubits 2 hands
 43 cubits 5 hands
 43 cubits 6 hands
 51 cubits 2 hands
 54 cubits 14 hands
 55 cubits 8 hands
 56 cubits 3 hands
 57 cubits 12 hands
 62 cubits 15 hands
 63 cubits 0 hands
 64 cubits 13 hands
 67 cubits 3 hands
 70 cubits 0 hands
 73 cubits 5 hands
 74 cubits 7 hands
 75 cubits 9 hands
 81 cubits 5 hands
 85 cubits 14 hands
 86 cubits 3 hands
 90 cubits 13 hands
 91 cubits 3 hands
 92 cubits 1 hands
 92 cubits 8 hands
 96 cubits 1 hands
 98 cubits 8 hands
 99 cubits 5 hands
 There are 57 widgets, sorted.
 APCS
 Encapsulation
 Exam
 Generics
 Inheritance
 Java
 Method
 OOP
 Object
 Oriented
 Polymorphism
 Programming
 There are 12 strings, alphabetized.   ****************************************/