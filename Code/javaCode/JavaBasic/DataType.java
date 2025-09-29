public class DataType {
    public static void main(String[] args) {
        boolean a = true;//a = 1 is an error.
        boolean b = 3 > 5;
        byte c = (byte)127;//-128 ~ 127
        short d = 32767;
        //shor d = 32768 is an error
        int e = 2147483647;//32bits
        //int e = 2147483648 is an error
        long f = 21;//Implicit transform from int to lont.
        long g = 10000000000000L;//The last L is necessary.
        float h = 1.23f;//The last f is necessary.
        double i = 4.56d;//The last d is not necessary.
        System.out.println(h==1.229999999f);//true
        System.out.println(h-1.229999999f);//0.0
        char j = '\u4e00';//Unicode 2bytes
        System.out.println(j);//一
    }
}
