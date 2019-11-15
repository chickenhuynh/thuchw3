package com.example.thuchw3;

import com.example.thuchw3.APIClasses.Cat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FavouriteCatDatabase {

    public static HashMap<String, Cat> favouriteCatsMap;

    static{
        favouriteCatsMap = new HashMap<>();
    }
    
    public static ArrayList<Cat> getFavouriteCats(){
        ArrayList<Cat> favouriteCatsArray = new ArrayList<>();
        for (Map.Entry<String, Cat> favouriteCat :
                favouriteCatsMap.entrySet()) {
            favouriteCatsArray.add(favouriteCat.getValue());
        }
        return favouriteCatsArray;
    }

    public static void addToFavourites(Cat newCat){
        String catId = newCat.getId();
        //Check If Cat Exists
        if (!favouriteCatsMap.containsKey(catId)){
            favouriteCatsMap.put(catId, newCat);
            System.out.println(newCat.getName() + " has been added to your favourites");
        } else {
            System.out.println("Oops, looks like this cat is already a favourite");
        }
    }

    public static void removeFromFavourite(Cat newCat){
        String catId = newCat.getId();
        //Check If Cat Exists
        if (favouriteCatsMap.containsKey(catId)){
            favouriteCatsMap.remove(catId);
            System.out.println(newCat.getName() + " is now removed from your favourites");
        } else {
            System.out.println("Aw poor cat");
        }

    }

}
