package practice;

import java.util.Arrays;
import java.util.Scanner;

public class linear_search
{

  public static void main(String[] args)
  {
    // TODO Auto-generated method stub
    System.out.println("Type the Target to search in array:");
    Scanner in = new Scanner(System.in);
    int target = in.nextInt();
    int[] nums = {1,2,3,4,5,6,7,8};
    System.out.println("The target present is : "+ linearSearch(nums, target));
    System.out.println("Enter the string to check");
    String name = "Hello World";
    System.out.println("First character to check in string :" + name);
    char letter = name.charAt(0);
    System.out.println("Searching "+ letter+ "in " + name);
    System.out.println("the letter " + letter + "in " + name + "Present is:" + linearSearchString(letter, name));    
    System.out.println("Finding minimum of array" + Arrays.toString(nums) + " is :");
    System.out.println(findMin(nums));
    System.out.println("Finding max of array" + Arrays.toString(nums) + " is :");
    System.out.println(findMax(nums));
    int[][] twoDimArr = {
      {1,2,3},{4,5},{6,7,8},{9,10}
    };
    System.out.println("Searching in " + target + " 2d array ");
    for (int[] arr : twoDimArr)
    {
      System.out.println(Arrays.toString(arr));
    }
    int[] ans = search2D(twoDimArr,target);
    System.out.println("The Element is present at "+ Arrays.toString(ans));
  }


  private static int[] search2D(int[][] twoDimArr, int target)
  {
    for (int row=0 ; row< twoDimArr.length; row++)
    {
      for (int col=0 ; col < twoDimArr[row].length; col++)
      {
        if(twoDimArr[row][col] == target)
        {
          int [] location = {row, col};
          return location;
        }
      }
    }
    return new int[] {-1,-1};
  }


  private static boolean linearSearchString(char letter, String name)
  {
    for (char element : name.toCharArray()) 
    {
      if (element == letter)
      {
        return true;
      }
    }
    return false;
    
  }

  private static boolean linearSearch(int[] nums, int target)
  {
    for (int element : nums)
    {
      if (element == target)
        return true;
    }
    return false;
  }
  private static int findMin(int[] arr1 )
  {
    int min = arr1[0];
    for (int i=1;i<arr1.length ; i++)
    {
      if (arr1[i] < min)
      {
        min = arr1[i];
      }
    }
    return min;
  }
  
  private static int findMax(int[] arr)
  {
    int max = arr[0];
    for (int i = 1 ; i<arr.length; i++)
    {
      if (arr[i]> max)
      {
        max = arr[i];
      }
    }
    return max;
    
  }  

}
