package com.training.to_doapp

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteCursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.sql.Types.INTEGER

class MyHandler(context:Context) :
    SQLiteOpenHelper(context,DATABASE_NAME,null,DATABASE_VERSION,)
{
    companion object
    {   private val DATABASE_VERSION=1
        private val DATABASE_NAME="LIST.db"
        private val TABLE_NAME="TODO"

        private val KEY_ID="Id"
        private val KEY_ENTRY="entry"
    }
    override fun onCreate(db: SQLiteDatabase?) {
        //TODO("Not yet implemented")
        val createTableQuery="CREATE TABLE $TABLE_NAME($KEY_ID INTEGER PRIMARY KEY ,$KEY_ENTRY VARCHAR) "
        db?.execSQL(createTableQuery)
    }

    fun addEntries(column:Columns){
        val c_values= ContentValues()
        c_values.put(KEY_ENTRY,column.entry)
        val db=this.writableDatabase
        db.insert(TABLE_NAME,null,c_values)
        db.close()
    }
    fun getEntries():ArrayList<Columns>{
        var  list=ArrayList<Columns>()

        val db=this.readableDatabase
        val getEntryQuery="SELECT * FROM $TABLE_NAME"

        val m_cursor=db.rawQuery(getEntryQuery,null)
        m_cursor.moveToFirst()
        do{
            val column=Columns()
            column.id=(m_cursor.getString(0)).toInt()
            column.entry=(m_cursor.getString(1))
            list.add(column)
        }while(m_cursor.moveToNext())
        return list
    }
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

}