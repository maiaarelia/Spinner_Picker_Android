package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val kelas = arrayOf(
            "Pilih Kelas",
            "Ekonomi",
            "First Class",
            "Premium",
            "Khusus",
            "Sosial",
            "Bisnis"
        )

        val penumpang = arrayOf(
            "Pilih Kategori Peumpang",
            "Dewasa",
            "Anak-anak",
            "Lansia",
            "Penumpang kebutuhan khusus",
            "Militer",
            "Penumpang Bisnis"
        )


        val keretaPergi = arrayOf(
            "Berangkat",
            "Yogyakarta",
            "Surabaya",
            "Kebumen",
            "Bandung",
            "Semarang",
            "Surakarta"
        )

        val keretaPulang = arrayOf(
            "Pulang",
            "Yogyakarta",
            "Surabaya",
            "Kebumen",
            "Bandung",
            "Semarang",
            "Surakarta"
        )



        with(binding) {

//            kelas layanan
            val kelasAdapter = ArrayAdapter(
                this@MainActivity,  androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, kelas
            )

            kelasAdapter.setDropDownViewResource(
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item
            )

            spinLayanan.adapter= kelasAdapter

//            Kategori Penumpang

            val penumpangAdapter = ArrayAdapter(
                this@MainActivity,  androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, penumpang
            )

            penumpangAdapter.setDropDownViewResource(
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item
            )

            spinPenumpang.adapter= penumpangAdapter


            //            Kereta Perggi
            val pergiAdapter = ArrayAdapter(
                this@MainActivity,  androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, keretaPergi
            )

            pergiAdapter.setDropDownViewResource(
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item
            )

            spinnerAsal.adapter= pergiAdapter

            //            Kereta Pulang
            val pulangAdapter = ArrayAdapter(
                this@MainActivity,  androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, keretaPulang
            )

            pulangAdapter.setDropDownViewResource(
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item
            )

            spinnerTujuan.adapter= pulangAdapter



            datePicker.init(datePicker.year, datePicker.month, datePicker.dayOfMonth) { _, year, month, day ->
                val selectedDate = "$day/${month + 1}/$year"
                Toast.makeText(this@MainActivity, selectedDate, Toast.LENGTH_SHORT).show()
            }


            timePicker.setOnTimeChangedListener { _, hourOfDay, minutes ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minutes)
                Toast.makeText(this@MainActivity, selectedTime, Toast.LENGTH_SHORT).show()
            }



            PESAN.setOnClickListener {
                val day = datePicker.dayOfMonth
                val month = datePicker.month + 1
                val year = datePicker.year

                val hourOfDay = timePicker.hour
                val minutes = timePicker.minute
                val toastMessage = "Tiket Kereta untuk tanggal ${day}/${month}/${year}, Waktu ${String.format("%02d:%02d", hourOfDay, minutes)} Berhasil Dipesan"

                Toast.makeText(this@MainActivity, toastMessage, Toast.LENGTH_SHORT).show()




        }

    }
}

}