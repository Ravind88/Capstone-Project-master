package com.udacity.ravindmauriya.capstonestage2.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseSave extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "rahul_capstone";

    // Contacts table name
    static final String TABLE_PLACES = "tbl_places";
    private static final String TABLE_RESTAURANTS = "tbl_restaurants";
    private static final String TABLE_HOTELS = "tbl_hotels";

    // Contacts Table Columns names
    private static final String KEY_ID = "id";
     static final String KEY_PLACE_ID = "place_id";

    private static final String KEY_ID1 = "id";
    private static final String KEY_RESTAURANTS_ID = "restaurant_id";

    private static final String KEY_ID2 = "id";
    private static final String KEY_HOTELS_ID = "hotel_id";

    public DatabaseSave(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_PLACE = "CREATE TABLE " + TABLE_PLACES + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_PLACE_ID + " TEXT unique" + ")";
        db.execSQL(CREATE_TABLE_PLACE);

        String CREATE_TABLE_HOTELS = "CREATE TABLE " + TABLE_HOTELS + "("
                + KEY_ID2 + " INTEGER PRIMARY KEY," + KEY_HOTELS_ID + " TEXT unique" + ")";
        db.execSQL(CREATE_TABLE_HOTELS);

        String CREATE_TABLE_RESTAURANT = "CREATE TABLE " + TABLE_RESTAURANTS + "("
                + KEY_ID1 + " INTEGER PRIMARY KEY," + KEY_RESTAURANTS_ID + " TEXT unique" + ")";
        db.execSQL(CREATE_TABLE_RESTAURANT);

    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PLACES);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RESTAURANTS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_HOTELS);

        // Create tables again
        onCreate(db);
    }

    //methods for marking it as favourties...............................................................
    public void addPlaces(String place_id) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_PLACE_ID, place_id);
        // Inserting Row
        db.insert(TABLE_PLACES, null, values);
        db.close(); // Closing database connection
    }

    public List<String> getAllPlaces() {
        List<String> List = new ArrayList<String>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_PLACES;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        try {
            // looping through all rows and adding to list
            if (cursor.moveToFirst()) {
                do {
                    // Adding contact to list
                    List.add(cursor.getString(1));
                } while (cursor.moveToNext());
            }
        } finally {
            if (cursor != null)
                cursor.close();
        }
        // return contact list
        return List;
    }

    public boolean getPlaces(String id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_PLACES, new String[]{KEY_ID,
                        KEY_PLACE_ID}, KEY_PLACE_ID + "=?",
                new String[]{id}, null, null, null, null);
        try {
            return cursor.moveToFirst();
        } finally {
            if (cursor != null)
                cursor.close();
        }
    }

    //methods for marking it as favourties...............................................................
    public void addRestaurants(String restaurant_id) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_RESTAURANTS_ID, restaurant_id);
        // Inserting Row
        db.insert(TABLE_RESTAURANTS, null, values);
        db.close(); // Closing database connection
    }

    public List<String> getAllRes() {
        List<String> List = new ArrayList<String>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_RESTAURANTS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        try {
            if (cursor.moveToFirst()) {
                do {
                    // Adding contact to list
                    List.add(cursor.getString(1));
                } while (cursor.moveToNext());
            }
        } finally {
            if (cursor != null)
                cursor.close();
        }
        // return contact list
        return List;
    }

    public boolean getRes(String id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_RESTAURANTS, new String[]{KEY_ID1,
                        KEY_RESTAURANTS_ID}, KEY_RESTAURANTS_ID + "=?",
                new String[]{id}, null, null, null, null);
        try {
            return cursor.moveToFirst();
        } finally {
            if (cursor != null)
                cursor.close();
        }
    }

    //methods for marking it as favourties...............................................................
    public void addHotels(String hotel_id) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_HOTELS_ID, hotel_id);
        // Inserting Row
        db.insert(TABLE_HOTELS, null, values);
        db.close(); // Closing database connection
    }

    public List<String> getAllHotels() {
        List<String> List = new ArrayList<String>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_HOTELS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        try {
            if (cursor.moveToFirst()) {
                do {
                    // Adding contact to list
                    List.add(cursor.getString(1));
                } while (cursor.moveToNext());
            }
        } finally {
            if (cursor != null)
                cursor.close();
        }
        // return contact list
        return List;
    }

    public boolean gethotel(String id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_HOTELS, new String[]{KEY_ID2,
                        KEY_HOTELS_ID}, KEY_HOTELS_ID + "=?",
                new String[]{id}, null, null, null, null);
        try {
            return cursor.moveToFirst();
        } finally {
            if (cursor != null)
                cursor.close();
        }
    }

    public Cursor getSavedHotels() {
        String selectQuery = "SELECT  * FROM " + TABLE_HOTELS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        return cursor;
    }

    public void clearDatabase() {
        SQLiteDatabase db = this.getReadableDatabase();
        db.delete(TABLE_HOTELS, null, null);
        db.delete(TABLE_PLACES, null, null);
        db.delete(TABLE_RESTAURANTS, null, null);
    }
}