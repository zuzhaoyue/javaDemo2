import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by zuzhaoyue on 2019/1/7.
 */
public class TestDemo {
    public static void main(String args[]) throws IOException {
//        testTreeSet();
//        test();
        test2();
    }
    public static  void  testTreeSet() throws IOException {
//        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
//        System.out.println("current loader:" + classLoader);
//        System.out.println("parent loader:" + classLoader.getParent());
//        System.out.println("grandparnt loader:" + classLoader.getParent().getParent());
//        String a = "{\"msg\":\"令牌无效:3a6e5b7f-2a68-4aad-b1aa-56b054153202\",\"code\":1}";
//        ObjectMapper mapper = new ObjectMapper();
//        JsonNode node  = mapper.readTree(a);
//        System.out.println(node.get("code").asText());

        Set aa = new HashSet<String>();
        aa.add("aa0");
        Set bb = new HashSet();
        bb.add("bb0");
        aa.addAll(bb);

        System.out.println(aa.toArray());

       /* Set<String> tree = new TreeSet<String>();
//        tree.add("ssd");
//        tree.add("asd");
//        tree.add("bnc");
        tree.addAll(Arrays.asList("sdsd","aaa","ccc"));
        for(String a:tree){
            System.out.println(a);
        }*/
    }
    public static void test() throws UnsupportedEncodingException {
        String  url = URLEncoder.encode(String.format("https://monitor.faas.alpha.elenet.me/infra/appos/byAppId?from=now()-1h&to=now()-30s&appid=%s","aaaaa"), "gb2312");
        String  url2 = String.format("https://monitor.faas.alpha.elenet.me/infra/appos/byAppId?from=now%28%29-1h&to=now%28%29-30s&appid=%s","aaaaa");
        String  url3 = "https://monitor.faas.alpha.elenet.me/infra/appos/byAppId?from=now%28%29-1h&to=now%28%29-30s&appid=" + "aaaaa";
        System.out.println(url);
        System.out.println(url2);
        System.out.println(url3);
    }
    public static void test2(){
        DecimalFormat df = new DecimalFormat("0.00");
        String a = df.format(0.26);
        System.out.println(a);

    }
}
