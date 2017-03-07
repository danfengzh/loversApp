package org.exercise;

/**
 * Created by Administrator on 2017/3/7.
 *
 *

 *
 */
public class demo {
    static boolean resolve(int[] A) {
        int start=0;
        int end=A.length-1;
        int i=start;
        int j=end;
        int suml=0;
        int sumr=0;
        //从两边扫描
        while (i<j){
            if(suml<sumr){
                suml+=A[i++];
            }else {
                sumr+=A[j--];
            }
            if(suml==sumr){
                //两边找到相等的值--先要确保两边可以找到
                break;
            }
            if(j<=i){
                return false;//没有元素
            }
            int temStart=i;
            int tempEnd=j;
            //递归搜索
            int sumTemp = suml;
            int sumLm=0;
            int sumRm=0;
            i++;
            j--;
            //在中间部分进行搜索
            while (i<j){
                if(sumLm < sumRm)
                    sumLm += A[i++];
                else
                    sumRm += A[j--];
                if(sumLm == sumRm && sumLm == suml)
                    return true;
                else
                    return false;
            }
        }
        return false;
    }



    public static void main(String[] args){
//        ArrayList<Integer> inputs = new ArrayList<Integer>();
//        Scanner in = new Scanner(System.in);
//        String line = in.nextLine();
//        while(line != null && !line.isEmpty()) {
//            int value = Integer.parseInt(line.trim());
//            if(value == 0) break;
//            inputs.add(value);
//            line = in.nextLine();
//        }
//        int[] A = new int[inputs.size()];
//        for(int i=0; i<inputs.size(); i++) {
//            A[i] = inputs.get(i).intValue();
    //    2, 5, 1, 1, 1, 1, 4, 1, 7, 3, 7
//        }
        int [] A={2, 5, 1, 1, 1, 1, 4, 1, 7, 3, 7};
        Boolean res = resolve(A);

        System.out.println(String.valueOf(res));
    }
}
