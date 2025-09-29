I.

 class Ca{
	    int num = 1;
	    Ca(int num){
		        this.num = num;
		        System.out.print(this.num);
	    }
}

class Cb extends Ca{

‍
‌    int num = 2;
	    Cb(int num) {
		        this.num = num;
        System.out.print(num);

‍
‌	    }
	
	    public static void main(String[] args) {
		        Ca a = new Cb(5);
	    }
} 

This cause a compilation fail because the Cb didn't call super(...) func which needs an argument.