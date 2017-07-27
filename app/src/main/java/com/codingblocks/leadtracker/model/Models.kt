package com.codingblocks.leadtracker.model

/**
 * Created by piyush on 27/7/17.
 */

data class LeadItem(val name: String,
                val eMail: String,
                val contact: String,
                val createdAt: String,
                val updatedAt: String)

data class Center(val name: String,
                   val address: String
)