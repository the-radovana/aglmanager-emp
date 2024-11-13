import androidx.lifecycle.ViewModel
//import com.example.stepcounter.data.stepHistory
import com.example.aglmanager.ui.AGLManagerUIState
//import com.example.stepcounter.ui.StepHistory
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.text.SimpleDateFormat
import java.util.*

class AGLManagerViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(AGLManagerUIState())
    val uiState: StateFlow<AGLManagerUIState> = _uiState.asStateFlow()

    init {
        updateMessage("Welcome to AGL Manager")
    }


    fun updateMessage(newMessage: String) {
        _uiState.update { currentState ->
            currentState.copy(message = newMessage)
        }
    }

    // Function to update the step count (e.g., called when steps are detected)
    /*fun updateStepCount(newSteps: Int) {
        _uiState.update {
                currentState -> currentState.copy(stepCount = newSteps)
        }
    }*/

    // Function to set a new daily goal
    /*fun setStepGoal(goal: Int) {
        _uiState.update {
                currentState -> currentState.copy(stepGoal = goal)
        }
    }*/

    // Function to add a new history entry (e.g., at the end of the day)
    /*fun addStepHistoryEntry() {
        val today = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())
        val newHistory = stepHistory + StepHistory(date = today, steps = _uiState.value.stepCount)

        //update the history

        // Reset the step count at the end of the day and update history
        resetStepCounter()
    }*/


}