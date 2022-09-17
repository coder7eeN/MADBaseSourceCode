package dev.tsnanh.android.core.navigation.contracts

import android.app.Activity
import android.content.Intent
import dev.tsnanh.android.core.navigation.BaseContract
import dev.tsnanh.android.core.navigation.NoArgs
import dev.tsnanh.android.core.navigation.NoResult
import javax.inject.Inject

class NoResultActivityContract @Inject constructor(
    destinationActivityClass: Class<out Activity>
) : BaseContract<NoArgs, NoResult>(destinationActivityClass) {
    override fun parseResult(resultCode: Int, intent: Intent?) = NoResult
}
