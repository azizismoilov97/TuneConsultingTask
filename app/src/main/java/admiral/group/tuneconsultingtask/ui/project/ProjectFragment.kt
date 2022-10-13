package admiral.group.tuneconsultingtask.ui.project


import admiral.group.tuneconsultingtask.MainActivity
import admiral.group.tuneconsultingtask.R
import admiral.group.tuneconsultingtask.model.ProjectEntity
import admiral.group.tuneconsultingtask.databinding.FragmentProjectBinding
import admiral.group.tuneconsultingtask.ui.viewmodel.MainViewModel
import admiral.group.tuneconsultingtask.util.ItemClickListener
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_project.*


@AndroidEntryPoint
class ProjectFragment : Fragment(R.layout.fragment_project) , ItemClickListener{

    private val mainViewModel: MainViewModel by viewModels()
    private val navController by lazy(LazyThreadSafetyMode.NONE) {findNavController()}
    private lateinit var projectAdapter: ProjectAdapter
    private val vbinding: FragmentProjectBinding by viewBinding()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(vbinding) {
            setUpRecyclerView()

            mainViewModel.readAll.observe(requireActivity()) { list ->
                updateUi(list, this)
                projectAdapter.mTodo = list

            }

            addProject.setOnClickListener {
                navController.navigate(R.id.action_navigation_home_to_newProjectFragment)
                (requireActivity() as MainActivity).setGone()
            }

        }
    }

    private fun setUpRecyclerView(){
            projectAdapter=ProjectAdapter(this)

            myRecyclerView.apply {
                layoutManager=LinearLayoutManager(requireContext())
                adapter=projectAdapter

            }
        }

    private fun updateUi(list: List<ProjectEntity>?, binding:FragmentProjectBinding) {
       if (list!!.isNotEmpty()){
           setVisisbilty(binding.myRecyclerView)
           setGone(binding.myLayout)
       }else{
           setVisisbilty( binding.myLayout)
           setGone(binding.myRecyclerView)
       }
    }

   private fun setGone(view:View){
       if (view.visibility!=View.GONE){
           view.visibility=View.GONE
       }
   }

    private fun setVisisbilty(view:View){
        if (view.visibility!=View.VISIBLE){
            view.visibility=View.VISIBLE
        }
    }

    override fun onResume() {
        super.onResume()
        (requireActivity() as MainActivity).setVisible()
    }


    override fun onItemClick(
       id:Int
    ) {
        val action=ProjectFragmentDirections.actionNavigationHomeToMainDataFragment(id)
        navController.navigate(action)
        (requireActivity() as MainActivity).setGone()
    }


}