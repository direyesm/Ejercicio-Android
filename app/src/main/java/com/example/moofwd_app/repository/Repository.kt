package com.example.moofwd_app.repository

import android.content.Context
import com.example.moofwd_app.entities.ItemEnti
import org.jsoup.Jsoup
import java.io.IOException
import java.net.URL

class Repository {

    companion object{
        var instance: Repository? = null
        lateinit var mContext: Context
    }

    fun getInstance(context: Context): Repository{
        mContext = context
        if (instance == null)
            instance = Repository()

        return instance!!
    }

    fun getEvents(): MutableList<ItemEnti> {
        val listData = mutableListOf<ItemEnti>()
        try {
            val url = "https://rss.nytimes.com/services/xml/rss/nyt/HomePage.xml"
            val doc = Jsoup.connect(url).get()
            val events = doc.select( "item")
            val eventsSize = events.size
            for (i in 0 until eventsSize){
                val title = events.select("title")
                    .select("tittle")
                    .eq(1)
                    .text()
                val description = events.select("description")
                    .select("description")
                    .eq(1)
                    .text()
                val date = events.select("pubDate")
                    .eq(1)
                    .text()
                val image = events.select("media:content")
                    .eq(1)
                    .attr("url")
                listData.add(ItemEnti(i,title,date,description,image))
            }
        }catch (e: IOException){
            e.printStackTrace()
        }
        return listData
    }

    fun getDetails(): MutableList<ItemEnti>{
        val  item = mutableListOf<ItemEnti>()
        try {
            val url = "https://rss.nytimes.com/services/xml/rss/nyt/HomePage.xml"
            val document = Jsoup.connect(url).get()
            val detail = document.select("item")
            val title = detail.select("title")
                .select("tittle")
                .eq(1)
                .text()
            val description = detail.select("description")
                .select("description")
                .eq(1)
                .text()
            val date = detail.select("pubDate")
                .eq(1)
                .text()
            val image = detail.select("media:content")
                .eq(1)
                .attr("url")
        } catch (e: IOException){
            e.printStackTrace()
        }
        return  item
    }
}