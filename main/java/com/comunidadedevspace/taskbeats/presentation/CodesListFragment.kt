package com.comunidadedevspace.taskbeats.presentation

import Product
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.comunidadedevspace.taskbeats.R
import com.comunidadedevspace.taskbeats.adapter.CustomerAdapter


/**
 * A simple [Fragment] subclass.
 * Use the [CodesListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

class CodesListFragment : Fragment() {

    var data: List<Product> = emptyList() // variável de instância para armazenar os dados
    lateinit var customerAdapter: CustomerAdapter

    companion object {
        fun newInstance(data: List<Product>): CodesListFragment {
            val fragment = CodesListFragment()
            fragment.data = data
            return fragment
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =
            inflater.inflate(R.layout.fragment_codes_list, container, false) // infla o layout XML


        val cartButton: ImageButton = view.findViewById(R.id.cartButton)
        val recyclerView = view.findViewById<RecyclerView>(R.id.rv_codes_list)
        val SearchView = view.findViewById<SearchView>(R.id.searchView)


        cartButton.setOnClickListener {

            val intent = Intent(context, CartActivity::class.java)
            startActivity(intent)

        }
        SearchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                customerAdapter.filter.filter(p0)
                return true
            }


            override fun onQueryTextChange(p0: String?): Boolean {
                customerAdapter.filter.filter(p0)
                return false
            }


        })

        customerAdapter = CustomerAdapter(data) {
            val intent = Intent(context, CartTaskDetailActivity::class.java)
            intent.putExtra("customer", it)
            startActivity(intent)
        }
        val adapter = customerAdapter // cria uma nova instância do Adapter
        recyclerView.layoutManager = LinearLayoutManager(activity) // define o LayoutManager
        recyclerView.adapter = adapter // define o Adapter

        return view


    }


}
