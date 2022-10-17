package admiral.group.tuneconsultingtask.repository

import admiral.group.tuneconsultingtask.domain.ProjectDAO
import admiral.group.tuneconsultingtask.data.ProjectEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val projectDAO: ProjectDAO
) {
       suspend fun insertProject(projectEntity: ProjectEntity)= projectDAO.insert(projectEntity)

       suspend fun updateProject(projectEntity: ProjectEntity)= projectDAO.update(projectEntity.nameProject, projectEntity.fullName,
       projectEntity.phoneNumber, projectEntity.production, projectEntity.interval, projectEntity.continious, projectEntity.id)

       suspend fun deleteProject(id:Int)= projectDAO.delete(id)

      fun getAllProjects():Flow<List<ProjectEntity>> = projectDAO.get()

       fun getProject(id:Int):Flow<ProjectEntity> = projectDAO.getItemById(id)
}
