public class SortingAlgo {
    public static void bubbleSort(int[]arr){
        for(int turns=0;turns<arr.length;turns++){
            boolean swap = false;
            for(int j=0;j<arr.length-turns-1;j++){
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
        for(int index = 1; index<arr.length ; index++){
            int temp = arr[index];
            int compareIndex = index-1;
           while(compareIndex >= 0 && arr[compareIndex] > temp){
               arr[compareIndex+1] = arr[compareIndex];
               compareIndex--;
           }
           arr[compareIndex+1] = temp;
        }
    }

    public static void selectionSort(int[]arr){
        for(int i=0;i<arr.length-1;i++){
            int min = i+1;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[min]){
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }

    public static void quickSort(int[]arr,int low,int high){
            int partationIndex = getPartationIndex(arr,low,high);
            quickSort(arr,low,high);

    }

    public static int getPartationIndex(int arr[],int low,int high){

    }


    public static void main(String[]args){
          int []arr = {3,4,8,10,2,5,7};
//          bubbleSort(arr);
//        insertionSort(arr);
        selectionSort(arr);
          for(int i=0;i<arr.length;i++){
              System.out.print(arr[i]+" ");
          }
    }
}
