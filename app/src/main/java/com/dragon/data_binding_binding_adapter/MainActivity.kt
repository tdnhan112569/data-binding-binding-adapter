package com.dragon.data_binding_binding_adapter

import android.app.DatePickerDialog
import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.dragon.data_binding_binding_adapter.databinding.ActivityMainBinding
import com.squareup.picasso.Picasso
import androidx.databinding.adapters.TextViewBindingAdapter.setText
import android.widget.DatePicker
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.view.View
import android.widget.EditText
import java.util.*
import java.util.Calendar.*


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setContentView(binding.root)
        initView()
    }

    private fun initView() {
        binding.viewModel = viewModel
        binding.handler = MyHandle(context = this)
        binding.name2 = ""
        Picasso.get().load("http://cdn.journaldev.com/wp-content/uploads/2016/11/android-image-picker-project-structure.png").into(binding.image1)
        binding.editText1.clearFocus()
    }

    inner class MyHandle (context: Context) {
      fun onOpenDatePickerDialog(_view : View) {
          val cldr : Calendar  = getInstance();
          val day = cldr.get(DAY_OF_MONTH)
          val month = cldr.get(MONTH)
          val year = cldr.get(YEAR)
          val picker = DatePickerDialog(this@MainActivity,
              DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                  (_view as EditText).setText( "Selected Date: "+ dayOfMonth+"/" + (monthOfYear + 1)+"/"+ year)
              }, year, month, day
          )
          picker.datePicker.apply {
              layoutMode = 1
          }
          picker.show()
      }
    }
}
