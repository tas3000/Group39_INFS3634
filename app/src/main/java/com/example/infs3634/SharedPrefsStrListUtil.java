package com.example.infs3634;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;

//This is the java class for the shared preferences string list util.

public class SharedPrefsStrListUtil {
    public final static String SETTING = "SharedPrefsStrList";

    //Putting int value
    private static void putIntValue(Context context, String key, int value) {
        SharedPreferences.Editor sp = context.getSharedPreferences(SETTING, Context.MODE_PRIVATE)
                .edit();
        sp.putInt(key, value);
        sp.commit();
    }

    //Putting string value
    private static void putStringValue(Context context, String key, String value) {
        SharedPreferences.Editor sp = context.getSharedPreferences(SETTING, Context.MODE_PRIVATE)
                .edit();
        sp.putString(key, value);
        sp.commit();
    }

    //Putting string list value
    public static void putStrListValue(Context context, String key,
                                       ArrayList<String> strList) {
        if (null == strList) {
            return;
        }
        removeStrList(context, key);
        int size = strList.size();
        putIntValue(context, key + "size", size);
        for (int i = 0; i < size; i++) {
            putStringValue(context, key + i, strList.get(i));
        }
    }

    //Getting int value
    private static int getIntValue(Context context, String key, int defValue) {
        SharedPreferences sp = context.getSharedPreferences(SETTING,
                Context.MODE_PRIVATE);
        int value = sp.getInt(key, defValue);
        return value;
    }

    //Getting string value
    private static String getStringValue(Context context, String key,
                                         String defValue) {
        SharedPreferences sp = context.getSharedPreferences(SETTING,
                Context.MODE_PRIVATE);
        String value = sp.getString(key, defValue);
        return value;
    }

    //Getting string list value
    public static ArrayList<String> getStrListValue(Context context, String key) {
        ArrayList<String> strList = new ArrayList<String>();
        int size = getIntValue(context, key + "size", 0);
        //Log.d("sp", "" + size);
        for (int i = 0; i < size; i++) {
            strList.add(getStringValue(context, key + i, null));
        }
        return strList;
    }

    //Removing string list
    public static void removeStrList(Context context, String key) {
        int size = getIntValue(context, key + "size", 0);
        if (0 == size) {
            return;
        }
        remove(context, key + "size");
        for (int i = 0; i < size; i++) {
            remove(context, key + i);
        }
    }

    //Removing string list item
    public static void removeStrListItem(Context context, String key, String str) {
        int size = getIntValue(context, key + "size", 0);
        if (0 == size) {
            return;
        }
        ArrayList<String> strList = getStrListValue(context, key);

        ArrayList<String> removeList = new ArrayList<String>();
        for (int i = 0; i < size; i++) {
            if (str.equals(strList.get(i))) {
                if (i >= 0 && i < size) {
                    removeList.add(strList.get(i));
                    remove(context, key + i);
                    putIntValue(context, key + "size", size - 1);
                }
            }
        }
        strList.removeAll(removeList);

        putStrListValue(context, key, strList);
    }

    //Remove method
    public static void remove(Context context, String key) {
        SharedPreferences.Editor sp = context.getSharedPreferences(SETTING, Context.MODE_PRIVATE)
                .edit();
        sp.remove(key);
        sp.commit();
    }

    //Clear method
    public static void clear(Context context) {
        SharedPreferences.Editor sp = context.getSharedPreferences(SETTING, Context.MODE_PRIVATE)
                .edit();
        sp.clear();
        sp.commit();
    }

}