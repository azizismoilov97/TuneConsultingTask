package admiral.group.tuneconsultingtask.database

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [ProjectEntity::class], version = 1)
abstract class ProjectDatabase: RoomDatabase()  {
    abstract fun projectDAO(): ProjectDAO

    companion object {
        const val DATABASE_NAME: String = "projects_db"
    }
}