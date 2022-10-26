package com.example.di

import com.example.feature.nomedatela.ExampleViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {

    viewModel { ExampleViewModel() }

}