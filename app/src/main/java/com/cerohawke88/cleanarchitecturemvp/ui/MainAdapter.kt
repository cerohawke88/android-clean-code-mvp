package com.cerohawke88.cleanarchitecturemvp.ui

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions
import com.cerohawke88.cleanarchitecturemvp.R
import com.cerohawke88.cleanarchitecturemvp.data.Repo
import kotlinx.android.synthetic.main.item_repo.view.*

class MainAdapter(private val repo: List<Repo>): RecyclerView.Adapter<MainAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder.inflate(parent)
    }

    override fun getItemCount(): Int = repo.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(repo[position])
        val repoData = repo.get(position)
        holder.itemView.setOnClickListener { v ->
            val expanded = repoData.isExpanded()
            repoData.setExpanded(!expanded)
            notifyItemChanged(position)
        }
    }

    class Holder(private val view: View): RecyclerView.ViewHolder(view) {
        private val name = view.name
        private val layoutExpanded = view.layoutExpanded
        private val desc = view.desc
        private val foto = view.foto
        private val author = view.author
        private val language = view.language
        private val languageText = view.languageText
        private val forksText = view.forksText
        private val starsText = view.starsText

        private var gd = GradientDrawable()

        companion object {
            fun inflate(parent: ViewGroup): Holder {
                return Holder(
                    LayoutInflater.from(parent.context).inflate(
                        R.layout.item_repo,
                        parent,
                        false)
                )
            }
        }

        fun bind(repo: Repo) {
            name.text = repo.name
            desc.text = repo.description
            author.text = repo.author
            Glide.with(this.view)
                .asBitmap()
                .load(repo.avatar)
                .apply(RequestOptions()
                    .transform(CircleCrop())
                )
                .into(foto)
            if(repo.language.isNullOrEmpty()){
                language.visibility = View.GONE
                languageText.visibility = View.GONE
            }else{
                gd.setColor(Color.parseColor(repo.languageColor))
                gd.setShape(GradientDrawable.OVAL);
                gd.setGradientType(GradientDrawable.RADIAL_GRADIENT);
                gd.setGradientRadius((language.getWidth()/2).toFloat());
                Glide.with(this.view)
                    .load(gd)
                    .apply(RequestOptions())
                    .into(language)
                languageText.text = repo.language
            }
            forksText.text = repo.forks.toString()
            starsText.text = repo.stars.toString()
        }
    }

}