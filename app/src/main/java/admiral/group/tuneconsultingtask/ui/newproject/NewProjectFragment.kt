package admiral.group.tuneconsultingtask.ui.newproject

import admiral.group.tuneconsultingtask.MainActivity
import admiral.group.tuneconsultingtask.R
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import admiral.group.tuneconsultingtask.database.ProjectEntity
import admiral.group.tuneconsultingtask.databinding.FragmentNewProjectBinding
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.google.android.material.textfield.TextInputEditText
import com.wajahatkarim3.easyvalidation.core.view_ktx.nonEmpty
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_new_project.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.combine


@AndroidEntryPoint
class NewProjectFragment : Fragment() {

    private val navController by lazy(LazyThreadSafetyMode.NONE) {findNavController()}
    private val newProjectViewModel:NewProjectViewModel by viewModels()

    private var _binding: FragmentNewProjectBinding? = null
    private val binding get() = _binding!!

     val _nameProject= MutableStateFlow("")
     val _fullName= MutableStateFlow("")
     val _production= MutableStateFlow("")
     val _phoneNumber= MutableStateFlow("")
     val _interval= MutableStateFlow("")
     val _continious= MutableStateFlow("")

    private var errorMessage:String?=null


    private var isFormValid= combine(_nameProject, _fullName, _production, _phoneNumber, _interval, _continious){

      it[0].isNotEmpty() && it[1].isNotEmpty() && it[2].isNotEmpty() && it[3].isNotEmpty() && it[4].isNotEmpty() && it[5].isNotEmpty()
    }




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNewProjectBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnClose.setOnClickListener {
            (requireActivity() as MainActivity).onBackPressed()
        }

        binding.add.setOnClickListener {
            saveProject()
        }

        with(binding){
            etNameProject.doOnTextChanged { text, start, before, count ->
                _nameProject.value=text.toString()
            }

            etFullname.doOnTextChanged { text, start, before, count ->
                _fullName.value=text.toString()
            }

            etProduction.doOnTextChanged { text, start, before, count ->
                _production.value=text.toString()
            }

            etPhone.doOnTextChanged { text, start, before, count ->
                _phoneNumber.value=text.toString()
            }

            etRazriv.doOnTextChanged { text, start, before, count ->
                _interval.value=text.toString()
            }

            etProdoljat.doOnTextChanged { text, start, before, count ->
                _continious.value=text.toString()
            }
        }

        lifecycleScope.launchWhenCreated {
            isFormValid.collectLatest {
                binding.add.apply {
                    if(it){
                        isEnabled=true
                        setBackgroundResource(R.drawable.button_enabled)
                    }else{
                        isEnabled=false
                        setBackgroundResource(R.drawable.button_disabled)
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


        newProjectViewModel.insertProject(ProjectEntity(nameProject, fullName, production, phoneNumber, interval, continous))
         (requireActivity() as MainActivity).onBackPressed()


    }

    override fun onDestroyView() {
        super.onDestroyView()
        (requireActivity() as MainActivity).setVisible()
        _binding = null
    }

}