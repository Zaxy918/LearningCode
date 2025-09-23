I.

float f1 = 1.2 is worng because 1.2 is a double type.

float f2 = 1 is true because 1 is an int which can be transform to float.

II.

A class definition must use new.

III.

i有如下代码段：

‌
if (num >= 0)

‌
    if (num == 0)

‌
        System.out.println("first string");

‌
else 

‌
    System.out.println("second string");

‌
System.out.println("third string");

‌
若num为3，则输出结果为：

second string
third string

The else will be connected to the closest if.

IV.

The viriable of java can include $ symbol.

V.

char is 2 bytes

VI.

byte b1 = 129 is wrong.

byte b2 = (byte)129 is true.

VII.

Java有“一次编译，到处运行”的说法，此种说法中编译的结果是：

A.机器码


B.符号表


C.字节码


D.中间代码

The answer is C.

VIII.

class MyNumber


{


   private int num = 5;


   public MyNumber(int num) { this.num = num; }


   public int getNum() { return num; }


   public void setNum(int num) { this.num = num; }


}


   What is output after the executation of following code? 


   MyNumber obj1 = new MyNumber();


   MyNumber obj2 = new MyNumber(10);


   obj2 = obj1;


   obj2.setNum(20);


   System.out.println(obj1.getNum() + “,” + obj2.getNum());

The answer is compilation fail because line 98 did not call the constructor.The initialization must call the constructor if any.