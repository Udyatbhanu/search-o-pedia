package com.slack.exercise.ui.usersearch

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.slack.exercise.R
import com.slack.exercise.model.UserSearchResult
import kotlinx.android.synthetic.main.item_user_search.view.*

/**
 * Adapter for the list of [UserSearchResult].
 */
class UserSearchAdapter : RecyclerView.Adapter<UserSearchAdapter.UserSearchViewHolder>() {
    private var userSearchResults: List<UserSearchResult> = emptyList()

    fun setResults(results: Set<UserSearchResult>) {
        userSearchResults = results.toList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserSearchViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user_search, parent, false)
        return UserSearchViewHolder(view)
    }

    override fun getItemCount(): Int {
        return userSearchResults.size
    }

    override fun onBindViewHolder(holder: UserSearchViewHolder, position: Int) {
        holder.displayName.text = userSearchResults[position].displayName
        holder.username.text = userSearchResults[position].username

        Glide.with(holder.avatar.context).load(userSearchResults[position].avatarUrl).into(holder.avatar)

    }

    class UserSearchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val avatar: ImageView = itemView.avatar
        val displayName: TextView = itemView.displayName
        val username: TextView = itemView.username
    }
}