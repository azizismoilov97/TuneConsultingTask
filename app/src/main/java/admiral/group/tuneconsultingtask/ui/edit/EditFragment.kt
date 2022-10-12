package admiral.group.tuneconsultingtask.ui.edit

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import admiral.group.tuneconsultingtask.R
import admiral.group.tuneconsultingtask.databinding.FragmentEditBinding
import admiral.group.tuneconsultingtask.databinding.FragmentMainDataBinding
import admiral.group.tuneconsultingtask.ui.MainViewModel
import admiral.group.tuneconsultingtask.ui.maindata.MainDataFragmentArgs
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class EditFragment @Inject constructor() : Fragment() {


    private val navController by lazy(LazyThreadSafetyMode.NONE) {findNavController()}
    private val mainViewModel: MainViewModel by viewModels()
    private val editViewModel: EditViewModel by viewModels()


    private var _binding: FragmentEditBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEditBinding.inflate(inflater, container, false)
        return binding.root
    }


}