package admiral.group.tuneconsultingtask.ui.project

import admiral.group.tuneconsultingtask.database.ProjectEntity
import admiral.group.tuneconsultingtask.repository.MainRepository
import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProjectViewModel @Inject constructor(
    private val mainRepository: MainRepository
): ViewModel() {

    val readAll=mainRepository.getAllProjects().asLiveData()

    fun addProject(projectEntity: ProjectEntity){
            viewModelScope.launch {
                mainRepository.insertProject(projectEntity)
            }
        }

    fun updateProject(projectEntity: ProjectEntity){
        viewModelScope.launch {
            mainRepository.updateProject(projectEntity)
        }
    }

    fun delete(projectEntity: ProjectEntity){
        viewModelScope.launch {
            mainRepository.deleteProject(projectEntity)
        }
    }


}