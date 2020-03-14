 public static int bSearch(int[] a,int val){
         int ans = a.length;
         
         int low = 0;
         int high = a.length-1;
         
         while(low <= high){
             int mid = (low+high)/2;
             if(a[mid] >= val){
                 ans = mid;
                 high = mid-1;
             }
             else
             low = mid+1;
         }
         
         if(ans < a.length && a[ans] == val)
          return ans;
          
          return -ans-1;
     }


// Way 2 seems better gives the first element greater than or equal to the given value  
 public int binarySearch(int[] times, int val,int low, int high){
    
        while(low < high){
            int mid = (low+high)/2;
            if(times[mid] < val){
                low = mid+1;
            }
            else
                high = mid;
        }
        return times[low]>val ? low-1:low;
    }
