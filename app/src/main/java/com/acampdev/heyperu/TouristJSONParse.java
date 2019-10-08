package com.acampdev.heyperu;

import com.acampdev.heyperu.Models.Tourist;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class TouristJSONParse {

    public static List<Tourist> parse(String content){
        try{
            JSONArray jsonArray= new JSONArray(content);
            List<Tourist> touristList= new ArrayList<>();
            for(int i=0; i<jsonArray.length();i++){
                JSONObject jsonObject= jsonArray.getJSONObject(i);
                Tourist tourist= new Tourist();
                tourist.setId(jsonObject.getInt("id"));
                tourist.setName(jsonObject.getString("name"));
                tourist.setImg(jsonObject.getString("img"));
                touristList.add(tourist);
            }
            return touristList;
        }catch (JSONException e){
            e.printStackTrace();
            return null;
        }
    }
}
