package admiral.group.tuneconsultingtask.ui

import admiral.group.tuneconsultingtask.model.ProjectEntity
import admiral.group.tuneconsultingtask.repository.MainRepository
import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository
): ViewModel() {

    val readAll=mainRepository.getAllProjects().asLiveData()

    fun readOne(id:Int)=mainRepository.getProject(id).asLiveData()


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