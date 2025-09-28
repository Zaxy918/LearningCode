package JavaClass;

public class StringClass {
    public static void main(String[] args) {
        String str1 = "123;456;7899;123";
        System.out.println((str1.charAt(0)));
        System.out.println(str1.indexOf(";"));
        System.out.println(str1.concat(";000"));
        System.out.println(str1.contains("000"));
        System.out.println(str1.endsWith("000"));
        System.out.println(str1.equals("000"));
        System.out.println(str1.equalsIgnoreCase("000"));
        System.out.println(str1.length());
        System.out.println(str1.trim());
        String[] str2 = str1.split(";");
        for (int i = 0; i < str2.length; i++) {
            System.out.println(str2[i]);
        }
        System.out.println("==========");
        System.out.println(str1.substring(2, 5));
        System.out.println(str1.replace("1", "a"));
        System.out.println(str1.replaceAll("1", "b"));
    }
}
