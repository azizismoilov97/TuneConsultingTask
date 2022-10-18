package admiral.group.tuneconsultingtask.ui.project


import admiral.group.tuneconsultingtask.ui.MainActivity
import admiral.group.tuneconsultingtask.R
import admiral.group.tuneconsultingtask.domain.model.ProjectEntity
import admiral.group.tuneconsultingtask.databinding.FragmentProjectBinding
import admiral.group.tuneconsultingtask.ui.project.adapter.ProjectAdapter
import admiral.group.tuneconsultingtask.ui.viewmodel.MainViewModel
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.button_view.view.*
import kotlinx.android.synthetic.main.fragment_project.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/*
 * SOLID - Dependency inversion
 * Framework - Dagger Hilt.
 *
 *  The @AndroidEntryPoint annotation helps to inject dependencies into Fragment and
 *  perform field injection using @Inject annotation.
 *
 */

@AndroidEntryPoint
class ProjectFragment : Fragment(R.layout.fragment_project){

    private val mainViewModel: MainViewModel by viewModels()
    private val navController by lazy(LazyThreadSafetyMode.NONE) {findNavController()}
    private  lateinit var projectAdapter: ProjectAdapter
    private val viewBinding: FragmentProjectBinding by viewBinding(FragmentProjectBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(viewBinding) {

            mainViewModel.getAllProject().observe(viewLifecycleOwner) { list ->
                if (list!!.isNotEmpty()){
                    setUpRecyclerView()
                    projectAdapter.mTodo = list
                    updateUi(list, this)
                }
            }


            addProject.customButton.setOnClickListener {
//               showToast(requireContext(), "Salom")
                navController.navigate(R.id.action_navigation_home_to_newProjectFragment)
                (requireActivity() as MainActivity).setGone()
            }
        }
    }

    private fun setUpRecyclerView(){
        projectAdapter= ProjectAdapter(ProjectAdapter.OnClickListener{
            val action=ProjectFragmentDirections.actionNavigationHomeToMainDataFragment(it)
            navController.navigate(action)
            (requireActivity() as MainActivity).setGone()
        })
            myRecyclerView.apply {
                layoutManager=LinearLayoutManager(requireContext())
                adapter=projectAdapter

            }
        }

    private fun updateUi(list: List<ProjectEntity>?, binding:FragmentProjectBinding) {
       if (list!!.isNotEmpty()){
           setVisibility(binding.myRecyclerView)
           setGone(binding.myLayout)
       }else{
           setVisibility( binding.myLayout)
           setGone(binding.myRecyclerView)
       }
    }

    private fun setGone(view:View){
       if (view.visibility!=View.GONE){
           view.visibility=View.GONE
       }
   }

    private fun setVisibility(view:View){
        if (view.visibility!=View.VISIBLE){
            view.visibility=View.VISIBLE
        }
    }

    override fun onResume() {
        super.onResume()
        (requireActivity() as MainActivity).setVisible()
    }



}