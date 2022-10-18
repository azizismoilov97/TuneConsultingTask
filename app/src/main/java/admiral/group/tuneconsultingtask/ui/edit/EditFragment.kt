package admiral.group.tuneconsultingtask.ui.edit

import admiral.group.tuneconsultingtask.R
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import admiral.group.tuneconsultingtask.databinding.FragmentEditBinding
import admiral.group.tuneconsultingtask.domain.model.ProjectEntity
import admiral.group.tuneconsultingtask.ui.viewmodel.MainViewModel
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint

/*
 * SOLID - Dependency inversion
 * Framework - Dagger Hilt.
 *
 *  The @AndroidEntryPoint annotation helps to inject dependencies into Fragment and
 *  perform field injection using @Inject annotation.
 *
 */
@AndroidEntryPoint
class EditFragment : Fragment(R.layout.fragment_edit) {


    private val navController by lazy(LazyThreadSafetyMode.NONE) {findNavController()}
    private val mainViewModel: MainViewModel by viewModels()
    private val arg:EditFragmentArgs by navArgs()
    private val viewBinding: FragmentEditBinding by viewBinding()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(viewBinding){

            btnClose.setOnClickListener {
                navController.navigateUp()
            }

            mainViewModel.message.observe(viewLifecycleOwner){
                if (it){
                    navController.navigateUp()
                }
            }

            mainViewModel.readOne(arg.id).observe(viewLifecycleOwner) { list ->
                if (list!=null){
                setData(list, this)
                }
            }

            sbros.setOnClickListener {
                setNull(this)
            }

            add.setOnClickListener {
                updateDate(this)
            }
        }

    }

    private fun updateDate(binding:FragmentEditBinding) {

       val name=binding.etNameProject.text.toString()
       val fullname=binding.etFullname.text.toString()
       val phone=binding.etPhone.text.toString()
       val produ=binding.etProduction.text.toString()
       val razr=binding.etRazriv.text.toString()
       val con=binding.etProdoljat.text.toString()

        if (fullname.isNotEmpty()&&phone.isNotEmpty()&&produ.isNotEmpty()&&razr.isNotEmpty()&&con.isNotEmpty()){
              mainViewModel.updateProject(ProjectEntity( name, fullname, phone, produ, razr, con, arg.id))
        }else{
            Toast.makeText(requireContext(), "Fill the fields", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setData(list: ProjectEntity, binding:FragmentEditBinding) {

            binding.etNameProject.setText(list.nameProject)
            binding.etFullname.setText(list.fullName)
            binding.etPhone.setText(list.phoneNumber)
            binding.etProduction.setText(list.production)
            binding.etRazriv.setText(list.interval)
            binding.etProdoljat.setText(list.continious)



    }

    private fun setNull(binding:FragmentEditBinding){
        binding.etNameProject.text=null
        binding.etFullname.text=null
        binding.etPhone.text=null
        binding.etProduction.text=null
        binding.etRazriv.text=null
        binding.etProdoljat.text=null
    }

}