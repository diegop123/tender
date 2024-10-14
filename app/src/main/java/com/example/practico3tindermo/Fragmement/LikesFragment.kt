package com.example.practico3tindermo.Fragmement

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.practico3tindermo.Adapters.LikesAdapter
import com.example.practico3tindermo.Persona
import com.example.practico3tindermo.databinding.FragmentLikesBinding

class LikesFragment : Fragment() {

    private var _binding: FragmentLikesBinding? = null
    private val binding get() = _binding!!

    companion object {
        private const val ARG_LIKED_PEOPLE = "liked_people"

        fun newInstance(likedPeople: ArrayList<Persona>): LikesFragment {
            val fragment = LikesFragment()
            val args = Bundle().apply {
                putParcelableArrayList(ARG_LIKED_PEOPLE, likedPeople)
            }
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLikesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val likedPeople = arguments?.getParcelableArrayList<Persona>(ARG_LIKED_PEOPLE)
        binding.likesRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.likesRecyclerView.adapter = LikesAdapter(likedPeople ?: arrayListOf())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
