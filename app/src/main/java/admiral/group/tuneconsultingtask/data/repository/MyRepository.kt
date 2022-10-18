package admiral.group.tuneconsultingtask.data.repository

import admiral.group.tuneconsultingtask.domain.model.ProjectEntity
import kotlinx.coroutines.flow.Flow

   /*
     *
     *  SOLID. Here, Interface Segregation Principle is used.
     *
     *  The interface-segregation principle indicates classes
     *  that implement interfaces,
     *  should not be forced to implement methods they do not use.
     *
     */

interface MyRepository {
    fun getAllProjects():Flow<List<ProjectEntity>>
    fun getProject(id:Int):Flow<ProjectEntity>
    suspend fun updateProject(projectEntity: ProjectEntity):Int
    suspend fun deleteProject(id: Int)
    suspend fun insertProject(projectEntity: ProjectEntity)
}