package CustomCollection;
import java.util.Arrays;
public class custom_collection 
{
	public static void main(String...a) 
	{
		CustomArrayList<String> list = new CustomArrayList<String>();
	    list.add("name1");
	    list.add("name2");
	    list.add("name3");
	    list.add("name4");
	    list.add("name5");
	    list.add("name6");
	    list.add("name7");
	    list.add("name8");
	    list.add("name9");
	    list.add("name10");
	    list.display();
	    list.add("name11");
	    System.out.println("Adding 11th element:");
	    list.display();
	    System.out.println("Element at index "+ 10 +" = " +list.get(10));
	    System.out.println("Element at index "+ 3 +" = " +list.get(3));
	    list.remove(7);
	    System.out.println("List elements after removing element at index 7:");
	    list.display();
	}
}
class CustomArrayList<E> 
{    
	  private static int INITIAL_CAPACITY = 10;
	  private Object elementData[]={};
	  public int size = 0;
	  public CustomArrayList() 
	  {
		  elementData = new Object[INITIAL_CAPACITY];
	  }
	  public void add(E e)
	  {
		  if (size == elementData.length)
		  {
			  ensureCapacity();
		  } 
		  elementData[size++] = e;
	  }
	  @SuppressWarnings("unchecked")
	  public E get(int index) 
	  {
		  if ( index <0 || index>= size) 
		  { 
			  throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index);
		  }
		  return (E) elementData[index];
	  }
	  public Object remove(int index) 
	  {
		  if ( index <0 || index>= size) 
		  {
			  throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index);
		  }
		  Object removedElement=elementData[index];
		  for(int i=index;i<size - 1;i++)
		  {
			  elementData[i]=elementData[i+1];
		  }
		  size--;  
		  return removedElement;
	  }
	  private void ensureCapacity() 
	  {
		  int newIncreasedCapacity = elementData.length * 2;
		  elementData = Arrays.copyOf(elementData, newIncreasedCapacity);
	  }
	  public void display() 
	  {
	      System.out.print("[");
	      for(int i=0;i<size;i++)
	      {
	    	  System.out.print(elementData[i]+" ");
	      }
	      System.out.print("]");
	      System.out.println();
	  }
}