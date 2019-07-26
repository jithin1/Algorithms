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
