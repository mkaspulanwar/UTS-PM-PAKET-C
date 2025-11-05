package id.antasari.uts_mp_230104040212

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import id.antasari.uts_mp_230104040212.data.DataStoreManager
import id.antasari.uts_mp_230104040212.navigation.AppNavHost
import id.antasari.uts_mp_230104040212.ui.theme.UTS_MP_230104040212Theme

class MainActivity : ComponentActivity() {

    private lateinit var dataStoreManager: DataStoreManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataStoreManager = DataStoreManager(applicationContext)

        setContent {
            UTS_MP_230104040212Theme {
                Surface {
                    AppNavHost(dataStoreManager = dataStoreManager)
                }
            }
        }
    }
}
