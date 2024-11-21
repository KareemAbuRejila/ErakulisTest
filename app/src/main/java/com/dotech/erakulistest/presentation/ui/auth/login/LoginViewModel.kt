package com.dotech.erakulistest.presentation.ui.auth.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import at.favre.lib.crypto.bcrypt.BCrypt
import com.dotech.erakulistest.data.local.dao.UserDao
import com.dotech.erakulistest.data.utils.SessionManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val userDao: UserDao,
    private val sessionManager: SessionManager
) : ViewModel() {


    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage

    private val _userToken = MutableStateFlow<String?>(null)
    val userToken: StateFlow<String?> = _userToken

    init {
        checkToken()
    }

    private fun checkToken(){
        _userToken.value = sessionManager.getToken()
    }

    fun login(email: String, password: String) {
        _errorMessage.value = null

        if (email.isEmpty() || password.isEmpty()) {
            _errorMessage.value = "Email and Password cannot be empty"
            return
        }

        if (password.length < 6 || password.length > 12) {
            _errorMessage.value = "Password must be between 6 and 12 characters"
            return
        }

        viewModelScope.launch {
            val user = userDao.checkUserExists(email)
            if (user != null) {
                val result = BCrypt.verifyer().verify(password.toCharArray(), user.password)
                if (result.verified) {
                    // Generate a unique token
                    val token = UUID.randomUUID().toString()
                    userDao.updateUserToken(email, token)
                    sessionManager.saveToken(token)
                    _userToken.value = token
                } else {
                    _errorMessage.value = "Invalid email or password"
                }
            } else {
                _errorMessage.value = "Invalid email or password"
            }
        }
    }
}