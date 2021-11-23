//package com.example.ezyfoodapp.Utils;
//
//import android.content.ContentValues;
//import android.content.Context;
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//
//import com.example.ezyfoodapp.Model.Item;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class DatabaseHandler extends SQLiteOpenHelper {
//    private static final int VERSION =1;
//    private static final String NAME="ezyFoodDatabase";
//    private static final String ITEM_TABLE="item_tables";
//    private static final String ID = "id";
//    private static final String ITEM_NAME= "item_name";
//    private static final String ITEM_TYPE="item_type";
//    private static final String PRICE ="price";
//    private static final String CREATE_ITEM_TABLE= "CREATE TABLE "+ ITEM_TABLE +"("+ ID + "INTEGER PRIMARY KEY AUTOINCREAMENT,"+
//    ITEM_NAME + "TEXT" + ITEM_TYPE + "TEXT" + PRICE + "INTEGER)";
//
//    private SQLiteDatabase db;
//
//    private DatabaseHandler(Context context){
//        super(context, NAME , null, VERSION);
//    }
//
//    @Override
//    public void onCreate(SQLiteDatabase db){
//        db.execSQL(CREATE_ITEM_TABLE);
//    }
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
//        db.execSQL("DROP TABLE IF EXISTS" + ITEM_TABLE);
//        //CREATE AGAIN
//        onCreate(db);
//    }
//    public void openDatabase(){
//        db= this.getWritableDatabase();
//    }
//    public void insertItem(Item item){
//        ContentValues cv = new ContentValues();
//        cv.put(ITEM_NAME, item.getItemName());
//        cv.put(ITEM_TYPE, item.getItemType());
//        cv.put(PRICE, item.getPrice());
//        db.insert(ITEM_TABLE, null,cv);
//    }
//    public List<Item> getAllItem(){
//        List<Item> itemList= new ArrayList<>();
//        Cursor cur = null;
//        db.beginTransaction();
//        try {
//            cur=db.query(ITEM_TABLE, null, null,null,null,null,null);
//        }
//        db.endTransaction();
//    }
//}
