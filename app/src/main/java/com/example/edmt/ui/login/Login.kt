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
import com.example.edmt.databinding.FragmentLoginBinding
import com.example.edmt.ui.login.MainViewModel
import com.example.edmt.ui.login.MainViewModelFactory
import com.example.edmt.ui.login.model.Login_schema
import com.example.edmt.ui.login.repository.Repository

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Login.newInstance] factory method to
 * create an instance of this fragment.
 */
class Login : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        binding.signupButton.setOnClickListener { view: View ->
            Navigation.findNavController(view).navigate(R.id.action_login_to_signup)
        }
       /* binding.loginButton.setOnClickListener { view: View ->
            Navigation.findNavController(view).navigate(R.id.action_login_to_nav_home)
        }*/
        binding.loginButton.setOnClickListener {
            if (validateinfo()) {
                lateinit var viewModel: MainViewModel
                val repository = Repository()
                val viewModelFactory = MainViewModelFactory(repository)
                viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
                val user = Login_schema(
                    binding.loginEmailEntry.text.toString(),
                    binding.loginPasswordEntry.text.toString()
                )
                viewModel.pushPost(user)
                viewModel.myresponse.observe(viewLifecycleOwner, Observer { response ->
                    if (response.isSuccessful) {
                        Toast.makeText(context, response.message().toString(), Toast.LENGTH_SHORT)
                            .show()
                        Navigation.findNavController(it).navigate(R.id.action_login_to_nav_home)
                    } else {
                        println("2")
                        Toast.makeText(context, response.message().toString(), Toast.LENGTH_SHORT)
                            .show()
                        Navigation.findNavController(it).navigate(R.id.action_login_to_signup)
                    }
                })
            }
        }
        return binding.root
    }

    fun validateinfo(): Boolean {
        return when{

            // validate input not empty

            TextUtils.isEmpty(binding.loginEmailEntry.text.toString().trim { it<=' ' }) ->{
                false
            }

            TextUtils.isEmpty(binding.loginPasswordEntry.text.toString().trim { it<=' ' }) ->{
                false
            }

            //validate email
            !android.util.Patterns.EMAIL_ADDRESS.matcher(
                binding.loginEmailEntry.text.toString().trim { it <= ' ' }).matches() -> {
                false
            }

            else -> {
                true
            }
        }
    }


}