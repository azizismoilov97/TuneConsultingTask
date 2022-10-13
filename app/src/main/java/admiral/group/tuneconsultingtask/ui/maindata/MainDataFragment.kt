package admiral.group.tuneconsultingtask.ui.maindata

import admiral.group.tuneconsultingtask.MainActivity
import admiral.group.tuneconsultingtask.R
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import admiral.group.tuneconsultingtask.databinding.FragmentMainDataBinding
import admiral.group.tuneconsultingtask.model.ProjectEntity
import admiral.group.tuneconsultingtask.ui.viewmodel.MainViewModel
import android.text.Html
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.shape.CornerFamily
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainDataFragment : Fragment(R.layout.fragment_main_data) {

    private val navController by lazy(LazyThreadSafetyMode.NONE) {findNavController()}
    private val mainViewModel: MainViewModel by viewModels()
    private val args:MainDataFragmentArgs by navArgs()

    private val vBinding:FragmentMainDataBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        with(vBinding){

            txtEdit.setOnClickListener {
                val action=MainDataFragmentDirections.actionMainDataFragmentToEditFragment(args.id)
                navController.navigate(action)
                (requireActivity() as MainActivity).setGone()
            }

            mainViewModel.readOne(args.id).observe(requireActivity()){
                setData(it, this)
            }

            btnClose.setOnClickListener {
                navController.navigateUp()
            }

            val radius = resources.getDimension(R.dimen.my_corner_radius);
            cardView.shapeAppearanceModel
                .toBuilder()
                .setTopLeftCorner(CornerFamily.ROUNDED,radius)
                .setTopRightCorner(CornerFamily.ROUNDED,radius)
                .build();
        }

    }

    private fun setData(list:ProjectEntity, binding:FragmentMainDataBinding) {
            binding.txtNameproject.text = list.nameProject
            binding.nameproject.text=Html.fromHtml(getString(R.string.name_project)+": " + "<b> " + list.nameProject + "</b>")
            binding.fullname.text=Html.fromHtml(getString(R.string.text_fio)+": " + "<b> " + list.fullName + "</b>")
            binding.phonenumber.text=Html.fromHtml(getString(R.string.phone_producer)+": " + "<b> " + list.phoneNumber + "</b>")
            binding.production.text=Html.fromHtml(getString(R.string.text_production)+": " + "<b> " + list.production + "</b>")
            binding.interval.text=Html.fromHtml(getString(R.string.txt_interval)+": " + "<b> " + list.interval + "</b>")
            binding.continuous.text=Html.fromHtml(getString(R.string.txt_continuous)+": " + "<b> " + list.continious + "</b>")
    }

    override fun onResume() {
        super.onResume()
        (requireActivity() as MainActivity).setGone()
    }
}