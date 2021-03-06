package com.vj.retrofithiltnavigationmvi.helper

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson
import com.vj.retrofithiltnavigationmvi.model.RepoResponse

class ArrayListMoshiAdapter {
    @ToJson
    fun arrayListToJson(list: ArrayList<RepoResponse>): List<RepoResponse> = list

    @FromJson
    fun arrayListFromJson(list: List<RepoResponse>): ArrayList<RepoResponse> = ArrayList(list)
}