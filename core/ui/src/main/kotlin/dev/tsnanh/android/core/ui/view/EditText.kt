package dev.tsnanh.android.core.ui.view

import android.widget.EditText
import androidx.core.widget.addTextChangedListener
import com.google.android.material.textfield.TextInputLayout
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flowOn

val EditText.textChange: Flow<String>
    get() = callbackFlow {
        val textWatcher = addTextChangedListener { text ->
            trySend((text ?: "").toString())
        }

        awaitClose {
            removeTextChangedListener(textWatcher)
        }
    }.flowOn(Dispatchers.Main)

val TextInputLayout.textChange: Flow<String>
    get() = callbackFlow {
        val textWatcher = editText?.addTextChangedListener { text ->
            trySend((text ?: "").toString())
        }

        awaitClose {
            editText?.removeTextChangedListener(textWatcher)
        }
    }.flowOn(Dispatchers.Main)
