package G;
//һ����˵���������Ǵ�Сд�ġ������д����������ͳһ

import D.E.F;

public class H {

	public static void main(String[] args) {
		System.out.println("I can call F for cooking");
		new F().cook();
	}
	
	public void cook()
	{
		System.out.println("I can call F");
		new F().cook();
	}

}
