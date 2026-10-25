public class SortingAlgo {
    public static void bubbleSort(int[]arr){
        for(int pass=1;pass<arr.length;pass++){
            boolean swap = false;
            for(int j=0;j<arr.length-pass;j++){
                if(arr[j] > arr[j+1]){
                    swap = true;
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
                if(!swap){
                    break;
                }
            }
        }
    }

    public static void insertionSort(int[] arr){
        for(int pass = 0; pass<arr.length-1 ; pass++){
            int temp = arr[pass+1];
            int compareIndex = pass;
           while(compareIndex >= 0 && arr[compareIndex] > temp){
//               shifting the larger elements to right
               arr[compareIndex+1] = arr[compareIndex];
               compareIndex--;
           }
           arr[compareIndex+1] = temp;
        }
    }

    public static void selectionSort(int[]arr){
        for(int pass=0;pass<arr.length-1;pass++){
            int minIdx = pass+1;
            for(int j=pass+1;j<arr.length;j++){
                if(arr[j]<arr[minIdx]){
                    minIdx= j;
                }
            }
            int temp = arr[pass];
            arr[pass] = arr[minIdx];
            arr[minIdx] = temp;
        }
    }

    public static void quickSort(int[]arr,int low,int high){
            int partationIndex = getPartationIndex(arr,low,high);
            quickSort(arr,low,high);

    }

    public static int getPartationIndex(int arr[],int low,int high){
        return 0;
    }


    public static void main(String[]args){
          int []arr = {3,4,8,10,2,5,7};
//          bubbleSort(arr);
        insertionSort(arr);
//        selectionSort(arr);
          for(int i=0;i<arr.length;i++){
              System.out.print(arr[i]+" ");
          }
    }
}
