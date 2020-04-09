package com.example.pac_m08_hectormartinezceballos;

public class Usuario {

    int id;
    String nombre;
    String apellido;
    String usuario;
    String contrasena;
    String Correo;



    public Usuario(int id, String nombre, String apellido, String correo, String usuario, String contrasena) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.Correo = correo;
    }

    public Usuario(String nombre, String apellido, String correo, String usuario, String contrasena) {
        this (0, nombre, apellido, correo, usuario, contrasena);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre_usuario() {
        return usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.usuario = nombre_usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        this.Correo = correo;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", usuario='" + usuario + '\'' +
                ", contraseña='" + contrasena + '\'' +
                ", Correo='" + Correo + '\'' +
                '}';
    }
}
