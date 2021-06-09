package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todolist.databinding.ActivityMainBinding
import sk.backbone.parent.ui.screens.ParentActivity

class MainActivity : ParentActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    private lateinit var todoAdapter: TodoAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        todoAdapter = TodoAdapter(mutableListOf())

        viewBinding.apply {
            rvTodoItems.adapter = todoAdapter
            rvTodoItems.layoutManager = LinearLayoutManager(this@MainActivity)
        }

        viewBinding.btnAddTodo.setOnClickListener {
            val todoTitle = viewBinding.etTodoTitle.text.toString()
            if(todoTitle.isNotEmpty()) {
                val todo = Todo(todoTitle)
                todoAdapter.addTodo(todo)
                viewBinding.etTodoTitle.text.clear()
            }
        }
        viewBinding.btnDeleteDoneTodos.setOnClickListener {
            todoAdapter.deleteDoneTodos()
        }
    }
}