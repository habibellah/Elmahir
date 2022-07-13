package habibellah.ayata.elmahirofquran.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper

class DB(context: Context) : SQLiteAssetHelper(context,Constants.DB_NAME,null,Constants.DB_VERSION) {


}