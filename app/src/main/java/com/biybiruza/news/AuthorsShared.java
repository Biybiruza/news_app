package com.biybiruza.news;

import android.content.Context;
import android.content.SharedPreferences;

import com.biybiruza.news.data.Authors;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class AuthorsShared {
    private SharedPreferences sharedPreferences;
    private Gson gson;

    public AuthorsShared(Context context, Gson gson) {
        this.sharedPreferences = context.getSharedPreferences("PREFS_NAME", Context.MODE_PRIVATE);
        this.gson = gson;
    }

    public <T> void putList(String key, List<T> list) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, gson.toJson(list));
        editor.apply();
    }

    public <T> List<T> getList(String key, Class<T> clazz) {
        String data = sharedPreferences.getString(key, null);

        Type typeOfT = new TypeToken<List<Authors>>() {
        }.getType();

        return gson.fromJson(data, typeOfT);
    }
}
