package com.comunidadedevspace.taskbeats.presentation

import CartListAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.comunidadedevspace.taskbeats.R
import com.comunidadedevspace.taskbeats.startWhatsAppIntent

class CartActivity : AppCompatActivity() {

    private lateinit var cartListAdapter: CartListAdapter
    private lateinit var rvCodesList: RecyclerView


    private lateinit var viewModel: CartViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cart_end)
        viewModel = ViewModelProvider(this).get(CartViewModel::class.java)
        viewModel.getAll()
        rvCodesList = findViewById(R.id.rv_codeslist)
        viewModel.listLiveData.observe(this){
            cartListAdapter = CartListAdapter(it){
             viewModel.delete(it)
            }
            rvCodesList.adapter = cartListAdapter
        }


        val codesList = listOf("Code 1", "Code 2", "Code 3")


        val sendButton = findViewById<Button>(R.id.env_button)

        sendButton.setOnClickListener {
            val list = cartListAdapter.codes.map {
                "${it.productId} - ${it.quantity}"
            }
            var message = ""
            list.forEach {
                message += "$it\n"
            }
            finish()
            startWhatsAppIntent(TextToSend = "Por favor, crie uma reserva:\n$message")
        }



    }

}