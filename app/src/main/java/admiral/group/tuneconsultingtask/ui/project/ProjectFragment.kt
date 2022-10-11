package admiral.group.tuneconsultingtask.ui.project


import admiral.group.tuneconsultingtask.MainActivity
import admiral.group.tuneconsultingtask.R
import admiral.group.tuneconsultingtask.database.ProjectEntity
import admiral.group.tuneconsultingtask.databinding.FragmentProjectBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ProjectFragment : Fragment() {

    private var _binding: FragmentProjectBinding? = null
     private val projectViewModel:ProjectViewModel by viewModels()
    private val navController by lazy(LazyThreadSafetyMode.NONE) {findNavController()}
    private lateinit var projectAdapter: ProjectAdapter

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProjectBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
          setUpRecyclerView()

        binding.addProject.setOnClickListener {
           navController.navigate(R.id.action_navigation_home_to_newProjectFragment)
            (requireActivity() as MainActivity).setGone()
        }

    }

    private fun setUpRecyclerView(){
        projectAdapter=ProjectAdapter()

    binding.myRecyclerView.apply {
        layoutManager=LinearLayoutManager(requireContext())
        adapter=projectAdapter
    }

        projectViewModel.readAll.observe(requireActivity()){list->
            updateUi(list)
            projectAdapter.mTodo=list

        }

}

    private fun updateUi(list: List<ProjectEntity>?) {
       if (list!!.isNotEmpty()){
           Toast.makeText(requireContext(), "${list.size}", Toast.LENGTH_SHORT).show()
           binding.myRecyclerView.visibility=View.VISIBLE
           binding.myLayout.visibility=View.GONE
       }else{
           binding.myRecyclerView.visibility=View.GONE
           binding.myLayout.visibility=View.VISIBLE
       }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}