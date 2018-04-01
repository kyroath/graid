import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;

public class GroupTester
{
  public static void main(String[] args)
  {
    Member m1 = new Member();
    Member m2 = new Member();
    Member m3 = new Member();
    Member m4 = new Member();
    Member m5 = new Member();
    Member m6 = new Member();
    
    Group g1 = new Group();
    Group g2 = new Group();
    
    g1.add(m1);
    g1.add(m2);
    g1.add(m3);
    g1.add(m4);
    
    System.out.println(m4);
    System.out.println(g1+"\n");
    
    System.out.println(g1.findCommons());
    
    System.out.println(m4.compareWithGroup(g1));
        
  }  
}