package com.example.mealplan.service;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.mealplan.controller.NetworkRequestSingleton;
import com.example.mealplan.model.Meal;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MealDataService {
    public static final String SPOONTACULAR_ENDPOINT = "https://api.spoonacular.com/recipes/complexSearch";
    Context context;

    public MealDataService(Context context){
        this.context = context;
    }

    public interface VolleyResponseListener{
        void onError(String message);

        void onResponse(Meal meal);
    }
    public void getMealInfo(String mealName, final VolleyResponseListener volleyResponseListener){
        String url = SPOONTACULAR_ENDPOINT + "?apiKey=7917d42088bd445ab8eac6fd2324df0e&query=" + mealName; //lol wont be a query string need json param i assume
        String cock = "";

        JsonObjectRequest stringRequest = new JsonObjectRequest(Request.Method.GET, url,null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        String mealID = "";
                        Meal meal = new Meal();
                        try {
                            JSONArray queryInfo = response.getJSONArray("results");
                            mealID = queryInfo.getJSONObject(0).getString("id");
                            meal.setName(queryInfo.getJSONObject(0).getString("title"));
                            meal.setCalories(Integer.parseInt(queryInfo.getJSONObject(0).getString("id")));
                            Log.d("mealId", mealID);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        Log.d("successapi", response.toString());


                        volleyResponseListener.onResponse(meal);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("errorapi", error.toString());
                volleyResponseListener.onError("Something wrong");
            }
        });

        NetworkRequestSingleton.getInstance(context).addToRequestQueue(stringRequest);
    }
}
