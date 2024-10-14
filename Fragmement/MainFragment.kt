package com.example.practico3tindermo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.practico3tindermo.Adapters.ImagePagerAdapter
import com.example.practico3tindermo.databinding.FragmentMainBinding
import com.example.practico3tindermo.Fragmement.LikesFragment
import com.example.practico3tindermo.ViewModel.MainViewModel

class MainFragment : Fragment() {

    private lateinit var viewModel: MainViewModel
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        // Observa el LiveData
        viewModel.person.observe(viewLifecycleOwner) { person ->
            if (person != null) {
                binding.personName.text = person.name
                binding.imageViewPager.adapter = ImagePagerAdapter(person.imageResources)
            } else {
                binding.personName.text = "No hay más personas"
                binding.imageViewPager.adapter = null
            }
        }

        binding.btnLike.setOnClickListener {
            viewModel.likePerson()
        }

        binding.btnDislike.setOnClickListener {
            viewModel.dislikePerson()
        }

        binding.btnShowLikes.setOnClickListener {
            val likedPeople = ArrayList(viewModel.getLikedPeople())
            val fragment = LikesFragment.newInstance(likedPeople)
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
