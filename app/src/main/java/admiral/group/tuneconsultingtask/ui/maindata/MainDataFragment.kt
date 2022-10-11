package admiral.group.tuneconsultingtask.ui.maindata

import admiral.group.tuneconsultingtask.MainActivity
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import admiral.group.tuneconsultingtask.R
import admiral.group.tuneconsultingtask.databinding.FragmentMainDataBinding
import admiral.group.tuneconsultingtask.databinding.FragmentNewProjectBinding
import admiral.group.tuneconsultingtask.ui.newproject.NewProjectViewModel
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainDataFragment : Fragment() {

    private val navController by lazy(LazyThreadSafetyMode.NONE) {findNavController()}
    private val mainDataViewModel: MainDataViewModel by viewModels()

    private var _binding: FragmentMainDataBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainDataBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        (requireActivity() as MainActivity).setVisible()
        _binding = null
    }


}