import java.util.*;

public class Arrays1 {
    public static int findLargest(int[]arr){
        int largest = arr[0];
        for(int i=0;i<arr.length;i++){
            if(arr[i] > largest){
                largest = arr[i];
            }
        }
        return largest;
    }
    public static int secondLargest(int[]arr){
        int largest = arr[0];
        int second_largest = -1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>largest){
                second_largest = largest;
                largest = arr[i];
            } else if (arr[i] < largest && arr[i] > second_largest) {
                second_largest = arr[i];
            }
        }
        return second_largest;
    }
    public static int secondSmallest(int[]arr){
        int smallest = arr[0];
        int ssmallest = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i] < smallest){
                ssmallest = smallest;
                smallest = arr[i];
            } else if (arr[i] > smallest && arr[i]<ssmallest) {
                ssmallest = arr[i];
            }
        }
        return ssmallest;
    }
    public static boolean isSorted(int[]arr){
        for(int i=1;i<arr.length;i++){
            if(arr[i] >= arr[i-1]){

            }else{
                return false;
            }
        }
        return true;
    }
    public static int removeDuplicates(int[]arr){
        int i =0;
        for(int j=1;j<arr.length;j++){
            if(arr[j] != arr[i]){
                i++;
                arr[i] = arr[j];
            }
        }
        return i+1;
    }
    public static void leftRotateByOne(int[]arr){
        int element = arr[0];
        for(int i=1;i<arr.length;i++){
            arr[i-1] = arr[i];
        }
        arr[arr.length-1] = element;
    }
//    ---------Brute force---------
//    public static void leftRotate(int[]arr,int n,int d){
//        d = d%n;
//        int[]temp = new int[d];
//        for(int i=0;i<temp.length;i++){
//            temp[i] = arr[i];
//        }
//        for(int i=d;i<arr.length;i++){
//            arr[i-d] = arr[d];
//        }
//
//        for(int i=n-d;i<n;i++){
//            arr[i] = temp[i-(n-d)];
//        }
//    }
    public static void leftRotate(int[]arr,int n,int d){
        reverse(arr,0,d-1);
        reverse(arr,d,n);
        reverse(arr,0,n);
    }
    public static void reverse(int[]arr,int s , int e){
        while (s <= e){
            int temp = arr[s];
            arr[s] = arr[e];
            arr[e] = temp;
            s++;
            e--;
        }
    }
//    public static void moveZerosToEnd(int arr[]){
//        int count = 0;
//        for(int i=0;i<arr.length;i++){
//            if(arr[i] == 0){
//                count++;
//            }else{
//                arr[i-count] = arr[i];
//            }
//        }
//    }
    public static void moveZerosToEnd(int[]arr){
        int j=-1;
        for(int i=0;i<arr.length;i++){
            if(arr[i] == 0){
                j=i;
                break;
            }
        }
        for(int i=j+1;i<arr.length;i++){
            if(arr[i] != 0){
                arr[j] = arr[i];
                arr[i] = 0;
                j++;
            }
        }
    }

//    public int[] union(int[]arr1,int[]arr2){
//        Set<Integer>set = new HashSet<>();
//        for(int i=0;i< arr1.length;i++){
//            set.add(arr1[i]);
//        }
//        for(int i=0;i<arr2.length;i++){
//            set.add(arr2[i]);
//        }
//        int[]union = new int[set.size()];
//       int i=0;
//       for(int ele:set){
//           union[i++] = ele;
//       }
//       return union;
//
//    }
//    public static ArrayList<Integer> union(int[]arr1, int[]arr2){
//        int i =0;
//        int j =0;
//        ArrayList<Integer>union = new ArrayList<>();
//        while(i <arr1.length && j<arr2.length){
//
//            if(arr1[i] <= arr2[j]){
//                if(union.isEmpty() || union.getLast()!=arr1[i]){
//                    union.add(arr1[i]);
//                }
//                i++;
//            }else {
//                if(union.isEmpty() || union.getLast()!=arr2[j]){
//                    union.add(arr2[j]);
//                }
//                j++;
//            }
//
//        }
//        while(i < arr1.length){
//            if(union.isEmpty() || union.getLast()!=arr1[i]){
//                union.add(arr1[i]);
//            }
//            i++;
//        }
//        while(j <arr2.length){
//            if(union.isEmpty() || union.getLast()!=arr2[j]){
//                union.add(arr2[j]);
//            }
//            j++;
//        }
//        return union;
//    }
//
//    public static ArrayList<Integer>intersection(int[]a,int[]b){
//        int i =0;
//        int j =0;
//        ArrayList<Integer>intersection = new ArrayList<>();
//        while(i<a.length && j<b.length){
//            if(a[i] < b[j]){
//                i++;
//            }else if(b[j] < a[i]){
//                j++;
//            }else{
//                intersection.add(a[i]);
//                i++;
//                j++;
//            }
//        }
//        return intersection;
//    }

    public static ArrayList<Integer>union(int[]a,int[]b){
        int i =0;
        int j =0;
        ArrayList<Integer>union = new ArrayList<>();
        while(i<a.length && j<b.length){
            if(a[i] <= b[j]){
                if(union.isEmpty() || union.getLast() != a[i]){
                    union.add(a[i]);
                }
                i++;
            }else{
                if(union.isEmpty() || union.getLast() == b[j]){
                    union.add(b[j]);
                }
                j++;
            }
        }
        while(i<a.length){
            if(union.isEmpty() || union.getLast() != a[i]){
                union.add(a[i]);
            }
            i++;
        }

        while(j<b.length){
            if(union.isEmpty() || union.getLast() != b[j]){
                union.add(b[j]);
            }
            j++;
        }
        return union;
    }

    public static ArrayList<Integer> getIntersection(int[]a,int[]b){
        ArrayList<Integer>intersection = new ArrayList<>();
        int i = 0;
        int j = 0;
        while(i < a.length || j<b.length){
            if(a[i] < b[j]){
                i++;
            }else if(b[j] < a[i]){
                j++;
            }else{
                intersection.add(a[i]);
                i++;
                j++;
            }
        }
        return intersection;
    }

//    public static int findMissing(int[]arr,int N){
//        int[]hashArray = new int[N+1];
//        for(int i=0;i<arr.length;i++){
//            hashArray[arr[i]] = 1;
//        }
//        int missing = -1;
//        for(int i=1;i<hashArray.length;i++){
//            if(hashArray[i] == 0){
//                missing =  i;
//            }
//        }
//        return missing;
//    }

//    public static int findMissing(int[]arr,int N){
//        int sum = (N*(N+1))/2;
//        int arrSum = 0;
//        for(int i=0;i<arr.length;i++){
//            arrSum+=arr[i];
//        }
//        return sum - arrSum;
//    }
    public static int findMissing(int[]arr,int N){
        int XOR1 = 0;
        int XOR2 = 0;
        for(int i=0;i<arr.length;i++){
            XOR1 = XOR1^arr[i];
            XOR2 = XOR2^(i+1);
        }
        return XOR1^XOR2;
    }

    public static int maximumConsecutiveOne(int[]arr){
        int count=0;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i] == 1){
                count++;
                max = Math.max(max,count);
            }else{
                count =0 ;
            }
        }
        return max;
    }

//    public static int findNumberAppearsOnce(int[]arr){
//        int XOR1=0;
//        for(int i=0;i<arr.length;i++){
//            XOR1 = XOR1^arr[i];
//        }
//        return XOR1;
//    }

    public static int findNumberAppearsOnce(int[]arr){
        Map<Integer,Integer>map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        for(int num:arr){
            if(map.get(num) == 1){
                return num;
            }
        }
        return -1;
    }

//    public static int longestSubarrayWithSum(int[]arr,int k){
//        int start=0;
//        int window = 0;
//        int sum =0;
//        for(int i=0;i<arr.length;i++){
//             sum = sum+arr[i];
//            while (sum > k){
//                sum-=arr[start];
//                start++;
//            }
//            if(sum == k){
//                window= Math.max(window,(i-start)+1);
//            }
//        }
//        return window;
//    }

//    public static int longestSubarrayWithSum(int[]arr,int K){
//
//        int longest=0;
//        for(int i=0;i<arr.length;i++){
//            int sum=0;
//            for(int j=i;j<arr.length;j++){
//                sum+=arr[j];
//                if(sum == K){
//                    longest = Math.max(longest,j-i+1);
//                }
//            }
//        }
//        return longest;
//    }

//    public static int longestSubarrayWithSum(int[]arr,int K){
//        int[]prefixSum=new int[arr.length];
//        int length=0;
//        prefixSum[0]=arr[0];
//        for(int i=1;i<arr.length;i++){
//            prefixSum[i]=prefixSum[i-1]+arr[i];
//        }
//        for(int i=1;i<arr.length;i++){
//            for(int j=i;j<arr.length;j++){
//                int currSum = i==0?prefixSum[j]:prefixSum[j]-prefixSum[i-1];
//                if(currSum == K){
//                    length = Math.max(length,(j-i)+1);
//                }
//            }
//        }
//        return length;
//    }

//    public static int longestSubarrayWithSum(int[]arr,int K){
//        Map<Integer,Integer>prefixSum = new HashMap<>();
//        int length =0;
//        int sum=0;
//        for(int i=0;i<arr.length;i++){
//            sum+=arr[i];
//            if(sum == K){
//                length = Math.max(length,i+1);
//            }
//            int remaining = sum - K ;
//            if(prefixSum.containsKey(remaining) ){
//                int j = prefixSum.get(remaining);
//                length = Math.max(length,(i-j));
//            }
//            if(!prefixSum.containsKey(sum)){
//                prefixSum.put(sum,i);
//            }
//        }
//        return length;
//    }
    public static int longestSubarrayWithSum(int[]arr,int K){
        int left=0;
        int right = 0;
        int sum=arr[0];
        int maxLength=0;
        while(right<arr.length){
            while(sum>K && left<=right){
                sum-=arr[left];
                left++;
            }
            if(sum == K){
                maxLength = Math.max(maxLength,(right-left)+1);
            }
            right++;
            if(right<arr.length){
                sum+=arr[right];
            }
        }
        return maxLength;
    }

//    public static int[] findTwoSums(int[]arr,int target){
//        for(int i=0;i<arr.length;i++){
//            int remain = target - arr[i];
//            for(int j=i+1;j<arr.length;j++){
//                if(arr[j] == remain){
//                    int[]ans={i,j};
//                    return ans;
//                }
//            }
//        }
//        return null;
//    }

//    public static int[] findTwoSums(int[]arr,int target){
//        Map<Integer,Integer>remaining = new HashMap<>();
//        remaining.put(target-arr[0],0);
//        for(int i=1;i<arr.length;i++){
//            if(remaining.containsKey(arr[i])){
//                int[]ans = {remaining.get(arr[i]),i};
//                return ans;
//            }
//            remaining.put(target-arr[i],i);
//        }
//        return null;
//    }

//    public static int[]findTwoSums(int[]arr,int target){
//        Map<Integer,Integer>map = new HashMap<>();
//        map.put(arr[0],0);
//        for(int i=1;i<arr.length;i++){
//            int remaining = target - arr[i];
//            if(map.containsKey(remaining)){
//                int[]ans = {map.get(remaining),i};
//                return ans;
//            }
//            map.put(arr[i],i);
//        }
//        return null;
//    }

    public static int[]findTwoSums(int[]arr,int target){
        Arrays.sort(arr);
        int i = 0;
        int j = arr.length-1;
        while(i < j){
            int sum = arr[i] + arr[j];
            if(sum == target){
                int[]ans = {i,j};
                return ans;
            } else if (sum > target) {
                j++;
            }else {
                i++;
            }
        }
        return null;
    }


    public static void main(String[]args){
        int[]arr = {1,2,3,1,1,1,1,4,2,3};
        System.out.println(longestSubarrayWithSum(arr,3));
    }
}
