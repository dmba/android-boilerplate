package io.github.dmba.android_boilerplate.data.model

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by dmba on 6/2/18.
 */
data class Check(
    val name: String,
    val amount: String,
    val date: String,
    val imgRes: Int,
    val isReceived: Boolean
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readByte() != 0.toByte())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(amount)
        parcel.writeString(date)
        parcel.writeInt(imgRes)
        parcel.writeByte(if (isReceived) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Check> {
        override fun createFromParcel(parcel: Parcel): Check {
            return Check(parcel)
        }

        override fun newArray(size: Int): Array<Check?> {
            return arrayOfNulls(size)
        }
    }

}
