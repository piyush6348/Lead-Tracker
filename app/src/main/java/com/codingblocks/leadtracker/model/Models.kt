package com.codingblocks.leadtracker.model

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by nimit on 27/7/17.
 */

data class LeadItem(val name: String,
                    val eMail: String,
                    val contact: String,
                    val createdAt: String,
                    val updatedAt: String)

data class Center(val name: String,
                  val address: String)

data class Comment(val studentName: String,
                   val studentCollege: String,
                   val creatersName: String,
                   val createdAt: String,
                   val updatedAt: String)

data class Course(val name: String,
                  val details: String,
                  val centerToInstructor: HashMap<String, String>,
                  val startDate: String,
                  val endDate: String
) : Parcelable {
    companion object {
        @JvmField val CREATOR: Parcelable.Creator<Course> = object : Parcelable.Creator<Course> {
            override fun createFromParcel(source: Parcel): Course = Course(source)
            override fun newArray(size: Int): Array<Course?> = arrayOfNulls(size)
        }
    }

    constructor(source: Parcel) : this(
            source.readString(),
            source.readString(),
            source.readSerializable() as HashMap<String, String>,
            source.readString(),
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(name)
        dest.writeString(details)
        dest.writeSerializable(centerToInstructor)
        dest.writeString(startDate)
        dest.writeString(endDate)
    }
}
