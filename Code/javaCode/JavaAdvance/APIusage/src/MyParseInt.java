public class MyParseInt {
    public static Integer test(String numStr) {
        if (!numStr.matches("-{0,1}[1-9]\\d{0,9}"))
            return Integer.MAX_VALUE;
        String absNumStr = numStr.charAt(0) == '-' ? numStr.substring(1) : numStr;
        Integer num = 0;
        for (int i = 0; i < absNumStr.length(); i++) {
            num = 10 * num + absNumStr.charAt(i) - '0';
        }
        return numStr.charAt(0) == '-' ? -num : num;
    }
}
