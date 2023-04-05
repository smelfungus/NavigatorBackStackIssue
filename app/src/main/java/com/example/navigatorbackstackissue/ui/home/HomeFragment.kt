package com.example.navigatorbackstackissue.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.fragment.findNavController
import com.example.navigatorbackstackissue.R
import com.example.navigatorbackstackissue.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.button.setOnClickListener {
            when (findNavController().currentDestination?.id) {
                R.id.navigation_home -> {
                    findNavController()
                        .navigate(R.id.action_navigation_home_to_rootNoOp)
                }
                R.id.rootNoOp -> {
                    findNavController()
                        .navigate(R.id.action_rootNoOp_to_innerNoOp)
                }
                else -> {
                }
            }
        }

        findNavController().addOnDestinationChangedListener { controller, destination, arguments ->
            Log.d("HomeFragment", destination.displayName)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
