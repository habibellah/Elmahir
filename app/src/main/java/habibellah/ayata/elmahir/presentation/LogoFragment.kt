package habibellah.ayata.elmahir.presentation

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import habibellah.ayata.elmahir.R
import habibellah.ayata.elmahir.databinding.FragmentLogoBinding

class LogoFragment : Fragment() {

   private lateinit var binding : FragmentLogoBinding
   override fun onCreateView(
      inflater : LayoutInflater , container : ViewGroup? ,
      savedInstanceState : Bundle?
   ) : View {
      binding = DataBindingUtil.inflate(inflater, R.layout.fragment_logo, container, false)
      timer()
      return binding.root
   }

   private fun timer() {
      Handler(Looper.getMainLooper()).postDelayed({
         navigateToNavigationBottomFragment()
      }, 3000)
   }

   private fun navigateToNavigationBottomFragment() {
      Navigation.findNavController(requireActivity(),R.id.fragmentContainerView)
         .navigate(R.id.action_logoFragment_to_navigationBottomFragment)
   }

}