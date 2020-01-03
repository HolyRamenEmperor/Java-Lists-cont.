// Name: J4-18 
// Date: 12/12/19
// This program takes a text file, creates an index (by line numbers)
// for all the words in the file and writes the index
// into the output file.  The program prompts the user for the file names.

import java.util.*;
import java.io.*;

public class IndexMaker extends ArrayList<Integer>
{
   public static void main(String[] args) throws IOException
   {
      Scanner keyboard = new Scanner(System.in);
      System.out.print("\nEnter input file name: ");
      String inFileName = keyboard.nextLine().trim();
      Scanner inputFile = new Scanner(new File(inFileName));
      String outFileName = "fishIndex.txt";
      PrintWriter outputFile = new PrintWriter(new FileWriter(outFileName));
      indexDocument(inputFile, outputFile);
      inputFile.close(); 						
      outputFile.close();
      System.out.println("Done.");
   }
   public static void indexDocument(Scanner inputFile, PrintWriter outputFile)
   {
      DocumentIndex index = new DocumentIndex();
      String line = null;
      int lineNum = 0;
      while(inputFile.hasNextLine())
      {
         lineNum++;
         index.addAllWords(inputFile.nextLine(), lineNum);
      }
      for(IndexEntry entry : index)
         outputFile.println(entry);
   }   
}
class DocumentIndex extends ArrayList<IndexEntry>
{
    //constructors
    public DocumentIndex()
    {
        super();
    }
    public DocumentIndex(int i)
    {
        super(i);
    }
      
  /** extracts all the words from str, skipping punctuation and whitespace 
 and for each word calls addWord().  In this situation, a good way to 
 extract while also skipping punctuation is to use String's split method, 
 e.g., str.split("[., \"!?]")       */
   public void addAllWords(String str, int lineNum) 
   {
      String punct = "[., \"!?]";
      String[] s = str.split(punct);
      for(String word : s)
      {  
         if(word.equals("") == false)
            addWord(word, lineNum);
      } 
   }
    
   /** calls foundOrInserted, which returns a position.  At that position,  
   updates that IndexEntry's list of line numbers with lineNum. */
   public void addWord(String word, int lineNum)
   {
      int pos = 0;
      pos = foundOrInserted(word);
      this.get(pos).add(lineNum);
   }
        
    /** traverses this DocumentIndex and compares word to the words in the 
    IndexEntry objects in this list, looking for the correct position of 
    word. If an IndexEntry with word is not already in that position, the 
    method creates and inserts a new IndexEntry at that position. The 
    method returns the position of either the found or the inserted 
    IndexEntry.*/
   private int foundOrInserted(String word)
   {
      int pos = 0;
      for(IndexEntry i : this)
      {
         if(i.getWord().compareTo(word.toUpperCase()) == 0)
         {
            return pos; 
         }
         pos++;
      }
      pos = 0;
      for(IndexEntry i : this)
      {
         if(i.getWord().compareTo(word.toUpperCase()) < 0)
         {
            pos++;
         }
         else
         {
            add(pos, new IndexEntry(word));
            return pos;
         }
     }
     add(new IndexEntry(word));
     return pos; 
            

   }
}
   
class IndexEntry implements Comparable<IndexEntry>
{
     //fields
    private String word;
    private ArrayList<Integer> numsList; 
     //constructors
    public IndexEntry(String s)
    {
        word = s.toUpperCase(); 
        numsList = new ArrayList<Integer>();
    }
   
   
     /**  appends num to numsList, but only if it is not already in that list.    
          */
   public void add(int num)
   {
       int pos = 0;
       boolean contains = false;   
       for(Integer i : numsList)
       {
           if(numsList.get(pos).equals(num))
           {
               contains = true;
           }
           pos++;
       }
       if(contains == false)
       {
           numsList.add(num);
       }
   }
      
   	/** this is a standard accessor method  */
   public String getWord()
   {
      return word; 
   }
      
     /**  returns a string representation of this Index Entry.  */
   public String toString()
   {
      int pos = 0;
      String str = word + " ";
      for (Integer i : numsList)
      {
         if (pos == numsList.size() - 1)
         {
            str += numsList.get(pos);
            return str;
         }
         str += numsList.get(pos);
         str += ", ";
         pos++;
      }
      return str; 
   }
   public int compareTo(IndexEntry i)
   {
      return this.getWord().compareTo(i.getWord());
   }
}

