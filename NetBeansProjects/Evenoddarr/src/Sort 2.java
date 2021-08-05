
public class Sort {
    public int[] arrange(int arr[]){
        int temp=0;
        if(arr.length==1 || arr.length==2){
            return arr;
        }
        for(int out=0; out<arr.length; out++){
            for(int sift=1;sift<arr.length; sift++ ){
                if(arr[sift]%2==0 && arr[sift-1]%2!=0){
                    temp=arr[sift];
                    arr[sift]=arr[sift-1];
                    arr[sift-1]=temp;
                }
            }
        }
        return arr;
    }
}
       
