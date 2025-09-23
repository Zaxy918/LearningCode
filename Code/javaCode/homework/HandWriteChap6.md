I.

static String s;

The s is not initialized, which makes it null.

II.

‌class Tree {

‌	private static String tree = "tree";

‌	String getTree() {

‌		return tree;

​‌	}

‌}

‌public class Elm extends Tree {

‌	private static String tree = "elm";

‌	public static void main(String[] args) {

‌		new Elm().go(new Tree());

‌	}

‌	void go(Tree t) {

​‌		String s = t.getTree() + Elm.tree + tree + (new Elm().getTree());

‌		System.out.println(s);

​‌	}

​‌}

The result is treeelmelmtree.

III.

​class A {

​	public static int x = 10;

​	public static void printX() {

​		System.out.print(x);
​
​	}

​}

​public class Elm extends A {

​	public int x = 20;

​	public static void main(String[] args) {

​		A a = new Elm();

​		printX();

​		System.out.print("and");

​		System.out.print(a.x);

​	}

​}

The result is 10 and 10.x in A is a static variable, which is not an instance of A,making it not be connected to elm, so the a.x will not be 20.