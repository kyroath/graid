import java.util.ArrayList;

public class Member
{
  //Properties
  ArrayList<String> tags;
  StringBuffer alphabet = new StringBuffer("abcdefghijklmnopqrstuwxvyz");
  
  //Constructor
  public Member()
  {
    tags = new ArrayList<String>();
    tagMaker();
  }
  
  //Methods
  public void tagMaker()
  {
    int tagNum = (int)(Math.random()*10);
    int pos;
    
    if(tagNum<5)
    {
      tagNum+=5;
    }
    for(int i =0; i<tagNum; i++)
    {
      pos = (int)(Math.random()*alphabet.length());
      tags.add(alphabet.substring(pos, pos+1));
      alphabet.deleteCharAt(pos);
    }    
  }
  
  public ArrayList<String> getTags()
  {
    return tags;
  }
  public String toString()
  {
    return tags.toString();
  }
  
  /**
   * returns the similarity as percent
   */
  public double compareWithGroup(Group g) 
  {
   ArrayList<String> commons = g.findCommons();//group
   ArrayList<String> commonTags = null;//individuals
   int count =0;
   int commonsTotal =0;
   int max;
   
   max= tags.size()*3;
   
   for (int i = 0; i < g.size(); i++) 
   {
     commonTags = g.getMember(i).getTags();
     commonTags.retainAll(tags);
     commonsTotal += commonTags.size();
     
     for (int j = 0; j < commons.size(); j++) 
     {
       if(commonTags.contains(commons.get(j))) 
       {
         count += 2;
       }
     }
   } 
  
  return ((commonsTotal+(double)count)/g.size())/max*100;

  }
}