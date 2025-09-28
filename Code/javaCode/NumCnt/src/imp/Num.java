package imp;

import java.lang.Comparable;

public class Num implements Comparable<Num> {
    private int num;
    private int count;

    public Num(int num, int count) {
        this.num = num;
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void increment(int n) {
        count += n;
    }

    public int getNum() {
        return num;
    }

    @Override
    public int compareTo(Num o) {
        return (-1) * (this.count - o.count);
    }
}
