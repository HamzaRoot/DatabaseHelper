package com.rootcoder.mvvmdemo.activites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.rootcoder.mvvmdemo.R
import com.rootcoder.mvvmdemo.adapters.RoomRecyclerAdapter
import com.rootcoder.mvvmdemo.database.RoomdbDatabase
import com.rootcoder.mvvmdemo.databinding.ActivityRoomDatabaseBinding
import com.rootcoder.mvvmdemo.datamodels.RoomdbDM
import com.rootcoder.mvvmdemo.interfaces.AdapterClickListener
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*

class RoomDatabaseA : AppCompatActivity() {

    lateinit var binding:ActivityRoomDatabaseBinding
    lateinit var database: RoomdbDatabase
    lateinit var adapter:RoomRecyclerAdapter
    lateinit var itemSelect:RoomdbDM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_room_database)


        database= RoomdbDatabase.getDatabase(this)



        database.getDAO().getData().observe(this, Observer {
            setupRecyclerAdapter(it)
        })


        binding.btnInsert.setOnClickListener {
            if (!(TextUtils.isEmpty(binding.etName.text.toString())) && !(TextUtils.isEmpty(binding.etAge.text.toString())))
            {
                GlobalScope.launch {
                    database.getDAO().insertData(RoomdbDM(0,binding.etName.text.toString()
                        ,binding.etAge.text.toString().toInt(),true, Date(),1))

                    binding.etName.setText("")
                    binding.etAge.setText("")
                }
            }
        }

        binding.btnUpdate.setOnClickListener {
            if ((::itemSelect.isInitialized && itemSelect!=null) && (!(TextUtils.isEmpty(binding.etName.text.toString())) && !(TextUtils.isEmpty(binding.etAge.text.toString()))))
            {
                GlobalScope.launch {
                    database.getDAO().updateData(RoomdbDM(itemSelect.id,binding.etName.text.toString()
                        ,binding.etAge.text.toString().toInt(),itemSelect.gender,Date(),1))
                }

            }

        }

        binding.btnDelete.setOnClickListener {
            if (::itemSelect.isInitialized && itemSelect!=null)
            {
                GlobalScope.launch {
                    database.getDAO().deleteData(itemSelect)

                    binding.etName.setText("")
                    binding.etAge.setText("")
                }
            }
        }
    }

    private fun setupRecyclerAdapter(list: List<RoomdbDM>) {
        val layoutManager=LinearLayoutManager(this)
        layoutManager.orientation= RecyclerView.VERTICAL
        binding.rvRoomData.layoutManager = layoutManager
        adapter = RoomRecyclerAdapter(list, object : AdapterClickListener {
            override fun onClick(posiotn: Int, view: View) {
                itemSelect= list.get(posiotn)

                binding.etName.setText(itemSelect.name.toString())
                binding.etAge.setText(itemSelect.age.toString())
            }
        })
        binding.rvRoomData.adapter = adapter

    }



}