import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Food extends Product {
    private Date prodDate;
    private int shelfLong;
    private Date shelfEnd;

    /***
     *
     * @param name
     * @param price
     * @param prodDate
     * @param shelfLong
     */
    public Food(String name, int price, String prodDate, int shelfLong) {
        super(name, price);
        SimpleDateFormat parser = new SimpleDateFormat("dd.MM.yyyy");
        try {
            this.prodDate = parser.parse(prodDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        this.shelfLong = shelfLong;
        ToMs<Integer> days = d -> d  * (24 * 60 * 60 * 1000);
        this.shelfEnd = new Date(this.prodDate.getTime() + days.getMS(this.shelfLong));
    }
    public long getProdDateMs(){return this.prodDate.getTime();}
    public String getProdDate() {
        return new SimpleDateFormat("dd.MM.yyyy").format(this.prodDate);
    }

    public int getShelfLife() {
        return shelfLong;
    }

    public String getShelfEnd() {
        return new SimpleDateFormat("dd.MM.yyyy").format(this.shelfEnd);
    }

    @Override
    public String toString() {
        Date now = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        return super.getName() + " " + super.getPrice() + "(годен до: " + this.getShelfEnd() + ")" +
                (this.shelfEnd.before(new Date()) ? "ЗАКОНЧИЛСЯ СРОК ГОДНОСТИ!" : "");
    }


}