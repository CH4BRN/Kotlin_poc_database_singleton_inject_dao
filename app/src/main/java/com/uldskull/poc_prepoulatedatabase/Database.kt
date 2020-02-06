/** File Database.kt
 *   @Author pierre.antoine - 05/02/2020 - No copyright.
 **/

package com.uldskull.poc_prepoulatedatabase

import android.content.Context
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(
    entities = arrayOf(Model::class),
    version = 1
)
abstract class MyDatabase : RoomDatabase(){

    abstract fun pocDao():PocDao



    companion object{

        var INSTANCE : MyDatabase? = null

        /**
         * Database lazy loader
         * Calls "buildDatabase" if database is null.
         */
         fun getDatabase(context: Context) : MyDatabase{
             if(INSTANCE == null){
                 INSTANCE = buildMyDatabase(context)
             }
             return INSTANCE!!
        }

        /**
         * Build the database .
         * Adds a callback to pre-populate the database.
         */
        private fun buildMyDatabase(context: Context): MyDatabase {
            return Room
                .databaseBuilder(
                    context.applicationContext,
                    MyDatabase::class.java,
                    "mydb"
                )
                .addCallback(object : RoomDatabase.Callback(){
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        getDatabase(context).pocDao().insertAll(populateData())
                    }

                })
                .allowMainThreadQueries()
                .build()
        }

        fun populateData():List<Model>{
            return listOf(
                Model(null, "Gerard"),
                Model(null, "Sonia")
            )
        }

        fun populateDatabase(){
            INSTANCE?.pocDao()?.insert(
                Model(
                    id = null,
                    name = "Sonny"
                ))
            INSTANCE?.pocDao()?.insert(
                Model(
                    id = null,
                    name = "Maxim"
                ))
            INSTANCE?.pocDao()?.insert(
                Model(
                    id = null,
                    name = "Laurent"
                ))
        }

    }



}



@Dao
interface PocDao{
    @Insert
    fun insert(model:Model)

    @Insert
    fun insertAll(models:List<Model>)

    @Query("SELECT name FROM Model")
    fun getAll():List<Model>
}


@Entity
data class Model(
    @PrimaryKey(autoGenerate = true)
    val id:Long?,
    val name:String
)