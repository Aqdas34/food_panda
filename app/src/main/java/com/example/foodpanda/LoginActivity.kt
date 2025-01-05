package  com.example.foodpanda
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import com.example.foodpanda.ui.theme.FoodPandaTheme

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodPandaTheme {
                LoginScreen()
            }
        }
    }
}

@Composable
fun LoginScreen() {
    val context = LocalContext.current;
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFC0CB)) // Pink background
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Top Image
        Image(
            painter = painterResource(id = R.drawable.panda_image),
            contentDescription = stringResource(id = R.string.login_image),
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            contentScale = ContentScale.Fit
        )

        // Login container
        Spacer(modifier = Modifier.height(30.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(12.dp))
                .background(Color.White)
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Title
            Text(
                text = stringResource(id = R.string.sign_up_or_log_in),
                color = Color.Black,
                fontSize = 24.sp,
                modifier = Modifier.padding(bottom = 8.dp),
                textAlign = TextAlign.Center
            )

            // Subtitle
            Text(
                text = stringResource(id = R.string.select_your_preferred_method_to_continue),
                color = Color.Gray,
                fontSize = 14.sp,
                modifier = Modifier.padding(bottom = 20.dp),
                textAlign = TextAlign.Center
            )

//            // Google Sign-in button
//            Button(
//                onClick = { /* TODO: Implement Google Sign-In */ },
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(vertical = 7.dp),
//            ) {
//                Text(text = stringResource(id = R.string.continue_with_google), color = Color.White)
//            }
//
//            // Facebook Sign-in button
//            Button(
//                onClick = { /* TODO: Implement Facebook Sign-In */ },
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(vertical = 7.dp),
//            ) {
//                Text(text = stringResource(id = R.string.continue_with_facebook), color = Color.White)
//            }

            // Divider
//            Spacer(modifier = Modifier
//                .fillMaxWidth()
//                .height(1.dp)
//                .background(Color.Gray)
//                .padding(vertical = 10.dp)
//            )

            // Email Sign-in button
            Button(
                onClick = {
                    val intent = Intent(context, EmailActivity::class.java)
                    context.startActivity(intent)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 7.dp),
            ) {
                Text(text = stringResource(id = R.string.continue_with_email), color = Color.White)
            }

            // Terms and conditions
            Text(
//                text = stringResource()
                text = stringResource(id = R.string.by_continuing_you_agree_to_our_terms_and_conditions_and_privacy_policy),
                color = Color.Gray,
                fontSize = 12.sp,
                modifier = Modifier.padding(top = 7.dp),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    FoodPandaTheme {
        LoginScreen()
    }
}
