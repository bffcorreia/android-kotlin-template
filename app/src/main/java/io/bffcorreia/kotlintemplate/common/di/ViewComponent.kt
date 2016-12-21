package io.bffcorreia.kotlintemplate.common.di

import dagger.Subcomponent

@PerView @Subcomponent(modules = arrayOf(ViewModule::class)) interface ViewComponent