package admiral.group.tuneconsultingtask.ui.viewmodel

import admiral.group.tuneconsultingtask.model.ProjectEntity
import admiral.group.tuneconsultingtask.repository.MainRepository
import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository
): ViewModel() {

    private val statusMessage = MutableLiveData<Boolean>()

    val message: LiveData<Boolean>
        get() = statusMessage

    val readAll= mainRepository.getAllProjects()

    fun readOne(id:Int)= mainRepository.getProject(id)

    fun addProject(projectEntity: ProjectEntity){
            viewModelScope.launch() {
                mainRepository.insertProject(projectEntity)
            }
        }

    fun updateProject(projectEntity: ProjectEntity)=viewModelScope.launch {
         val result=  mainRepository.updateProject(projectEntity)
         statusMessage.value = result>-1
    }

    fun delete(id:Int){
        viewModelScope.launch() {
            mainRepository.deleteProject(id)
        }
    }


}