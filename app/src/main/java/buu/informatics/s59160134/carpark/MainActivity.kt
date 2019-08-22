package buu.informatics.s59160134.carpark

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import buu.informatics.s59160134.carpark.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val carInfo1: CarInfo = CarInfo("","","","Empty")
    private val carInfo2: CarInfo = CarInfo("","","","Empty")
    private val carInfo3: CarInfo = CarInfo("","","","Empty")
    private var value = 1;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.carInfo1 = carInfo1
        binding.carInfo2 = carInfo2
        binding.carInfo3 = carInfo3
        setListeners()
    }



    private fun setListeners() {
        val boxOneText = binding.boxOneText
        val boxTwoText = binding.boxTwoText
        val boxThreeText = binding.boxThreeText
        val delete = binding.deleteButton
        val update = binding.updateButton
        boxOneText.setOnClickListener {
            value = 1
            showdetail(it)
        }
        boxTwoText.setOnClickListener {
            value = 2
            showdetail(it)
        }
        boxThreeText.setOnClickListener {
            value = 3
            showdetail(it)
        }
        delete.setOnClickListener {
            deletedData(value)
            showdetail(it)

        }
        update.setOnClickListener {
            updateData(value)
            showdetail(it)

        }
    }
    private fun deletedData(valueNow : Int) {
        binding.apply {
            if (valueNow == 1) {
                carInfo1?.no = ""
                carInfo1?.brand = ""
                carInfo1?.name = ""
                carInfo1?.status = "Empty"
                boxOneText.setBackgroundColor(Color.DKGRAY)
            }
            else if (valueNow == 2) {
                carInfo2?.no = ""
                carInfo2?.brand = ""
                carInfo2?.name = ""
                carInfo2?.status = "Empty"
                boxTwoText.setBackgroundColor(Color.DKGRAY)
            } else {
                carInfo3?.no = ""
                carInfo3?.brand = ""
                carInfo3?.name = ""
                carInfo3?.status = "Empty"
                boxThreeText.setBackgroundColor(Color.DKGRAY)
            }
            invalidateAll()
        }
    }


    private fun showdetail(view: View) {
        binding.apply {
            headerText.text = "Slot : " + value
            headerText.visibility = View.VISIBLE
            noEdit.visibility = View.VISIBLE
            brandEdit.visibility = View.VISIBLE
            nameEdit.visibility = View.VISIBLE
            deleteButton.visibility = View.VISIBLE
            updateButton.visibility = View.VISIBLE
            if (value == 1) {
                noEdit.setText(carInfo1?.no)
                brandEdit.setText(carInfo1?.brand)
                nameEdit.setText(carInfo1?.name)
            }
            else if (value == 2) {
                noEdit.setText(carInfo2?.no)
                brandEdit.setText(carInfo2?.brand)
                nameEdit.setText(carInfo2?.name)
            } else {
                noEdit.setText(carInfo3?.no)
                brandEdit.setText(carInfo3?.brand)
                nameEdit.setText(carInfo3?.name)
            }
            invalidateAll()
        }

    }

    private fun updateData(valueNow : Int) {
        binding.apply {
            if (valueNow == 1) {
                carInfo1?.no = noEdit.text.toString()
                carInfo1?.brand = brandEdit.text.toString()
                carInfo1?.name = nameEdit.text.toString()
                carInfo1?.status = "Parking"
                boxOneText.setBackgroundColor(Color.MAGENTA)
            }
            else if (valueNow == 2) {
                carInfo2?.no = noEdit.text.toString()
                carInfo2?.brand = brandEdit.text.toString()
                carInfo2?.name = nameEdit.text.toString()
                carInfo2?.status = "Parking"
                boxTwoText.setBackgroundColor(Color.MAGENTA)
            } else {
                carInfo3?.no = noEdit.text.toString()
                carInfo3?.brand = brandEdit.text.toString()
                carInfo3?.name = nameEdit.text.toString()
                carInfo3?.status = "Parking"
                boxThreeText.setBackgroundColor(Color.MAGENTA)
            }
            invalidateAll()
        }

    }

}
