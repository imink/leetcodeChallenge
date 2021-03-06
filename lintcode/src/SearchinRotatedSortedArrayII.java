/**
 * Created by imink on 12/12/2016.
 */
public class SearchinRotatedSortedArrayII {
    public boolean search(int [] A,int target){
        if(A==null||A.length==0)
            return false;

        int low = 0;
        int high = A.length-1;

        while(low <= high){
            int mid = (low + high)/2;
            System.out.println("mid " + mid);
            if(target < A[mid]){
                if(A[mid]<A[high])//right side is sorted
                    high = mid - 1;//target must in left side
                else if(A[mid]==A[high])//cannot tell right is sorted, move pointer high
                    high--;
                else//left side is sorted
                    if(target<A[low])
                        low = mid + 1;
                    else
                        high = mid - 1;
                System.out.println("high " + high);
            }else if(target > A[mid]){
                if(A[low]<A[mid])//left side is sorted
                    low = mid + 1;//target must in right side
                else if(A[low]==A[mid])//cannot tell left is sorted, move pointer low
                    low++;
                else//right side is sorted
                    if(target>A[high])
                        high = mid - 1;
                    else
                        low = mid + 1;
            }else
                return true;
        }

        return false;
    }
}
