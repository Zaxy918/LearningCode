
public class B extends A{
	public B()
	{
		//super(); �������Զ�����super()
		System.out.println("333333");
	}
	public B(int a)
	{
		super(a);  //�����������Զ�����super();
		System.out.println("444444");
	}
	public static void main(String[] a)
	{
		B obj1 = new B();
		System.out.println("==============");
		B obj2 = new B(10);		
	}

}
