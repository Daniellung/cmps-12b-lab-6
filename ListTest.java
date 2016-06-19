//-----------------------------------------------------------------------------
// Daniel Lung
// dlung
// 12M
// lab6
// ListTest.java
// A test client for the List ADT
//-----------------------------------------------------------------------------

public class ListTest{

   public static void main(String[] args){
      List<String> A = new List<String>();
      List<String> B = new List<String>();
      List<List<String>> C = new List<List<String>>();
      int i, j, k;

      A.add(1, "testing");
      A.add(2, "when");
      A.add(3, "Tree");
      B.add(1, "delete");
      B.add(2, "enter");
      B.add(3, "space");
	  System.out.println("A.equals(A) is "+A.equals(A));
      System.out.println("A.equals(B) is "+A.equals(B));
      System.out.println("A: "+A);
      System.out.println("B: "+B);


      System.out.println("A.size() is "+A.size());
      System.out.println("B.size() is "+B.size());

      A.remove(1);
      B.remove(2);
	  System.out.println("A: "+A);
      System.out.println("B: "+B);
      System.out.println("A.size() is "+A.size());
      System.out.println("B.size() is "+B.size());
      System.out.println("B.get(1) is "+B.get(1));

      System.out.println();
      System.out.println("A.get(2) is "+A.get(2));

   }
}