package habibellah.ayata.elmahir.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import habibellah.ayata.elmahir.R
import habibellah.ayata.elmahir.databinding.FragmentNavigationBottomBinding

class NavigationBottomFragment : Fragment() {

   private lateinit var binding : FragmentNavigationBottomBinding
   override fun onCreateView(
      inflater : LayoutInflater , container : ViewGroup? ,
      savedInstanceState : Bundle?
   ) : View {
      binding = DataBindingUtil.inflate(inflater, R.layout.fragment_navigation_bottom, container, false)
      return binding.root
   }

   override fun onStart() {
      super.onStart()
      val navigate = requireActivity().findNavController(R.id.fragment_container)
      binding.bottomNavigationView.setupWithNavController(navigate)
   }
}