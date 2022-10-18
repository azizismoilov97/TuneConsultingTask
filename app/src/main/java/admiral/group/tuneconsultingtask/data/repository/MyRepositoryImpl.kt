package admiral.group.tuneconsultingtask.data.repository

import admiral.group.tuneconsultingtask.data.local.ProjectDAO
import admiral.group.tuneconsultingtask.domain.model.ProjectEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject



class MyRepositoryImpl @Inject constructor(
    private val projectDAO: ProjectDAO
): MyRepository {

       /*
        * SOLID. Here Open/Closed principle is used.
        *  the Open/Closed principle states “software entities
        * such as classes, components, modules should be open for extension,
        *  but closed for modification”;
        *
        * In this class, new functionality is added to MyRepository interface
        */
       override suspend fun insertProject(projectEntity: ProjectEntity)= projectDAO.insert(projectEntity)

       override suspend fun updateProject(projectEntity: ProjectEntity) = projectDAO.update(projectEntity.nameProject, projectEntity.fullName,
       projectEntity.phoneNumber, projectEntity.production, projectEntity.interval, projectEntity.continious, projectEntity.id)

       override suspend fun deleteProject(id:Int) = projectDAO.delete(id)

       override  fun getAllProjects():Flow<List<ProjectEntity>> = projectDAO.get()

       override  fun getProject(id:Int):Flow<ProjectEntity> = projectDAO.getItemById(id)

}
