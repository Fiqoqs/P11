package com.example.p11

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.p11.databinding.KeteranganBinding


class DetailActivity : AppCompatActivity() {

    private lateinit var binding: KeteranganBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = KeteranganBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Ambil data yang dikirim dari MainActivity
        val name = intent.getStringExtra("name")
        val email = intent.getStringExtra("email")
        val profileImage = intent.getStringExtra("profileImage")

        // Set data ke view
        binding.txtName.text = name
        binding.txtEmail.text = email
        Glide.with(this).load(profileImage).into(binding.imgPlaceholder)
    }
}