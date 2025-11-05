package id.antasari.uts_mp_230104040212.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import id.antasari.uts_mp_230104040212.R
import id.antasari.uts_mp_230104040212.data.DataStoreManager
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.first

@Composable
fun SplashScreen(
    dataStoreManager: DataStoreManager,
    onNavigateToLogin: () -> Unit,
    onNavigateToDashboard: (String) -> Unit
) {
    LaunchedEffect(Unit) {
        // Tampilkan splash selama 2 detik
        delay(2000)

        // Setelah delay, baru cek username tersimpan
        val saved = dataStoreManager.getUsername().first()
        if (!saved.isNullOrBlank()) {
            onNavigateToDashboard(saved)
        } else {
            onNavigateToLogin()
        }
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            // tampilkan logo jika ada
            val logoRes = try {
                R.drawable.logo
            } catch (e: Exception) {
                0
            }

            if (logoRes != 0) {
                Image(
                    painter = painterResource(id = logoRes),
                    contentDescription = "Logo",
                    modifier = Modifier.size(140.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
            }

            Text(text = "UTSLoginCompose")
            Spacer(modifier = Modifier.height(12.dp))
            CircularProgressIndicator()
        }
    }
}
