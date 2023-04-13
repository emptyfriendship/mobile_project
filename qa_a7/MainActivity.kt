package com.example.qa_a7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CompoundButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import com.example.qa_a7.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    class BtnClkListener : View.OnClickListener {
        override fun onClick(p0: View?) {
            Toast.makeText(p0?.context, "사물함 신청 완료", Toast.LENGTH_LONG).show()
        }
    }

    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val strTitle: String = getString(R.string.title)
        binding.textTitle.text = strTitle
        binding.textTitle.visibility = View.GONE
        //val clkListener = BtnClkListener()
        //binding.buttonOK.setonClickListener(clkListener)
        /* val clkListener2 = object : View.OnClickListener {
             override fun onClick(p0: View?) {
                 //val msg: String = getString(R.string.okmsg)
                 //Toast.makeText(applicationContext, msg, Toast.LENGTH_LONG).show()
                 Toast.makeText(applicationContext, R.string.okmsg1, Toast.LENGTH_LONG).show()
             }

         }
         binding.buttonOk.setOnClickListener(clkListener2)*/
        /*binding.buttonOk.setOnClickListener(object :View.OnClickListener{
            override fun onClick(p0: View?) {
                Toast.makeText(applicationContext, R.string.okmsg1, Toast.LENGTH_LONG).show()
            }
        })*/
        binding.buttonOk.setOnClickListener {
            //val msg:String = "${(it as TextView).text} ${getString(R.string.okmsg1)}"
            //Toast.makeText(applicationContext, msg, Toast.LENGTH_LONG).show()
            with(binding) {
                val strName = editTextName.text.toString().trim()
                val strSNo = editTextSNo.text.toString().trim()

                if (strName.isEmpty() || strSNo.isEmpty()) {
                    Toast.makeText(applicationContext, "입력 잘해", Toast.LENGTH_LONG).show()
                    return@setOnClickListener
                }

                if (!checkBoxReq.isChecked) {
                    Toast.makeText(applicationContext, "선택 잘해", Toast.LENGTH_LONG).show()
                    return@setOnClickListener
                }

                var msg:String = "이름 : ${strName}, "
                when (radioGroupM.checkedRadioButtonId) {
                    R.id.radioButtonCS -> msg += "학과 : 컴퓨터 SW"
                    R.id.radioButtonCI -> msg += "학과 : 컴퓨터 정보공학"
                    R.id.radioButtonAI -> msg += "학과 : 인공지능 SW"
                }
                msg += "\n위의 정보로 신청하였습니다."
                Toast.makeText(applicationContext, msg, Toast.LENGTH_LONG).show()
            }
        }

        binding.radioGroupM.setOnCheckedChangeListener { p0, p1 ->
            var msg: String = ""
            when (p1) {
                R.id.radioButtonCS -> msg = "컴퓨터 SW"
                R.id.radioButtonCI -> msg = "컴퓨터 정보공학"
                R.id.radioButtonAI -> msg = "인공지능 SW"
            }
            Toast.makeText(applicationContext, msg, Toast.LENGTH_SHORT).show()
        }

        binding.checkBoxReq.setOnCheckedChangeListener { p0, p1 ->
            if (p1)
                Toast.makeText(applicationContext, "사물함 신청 선택", Toast.LENGTH_LONG).show()
        }
    }//oncreate
}//MainActivity

