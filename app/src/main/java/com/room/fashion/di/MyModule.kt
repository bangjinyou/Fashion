package com.room.fashion.di

import com.room.fashion.FashionListViewAdapter
import com.room.fashion.model.DataModel
import com.room.fashion.model.DataModelImpl
import com.room.fashion.model.service.FashionService
import com.room.fashion.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

var retrofitPart = module {
    single<FashionService> {
        Retrofit.Builder()
            .baseUrl("http://d2bab9i9pr8lds.cloudfront.net/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(FashionService::class.java)
    }
}

var adapterPart = module {
    factory {
        FashionListViewAdapter()
    }
}

var modelPart = module {
    factory<DataModel> {
        DataModelImpl(get())
    }
}

var viewModelPart = module {
    viewModel {
        MainViewModel(get())
    }
}

var myDiModule = listOf(retrofitPart, adapterPart, modelPart, viewModelPart)