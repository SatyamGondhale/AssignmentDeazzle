package com.deazzle.assignmentdeazzle

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.deazzle.assignmentdeazzle.Adapter.RandomUserListAdapter
import com.deazzle.assignmentdeazzle.model.Example
import com.deazzle.assignmentdeazzle.model.Result
import com.deazzle.assignmentdeazzle.viewmodel.MainActivityViewModel
import com.yuyakaido.android.cardstackview.*
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    var mainActivityVm: MainActivityViewModel?=null
    var cardstack: CardStackView?=null
    var adapter: RandomUserListAdapter?=null
    var manager: CardStackLayoutManager?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        manager=CardStackLayoutManager(applicationContext)
        mainActivityVm=
            ViewModelProvider.AndroidViewModelFactory(applicationContext as Application).create(MainActivityViewModel::class.java)
        mainActivityVm?.getDataFromVm()?.observe(this, Observer<List<Result>>(
        ){
            val finalList:List<Result> = it
            //   Log.i("DATA",finalList.get(0).name.first);
            adapter= RandomUserListAdapter(finalList,applicationContext as Application)
            usersList.layoutManager=manager
            manager?.setStackFrom(StackFrom.None)
            manager?.setVisibleCount(1)
            manager?.setTranslationInterval(8.0f)
            manager?.setScaleInterval(0.95f)
            manager?.setSwipeThreshold(0.3f)
            manager?.setMaxDegree(20.0f)
            manager?.setDirections(Direction.HORIZONTAL)
            manager?.setCanScrollHorizontal(true)
            manager?.setCanScrollVertical(true)
            manager?.setSwipeableMethod(SwipeableMethod.Manual)
            usersList.adapter=adapter
        });


    }
}