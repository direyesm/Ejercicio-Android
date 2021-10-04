package com.example.moofwd_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.moofwd_app.databinding.FragmentSecondBinding
import com.example.moofwd_app.viewModel.ItemViewModel

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val viewModel by lazy { ViewModelProvider(this).get(ItemViewModel::class.java) }


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)

        val arg = SecondFragmentArgs.fromBundle(requireArguments())
        val item = arg.itemEnti

//        binding.detailTitle.text
//        binding.detailDescr.text
//        binding.detailDate.text
//        Glide.with(itemView.context).load(item.image).centerCrop().into(binding.imageView2)

        viewModel.fetchDetails().observe(viewLifecycleOwner, Observer {

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