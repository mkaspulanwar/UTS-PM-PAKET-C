package id.antasari.uts_mp_230104040212.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import id.antasari.uts_mp_230104040212.data.DataStoreManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun DashboardScreen(
    username: String,
    dataStoreManager: DataStoreManager,
    onLogout: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Selamat datang, $username", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            // hapus username dari DataStore dan panggil onLogout
            CoroutineScope(Dispatchers.IO).launch {
                dataStoreManager.clearUsername()
                // pindah ke UI thread
                CoroutineScope(Dispatchers.Main).launch {
                    onLogout()
                }
            }
        }, modifier = Modifier.fillMaxWidth()) {
            Text("Hapus Data Login / Keluar")
        }
    }
}
