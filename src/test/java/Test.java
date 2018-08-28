import java.util.Hashtable;
import java.util.Map;

/**
 * @author lk
 * 2018/8/28 10:46
 * @description:
 */
public class Test {
    Hashtable<String, Integer> hashtable = new Hashtable<>();

    @org.junit.Test
    public void Test() {

        hashtable.put("a", 1);
        hashtable.put("b", 2);
        hashtable.put("c", 3);
        hashtable.put("d", 4);
        hashtable.put("e", 5);

        for (Map.Entry<String, Integer> entry: hashtable.entrySet()) {
            System.out.println(entry.getKey() + "  " + entry.getValue());
        }
    }

}
