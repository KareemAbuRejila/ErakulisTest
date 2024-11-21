package com.dotech.erakulistest.presentation.ui.auth.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import at.favre.lib.crypto.bcrypt.BCrypt
import com.dotech.erakulistest.data.local.dao.UserDao
import com.dotech.erakulistest.data.models.User
import com.dotech.erakulistest.data.utils.SessionManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.util.UUID
import javax.inject.Inject


@HiltViewModel
class RegistrationViewModel @Inject constructor(
    private val userDao: UserDao,
    private val sessionManager: SessionManager
) : ViewModel() {

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage

    private val _userToken = MutableStateFlow<String?>(null)
    val userToken: StateFlow<String?> = _userToken

    fun register(email: String, password: String, age: Int?) {
        _errorMessage.value = null

        if (email.isEmpty() || password.isEmpty() || age == null) {
            _errorMessage.value = "All fields are required"
            return
        }

        if (password.length < 6 || password.length > 12) {
            _errorMessage.value = "Password must be between 6 and 12 characters"
            return
        }


        viewModelScope.launch {
            val existingUser = userDao.checkUserExists(email)
            if (existingUser != null) {
                _errorMessage.value = "Email already exists"
            } else {
                // Encrypt the password
                val hashedPassword = BCrypt.withDefaults().hashToString(12, password.toCharArray())

                userDao.registerUser(User(email = email, password = hashedPassword, age = age))
                val token = UUID.randomUUID().toString()
                sessionManager.saveToken(token)
                _userToken.value = token
            }
        }
    }
}