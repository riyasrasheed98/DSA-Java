package practice;

import java.util.Arrays;


public class BinarySearch
{

  public static void main(String[] args)
  {
    // TODO Auto-generated method stub
    int[] nums = {-10,-7,0,1,3,6,8,13,15,22,66,87,91};
    int target = 15;
    System.out.println("Binary Searching for target: "+ target + ". In" + Arrays.toString(nums));
    System.out.println( binarySearch(nums, target));
    // Reverse the array using Java Streams
    int[] reversedArray = Arrays.stream(nums)
                                .boxed()
                                .sorted((a, b) -> Integer.compare(b, a))
                                .mapToInt(Integer::intValue)
                                .toArray();    
    System.out.println("Agnostic Binary Searching for target: "+ target + ". In" + Arrays.toString(reversedArray));
    System.out.println(agnosticBinarySearch(reversedArray,target));

  }
  
  public static int binarySearch(int[] nums, int target)
  {
    int start = 0, end = nums.length - 1;
    while(start <= end)
    {
      int mid = start + (end - start)/2;
      if (nums[mid] > target)
      {
        end = mid - 1;
      }
      else if(nums[mid] < target)
      {
        start = mid + 1;
      }
      else
      {
        return mid;
      }
    }
    return -1;
  }
  public static int agnosticBinarySearch(int[] nums, int target)
  {
    int start =0, end = nums.length - 1;
    boolean isAssending = nums[start] < nums[end]; 
    while(start <= end )
    {
      int mid = start + (end - start)/2;
      if (nums[mid] == target)
      {
        return mid;
      }
      if( isAssending)
      {
        if(nums[mid] > target)
        {
          end = mid - 1;
        }
        else if(nums[mid] < target)
        {
          start = mid + 1;
        }
        else
        {
          return mid;
        }
      }
      else 
      {
        if (nums[mid] > target)
        {
          start = mid +1;
        }
        else if (nums[mid] < target)
        {
          end = mid -1;
        }
        else
        {
          return mid;
        }
        
      }
    }
    return -1;
  }

}
