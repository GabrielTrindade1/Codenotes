package com.comunidadedevspace.taskbeats.presentation

import CodigosCSV
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.comunidadedevspace.taskbeats.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {


    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavView = findViewById<BottomNavigationView>(R.id.bottom_nav_view)
        val floatActionButton = findViewById<FloatingActionButton>(R.id.floatingActionButton)

        floatActionButton.setOnClickListener {
            openTaskListDetail()
        }

        val taskListFragment = TaskListFragment.newInstance()
        val newsListFragment = CodesListFragment.newInstance(CodigosCSV.main(this))

        supportFragmentManager.commit {
            replace(R.id.fragment_container_view, taskListFragment)
            setReorderingAllowed(true)
        }

        bottomNavView.setOnItemSelectedListener { menuItem ->
            val fragment = when (menuItem.itemId) {
                R.id.task_list -> taskListFragment
                R.id.codes_list -> newsListFragment
                else -> taskListFragment
            }

            supportFragmentManager.commit {
                replace(R.id.fragment_container_view, fragment as Fragment)
                setReorderingAllowed(true)
            }
            true
        }
    }

    private fun openTaskListDetail() {
        val intent = TaskDetailActivity.start(this, null)
        startActivity(intent)
    }
}