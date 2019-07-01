package com.example.retrofit

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

//https://codelabs.developers.google.com/codelabs/kotlin-coroutines/#3

//FIRST GIVE INTERNET PERMISSION TO APP IN MANIFEST

/*ADD THESE DEPENDENCIES IN THE build.gradle(Module:app)
implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.0-M1'
implementation 'com.squareup.retrofit2:retrofit:2.6.0'
implementation 'com.squareup.retrofit2:converter-gson:2.6.0'*/
/* compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8
        targetCompatibility JavaVersion.VERSION_1_8
        also add androidx dependencies
        foe help notepad retrofit dependencies
    }*/
class MainActivity : AppCompatActivity(),CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main // Dispatcher.main "means that do this on main thread"// Dispatcher(okhttp);Dispather(s)retrofit


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener { // launch is a coroutine builder , opertes synchronously , we are still on the same thread but we are not blocking the whole thread
            launch {
                val users = getUserRetrofit()//UI is stopped and network starts
                rvUsers.layoutManager = LinearLayoutManager(
                    this@MainActivity,
                    RecyclerView.VERTICAL,
                    false
                )
                rvUsers.adapter = UserAdapter(users)

            }
        }


    }

    suspend fun getUserRetrofit(): List<User> {
        val userApi = RetrofitClient.userApi  // RetfrofitCliet has API stored in object userApi
        val response = userApi.getUser()
        return if (response.isSuccessful) {
            response.body()!!
        } else {
            emptyList()
        }
    }
}

