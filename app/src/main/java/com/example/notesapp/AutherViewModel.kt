package com.example.notesapp

import android.text.TextUtils
import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notesapp.models.UserRequest
import com.example.notesapp.models.UserResponse
import com.example.notesapp.repository.UserRepository
import com.example.notesapp.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.regex.Pattern
import javax.inject.Inject

@HiltViewModel
class AutherViewModel @Inject constructor (private val userRepository: UserRepository): ViewModel(){

    val userResponseLiveData : LiveData<NetworkResult<UserResponse>>
    get() = userRepository.userResponseLiveData

    fun registerUser(userRequest: UserRequest){

        viewModelScope.launch {
            userRepository.registerUser(userRequest)
        }

    }

    fun loginUser(userRequest: UserRequest){
        viewModelScope.launch {
            userRepository.loginUser(userRequest)
        }
    }

    fun validateCredentials(username : String , emailaddress : String, password : String, isLogin : Boolean): Pair<Boolean, String>{
        var result = Pair(true , "")

        if (!isLogin && TextUtils.isEmpty(username) || TextUtils.isEmpty(emailaddress) || TextUtils.isEmpty(password) ){
            result = Pair(false , "Please Provide Valid Credentials")
        }
        else if (!Patterns.EMAIL_ADDRESS.matcher(emailaddress).matches()){
            result = Pair(false , " Please Provide Valid Email")
        }
        else if (password.length <=5){
            result = Pair(false, " Password Length Should Be More Than 5 Characters")
        }
        return result
    }
}