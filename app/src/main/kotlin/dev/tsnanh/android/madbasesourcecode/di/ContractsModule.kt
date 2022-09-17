package dev.tsnanh.android.madbasesourcecode.di

import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey
import dev.tsnanh.android.core.navigation.contracts.NavigationRoute
import dev.tsnanh.android.core.navigation.contracts.NoResultActivityContract
import dev.tsnanh.android.feature.activity.sample.SampleActivity

@Component(modules = [ContractsModule::class])
interface ContractComponent {
    fun contracts(): Map<String, NoResultActivityContract>
}

@Module
@InstallIn(SingletonComponent::class)
object ContractsModule {
    @Provides
    @IntoMap
    @StringKey(NavigationRoute.USER)
    fun providesSampleActivityContract(): NoResultActivityContract =
        NoResultActivityContract(SampleActivity::class.java)
}
