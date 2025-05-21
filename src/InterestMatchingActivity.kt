package com.example.skkumate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class InterestMatchingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_interest_matching)

        val tabCreate = findViewById<TextView>(R.id.tabCreateRoom)
        val tabJoin   = findViewById<TextView>(R.id.tabJoinRoom)
        val createLayout = findViewById<View>(R.id.createRoomLayout)
        val joinLayout   = findViewById<View>(R.id.joinRoomLayout)
        val actionBtn    = findViewById<Button>(R.id.actionButton)

        fun selectCreate() {
            tabCreate.setBackgroundResource(R.drawable.bg_tab_active)
            tabJoin.setBackgroundResource(R.drawable.bg_tab_inactive)
            createLayout.visibility = View.VISIBLE
            joinLayout.visibility   = View.GONE
            actionBtn.text          = "CREATE ROOM"
            actionBtn.visibility    = View.VISIBLE
        }

        fun selectJoin() {
            tabCreate.setBackgroundResource(R.drawable.bg_tab_inactive)
            tabJoin.setBackgroundResource(R.drawable.bg_tab_active)
            createLayout.visibility = View.GONE
            joinLayout.visibility   = View.VISIBLE
            actionBtn.visibility    = View.GONE
        }

        tabCreate.setOnClickListener { selectCreate() }
        tabJoin.setOnClickListener   { selectJoin() }

        // 초기 상태
        selectCreate()
    }
}