package D.E;
//һ����˵���������Ǵ�Сд�ġ������д����������ͳһ

import A.B.C;

public class F {

	public static void main(String[] args) {
		System.out.println("I can call C for cooking");
		new C().cook();
	}
	
	public void cook()
	{
		System.out.println("I can call C");
		new C().cook();
	}

}
