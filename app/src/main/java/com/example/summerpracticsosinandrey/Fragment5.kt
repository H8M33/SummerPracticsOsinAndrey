package com.example.summerpracticsosinandrey

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.summerpracticsosinandrey.databinding.Fragment5Binding;
import com.google.android.material.snackbar.Snackbar
import java.lang.Exception

class Fragment5 : Fragment() {

    private var _binding: Fragment5Binding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = Fragment5Binding.inflate(inflater, container, false)
        val root: View = binding.root
        val a:MainActivity = activity as MainActivity
        if(a.getHash()!="") {
            try {
                Snackbar.make(
                    requireActivity().findViewById(android.R.id.content),
                    a.getHash(),
                    Snackbar.LENGTH_LONG
                ).apply {
                    setAnchorView(R.id.nav_view)
                }.show()
            } catch (e: Exception) {
            }
        }
        a.saveHash("Fragment5")
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}