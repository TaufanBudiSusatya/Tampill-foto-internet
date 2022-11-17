package com.example.tv_film_taufan.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.tv_film_taufan.databinding.TvShowLayoutAdapterBinding
import com.example.tv_film_taufan.models.TvShowItem

class TvShowAdapter : RecyclerView.Adapter<TvShowAdapter.MyViewHolder>() {

    inner class MyViewHolder(val binding: TvShowLayoutAdapterBinding) :
        RecyclerView.ViewHolder(binding.root)

    //memanggil kembali  objek dengan menggunakan id pada data
    private val diffCallback = object : DiffUtil.ItemCallback<TvShowItem>() {
        override fun areItemsTheSame(oldItem: TvShowItem, newItem: TvShowItem): Boolean {
            return oldItem.id == newItem.id
        }
    // membuat agar id tidak sama atau ber tabrakan
        override fun areContentsTheSame(oldItem: TvShowItem, newItem: TvShowItem): Boolean {
            return newItem == oldItem
        }
    }
    //list show agar tampilan menjadi banyak
    private val differ = AsyncListDiffer(this, diffCallback)
    var tvShows: List<TvShowItem>
        get() = differ.currentList
        set(value) {
            differ.submitList(value)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            TvShowLayoutAdapterBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentTvShow = tvShows[position]
    //text untuk menampilkan foto dari json
        holder.binding.apply {
            textView.text = currentTvShow.name
            // image untuk menampilkan foto dari json
            imageView.load(currentTvShow.image.original) {
                crossfade(true)
                crossfade(1000)
            }
        }
    }

    override fun getItemCount() = tvShows.size

}