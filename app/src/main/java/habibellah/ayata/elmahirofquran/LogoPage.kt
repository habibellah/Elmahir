package habibellah.ayata.elmahirofquran

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import habibellah.ayata.elmahirofquran.databinding.FragmentLogoPageBinding
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers.io
import java.util.concurrent.TimeUnit

class LogoPage : Fragment() {

    private lateinit var binding: FragmentLogoPageBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentLogoPageBinding.inflate(inflater, container, false)
        timerOfSeconds()
        return binding.root
    }

    private fun timerOfSeconds() {
        val observable = Observable.timer(3, TimeUnit.SECONDS)
        observable.subscribeOn(io()).observeOn(AndroidSchedulers.mainThread()).subscribe(
            { navToStudentTeacherPage() }, { throwException() }
        )
    }

    private fun navToStudentTeacherPage() {
        view?.let {
            Navigation.findNavController(it)
                .navigate(R.id.action_logoPage_to_navToStudentOrTeacherPage)
        }
    }

    private fun throwException() {
        throw Exception()
    }

}