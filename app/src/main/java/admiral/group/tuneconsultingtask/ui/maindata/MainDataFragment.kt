package admiral.group.tuneconsultingtask.ui.maindata

import admiral.group.tuneconsultingtask.MainActivity
import admiral.group.tuneconsultingtask.R
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import admiral.group.tuneconsultingtask.databinding.FragmentMainDataBinding
import admiral.group.tuneconsultingtask.ui.MainViewModel
import android.graphics.Typeface
import android.text.Html
import android.text.style.StyleSpan
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.material.shape.CornerFamily
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainDataFragment : Fragment() {


    private val navController by lazy(LazyThreadSafetyMode.NONE) {findNavController()}
    private val mainViewModel: MainViewModel by viewModels()
    private val args:MainDataFragmentArgs by navArgs()

    private var _binding: FragmentMainDataBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainDataBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setData()

        binding.btnClose.setOnClickListener {
            binding.btnClose.setOnClickListener {
                (requireActivity() as MainActivity).onBackPressed()
            }
        }

        val radius = resources.getDimension(R.dimen.my_corner_radius);
        binding.cardView.shapeAppearanceModel = binding.cardView.shapeAppearanceModel
            .toBuilder()
            .setTopLeftCorner(CornerFamily.ROUNDED,radius)
            .setTopRightCorner(CornerFamily.ROUNDED,radius)
            .build();

    }


    private fun setData() {
        binding.nameproject.text=Html.fromHtml(getString(R.string.name_project)+": " + "<b> " + args.nameProject + "</b>")
        binding.fullname.text=Html.fromHtml(getString(R.string.text_fio)+": " + "<b> " + args.fullName + "</b>")
        binding.phonenumber.text=Html.fromHtml(getString(R.string.phone_producer)+": " + "<b> " + args.production + "</b>")
        binding.production.text=Html.fromHtml(getString(R.string.text_production)+": " + "<b> " + args.phoneNumber + "</b>")
        binding.interval.text=Html.fromHtml(getString(R.string.txt_interval)+": " + "<b> " + args.interval + "</b>")
        binding.continuous.text=Html.fromHtml(getString(R.string.txt_continuous)+": " + "<b> " + args.continuous + "</b>")
    }


    override fun onDestroyView() {
        super.onDestroyView()
        (requireActivity() as MainActivity).setVisible()
        _binding = null
    }


}