package com.acampdev.heyperu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.acampdev.heyperu.Adapters.TouristAdapter;
import com.acampdev.heyperu.Models.Tourist;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Lugares extends Fragment {

    RecyclerView recyclerView;
    ProgressBar progressBar;
    List<Tourist> touristList= new ArrayList<>();
    TouristAdapter adapter;
    private final String JSON_URL="https://gist.githubusercontent.com/alexandr28/4879b280e39889f40f5fdcbf50937467/raw/ad309f2c2bb01f23d88d14aa2defa02a3b07d66c/tourist.json/";
    JsonArrayRequest jsonArrayRequest;
    RequestQueue requestQueue;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView;
        rootView=inflater.inflate(R.layout.fragment_lugares,container,false);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView=view.findViewById(R.id.recyclerViewID);
        progressBar=view.findViewById(R.id.progressBarID);
        progressBar.setVisibility(View.INVISIBLE);
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(Objects.requireNonNull(getActivity()).getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        jsonrequest();
    }

    private  void  jsonrequest(){
        jsonArrayRequest= new JsonArrayRequest(JSON_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject= null;
                for(int i=0; i<response.length(); i++){
                    try{
                        jsonObject=response.getJSONObject(i);
                        Tourist tourist = new Tourist();
                        tourist.setName(jsonObject.getString("name"));
                        tourist.setUbigeo(jsonObject.getString("ubigeo"));
                        tourist.setImg(jsonObject.getString("img"));
                        tourist.setDescription(jsonObject.getString("description"));
                        touristList.add(tourist);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
                setupRecyclerView(touristList);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue = Volley.newRequestQueue(Objects.requireNonNull(getActivity()).getApplicationContext());
        requestQueue.add(jsonArrayRequest);
    }
    private void setupRecyclerView(List<Tourist> list){
        adapter= new TouristAdapter(Objects.requireNonNull(getActivity()).getApplicationContext(),touristList);
        recyclerView.setLayoutManager(new LinearLayoutManager(Objects.requireNonNull(getActivity()).getApplicationContext()));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }
}
