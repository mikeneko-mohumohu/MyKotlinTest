package com.example.kmyou.kotlin

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

/**
 * Created by kmyou on 2017/05/19.
 */
class ListAdapter(val context: Context, val personList: ArrayList<Person>): BaseAdapter() {

    override fun getCount(): Int {
        return personList.size
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getItem(p0: Int): Any {
        return personList[p0]
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        val personData = personList[position]
        var view = convertView
        val holder = viewHolder()
        if(view == null){
            val inflater = context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view = inflater.inflate(R.layout.list_item, parent, false)
            holder.title = view.findViewById(R.id.list_text) as TextView
            holder.article = view.findViewById(R.id.list_text2) as TextView
            holder.title!!.text = personData.getFullName
            holder.article!!.text = personData.age.toString()
        }
        return view
    }

    companion object {
        private class viewHolder(){
            var title: TextView? = null
            var article: TextView? = null
        }
    }
}