package admiral.group.tuneconsultingtask.data.local

import admiral.group.tuneconsultingtask.domain.model.ProjectEntity
import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [ProjectEntity::class], version = 1)
abstract class ProjectDatabase: RoomDatabase()  {
    abstract fun projectDAO(): ProjectDAO

    companion object {
        const val DATABASE_NAME: String = "projects_db"
    }
}