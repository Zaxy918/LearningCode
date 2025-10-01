package test.t3;

public class GoodsTest {
    public static void main(String[] args) {
        Goods[] goodsArray = new Goods[3];

        Goods g1 = new Goods("001", "HuaWeiP40", 5999.0, 100);
        Goods g2 = new Goods("002", "XiaoMi10", 4999.0, 200);
        Goods g3 = new Goods("003", "iPhone12", 6999.0, 300);

        goodsArray[0] = g1;
        goodsArray[1] = g2;
        goodsArray[2] = g3;

        for (Goods g : goodsArray) {
            System.out.println("ID: " + g.getId() + ", Name: " + g.getName() + ", Price: " + g.getPrice() + ", Count: " + g.getCount());
        }
    }
}