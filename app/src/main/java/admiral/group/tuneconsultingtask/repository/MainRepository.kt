package admiral.group.tuneconsultingtask.repository

import admiral.group.tuneconsultingtask.database.ProjectDAO
import admiral.group.tuneconsultingtask.model.ProjectEntity
import androidx.lifecycle.LiveData
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val projectDAO: ProjectDAO
) {
       suspend fun insertProject(projectEntity: ProjectEntity)= projectDAO.insert(projectEntity)

       suspend fun updateProject(projectEntity: ProjectEntity)= projectDAO.update(projectEntity.nameProject, projectEntity.fullName,
       projectEntity.phoneNumber, projectEntity.production, projectEntity.interval, projectEntity.continious, projectEntity.id)

       suspend fun deleteProject(projectEntity: ProjectEntity)= projectDAO.delete(projectEntity)

       fun getAllProjects() :LiveData<List<ProjectEntity>>{
           return  projectDAO.get()
       }

       fun getProject(id:Int):LiveData<ProjectEntity>{
           return projectDAO.getItemById(id)
       }
}
