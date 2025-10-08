import java.util.Arrays;

public class LambdaEx {
    public static void test() {
        String[] strs = { "hello", "world", "java", "python", "c++", "go", "javascript", "typescript", "ruby", "perl", "swift" };
        Arrays.sort(strs, (s1, s2) -> s1.length() - s2.length());
        System.out.println(Arrays.toString(strs));
    }
}
