@file:Suppress("UNCHECKED_CAST")

package dev.tsnanh.android.core.navigation

import android.app.Activity
import android.os.Parcelable
import androidx.fragment.app.Fragment

fun <Args : Parcelable> Activity.launch(
    contract: BaseContract<Args, NoResult>?,
    args: Args? = null,
) {
    startActivity(contract!!.createIntent(this, (args ?: NoArgs) as Args))
}

fun <Args : Parcelable> Fragment.launch(
    contract: BaseContract<Args, NoResult>?,
    args: Args? = null,
) {
    startActivity(contract!!.createIntent(requireContext(), (args ?: NoArgs) as Args))
}

fun <Result : Parcelable> Activity.setContractResult(
    contract: BaseContract<*, Result>,
    result: Result,
) {
    setResult(Activity.RESULT_OK, contract.createResultIntent(result))
}
