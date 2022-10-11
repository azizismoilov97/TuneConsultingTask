package admiral.group.tuneconsultingtask.ui.newproject

import admiral.group.tuneconsultingtask.database.ProjectEntity
import admiral.group.tuneconsultingtask.repository.MainRepository
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class NewProjectViewModel @Inject constructor(
    private val mainRepository: MainRepository
): ViewModel() {

    val mNameProject=MutableLiveData<String>()
    val mfullName=MutableLiveData<String>()
    val mPhoneNumber=MutableLiveData<String>()
    val mProduction=MutableLiveData<String>()
    val mInterval=MutableLiveData<String>()
    val mContinious=MutableLiveData<String>()



     fun insertProject(prjectEntity: ProjectEntity)=viewModelScope.launch {
         mainRepository.insertProject(prjectEntity)
     }


}