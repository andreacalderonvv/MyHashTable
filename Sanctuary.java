/*
 * Name: Andrea Calderon
 * Email: a6calderon@ucsd.edu
 * PID: A17303613
 * Sources: Write Up, JDK 17 Doc
 * 
 * This Tester tests the various methods in the java files Student, Course,
 * and Sanctuary
 */
import java.util.Objects;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Iterator;


public class Sanctuary{

    HashMap<String, Integer> sanctuary;
    private final int maxAnimals;
    private final int maxSpecies;


    public Sanctuary(int maxAnimals, int maxSpecies){
        if (maxAnimals <= 0 || maxSpecies <= 0 || maxAnimals < maxSpecies){
            throw new IllegalArgumentException();
        }

        this.maxAnimals=maxAnimals;
        this.maxSpecies = maxSpecies;
        this.sanctuary = new HashMap<>();
    }


    public int countForSpecies(String species){//NOT DONEEEEEEEEEEEEEE
        if(species==null){
            throw new IllegalArgumentException();
        }
        if(sanctuary.containsKey(species)){
            return sanctuary.get(species);
            
        }
        return 0;
    }

    public int getTotalAnimals(){
        int total=0;
        for(int s: sanctuary.values()){
            total=total+s;
        }
        return total;
    }

    public int getTotalSpecies(){
        return sanctuary.size();
    }

    public int getMaxAnimals(){
        return maxAnimals;
    }

    public int getMaxSpecies(){
        return maxSpecies;
    }

    public int rescue(String species, int num){
        int leftOver = 0;
        if (num <= 0 || species== null){
            throw new IllegalArgumentException();
        }
        if (sanctuary.containsKey(species)==false && getMaxSpecies()+1 <= maxSpecies && getTotalAnimals() + num <= maxAnimals){
                sanctuary.put(species,num);
                return leftOver;
        }
        else if(sanctuary.containsKey(species)==true && getTotalAnimals() + num <= maxAnimals){
                    sanctuary.put(species,(sanctuary.get(species)+num));
                    return leftOver;
        }
        else if (sanctuary.containsKey(species) == false && getTotalSpecies()+1 > maxSpecies){
            return num;
        }
        else if (sanctuary.containsKey(species) == true && getTotalAnimals() + num > maxAnimals && maxAnimals-(getMaxAnimals()+num) > 0 ){
                int i = 0;
                while (maxAnimals > getTotalAnimals()  || i <= num ){
                    sanctuary.put(species,(sanctuary.get(species)+i));
                }
                return num-i;
        }

        else if(sanctuary.containsKey(species)==false && maxSpecies < getTotalSpecies()+1){
            return num;
        }
        else if(sanctuary.containsKey(species)==true && getTotalAnimals()+num > maxAnimals){
            return num;
        }
        else if(getTotalAnimals()+num < maxAnimals && getTotalSpecies() + 1 < maxSpecies){
            if(sanctuary.containsKey(species)==false){
                sanctuary.put(species,num);
            }
        }
        else if(getTotalAnimals()+num > maxAnimals && getTotalSpecies()+ 1 < maxSpecies){
            leftOver = getTotalAnimals() - maxAnimals;
            int rescues = num-leftOver;
            sanctuary.put(species,rescues);
        }
        return leftOver;
    }

    public void release(String species, int num){
        if(sanctuary.containsKey(species)==false || species==null || num <=0 || num > sanctuary.get(species)){
            throw new IllegalArgumentException();
        }

        sanctuary.replace(species, sanctuary.get(species)-num);
        if(sanctuary.get(species)==0){
            sanctuary.remove(species);
        }
    }
}