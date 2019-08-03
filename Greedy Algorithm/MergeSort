 
      public static void mergeSort(long []a,int low, int high){
         if(low == high)
          return;
          
             int mid = (low + high)/2;
                  mergeSort(a,low,mid);
                  mergeSort(a,mid+1,high);
                  merge(a,low,mid,mid+1,high);
     }
     
     public static void merge(long[] a,int l1, int h1, int l2, int h2){
         int low = l1;
         int k=0;
         long[] temp = new long[h2-l1+1];
         while(l1<=h1 && l2 <= h2){
             if(a[l1] <= a[l2])
                 temp[k++] = a[l1++];
             else
               temp[k++] = a[l2++];
         }
         
         while(l1 <= h1)
          temp[k++] = a[l1++];
          
         while(l2 <= h2)
          temp[k++] = a[l2++];
          
          k=0;
         for(int i=low; i<=h2; i++,k++)
         a[i] = temp[k];
     }
