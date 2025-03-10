package com.example.johannesburg.ui.theme.screens.registration

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.johannesburg.R
import com.example.johannesburg.ui.theme.ElectricBlue
import com.example.johannesburg.ui.theme.SoftWhite


class RegisterActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RegisterScreen()
        }
    }
}

@Composable
fun RegisterScreen() {
    var name by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(Color(0xFF1E3A8A), Color(0xFF2563EB))
                )
            )
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFF1F2F2), RoundedCornerShape(20.dp))
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.newlogo),
                contentDescription = "App Logo",
                modifier = Modifier
                    .width(420.dp)
                    .height(120.dp)
                    .padding(bottom = 16.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))

            RegistrationTextField("Full Name", name) { name = it }
            RegistrationTextField("Phone Number", phone) { phone = it }
            RegistrationTextField("Email", email) { email = it }
            PasswordTextField("Password", password, passwordVisible) { password = it }
            PasswordTextField("Confirm Password", confirmPassword, passwordVisible) { confirmPassword = it }

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                "By continuing, you agree to our Terms and Conditions",
                fontSize = 12.sp,
                color = Color.Gray,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = { /* Handle registration logic */ },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = ElectricBlue, contentColor = SoftWhite),
                shape = RoundedCornerShape(12.dp),
                elevation = ButtonDefaults.elevatedButtonElevation(defaultElevation = 8.dp)
            ) {
                Text("Sign Up", fontSize = 18.sp)
            }

            Spacer(modifier = Modifier.height(10.dp))

            SocialLoginButtons()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegistrationTextField(label: String, value: String, onValueChange: (String) -> Unit) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label, color = Color.Gray) },
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = ElectricBlue,
            unfocusedBorderColor = Color.Gray,
        )
    )
    Spacer(modifier = Modifier.height(10.dp))
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordTextField(label: String, value: String, passwordVisible: Boolean, onValueChange: (String) -> Unit) {
    var visibility by remember { mutableStateOf(passwordVisible) }

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label, color = Color.Gray) },
        modifier = Modifier.fillMaxWidth(),
        visualTransformation = if (visibility) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            IconButton(onClick = { visibility = !visibility }) {
                Icon(
                    painter = painterResource(if (visibility) R.drawable.visibility else R.drawable.visibility_off),
                    contentDescription = "Toggle Password Visibility"
                )
            }
        },
        shape = RoundedCornerShape(12.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = ElectricBlue,
            unfocusedBorderColor = Color.Gray,
        )
    )
    Spacer(modifier = Modifier.height(10.dp))
}

@Composable
fun SocialLoginButtons() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        val icons = listOf(
            R.drawable.googleicon,
            R.drawable.appleicon,
            R.drawable.msicon,
        )

        icons.forEach { icon ->
            IconButton(
                onClick = { /* Handle social login */ },
                modifier = Modifier
                    .size(60.dp)
                    .background(Color.White, CircleShape)
                    .border(1.dp, Color.LightGray, CircleShape)
            ) {
                Icon(
                    painter = painterResource(id = icon),
                    contentDescription = null,
                    tint = Color.Unspecified,
                    modifier = Modifier.size(30.dp)
                )
            }
            Spacer(modifier = Modifier.width(12.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewRegisterScreen() {
    RegisterScreen()
}
