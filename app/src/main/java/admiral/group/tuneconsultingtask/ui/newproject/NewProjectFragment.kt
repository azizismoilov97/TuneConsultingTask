package admiral.group.tuneconsultingtask.ui.newproject

import admiral.group.tuneconsultingtask.R
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import admiral.group.tuneconsultingtask.domain.model.ProjectEntity
import admiral.group.tuneconsultingtask.databinding.FragmentNewProjectBinding
import admiral.group.tuneconsultingtask.ui.viewmodel.MainViewModel
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.button_view.view.*
import kotlinx.android.synthetic.main.fragment_new_project.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.combine


@AndroidEntryPoint
class NewProjectFragment : Fragment(R.layout.fragment_new_project) {

    private val navController by lazy(LazyThreadSafetyMode.NONE) {findNavController()}
    private val mainViewModel: MainViewModel by viewModels()
    private val viewBinding: FragmentNewProjectBinding by viewBinding(FragmentNewProjectBinding::bind)


     private val _nameProject= MutableStateFlow("")
     private val _fullName= MutableStateFlow("")
     private val _production= MutableStateFlow("")
     private val _phoneNumber= MutableStateFlow("")
     private val _interval= MutableStateFlow("")
     private val _continuous= MutableStateFlow("")


    private var isFormValid= combine(_nameProject, _fullName, _production, _phoneNumber, _interval, _continuous){
      it[0].isNotEmpty() && it[1].isNotEmpty() && it[2].isNotEmpty() && it[3].isNotEmpty() && it[4].isNotEmpty() && it[5].isNotEmpty()
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(viewBinding) {

            btnClose.setOnClickListener {
                navController.popBackStack()
            }

            add.customButton.setOnClickListener {
                saveProject()
            }

            etNameProject.doOnTextChanged { text, start, before, count ->
                _nameProject.value = text.toString()
            }

            etFullname.doOnTextChanged { text, start, before, count ->
                _fullName.value = text.toString()
            }

            etProduction.doOnTextChanged { text, start, before, count ->
                _production.value = text.toString()
            }

            etPhone.doOnTextChanged { text, start, before, count ->
                _phoneNumber.value = text.toString()
            }

            etRazriv.doOnTextChanged { text, start, before, count ->
                _interval.value = text.toString()
            }

            etProdoljat.doOnTextChanged { text, start, before, count ->
                _continuous.value = text.toString()
            }


            lifecycleScope.launchWhenCreated {
                isFormValid.collectLatest {
                    add.customButton.apply {
                        if (it) {
                            isEnabled = true
                            setBackgroundResource(R.drawable.button_enabled)
                        } else {
                            isEnabled = false
                            setBackgroundResource(R.drawable.button_disabled)
                        }

                    }
                }
            }
        }
    }

    private fun saveProject(){
        val nameProject=et_name_project.text.toString()
        val fullName=et_fullname.text.toString()
        val production=et_production.text.toString()
        val phoneNumber=et_phone.text.toString()
        val interval=et_razriv.text.toString()
        val continous=et_prodoljat.text.toString()

        mainViewModel.addProject(ProjectEntity(nameProject, fullName, phoneNumber, production, interval, continous, 0))
        navController.navigateUp()

    }


}