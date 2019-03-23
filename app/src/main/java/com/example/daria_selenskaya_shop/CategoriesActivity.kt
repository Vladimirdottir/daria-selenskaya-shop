package com.example.daria_selenskaya_shop

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_category.*
import kotlinx.serialization.json.Json
import kotlinx.serialization.list
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class CategoriesActivity : CategoriesView, AppCompatActivity() {
    val categoriesListUrl =
        "https://gist.githubusercontent.com/Vladimirdottir/b0ebbf26f760b1eb8479bfd9237e144b/raw/d34eae857cc781fdc07209cd1fc4408303adec67/categories.json"

    val presenter = CategoriesPresenter(categoriesListUrl, this, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)

        refreshButton.onClick() {
            presenter.onRefresh()

        }

    }

    override fun onResume() {
        super.onResume()
        presenter.onAppear()
    }


    override fun displayCategories(categories: List<Category>) {
        categoriesListView.adapter = CategoriesAdapter(categories, this)

        loadingView.visibility = View.INVISIBLE
    }

    override fun displayError() {
        longToast("Произошла ошибка")


    }

    override fun showRefresh(){refreshButton.visibility = View.VISIBLE}

    override fun hideRefresh(){refreshButton.visibility = View.GONE}

}




