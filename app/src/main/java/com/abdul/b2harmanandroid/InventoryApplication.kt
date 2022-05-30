package com.abdul.b2harmanandroid

import android.app.Application
import com.abdul.b2harmanandroid.data.ItemRoomDatabase

class InventoryApplication : Application() {
    val database: ItemRoomDatabase by lazy { ItemRoomDatabase.getDatabase(this) }

}