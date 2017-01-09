/**
 * Created by Gosia on 2016-12-19.
 */
public class Voyage extends Cost {
    private int time;
    private String country;

    public Voyage(String country, int time, float cost){
        this.country = country;
        this.time = time;
        this.cost = cost;
    }

    public String getCountry(){
        return country;
    }

    public int getTime() {
        return time;
    }
}
