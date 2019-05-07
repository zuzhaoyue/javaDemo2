package guava;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;

/**
 * Created by zuzhaoyue on 2019/3/8.
 */
public class GuavaTest {
    public static void main(String[] args){
//        Optional<Integer> a = Optional.of(null);
//        Optional<Integer> b = Optional.of(1);
//        System.out.println(sum(a,b));

//        System.out.println(sum0(1,-1));
        test();
    }
    public static int  sum(Optional<Integer> a, Optional<Integer> b){
        return a.get() + b.get();
    }
    public static int  sum0(Integer a,Integer b){
        a = Preconditions.checkNotNull(a ,"cannot be null");
        Preconditions.checkArgument(b > 0,"不能为负数",b);
        return a+b;

    }
    public static void test(){
        Double[][]a  = new Double[2][2];
        a[1][0] = 1.0;
        System.out.println(a);
    }
}
