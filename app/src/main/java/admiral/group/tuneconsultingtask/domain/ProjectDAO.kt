package admiral.group.tuneconsultingtask.domain

import admiral.group.tuneconsultingtask.data.ProjectEntity
import androidx.lifecycle.LiveData
import androidx.room.*
import kotlinx.coroutines.flow.Flow


@Dao
interface ProjectDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(projectEntity: ProjectEntity)

    @Query("SELECT * FROM projects")
    fun get():Flow<List<ProjectEntity>>

    @Query("SELECT * FROM projects WHERE id=:id ")
    fun getItemById(id:Int):Flow<ProjectEntity>

//    @Delete
//    suspend fun delete(projectEntity: ProjectEntity)

    @Query("DELETE FROM projects WHERE id = :id")
    suspend fun delete(id: Int)

//    @Update(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun update(projectEntity: ProjectEntity):Int

    @Query("UPDATE projects SET nameProject =:nameProject, fullName =:fullName, phoneNumber =:phoneNumber, production=:production, interval=:interval, continious=:con WHERE id = :id")
    suspend fun update(nameProject: String, fullName: String, phoneNumber: String, production:String, interval:String, con:String, id:Int):Int

}