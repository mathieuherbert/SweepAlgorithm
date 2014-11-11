package util;

import model.Possibility;

import java.util.List;

/**
 * Created by math.herbert on 11/11/14.
 */
public class Print {
    public static void printPossibilites(List<List<Possibility>> possibilities) {
        System.out.println("Nombre de possibilités : " +possibilities.size());
        int count = 1;
        for(List<Possibility> possibilities1 : possibilities){
            System.out.println("Possibilité numero : "+count);
            for(Possibility possibility : possibilities1){
                System.out.println("possibility = " + possibility);
            }
            count++;
        }
    }
}
