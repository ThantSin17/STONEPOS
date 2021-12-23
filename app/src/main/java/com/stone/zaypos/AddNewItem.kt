package com.stone.zaypos

import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import androidx.core.view.get
import androidx.databinding.DataBindingUtil
import com.stone.zaypos.databinding.ActivityAddNewItemBinding
import java.io.File
import java.text.SimpleDateFormat
import java.util.*


class AddNewItem : AppCompatActivity() {
    private lateinit var binding: ActivityAddNewItemBinding
    private var soldBy: String = "Each"
    private var representativeColor = "#AFB1B3"
    private lateinit var filePhoto: File
    private var fileName="foto"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_new_item)

        val takePhotoResult =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == RESULT_OK) {
                    val takePhoto = BitmapFactory.decodeFile(filePhoto.absolutePath)
                    binding.image.setImageBitmap(takePhoto)
                    //binding.image.setImageURI
                }
            }
        val choosePhotoResult=
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()){result->
                if (result.resultCode== RESULT_OK){
                    binding.image.setImageURI(result.data?.data)
                }
            }

        val list = listOf("No Category", "Vegetable", "Drik", "Fast Food")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, list)
        (binding.spinner.editText as AutoCompleteTextView).setAdapter(adapter)
        (binding.spinner.editText as AutoCompleteTextView).setSelection(0)

        (binding.spinner.editText as AutoCompleteTextView).setOnItemClickListener { adapterView, view, i, l ->
            Toast.makeText(view.context, adapterView.get(i).toString(), Toast.LENGTH_LONG).show()
        }

        setSupportActionBar(binding.actionBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)


        binding.layoutSoldBy.setOnCheckedChangeListener { _, checkId ->
            val radio: RadioButton = findViewById(checkId)
            soldBy = radio.text.toString()

        }





        binding.rbtnColor.setOnCheckedChangeListener { _, isCheck ->
            if (isCheck) {
                binding.layoutImage.visibility = View.GONE
                binding.layoutColor.visibility = View.VISIBLE
                Toast.makeText(this, "choose color", Toast.LENGTH_LONG).show()
            }

        }
        binding.rbtnImage.setOnCheckedChangeListener { _, isCheck ->
            if (isCheck) {
                binding.layoutColor.visibility = View.GONE
                binding.layoutImage.visibility = View.VISIBLE
                Toast.makeText(this, "choose image", Toast.LENGTH_LONG).show()
            }

        }
        binding.takePhoto.setOnClickListener {
            //camera intent
            val takePhotoIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

            //setFileName
            val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
            fileName="foto_"+timeStamp+".jpg"

            //set directory folder
            val file=File(Environment.getExternalStorageDirectory().getPath(),fileName)
            filePhoto = getPhotoFile(FILE_NAME)


            val providerFile = FileProvider.getUriForFile(this, "com.stone.zaypos", filePhoto)
            takePhotoIntent.putExtra(MediaStore.EXTRA_OUTPUT, providerFile)
            Log.i("log.activityResult", "finish click")
            takePhotoResult.launch(takePhotoIntent)

        }
        binding.choosePhoto.setOnClickListener{
            val intent=Intent(Intent.ACTION_PICK)
            intent.type="image/*"
            choosePhotoResult.launch(intent)
        }


        chooseColor()
    }

    private fun getPhotoFile(fileName: String): File {

        val directoryStorage = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        Log.i("log.activityResult", "getPhotoFile")
        return File.createTempFile(fileName, ".jpg", directoryStorage)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.add_new_item_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.save_item) {
            saveItem()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun saveItem() {
        var name = binding.layoutName.editText?.text.toString()
        var price = binding.layoutPrice.editText?.text.toString()
        var stock = binding.layoutTrack.editText?.text.toString()


    }

    private fun chooseColor() {

        binding.color1.setOnClickListener {
            selectColor(1)
        }
        binding.color2.setOnClickListener {
            selectColor(2)
        }
        binding.color3.setOnClickListener {
            selectColor(3)
        }
        binding.color4.setOnClickListener {
            selectColor(4)
        }
        binding.color5.setOnClickListener {
            selectColor(5)
        }
        binding.color6.setOnClickListener {
            selectColor(6)
        }
        binding.color7.setOnClickListener {
            selectColor(7)
        }
        binding.color8.setOnClickListener {
            selectColor(8)
        }
    }

    private fun selectColor(index: Int) {
        var id = arrayOf(
            binding.color1, binding.color2, binding.color3, binding.color4,
            binding.color5, binding.color6, binding.color7, binding.color8
        )
        for (item in id.indices) {
            id[item].setImageResource(0)

            if (index == item + 1) {
                id[item].setImageResource(R.drawable.ic_check_24)
                representativeColor = id[item].contentDescription.toString()

            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            Log.i("log.activityResult", "Request")

        } else {
            Log.i("log.activityResult", "Fail")
            super.onActivityResult(requestCode, resultCode, data)
        }
    }

    companion object {
        private const val FILE_NAME = "photo.jpg"
        private const val REQUEST_CODE = 13
    }


}


