package admiral.group.tuneconsultingtask.ui.union

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import admiral.group.tuneconsultingtask.databinding.FragmentUnionBinding
import androidx.navigation.fragment.findNavController

class UnionFragment : Fragment() {

    private var _binding: FragmentUnionBinding? = null
    private val navController by lazy(LazyThreadSafetyMode.NONE) {findNavController()}

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(UnionViewModel::class.java)

        _binding = FragmentUnionBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textDashboard
        dashboardViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}