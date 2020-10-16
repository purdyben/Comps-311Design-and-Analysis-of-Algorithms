/**
 * Interval(int low, int high): Constructor with two parameters: the low and high
 * endpoints.
 * • int getLow(): Returns the low endpoint of the interval.
 * • int getHigh(): Returns the high endpoint of the interval
 */
public class Interval {
    private int low;
    private int high;

    public  Interval(int low, int high){
        this.low = low;
        this.high = high;
    }

    public int getHigh() {
        return high;
    }

    public int getLow() {
        return low;
    }
}
