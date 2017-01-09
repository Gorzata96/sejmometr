import java.util.ArrayList;

/**
 * Created by Gosia on 2016-12-18.
 */
public class Person {
    private String name;
    private String id;

    private ArrayList<Cost> costs = new ArrayList<>();

    public Person(String name, String id) {
        this.name = name;
        this.id = id;
    }


    public float getAllCosts(){
        float costsSum = 0;
        for(Cost c: costs)
            costsSum += c.getCost();
        return costsSum;
    }
    public float getVoyageCostMax(){
        //znajduje najdroższą wycieczkę zagraniczną
    }
    public float getRepairsValue(){
        float repairsSum = 0;

    }
    public int getNumberOfVoyages(){
        //zwraca liczbę podrozy zagranicznych
    }
    public int getVoyagesTime(){
        //zwraca łączny czas za granicą
    }
}
