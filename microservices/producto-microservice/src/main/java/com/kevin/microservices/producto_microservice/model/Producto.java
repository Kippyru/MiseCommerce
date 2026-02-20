package com.kevin.microservices.producto_microservice.model;

@lombok.Getter
@lombok.Setter@jakarta.persistence.Entity
@jakarta.persistence.Table(name = "producto")
public class Producto {
@jakarta.persistence.Id
@jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
@jakarta.persistence.Column(name = "id", nullable = false)
private java.lang.Long id;

@jakarta.validation.constraints.Size(max = 150)
@jakarta.validation.constraints.NotNull
@jakarta.persistence.Column(name = "nombre", nullable = false, length = 150)
private java.lang.String nombre;

@jakarta.validation.constraints.Size(max = 255)
@jakarta.persistence.Column(name = "descripcion")
private java.lang.String descripcion;

@jakarta.validation.constraints.NotNull
@jakarta.persistence.Column(name = "precio", nullable = false)
private java.lang.Double precio;

@jakarta.validation.constraints.NotNull
@org.hibernate.annotations.ColumnDefault("0")
@jakarta.persistence.Column(name = "stock", nullable = false)
private java.lang.Integer stock;

@jakarta.validation.constraints.Size(max = 255)
@jakarta.persistence.Column(name = "imagen_url")
private java.lang.String imagenUrl;

@jakarta.validation.constraints.NotNull
@jakarta.persistence.ManyToOne(fetch = jakarta.persistence.FetchType.LAZY, optional = false)
@jakarta.persistence.JoinColumn(name = "categoria_id", nullable = false)
private com.kevin.microservices.producto_microservice.model.Categoria categoria;



}