package admiral.group.tuneconsultingtask.database

import androidx.room.*
import kotlinx.coroutines.flow.Flow


@Dao
interface ProjectDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(projectEntity: ProjectEntity)

    @Query("SELECT * FROM projects")
    fun get(): Flow<List<ProjectEntity>>

    @Delete
    suspend fun delete(projectEntity: ProjectEntity)

    @Update
    suspend fun update(projectEntity: ProjectEntity)
}