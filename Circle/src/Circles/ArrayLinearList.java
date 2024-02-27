package Circles;
import java.util.*;
	public class ArrayLinearList
	{
	protected Object[] element;
	protected int size;

	public ArrayLinearList(int capacity)
	{
	  if(capacity<1)
	    throw new IllegalArgumentException("initial capacity must be >=1");
	  element = new Object [ capacity];
	}
	public boolean isEmpty()
	{
	  return size==0;
	}
	public int size()
	{
	  return size;
	}
	public void checkIndex(int index)
	{
	  if(index<0 || index> size)
	    throw new IndexOutOfBoundsException("index="+index+"size"+size);
	}
	public Object get(int index)
	{
	  checkIndex(index);
	  return element[index];
	}
	public int indexOf(Object _Element)
	{
	  for(int i=0;i<size;i++)
	  {
	    if(element[i]==_Element)
	      return i;

	}
	  return -1;
	}
	public void add(int index, Object _Element)
	{
	  if(index<0)
	    throw new IndexOutOfBoundsException("index="+index+"size"+size);
	  if(size==element.length)
	  {
	     Integer[] newArray  = new Integer[2*size];
	    System.arraycopy(element, 0, newArray, 0, element.length);
	    element= newArray;
	    }
	  for(int i = size-1;i>=index;i--)
	    element[i+1]=element[i];
	  element[index]= _Element;
	size++;
	}
	public Object remove(int index)
	{
	  checkIndex(index);
	  Integer removed = (Integer)element[index];
	  for(int i=index+1;i<size;i++)
	  {
	    element[i-1]=element[i];
	  }
	  size=size-1;
	  element[size]=null;
	return removed;
	}
	public String toString()
	{
	  StringBuffer s = new StringBuffer("[");
	  for(int i=0;i<size;i++)
	    if(element[i]==null)
	      s.append("0");
	    else
	      s.append(element[i].toString()+", ");
	    if(size>0)
	      s.delete(s.length()-2,s.length());
	    s.append("]");
	return new String(s);
	}
	public static void main(String[] args)
	{
	  Scanner sc = new Scanner(System.in);
	  System.out.println("Please enter the size of ArrayList");
	  int p = sc.nextInt();
	  ArrayLinearList b = new ArrayLinearList(p);
	  int c= 1;
	  while(c>=1)
	  {
	    System.out.println("\nEnter your choice:-\n1.Add\n2.delete\n3.dispaly the array\n4.Exit");
	    int a = sc.nextInt();
	    if(a==4)
	      break;
	switch(a)
	{
	case 1:
	  int q= sc.nextInt();
	  Integer m = sc.nextInt();
	  b.add(q,m);
	  break;
	case 2:
	  System.out.println("Enter the index for deleting the object");
	  int k = sc.nextInt();
	  System.out.println("The deleted object is "+b.remove(k));
	  break;
	case 3:
	  System.out.println("the total elements:-\n"+b.toString());
	  break;
	default:
	  System.out.println("Please enter correct input..");
	}
	}
	}
	}
