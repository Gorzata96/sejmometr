import java.util.HashMap;
import java.util.IllegalFormatException;
import java.util.Map;

/**
 * Created by Gosia on 2017-01-04.
 */
public class Parser {
    Map<String, Option> optionHashMap = new HashMap<>();
    private Option option;
    private String firstName;
    private String lastName;
    private int cadency;

    public Parser(){
        optionHashMap.put("allCosts", Option.allCosts);
        optionHashMap.put("repairsCosts", Option.repairsCosts);
        optionHashMap.put("average", Option.average);
        optionHashMap.put("mostVoyages", Option.mostVoyages);
        optionHashMap.put("longestVoyage", Option.longestVoyage);
        optionHashMap.put("expensiveVoyage", Option.expensiveVoyage);
        optionHashMap.put("Italy", Option.Italy);
    }

    public void parse(String[] args){
        if(args.length == 0){
            System.err.println("Brak argumentow");
            System.exit(1);
        } else if(args.length > 4){
            System.err.println("Za duzo argumentow");
            System.exit(1);
        }

        try{
            if(optionHashMap.containsKey(args[0]))
                this.option = optionHashMap.get(args[0]);
            else {
                throw new IllegalArgumentException(args[0]+"nie jest poprawny");
            }
        } catch(IllegalArgumentException ex) {
            System.err.println(ex.getMessage());
            System.exit(1);
        }

        if(args.length > 1){
            try{
                this.cadency = Integer.parseInt(args[1]);
            } catch(NumberFormatException ex){
                System.err.println(args[1] + "nie jest liczba");
                System.exit(1);
            }
        }
        else {
            System.err.println("Wybierz kadencje");
            System.exit(1);
        }

        if(this.option!=Option.allCosts && this.option!=Option.repairsCosts) {
            if (args.length > 2) {
                System.err.println("Za duzo argumentow dla podanej opcji");
                System.exit(1);
            }
        }
        else {
            if(args.length == 4){
                try{
                    this.firstName = args[2];
                    this.lastName = args[3];
                } catch(IllegalFormatException ex) {
                    System.exit(1);
                }
            }
            else {
                System.err.println("Wybierz imie i nazwisko posla");
                System.exit(1);
            }
        }
    }

    public Option getOption(){
        return this.option;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public String getName(){
        return this.firstName + " " + this.lastName;
    }
}
