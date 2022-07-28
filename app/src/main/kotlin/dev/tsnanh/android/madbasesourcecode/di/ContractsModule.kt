package dev.tsnanh.android.madbasesourcecode.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.tsnanh.android.core.navigation.contracts.SampleActivityContract
import dev.tsnanh.android.feature.activity.sample.SampleActivity

@Module
@InstallIn(SingletonComponent::class)
object ContractsModule {
    @Provides
    fun providesSampleActivityContract(): SampleActivityContract =
        SampleActivityContract(SampleActivity::class.java)
}
