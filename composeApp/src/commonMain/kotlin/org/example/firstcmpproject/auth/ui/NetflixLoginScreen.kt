package org.example.firstcmpproject.auth.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import firstcmpproject.composeapp.generated.resources.Res
import firstcmpproject.composeapp.generated.resources.email_or_phone_hint
import firstcmpproject.composeapp.generated.resources.forget_password
import firstcmpproject.composeapp.generated.resources.hide
import firstcmpproject.composeapp.generated.resources.netflix_logo_app_bar
import firstcmpproject.composeapp.generated.resources.or
import firstcmpproject.composeapp.generated.resources.password_hint
import firstcmpproject.composeapp.generated.resources.show
import firstcmpproject.composeapp.generated.resources.sign_in
import firstcmpproject.composeapp.generated.resources.use_a_sign_in_code
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun NetflixLoginScreen(onTapSignIn: () -> Unit) {

    var email by mutableStateOf("");
    var password by mutableStateOf("");

    var isPasswordShown by mutableStateOf(false);

    Scaffold(
        containerColor = Color.Black,
        topBar = {
            NetflixLoginScreenAppBar()
        }
    ) { innerPadding ->
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.padding(innerPadding).fillMaxSize()
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(horizontal = 40.dp)
            ) {
                /// Email
                OutlinedTextField(
                    value = email,
                    onValueChange = { text ->
                        email = text
                    },
                    placeholder = {
                        Text(
                            stringResource(Res.string.email_or_phone_hint),
                            color = Color(red = 145, green = 145, blue = 145)
                        )
                    },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = Color(red = 51, green = 51, blue = 51),
                        unfocusedContainerColor = Color(red = 51, green = 51, blue = 51),
                        focusedBorderColor = Color.Transparent,
                        unfocusedBorderColor = Color.Transparent,
                        focusedTextColor = Color.White,
                        unfocusedTextColor = Color.White
                    ),
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(16.dp))

                /// Password
                OutlinedTextField(
                    value = password,
                    onValueChange = { text ->
                        password = text
                    },
                    placeholder = {
                        Text(
                            stringResource(Res.string.password_hint),
                            color = Color(red = 145, green = 145, blue = 145)
                        )
                    },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = Color(red = 51, green = 51, blue = 51),
                        unfocusedContainerColor = Color(red = 51, green = 51, blue = 51),
                        focusedBorderColor = Color.Transparent,
                        unfocusedBorderColor = Color.Transparent,
                        focusedTextColor = Color.White,
                        unfocusedTextColor = Color.White
                    ),
                    visualTransformation = if (isPasswordShown) VisualTransformation.None else PasswordVisualTransformation(),
                    suffix = {
                        Text(
                            if (isPasswordShown) stringResource(Res.string.hide) else stringResource(Res.string.show),
                            color = Color(red = 145, green = 145, blue = 145),
                            modifier = Modifier.clickable {
                                isPasswordShown = !isPasswordShown;
                            }
                        )
                    },
                    modifier = Modifier.padding(top = 16.dp).fillMaxWidth()
                )


                Spacer(modifier = Modifier.padding(top = 16.dp))

                // Sign In Button
                Button(
                    onClick = {
                        onTapSignIn();
                    },
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(red = 83, green = 14, blue = 13)
                    ),
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    Text(
                        stringResource(Res.string.sign_in),
                        fontSize = 16.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                // OR
                Text(stringResource(Res.string.or), color = Color(red = 145, green = 145, blue = 145), fontSize = 16.sp)

                Spacer(modifier = Modifier.height(20.dp))

                /// Use a sign in code
                Button(
                    onClick = {

                    },
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(red = 51, green = 51, blue = 51)
                    ),
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    Text(
                        stringResource(Res.string.use_a_sign_in_code),
                        fontSize = 16.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(modifier = Modifier.height(32.dp))

                Text(
                    stringResource(Res.string.forget_password),
                    fontWeight = FontWeight.Bold,
                    color = Color(red = 181, green = 181, blue = 181),
                    modifier = Modifier.clickable {

                    }
                )

                Spacer(modifier = Modifier.height(32.dp))

                SignInTermsAndConditions()
            }
        }
    }
}

@Composable
fun SignInTermsAndConditions() {
    val annotatedString = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                color = Color(
                    red = 145,
                    green = 145,
                    blue = 145
                )
            )
        ) {
            append("Sign in is protected by Google reCAPTCHA to ensure you're not a bot.")
        }


        withStyle(
            style = SpanStyle(
                color = Color(red = 145, green = 145, blue = 145),
                fontWeight = FontWeight.Bold
            )
        ) {
            append("Learn More.")

        }

    }

    Text(annotatedString, textAlign = TextAlign.Center)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NetflixLoginScreenAppBar() {
    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Black,
        ),
        title = {
            Image(
                painterResource(Res.drawable.netflix_logo_app_bar),
                contentDescription = "Netflix Appbar Icon"
            )
        },
        navigationIcon = {
            Icon(
                Icons.AutoMirrored.Default.KeyboardArrowLeft,
                contentDescription = "Back button",
                tint = Color.White,
                modifier = Modifier.size(32.dp)
            )
        },
        actions = {
            Text(
                "Help",
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(end = 12.dp)
            )
        },
    )
}

@Preview
@Composable
fun NetflixLoginScreenPreview() {
    NetflixLoginScreen(onTapSignIn = {})
}