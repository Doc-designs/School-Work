/**
      Returns the next number in an integer sequence whose elements are squares of an increasing value starting at 1
      Example: n = 1, then the sequence is 1*1, 2*2, 3*3 etc
 */
//-----------Start below here. To do: approximate lines of code = 1
// Make class SquareSequence implement the Sequence interface 
class SquareSequence implements Sequence
//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
{
   private int n;

   public SquareSequence()
   {
  	 this.n = 1;
   }
   
   //-----------Start below here. To do: approximate lines of code = 4
   // implement the Sequence interface (see Sequence.java)
   public int next(){
      int current = n*n;
      this.n++;
      return current;
   }
   
   
   
   
   
   //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
   
   
}
