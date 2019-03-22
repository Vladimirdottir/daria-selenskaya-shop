package com.example.daria_selenskaya_shop

import android.content.Context
import kotlinx.serialization.json.Json
import kotlinx.serialization.list

class CategoriesPresenter(
    val categoriesListUrl: String,
    val view: CategoriesView,
    context: Context
){

    val requestMaker = getRequestMaker(context)

    fun updateCategories(){
        requestMaker.make(categoriesListUrl,
            onResult = { categoriesJson ->
                val categories = getCategories(categoriesJson)
                view.displayCategories(categories)
                view.hideRefresh()
            },
            onError = {
                view.displayError()
                view.showRefresh()
            }
        )
    }

    fun onAppear(){
        updateCategories()
    }

    fun onRefresh(){
        updateCategories()
    }

    fun getCategories(json: String) = Json.parse(Category.serializer().list, json)

}

interface CategoriesView{
    fun displayCategories(categories: List<Category>)
    fun displayError()
    fun showRefresh()
    fun hideRefresh()
}
