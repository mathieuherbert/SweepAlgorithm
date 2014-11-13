package util;

import model.Possibility;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by math.herbert on 12/11/14.
 */
public class Verify {

    public static boolean samePossibilities(List<List<Possibility>> p1, List<List<Possibility>> p2){
        if (p1.size() != p2.size())
               return false;
        boolean[] foundP1InP2 = new boolean[p1.size()];
        for(int i = 0; i< foundP1InP2.length;i++){
            foundP1InP2[i] = false;
        }
        for(int i = 0; i<p2.size(); i++){
            for(int j =0; j<p1.size(); j++){
                if(samePossibility(p2.get(i), p1.get(j))){
                    if(foundP1InP2[j]){
                        //twice the same possibility
                        return false;
                    }else{
                        foundP1InP2[j] = true;
                    }
                }
            }
        }
        for(int i = 0; i< foundP1InP2.length;i++){
            if(foundP1InP2[i] == false){
                return false;
            }
        }
        return true;
    }

    public static List<List<Possibility>> areNotInP2(List<List<Possibility>> p1, List<List<Possibility>> p2) throws Exception {

        boolean[] foundP1InP2 = new boolean[p1.size()];
        for(int i = 0; i< foundP1InP2.length;i++){
            foundP1InP2[i] = false;
        }
        for(int i = 0; i<p2.size(); i++){
            for(int j =0; j<p1.size(); j++){
                if(samePossibility(p2.get(i), p1.get(j))){
                    if(foundP1InP2[j]){
                        //twice the same possibility
                        throw new Exception("Twice the same");
                    }else{
                       // System.out.println("isok");
                        foundP1InP2[j] = true;
                    }
                }
            }
        }
        List<List<Possibility>> possibilites = new ArrayList<List<Possibility>>();
        for(int i = 0; i< foundP1InP2.length;i++){
            if(foundP1InP2[i] == false){
                possibilites.add(p1.get(i));
            }
        }
        return possibilites;
    }


    public static boolean samePossibility(List<Possibility> p1, List<Possibility> p2){
        if (p1.size() != p2.size())
            return false;
        boolean[] foundP1InP2 = new boolean[p1.size()];
        for(int i = 0; i< foundP1InP2.length;i++){
            foundP1InP2[i] = false;
        }
        for(int i = 0; i<p2.size(); i++){
            for(int j =0; j<p1.size(); j++){
                if(p2.get(i).equals(p1.get(j))){
                    if(foundP1InP2[j] == true){
                        continue;
                    }else{
                        foundP1InP2[j] =true;
                        break;
                    }
                }
            }
        }
        for(int i = 0; i< foundP1InP2.length;i++){
            if(foundP1InP2[i] == false){
                return false;
            }
        }

        return true;
    }
}
