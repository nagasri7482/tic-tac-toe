 import java.util.ArrayList;
import java.util.*;
import java.util.Random;
import java.util.Scanner;
public class game
{
    static ArrayList<Integer> playerpositions=new ArrayList<Integer>();
    static ArrayList<Integer> cpupositions=new ArrayList<Integer>();  
    public static void main(String[] naga)
   {
      char[][] gameboard = {{' ','|',' ','|',' '},
      {'-','+','-','+','-'},
      {' ','|',' ','|',' '},
      {'-','+','-','+','-'},
      {' ','|',' ','|',' '}
      };
    printboard(gameboard);
    while(true)
    {
      Scanner s=new Scanner(System.in);
      System.out.println("enter a position b/w 1 to 9 ");
      int posi=s.nextInt();

      while(playerpositions.contains(posi)||cpupositions.contains(posi)){
          System.out.println("enter another position");
          posi=s.nextInt();
      }
      printplace(gameboard,posi,"player");

      String result=isWinner();
      if(result.length()>0){
        System.out.println(result);
        break;
      }
      
      Random rand=new Random();
      int cposi=rand.nextInt(9)+1;

      while(playerpositions.contains(cposi)||cpupositions.contains(cposi)){
        System.out.println("enter another position");
        cposi=rand.nextInt(9)+1;
      }

      System.out.println("\ncomputers marker\n\n");
      printplace(gameboard,cposi,"cpu");
      result = isWinner();
      if(result.length()>0){
          System.out.println(result);
          break;
      }         
    }
  }

private static void printplace(char[][] gameboard,int posi,String user)
{
  char simbol =' ';
  if(user.equals("player"))
  {
  simbol='X';
  playerpositions.add(posi);
  }
  else if(user.equals("cpu"))
  {
  simbol='O';
  cpupositions.add(posi);
  }
  switch(posi)
  {
    case 1:gameboard[0][0]= simbol;
    break;
    case 2:gameboard[0][2]= simbol;
    break;
    case 3:gameboard[0][4]= simbol;
    break;
    case 4:gameboard[2][0]= simbol;
    break;
    case 5:gameboard[2][2]= simbol;
    break;
    case 6:gameboard[2][4]= simbol;
    break;
    case 7:gameboard[4][0]= simbol;
    break;
    case 8:gameboard[4][2]= simbol;
    break;
    case 9:gameboard[4][4]= simbol;
    break;
    default:System.out.println("please enter the number");
  }
  printboard(gameboard);
}
private static String isWinner()
{
 List topRow=Arrays.asList(1,2,3);
 List midRow=Arrays.asList(4,5,6);
 List botRow=Arrays.asList(7,8,9);
 List leftCol=Arrays.asList(1,4,7);
 List midCol=Arrays.asList(2,5,8);
 List rightCol=Arrays.asList(3,6,9);
 List cross1=Arrays.asList(1,5,9);
 List cross2=Arrays.asList(7,5,3);
 
 List<List> winning=new ArrayList<List>();
 winning.add(topRow);
 winning.add(midRow);
 winning.add(botRow);
 winning.add(leftCol);
 winning.add(midCol);
 winning.add(rightCol);
 winning.add(cross1);
 winning.add(cross2);
 
 for(List l:winning)
 {
    if(playerpositions.containsAll(l))
    {
    return "congratulations you won";
    }
    else if(cpupositions.containsAll(l))
    {
    return "sorry you lost the game try again";
    }
    
  }
  if(playerpositions.size()+cpupositions.size()==9)
  {
      return "It's a Tie ";
  }
	else{
    return "";
  }
}

  private static void printboard(char[][] gameboard)
  { 
  Scanner s=new Scanner(System.in);
    for(int i=0;i<5;i++){
      for(int j=0;j<5;j++)
      {
      System.out.print(gameboard[i][j]);
      }
      System.out.println();
    }
  }
} 

       
 




