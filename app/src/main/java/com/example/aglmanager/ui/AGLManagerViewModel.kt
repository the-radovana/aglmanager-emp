import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.aglmanager.AGLManagerScreen
import com.example.aglmanager.UserStore
import com.example.aglmanager.data.LoginRequest
import com.example.aglmanager.network.Api
import com.example.aglmanager.ui.AGLManagerUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class AGLManagerViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(AGLManagerUIState())
    val uiState: StateFlow<AGLManagerUIState> = _uiState.asStateFlow()

    fun updateMessage(newMessage: String) {
        _uiState.update { currentState ->
            currentState.copy(message = newMessage)
        }
    }

    fun login(email: String, password: String, navController: NavController) {
        viewModelScope.launch {
            try {
                val login = Api.retrofitService.login(LoginRequest(email, password))

                _uiState.update { currentState ->_uiState.update { currentState ->
                    currentState.copy(message = login.message)
                }
                    currentState.copy(message = login.message)
                }
                UserStore.user = login.data.user
                UserStore.accessToken = login.data.accessToken
                UserStore.refreshToken = login.data.refreshToken
                UserStore.accessTokenExp = login.data.accessTokenExp
                UserStore.refreshTokenExp = login.data.refreshTokenExp
                UserStore.isLoggedIn = true

                navController.navigate(AGLManagerScreen.Events.name);
                
            } catch (e: Exception) {
                Log.e("AGLManagerViewModel", "Login failed: ${e.message}", e)
                if (e is retrofit2.HttpException) {
                    val errorBody = e.response()?.errorBody()?.string()
                    Log.e("AGLManagerViewModel", "Error body: $errorBody")
                }
            }
        }
    }
}