package com.memostenes.mascotas;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by memo on 24/06/16.
 */
public class Mascota implements Parcelable {
    public Mascota(String nombre, int likes, int foto) {
        this.nombre = nombre;
        this.likes = likes;
        this.foto = foto;
    }
    public Mascota(Parcel in){
        readFromParcel(in);
    }

    public static final Creator<Mascota> CREATOR = new Creator<Mascota>() {
        @Override
        public Mascota createFromParcel(Parcel in) {
            return new Mascota(in);
        }

        @Override
        public Mascota[] newArray(int size) {
            return new Mascota[size];
        }
    };

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    private String nombre;
    private int likes;
    private int foto;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nombre);
        parcel.writeInt(likes);
        parcel.writeInt(foto);

    }
    private void readFromParcel(Parcel in){
        nombre = in.readString();
        likes = in.readInt();
        foto = in.readInt();
    }
}