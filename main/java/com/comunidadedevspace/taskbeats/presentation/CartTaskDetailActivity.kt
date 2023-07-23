package com.comunidadedevspace.taskbeats.presentation

import Product
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.comunidadedevspace.taskbeats.data.ProductToSave
import com.comunidadedevspace.taskbeats.databinding.CartTaskDetailBinding

class CartTaskDetailActivity : AppCompatActivity() {

    private val binding by lazy {
        CartTaskDetailBinding.inflate(layoutInflater)
    }

    private val viewModel = CartTaskDetailViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val product = intent.extras?.getParcelable<Product>("customer")
        if (product != null) {
            Log.d("customer", "${product.id} ${product.produto}")
            binding.cartProduct.text = product.produto
        }
        binding.buttonDone.setOnClickListener {
            if (binding.edtTaskAmount.text.isEmpty()) {
                binding.edtTaskAmount.error = "Preenchimento obrigatório"
            } else {
                product?.let {
                    val productToSave = ProductToSave(
                        productName = product.produto,
                        productId = product.id.toLong(),
                        quantity = binding.edtTaskAmount.text.toString().toLong()
                    )
                    viewModel.insert(productToSave)
                    val intent = Intent(this, CartActivity::class.java)
                    finish()
                    startActivity(intent)
                }
            }


        }
    }

}