package app.soulcramer.machineacompose.ui

import android.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import app.soulcramer.machineacompose.symbols.BleachingIcon
import app.soulcramer.machineacompose.symbols.DryingIcon
import app.soulcramer.machineacompose.symbols.IroningIcon
import app.soulcramer.machineacompose.symbols.WashingIcon
import app.soulcramer.machineacompose.util.ReduxViewModel

class AddClotheViewModel() : ReduxViewModel<AddClotheState>(AddClotheState()) {

//    private val _uiState = MutableLiveData<SurveyState>()
//    val uiState: LiveData<SurveyState>
//        get() = _uiState
//
//    private lateinit var addClotheInitialState: SurveyState
//
//    init {
//        viewModelScope.launch {
//            val survey = clotheRepository.clotheStore().stream(StoreRequest.cached(0, true))
//
//            // Create the default questions state based on the survey questions
//            val questions: List<QuestionState> = survey.questions.mapIndexed { index, question ->
//                val enablePrevious = index > 0
//                val showDone = index == survey.questions.size - 1
//                QuestionState(question, index, survey.questions.size, enablePrevious, showDone)
//            }
//            surveyInitialState = SurveyState.Questions(survey.title, questions)
//            _uiState.value = surveyInitialState
//        }
//    }
//
//    fun computeResult(surveyQuestions: SurveyState.Questions) {
//        val answers = surveyQuestions.questionsState.mapNotNull { it.answer }
//        val result = surveyRepository.getSurveyResult(answers)
//        _uiState.value = SurveyState.Result(surveyQuestions.surveyTitle, result)
//    }
//
//    fun onSymbolPicked(questionId: Int, date: String) {
//        updateStateWithActionResult(questionId, SurveyActionResult.Date(date))
//    }
//
//    private fun updateStateWithActionResult(questionId: Int, result: SurveyActionResult) {
//        val latestState = _uiState.value
//        if (latestState != null && latestState is SurveyState.Questions) {
//            val question =
//                latestState.questionsState.first { questionState ->
//                    questionState.question.id == questionId
//                }
//            question.answer = Answer.Action(result)
//        }
//    }
}

class AddClotheViewModelFactory() : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AddClotheViewModel::class.java)) {
            return AddClotheViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

data class AddClotheState(
    val washSymbols: List<WashingIcon> = WashingIcon.getIcons(),
    val bleachSymbols: List<BleachingIcon> = BleachingIcon.getIcons(),
    val ironSymbols: List<IroningIcon> = IroningIcon.getIcons(),
    val drySymbols: List<DryingIcon> = DryingIcon.getIcons(),
    val sizes: List<String> = listOf("XS", "S", "M", "L", "XL"),
    val types: List<String> = emptyList(),
    val color: Int = Color.WHITE,
    val materials: List<String> = emptyList(),
    val brand: String = "",
    val description: String = ""
)
