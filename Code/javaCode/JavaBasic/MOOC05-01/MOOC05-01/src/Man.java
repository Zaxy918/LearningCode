public class Man extends Human
{
	//overwrite��д���෽��
	public void eat(){
		System.out.println("I can eat more");
	}
	//��չ���ȸ���ӵ�и���ķ���
	public void plough(){
		System.out.println("I can plough");
	} //����

	public static void main(String[] a)	{
		Man obj1 = new Man();
		obj1.eat();
	}
}
