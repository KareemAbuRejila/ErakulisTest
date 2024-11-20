package com.dotech.erakulistest.presentation.common.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation

@Composable
fun CusTextField(
    value: String ,
    onValueChange : (String)-> Unit,
    label: String,
    modifier : Modifier = Modifier.fillMaxWidth(),
    visualTransformation : VisualTransformation?=null
){
    (visualTransformation)?.let {
        TextField(
        value = value,
        onValueChange = { onValueChange},
        label = { Text(label) },
        modifier = modifier,
        visualTransformation = it
    )
    }
}