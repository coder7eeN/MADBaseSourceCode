package dev.tsnanh.android.madbasesourcecode.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.tsnanh.android.core.navigation.contracts.NoArgsAndNoResultActivityContract
import dev.tsnanh.android.feature.activity.sample.SampleActivity

@Module
@InstallIn(SingletonComponent::class)
object ContractsModule {
    @Provides
    fun providesNoArgsAndNoResultActivityContract(): NoArgsAndNoResultActivityContract =
        NoArgsAndNoResultActivityContract(SampleActivity::class.java)
}
