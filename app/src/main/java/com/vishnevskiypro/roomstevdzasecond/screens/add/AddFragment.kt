package com.vishnevskiypro.roomstevdzasecond.screens.add

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.vishnevskiypro.roomstevdzasecond.R
import com.vishnevskiypro.roomstevdzasecond.data.User
import com.vishnevskiypro.roomstevdzasecond.data.UserViewModel
import com.vishnevskiypro.roomstevdzasecond.databinding.FragmentAddBinding

class AddFragment : Fragment(R.id.addFragment) {

    private lateinit var binding: FragmentAddBinding
    private lateinit var mUserViewModel: UserViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentAddBinding.inflate(layoutInflater, container, false)
        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.buttonAdd.setOnClickListener {
            insertDataToDatabase()
        }
        super.onViewCreated(view, savedInstanceState)
    }

    private fun insertDataToDatabase() {
        val id = 0
        val firstName = binding.firstNameTextInput.text.toString()
        val secondName = binding.secondNameTextInput.text.toString()
        val age = binding.ageTextInput.text

        if (inputCheck(firstName, secondName, age)){
            //Create Object
            val user = User(0, firstName, secondName, Integer.parseInt(age.toString()))

            //Add to Database
            mUserViewModel.addUser(user)
            Toast.makeText(requireContext(), "User added", Toast.LENGTH_LONG).show()

            //Navigate Back
            findNavController().navigate(R.id.action_addFragment_to_listFragment)

        } else {
            Toast.makeText(requireContext(), "Fill all fields please", Toast.LENGTH_LONG).show()
        }

    }

    private fun inputCheck(firstName: String, secondName: String, age: Editable): Boolean {
        return !(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(secondName) && age.isEmpty())
    }


}