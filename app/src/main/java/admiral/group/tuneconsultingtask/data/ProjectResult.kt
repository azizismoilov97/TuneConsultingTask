package admiral.group.tuneconsultingtask.data

sealed class ProjectResult<out DATA> {
    data class Success<DATA>(val data: DATA) : ProjectResult<DATA>()
    data class Failure<DATA>(val error: String = "") : ProjectResult<DATA>()
    object Loading : ProjectResult<Nothing>()
}