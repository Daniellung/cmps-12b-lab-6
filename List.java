//-----------------------------------------------------------------------------
// Daniel Lung
// dlung
// 12M
// lab6
// List.java
// contains methods for List ADT
//-----------------------------------------------------------------------------
@SuppressWarnings("overrides")
public class List<T>{
   
   int numItems;
   Node<T> head;
   
   private class Node<T>{
      private T item;
      Node<T> next = null;
	  Node<T> previous = null;
   }
   
   
   List(){
	   numItems = 0;
	   head = null;
   }
   // isEmpty
   // pre: none
   // post: returns true if this List is empty, false otherwise
   public boolean isEmpty(){
      if(numItems == 0)return true;
	  return false;
   }
	  
   // size
   // pre: none
   // post: returns the number of elements in this List
   public int size(){
	   return numItems;
   }

   // get
   // pre: 1 <= index <= size()
   // post: returns item at position index
   public T get(int index) throws ListIndexOutOfBoundsException{
	   if(index > (numItems+1)){
		   throw new ListIndexOutOfBoundsException(
            "List Error: get() called on invalid index: " + index);
	   }
	   Node<T> a = head;
	   for(int x = 1; x < index; x++){
		   a = a.next;
	   }
	   return a.item;
   }

   // add
   // inserts newItem in this List at position index
   // pre: 1 <= index <= size()+1
   // post: !isEmpty(), items to the right of newItem are renumbered
   public void add(int index, T newItem) throws ListIndexOutOfBoundsException{
	   if(index > (numItems+1)){
		   throw new ListIndexOutOfBoundsException(
            "List Error: get() called on invalid index: " + index);
	   }
	   Node<T> a = new Node<T>();
	   Node<T> h = head;
	   Node<T> p = null;
	   a.item = newItem;
	   if(index == 1){head = a;}
	   for(int x = 1; x < index; x++){
		   p = h;
		   h = h.next;	
	   }
	   a.next = h;
	   a.previous = p;
	   if(h != null){
		   h.previous = a;
	   }
	   if(p != null){
		   p.next = a;
	   }
	   numItems++;
   }

   // remove
   // deletes item from position index
   // pre: 1 <= index <= size()
   // post: items to the right of deleted item are renumbered
   public void remove(int index) throws ListIndexOutOfBoundsException{
	   if(index > (numItems+1)){
		   throw new ListIndexOutOfBoundsException(
            "List Error: get() called on invalid index: " + index);
	   }
	   Node<T> h = head;
	   for(int x = 1; x < index; x++){
		   h = head.next;
	   }
	   if(h == head){head = head.next;}
	   if(h.previous != null){h.previous.next = h.next;}
	   if(h.next != null){h.next.previous = h.previous;}
	   h = null;
	   numItems--;
   }

   // removeAll
   // pre: none
   // post: isEmpty()
   public void removeAll(){
	   for(int x = 0; x < numItems; x++){
		   Node<T> h = head;
		   head = head.next;
		   h = null;
	   }
	   numItems = 0;
   }
   public String toString(){
	   Node<T> h = head;
	   String s = "";
	   for(int x = 0; x < numItems; x++){
		   s += h.item.toString();
		   s += " ";
		   h = h.next;
	   }
	   return s;
   }
}