import java.util.Arrays;

import java.util.Scanner;

class Currency {

    private String name; // 货币名称

    private int originalValue; // 原始值

    private int value; // 转换为人民币后的值

    public static String[] CURRENCY_NAME = { "CNY", "HKD", "USD", "EUR" };

    public static int[] CURRENCY_RATIO = { 100, 118, 15, 13 };

    public String getName() {

        return name;

    }

    public void setName(String name) {

        this.name = name;

    }

    public int getOriginalValue() {

        return originalValue;

    }

    public void setOriginalValue(int originalValue) {

        this.originalValue = originalValue;

    }

    public int getValue() {

        return value;

    }

    public void setValue(int value) {

        this.value = value;

    }

}

class HKD extends Currency implements Comparable {

    HKD(int originalValue) {

        this.setOriginalValue(originalValue);

        this.setValue(originalValue * CURRENCY_RATIO[1] / CURRENCY_RATIO[0]);
        this.setName(CURRENCY_NAME[1]);
    }

    @Override
    public int compareTo(Object o) {

        Currency c = (Currency) o;

        if (this.getValue() < c.getValue()) {

            return 1;

        } else if (this.getValue() > c.getValue()) {

            return -1;

        } else {

            return 0;

        }

    }
}

class USD extends Currency implements Comparable {

    USD(int originalValue) {

        this.setOriginalValue(originalValue);

        this.setValue(originalValue * CURRENCY_RATIO[2] / CURRENCY_RATIO[0]);
        this.setName(CURRENCY_NAME[2]);
    }

    @Override
    public int compareTo(Object o) {

        Currency c = (Currency) o;

        if (this.getValue() < c.getValue()) {

            return 1;

        } else if (this.getValue() > c.getValue()) {

            return -1;

        } else {

            return 0;

        }

    }
}

class EUR extends Currency implements Comparable {

    EUR(int originalValue) {

        this.setOriginalValue(originalValue);

        this.setValue(originalValue * CURRENCY_RATIO[3] / CURRENCY_RATIO[0]);
        this.setName(CURRENCY_NAME[3]);
    }

    @Override
    public int compareTo(Object o) {

        Currency c = (Currency) o;

        if (this.getValue() < c.getValue()) {

            return 1;

        } else if (this.getValue() > c.getValue()) {

            return -1;

        } else {

            return 0;

        }

    }
}

public class Main {

    public static void main(String[] args) {

        Currency[] cs = new Currency[3];

        Scanner sc = new Scanner(System.in);

        int a = 0;

        int b = 0;

        int c = 0;

        if (sc.hasNext()) {

            a = sc.nextInt();

            cs[0] = new HKD(a);

        }

        if (sc.hasNext()) {

            b = sc.nextInt();

            cs[1] = new USD(b);

        }

        if (sc.hasNext()) {

            c = sc.nextInt();

            cs[2] = new EUR(c);

        }

        sc.close();
        Arrays.sort(cs);
        for (Currency currency : cs) {
            System.out.println(currency.getName() + currency.getOriginalValue());
        }

    }

}