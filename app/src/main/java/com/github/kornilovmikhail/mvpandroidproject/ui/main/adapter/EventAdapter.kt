package com.github.kornilovmikhail.mvpandroidproject.ui.main.adapter

import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.kornilovmikhail.mvpandroidproject.R
import com.github.kornilovmikhail.mvpandroidproject.data.entity.Event
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.event_list_item.view.*


class EventAdapter(
    private val events: List<Event>,
    private val eventLambda: (Int) -> Unit
) : ListAdapter<Event, EventAdapter.EventHolder>(EventDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, type: Int): EventHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.event_list_item, parent, false)
        return EventHolder(view)
    }

    override fun getItemCount(): Int = events.size

    override fun onBindViewHolder(holder: EventHolder, position: Int) {
        holder.bind(events[position].title)
        holder.itemView.setOnClickListener {
            eventLambda.invoke(position)
        }
    }

    override fun submitList(list: List<Event>?) {
        super.submitList(if (list != null) ArrayList(list) else null)
    }

    class EventDiffCallback : DiffUtil.ItemCallback<Event>() {
        override fun areItemsTheSame(oldItem: Event, newItem: Event): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: Event, newItem: Event): Boolean {
            return oldItem == newItem
        }
    }

    class EventHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
        LayoutContainer {

        fun bind(eventName: String) {
            containerView.tv_list_item_name.text = eventName
        }
    }
}