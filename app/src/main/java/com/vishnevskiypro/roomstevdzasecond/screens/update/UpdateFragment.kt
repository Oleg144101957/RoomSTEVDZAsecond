package com.vishnevskiypro.roomstevdzasecond.screens.update

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.vishnevskiypro.roomstevdzasecond.R
import com.vishnevskiypro.roomstevdzasecond.databinding.FragmentUpdateBinding
import com.vishnevskiypro.roomstevdzasecond.model.User
import com.vishnevskiypro.roomstevdzasecond.viewmodel.UserViewModel

class UpdateFragment : Fragment() {

    private lateinit var binding: FragmentUpdateBinding
    private val args by navArgs<UpdateFragmentArgs>()

    private lateinit var mUserViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentUpdateBinding.inflate(layoutInflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)


        binding.apply {
            updateFirstNameTextInput.setText(args.currentUser.firstName)
            updateSecondNameTextInput.setText(args.currentUser.secondName)
            updateAgeTextInput.setText(args.currentUser.age.toString())
        }

        binding.buttonUpdate.setOnClickListener {
            updateItem()
        }

        super.onViewCreated(view, savedInstanceState)
    }

    private fun updateItem(){
        val firstName = binding.updateFirstNameTextInput.text.toString()
        val secondName = binding.updateSecondNameTextInput.text.toString()
        val age = Integer.parseInt(binding.updateAgeTextInput.text.toString())

        if (inputCheck(firstName, secondName, binding.updateAgeTextInput.text)){
            //Create Object
            val updatedUser = User(args.currentUser.id, firstName, secondName, age)

            //Update Current User
            mUserViewModel.updateUser(user = updatedUser)
            Toast.makeText(requireContext(), "Updated", Toast.LENGTH_LONG).show()
            //Navigate Back
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)

        } else {
            Toast.makeText(requireContext(), "Fill all fields", Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(firstName: String, secondName: String, age: Editable): Boolean {
        return !(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(secondName) && age.isEmpty())
    }

}