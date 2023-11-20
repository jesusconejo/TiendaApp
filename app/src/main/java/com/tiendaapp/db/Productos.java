package com.tiendaapp.db;

public class Productos {
    private int id;
    private String nombre;
    private double precio;

    private String marca;

    private int cantidad;


// Puedes agregar más atributos según las propiedades de tus productos

    // Constructor
    public Productos() {
        // Constructor vacío necesario para SQLite
    }

    public Productos(String nombre, double precio, String marca, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.marca = marca;
        this.cantidad = cantidad;
        // Puedes inicializar otros atributos aquí si es necesario
    }

    // Getters y setters
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getMarca() {
        return marca;
    }


    public void setMarca(String marca) {
        this.marca = marca;
    }
}

