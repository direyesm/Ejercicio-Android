package com.example.moofwd_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moofwd_app.adapters.ItemAdapter
import com.example.moofwd_app.databinding.FragmentFirstBinding
import com.example.moofwd_app.entities.ItemEnti
import com.example.moofwd_app.viewModel.ItemViewModel

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val viewModel by lazy { ViewModelProvider(this).get(ItemViewModel::class.java) }
    private lateinit var adapter: ItemAdapter


    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)


        binding.recyclerView.layoutManager = LinearLayoutManager(requireActivity())
        adapter = ItemAdapter(requireActivity())
        binding.recyclerView.adapter = adapter

        viewModel.fetchData().observe(viewLifecycleOwner, Observer {
            adapter.updateListItem(it)
        })

        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}