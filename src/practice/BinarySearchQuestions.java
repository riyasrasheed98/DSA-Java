package practice;

import java.util.Arrays;

public class BinarySearchQuestions
{

  public static void main(String[] args)
  {
    // Question1 Ceiling of  a number
    // Find the smallest number which is greater than or equal to the target.
    System.out.println("Finding Ceil of number");
    int[] arr = {1,2,4,6,8,13,16,18,36,56,74,99};
    int target = 60;
    System.out.println(findCeiling(arr, target));
    System.out.println("Finding Floor of number");
    System.out.println(findFloor(arr,target));
    System.out.println("searchRange find left most element with target as :" + target);
    int [] arr1 = {1,2,3,4,60,60,60,80};
    int [] range = searchRange(arr1,target);
    System.out.println(Arrays.toString(range));
    System.out.println("Finding a number in an infinite array,  that is we cant use arr.length");
    System.out.println(infiniteArrayBS(arr,8));

  }
  public static int findCeiling(int[] arr, int target)
  {
    int start = 0, end = arr.length - 1;
    while(start <= end)
    {
      int mid = start + (end - start)/2;
      if (target > arr[mid])
      {
        start = mid + 1;
      }
      else if (target < arr[mid])
      {
        end = mid - 1;
      }
      else 
      {
        return mid;
      }
    }
    // when the state changes from start, target, end to end, target, start. the next shortest number to the target will
    // be at the position of start so we return start
    
    return arr[start];
  }
  public static int findFloor(int[] arr, int target)
  {
    int start=0, end=arr.length-1;
    while(start <= end) {
      int mid = start + (end-start)/2;
      if (target > arr[mid])
      {
        start = mid+1;
      }
      else if (target < arr[mid]) {
        end = mid-1;
      }
      else {
        return arr[mid];
      }
    }
    return arr[end];
  }
  
  public static int[] searchRange(int[] nums, int target)
  {
    int[] ans = { -1, -1 };
    // find start
    int start = searchIndex(nums, target, true);
    // find end
    int end = searchIndex(nums, target, false);
    ans[0] = start;
    ans[1] = end;
    return ans;
  }

  public static int searchIndex(int[] arr, int num, boolean findStartIndex)
  {
    int start = 0, end = arr.length, ans = -1;
    while (start <= end)
    {
      int mid = start + (end - start) / 2;
      if (arr[mid] < num)
      {
        start = mid + 1;
      }
      else if (arr[mid] > num)
      {
        end = mid = 1;
      }
      else
      {
        ans = mid;
        if (findStartIndex)
        {
          end = mid - 1;
        }
        else
        {
          start = mid + 1;
        }
      }
    }
    return ans;
  }
  public static int infiniteArrayBS(int[] nums, int target)
  {
    int start = 0, end =2;
    if (target > nums[2])
    {
      start = end +1;
      end = end*2;
    }
    if (target <= nums[end])
    {
      while(start <= end)
      {
        int mid = start + (end - start)/2;
        if (target < nums[mid])
        {
          end = mid -1;
        }
        else if (target > nums[mid])
        {
          start = mid + 1;
        }
        else {
          return mid;
        }
      }
    }
    
    
    return -1;
  }
  

  public int peakIndexInMountainArray(int[] arr)
  {
    int start = 0, end = arr.length - 1;
    while (start < end)
    {
      int mid = start + (end - start) / 2;
      if (arr[mid] > arr[mid + 1])
      {
        // dec order
        end = mid;
      }
      else if (arr[mid] < arr[mid + 1])
      {
        start = mid + 1;
      }

    }
    return start;
  }

}
