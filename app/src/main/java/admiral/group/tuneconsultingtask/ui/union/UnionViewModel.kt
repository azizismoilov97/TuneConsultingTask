package admiral.group.tuneconsultingtask.ui.union

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UnionViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Welcome"
    }
    val text: LiveData<String> = _text
}