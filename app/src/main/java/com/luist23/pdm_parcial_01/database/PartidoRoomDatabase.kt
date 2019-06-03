package com.luist23.pdm_parcial_01.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.luist23.pdm_parcial_01.database.daos.PartidoDao
import com.luist23.pdm_parcial_01.database.entities.Partido
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.sql.Date
import java.util.*

@Database(entities = [Partido::class],version = 1)
abstract class PartidoRoomDatabase : RoomDatabase() {

    abstract fun partidoDao(): PartidoDao

    companion object{
        @Volatile
        private var INSTANCE : PartidoRoomDatabase? = null

        fun getDatabase(
            context: Context,
            scope:CoroutineScope
        ) : PartidoRoomDatabase{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PartidoRoomDatabase::class.java,
                    "partido_database"
                )
                    .fallbackToDestructiveMigration()
                    .addCallback(PartidoDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }

    private class PartidoDatabaseCallback(private val scope : CoroutineScope)  : RoomDatabase.Callback() {
        /**
         * Override the onOpen method to populate the database.
         * For this sample, we clear the database every time it is created or opened.
         */
        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            // If you want to keep the data through app restarts,
            // comment out the following line.
            INSTANCE?.let { database ->
                scope.launch(Dispatchers.IO) {
                    populateDatabase(database.partidoDao())
                }
            }
        }
        suspend fun populateDatabase(partidoDao: PartidoDao) {
            // Start the app with a clean database every time.
            // Not needed if you only populate on creation.
            partidoDao.nukeTable()

            var partido = Partido(1,"equipo23","equipo15",23,15,
                1,23,"equipo23")
            partidoDao.insert(partido)
            partido = Partido(2,"equipo32","equipo15",23,15,
                2,23,"equipo32")
            partidoDao.insert(partido)
        }
    }

    /**
     * Populate the database in a new coroutine.
     * If you want to start with more words, just add them.
     */

}
