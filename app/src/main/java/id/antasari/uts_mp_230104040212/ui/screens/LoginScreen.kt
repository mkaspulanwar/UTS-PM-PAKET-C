package id.antasari.uts_mp_230104040212.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import id.antasari.uts_mp_230104040212.data.DataStoreManager
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(
    dataStoreManager: DataStoreManager,
    onLoginSuccess: (String) -> Unit
) {
    val coroutineScope = rememberCoroutineScope()

    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var rememberMe by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    // UI
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .padding(24.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Form Login Palsu", style = MaterialTheme.typography.headlineSmall)
            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = username,
                onValueChange = { username = it },
                label = { Text("Username") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(12.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(checked = rememberMe, onCheckedChange = { rememberMe = it })
                Spacer(modifier = Modifier.width(8.dp))
                Text("Ingat saya")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(modifier = Modifier.fillMaxWidth(), onClick = {
                // validasi statis: username = "mhs", password = "123"
                if (username.trim() == "mhs" && password == "123") {
                    errorMessage = null
                    coroutineScope.launch {
                        if (rememberMe) {
                            dataStoreManager.saveUsername(username.trim())
                        } else {
                            // hapus jika ada
                            dataStoreManager.clearUsername()
                        }
                        onLoginSuccess(username.trim())
                    }
                } else {
                    errorMessage = "Username atau password salah"
                }
            }) {
                Text("Login")
            }

            errorMessage?.let {
                Spacer(modifier = Modifier.height(12.dp))
                Text(text = it, color = MaterialTheme.colorScheme.error)
            }
        }
    }
}
