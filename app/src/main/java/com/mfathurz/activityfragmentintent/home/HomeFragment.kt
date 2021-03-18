package com.mfathurz.activityfragmentintent.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import com.mfathurz.activityfragmentintent.core.domain.User
import com.mfathurz.activityfragmentintent.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val list = ArrayList<User>()
        val adapter = UserListAdapter()
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter

        val fireStore = FirebaseFirestore.getInstance()
        fireStore.collection("users").get().addOnSuccessListener {querySnapShot ->
            querySnapShot.forEach {document->
                list.add(
                    User(
                        document.id,
                        document.getString("name") ?: "",
                        document.getString("city") ?: ""
                    )
                )
            }
            adapter.submitList(list)
        }.addOnFailureListener {
            Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
        }
    }
}

