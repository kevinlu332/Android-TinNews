package com.laioffer.tinnews.ui.search;

import android.icu.text.StringSearch;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.laioffer.tinnews.R;
import com.laioffer.tinnews.databinding.SearchNewsItemBinding;
import com.laioffer.tinnews.model.Article;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class SearchNewsAdapter extends RecyclerView.Adapter<SearchNewsAdapter.SearchNewsViewHolder>{
    interface ItemCallback{
        void onOpenDetails(Article article);
    }
    private ItemCallback itemCallback;
    public void setItemCallback(ItemCallback itemCallback){
        this.itemCallback = itemCallback;
    }
    // 1. Supporting data
    // 2. Adapter overrides functions
        // 3. SearchNewsViewHolder


    // 1. Supporting data:
    private List<Article> articles= new ArrayList<>();
    public void setArticles(List<Article> newsList) {
        articles.clear();
        articles.addAll(newsList);
        notifyDataSetChanged();
    }


    // 2. Adapter overrides functions:
    @NonNull
    @Override
    public SearchNewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //把xml转换成java的view:
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.search_news_item, parent, false);
        return new SearchNewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchNewsViewHolder holder, int position) {
        Article article = articles.get(position);
        if(position==1){
            holder.favoriteImageView.setImageResource(R.drawable.ic_favorite_border_24dp);
        }else{
            holder.favoriteImageView.setImageResource(R.drawable.ic_favorite_24dp);
        }
        //holder.favoriteImageView.setImageResource(R.drawable.ic_favorite_24dp);
        holder.itemTitleTextView.setText(article.title);
        //add Picasso image
        Picasso.get().load(article.urlToImage).into(holder.itemImageView);
        //listener to open detail fragment
        holder.itemView.setOnClickListener(evt -> itemCallback.onOpenDetails(article));
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }



    // 3. static inner class SearchNewsViewHolder:

    public static class SearchNewsViewHolder extends RecyclerView.ViewHolder {

        ImageView favoriteImageView;
        ImageView itemImageView;
        TextView itemTitleTextView;

        public SearchNewsViewHolder(@NonNull View itemView) {
            super(itemView);
            SearchNewsItemBinding binding = SearchNewsItemBinding.bind(itemView);
            favoriteImageView = binding.searchItemFavorite;
            itemImageView = binding.searchItemImage;
            itemTitleTextView = binding.searchItemTitle;
        }
    }
}


