package dev.tsnanh.android.core.navigation.contracts

import android.app.Activity
import dev.tsnanh.android.core.navigation.BaseContract
import dev.tsnanh.android.core.navigation.NoArgs
import dev.tsnanh.android.core.navigation.NoResult
import javax.inject.Inject

class SampleActivityContract @Inject constructor(
    activityClass: Class<out Activity>
) : BaseContract<NoArgs, NoResult>(activityClass)
