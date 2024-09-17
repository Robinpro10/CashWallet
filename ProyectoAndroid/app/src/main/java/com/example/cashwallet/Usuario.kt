package com.example.cashwallet

import android.os.Parcel
import android.os.Parcelable

// La clase Usuario implementa Parcelable para poder enviarla entre Activities
data class Usuario(
    val cedula: String,
    var nombre: String,
    val fechaNacimiento: String,
    var contraseña: String,
    val saldo: String,
    var pin: String,
    var telefono: String,
    var ingresos: String,
    var correo: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?:""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(cedula)
        parcel.writeString(nombre)
        parcel.writeString(fechaNacimiento)
        parcel.writeString(contraseña)
        parcel.writeString(saldo)
        parcel.writeString(pin)
        parcel.writeString(telefono)
        parcel.writeString(ingresos)
        parcel.writeString(correo)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Usuario> {
        override fun createFromParcel(parcel: Parcel): Usuario {
            return Usuario(parcel)
        }

        override fun newArray(size: Int): Array<Usuario?> {
            return arrayOfNulls(size)
        }
    }
}
