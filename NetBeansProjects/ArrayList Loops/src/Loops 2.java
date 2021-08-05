
public class Loops {

    public static void main(String[] args) {
//#1
        /*int [] ary={2,5,3,0,4,6,9};
        for(int i=1; i<ary.length; i++){
            ary[i-1]=ary[i];
        }
        ary[ary.length-1]=ary.length; */

//#2
        /*int[] ary;
        int i=3;  //can be anything as long as defined such that 0 <= i < ary.length
        for(int j=1; j<=i; j++){
            ary[j-1]=ary[j];
        }
        ary[i]=123;*/
//#3
        /*int[] ary;
        for(int i=0; i<ary.length;i++){
            int test=0;
            if(ary[i]%2 !=0){
                System.out.println("The index is "+i+" and the value of that index is "+ary[i]);
                test++;
                break;
            }
            if(test==0 && i==ary.length-1){
                System.out.println(-1);
            }
        }*/
///4
        /*int[] ary;
        for(int i=ary.length-1; i>0;i--){
            int test=0;
            if(ary[i]%2 !=0){
                System.out.println("The index is "+i+" and the value of that index is "+ary[i]);
                test++;
                break;
            }
            if(test==0 && i==1){
                System.out.println(-1);
            }
        }*/
//5
        /*int[] ary = {3, 6, 2, 8, 5, 7};
        for (int i = ary.length - 1; i > 0; i--) {
            ary[i] = ary[i - 1];
        }
        ary[0] = 1; */
            
//6 
        /*int[] ary;  
        int i=0; //value of i doesn't matter as long as 0 <= i < ary.length
        for(int j=ary.length-1; j>=i+1; j--){
            ary[j]=ary[j-1];   
        }
        ary[i]=123;  
        */
            

//7     
    /*int []ary;
    int[]newAry= new int[ary.length*2];
    for(int i=0; i<ary.length; i++){
        newAry[i]= ary[i];                
    }
    ary=newAry;*/
    }
}
