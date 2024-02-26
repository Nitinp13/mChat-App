package com.example.messmeapp.screens.main.datamodel

data class ChatDatamodel(
    val image: Int? = null,
    val fName : String? = null,
    val lName : String? = null,
    val mess : String? = null,
    val time : String? = null,
    val isOtherUser : Boolean? = false
)
