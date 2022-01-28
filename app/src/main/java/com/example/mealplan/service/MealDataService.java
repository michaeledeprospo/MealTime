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
import com.example.mealplan.MainActivity;
import com.example.mealplan.controller.NetworkRequestSingleton;
import com.example.mealplan.model.Meal;
import com.example.mealplan.view.SimpleAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MealDataService {
    public static final String SPOONTACULAR_ENDPOINT = "https://api.spoonacular.com/recipes/complexSearch";
    //{{baseUrl}}/recipes/642539/information?apiKey=7917d42088bd445ab8eac6fd2324df0e&includeNutrition=true
    //{{baseUrl}}/recipes/642539/nutritionWidget.json/?apiKey=7917d42088bd445ab8eac6fd2324df0e
    public static final String SPOONTACULAR_ENDPOINT_ID = "https://api.spoonacular.com/recipes"; // + id + /nutritionWidget.json/ + apikey
    public static final String API_KEY = "?apiKey=7917d42088bd445ab8eac6fd2324df0e";
    Context context;

    public MealDataService(Context context){
        this.context = context;
    }

    public interface VolleyResponseListener{
        void onError(String message);

        void onResponse(Meal meal);
    }
    public void getMealInfo(String mealName, final VolleyResponseListener volleyResponseListener){
        String url = SPOONTACULAR_ENDPOINT + API_KEY + "&query=" + mealName; //lol wont be a query string need json param i assume
        String cock = "";

        JsonObjectRequest stringRequest = new JsonObjectRequest(Request.Method.GET, url,null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        String mealID = "";

                        try {
                            JSONArray queryInfo = response.getJSONArray("results");
                            Log.d("querylen", String.valueOf(queryInfo.length()));
                            Log.d("queryinfo", queryInfo.toString());
                            for(int i = 0; i<queryInfo.length();i++) {
                                Meal meal = new Meal();

                                Log.d("query@", String.valueOf(queryInfo.getJSONObject(i)));
                                mealID = queryInfo.getJSONObject(i).getString("id");
                                meal.setName(queryInfo.getJSONObject(i).getString("title"));
                                meal.setMealType(queryInfo.getJSONObject(i).getString("image"));
                                meal.setImageUrl(queryInfo.getJSONObject(i).getString("image"));
                                meal.setCalories(Integer.parseInt(queryInfo.getJSONObject(i).getString("id")));
                                Log.d("mealId", mealID);

                                Log.d("successapi", response.toString());


                                volleyResponseListener.onResponse(meal);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
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
