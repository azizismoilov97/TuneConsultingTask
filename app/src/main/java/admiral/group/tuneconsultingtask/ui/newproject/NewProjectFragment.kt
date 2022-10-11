package admiral.group.tuneconsultingtask.ui.newproject

import admiral.group.tuneconsultingtask.MainActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import admiral.group.tuneconsultingtask.database.ProjectEntity
import admiral.group.tuneconsultingtask.databinding.FragmentNewProjectBinding
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_new_project.*


@AndroidEntryPoint
class NewProjectFragment : Fragment() {

    private val navController by lazy(LazyThreadSafetyMode.NONE) {findNavController()}
    private val newProjectViewModel:NewProjectViewModel by viewModels()

    private var _binding: FragmentNewProjectBinding? = null
    private val binding get() = _binding!!

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

    }
    private fun saveProject(){
        val nameProject=et_name_project.text.toString()
        val fullName=et_fullname.text.toString()
        val production=et_production.text.toString()
        val phoneNumber=et_phone.text.toString()
        val interval=et_razriv.text.toString()
        val continous=et_prodoljat.text.toString()

        if (nameProject.isNotEmpty()){
        newProjectViewModel.insertProject(ProjectEntity(nameProject,fullName,production,phoneNumber,interval, continous))
            (requireActivity() as MainActivity).onBackPressed()
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        (requireActivity() as MainActivity).setVisible()
        _binding = null
    }

}