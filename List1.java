// Daniel Lung
// dlung
// 12B
// 4/24/16
// Creates linked list of Dictionary with methods
// Dictionary.java
public class List<T> implements ListInterface{
	
	private class Node<T>{
		Node<T> next = null;
		Node<T> previous = null;
		String key = "";
		String value = "";
	}
   Node<T> head;
   int numItems;
   public List(){
	   head = new Node<T>();
	   numItems = 0;
   }
   
   // isEmpty()
   // pre: none
   // returns true if this Dictionary is empty, false otherwise
   public boolean isEmpty(){
      if(numItems == 0){
		  return true;
	  }
	  return false;
   }

   // size()
   // pre: none
   // returns the number of entries in this Dictionary
   public int size(){
      return numItems;
   }

   // lookup()
   // pre: none
   // returns value associated key, or null reference if no such key exists
   public String lookup(String key){
	  Node<T> I = head.next;
	  if(!isEmpty()){
		  int x;
		  for(x = 0; x < numItems; x++){
			  if(key.compareTo(I.key)==0){
				return I.value;
				}
			I = I.next;
		      }
		  }
     
	  
	  return null;
   }

   // insert()
   // inserts new (key,value) pair into this Dictionary
   // pre: lookup(key)==null
   public void insert(String key, String value) throws DuplicateKeyException{
      int x;
	  Node<T> I = new Node<T>();
	  I.key = key;
	  I.value = value;
	  Node<T> J;
	  if(lookup(key) != null){
         throw new DuplicateKeyException("pre: lookup(key)==null");
	  }

	  if(isEmpty()==false){
         for(J = head.next; J != null; J = J.next){
		    if(I.key.compareTo(J.key)==1){
               break;
		    }
			if(J.next == null){

				break;
			}

	     }
		 I.next = J.next;
		 if(J.next != null){
			J.next.previous = I;
			
		 }
		 I.previous = J;
	     J.next = I;
		 
		 
			 
	  }
	  else{
		  head.next = I;
		  I.previous = head;
	  }

      numItems++;
   }

   // delete()
   // deletes pair with the given key
   // pre: lookup(key)!=null
   public void delete(String key) throws KeyNotFoundException{
      int x;
	  
	  Node<T> I = head.next;
	  if(lookup(key) == null){
         throw new KeyNotFoundException("pre: lookup(key)!=null");
	  }
         
		 
		 for(x = 0; x < numItems; x++){
		    if(key.compareTo(I.key)==0){
               break;
		    }
		 if(I.next != null){
			I = I.next;
		 }
	     }
		
			I.previous.next = I.next;
		 
		 if(I.next != null){
			I.next.previous = I.previous;
		 
		 }
		 numItems--;
   }

   // makeEmpty()
   // pre: none
   public void makeEmpty(){
	   numItems = 0;
      head.next = null;
   }

   // toString()
   // returns a String representation of this Dictionary
   // overrides Object's toString() method
   // pre: none
   public String toString(){
      Node<T> I  = head.next;
	  int x;
	  String s = "";
	  for(x = 0; x< numItems; x++){
		  s += I.key + " " + I.value + "\n";
		  I = I.next;
	  }
	  return s;
   }

}