package com.example.edmt

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.edmt.databinding.FragmentSignupBinding
import com.example.edmt.ui.login.MainViewModel
import com.example.edmt.ui.login.MainViewModelFactory
import com.example.edmt.ui.login.model.Signup_schema
import com.example.edmt.ui.login.repository.Repository



// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [signup.newInstance] factory method to
 * create an instance of this fragment.
 */
class signup : Fragment() {
    private lateinit var binding: FragmentSignupBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_signup, container, false)

        binding.signupSignupButton.setOnClickListener { view: View ->
            if (validateRegistrationDetails()) {
                lateinit var viewModel: MainViewModel
                val repository = Repository()
                val viewModelFactory = MainViewModelFactory(repository)
                viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
                val user = Signup_schema(
                    binding.signupFirstNameEntry.text.toString(),
                    binding.signupMiddleNameEntry.text.toString(),
                    binding.signupLastNameEntry.text.toString(),
                    binding.signupEmailEntry.text.toString(),
                    binding.signupPasswordEntry.text.toString(),
                    binding.signupPhoneNumberEntry.text.toString(),
                    binding.signupBirthdateEntry.text.toString(),
                    binding.signupGenderEntry.text.toString(),
                    binding.signupCardNumberEntry.text.toString(),
                    true
                )
                viewModel.Signup(user)
                viewModel.myresponse2.observe(viewLifecycleOwner, Observer { response ->
                    if (response.isSuccessful) {
                        Toast.makeText(context, response.message().toString(), Toast.LENGTH_SHORT)
                            .show()
                        Navigation.findNavController(view).navigate(R.id.action_signup_to_nav_home)
                    } else {
                        Toast.makeText(context, response.message().toString(), Toast.LENGTH_SHORT)
                            .show()

                    }
                })
            }
        }
        return binding.root
    }


    fun validateRegistrationDetails(): Boolean {
        return when {
            // validate input not empty

            TextUtils.isEmpty(binding.signupFirstNameEntry.text.toString().trim { it <= ' ' }) -> {
                false
            }

            TextUtils.isEmpty(binding.signupMiddleNameEntry.text.toString().trim { it <= ' ' }) -> {
                false
            }

            TextUtils.isEmpty(binding.signupLastNameEntry.text.toString().trim { it <= ' ' }) -> {
                false
            }

            TextUtils.isEmpty(binding.signupEmailEntry.text.toString().trim { it <= ' ' }) -> {
                false
            }

            TextUtils.isEmpty(
                binding.signupConfirmPasswordEntry.text.toString().trim { it <= ' ' }) -> {
                false
            }

            TextUtils.isEmpty(
                binding.signupConfirmPasswordEntry.text.toString().trim { it <= ' ' }) -> {
                false
            }

            TextUtils.isEmpty(
                binding.signupPhoneNumberEntry.text.toString().trim { it <= ' ' }) -> {
                false
            }

            TextUtils.isEmpty(binding.signupBirthdateEntry.text.toString().trim { it <= ' ' }) -> {
                false
            }

            TextUtils.isEmpty(binding.signupGenderEntry.text.toString().trim { it <= ' ' }) -> {
                false
            }

            TextUtils.isEmpty(binding.signupCardNumberEntry.text.toString().trim { it <= ' ' }) -> {
                false
            }

            // validate password match confirm-password
            binding.signupPasswordEntry.text.toString()
                .trim { it <= ' ' } != binding.signupConfirmPasswordEntry.text.toString()
                .trim { it <= ' ' } -> {
                false
            }

            // validate email
            !android.util.Patterns.EMAIL_ADDRESS.matcher(
                binding.signupEmailEntry.text.toString().trim { it <= ' ' }).matches() -> {
                false
            }

            else -> {
                true
            }
        }
    }
}


