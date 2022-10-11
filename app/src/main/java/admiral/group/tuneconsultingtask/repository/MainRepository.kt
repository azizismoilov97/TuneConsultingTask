package admiral.group.tuneconsultingtask.repository

import admiral.group.tuneconsultingtask.database.ProjectDAO
import admiral.group.tuneconsultingtask.database.ProjectEntity
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val projectDAO: ProjectDAO
) {
        suspend fun insertProject(projectEntity: ProjectEntity)= projectDAO.insert(projectEntity)

       suspend fun updateProject(projectEntity: ProjectEntity)= projectDAO.update(projectEntity)

       suspend fun deleteProject(projectEntity: ProjectEntity)= projectDAO.delete(projectEntity)

       fun getAllProjects() = projectDAO.get()
}
