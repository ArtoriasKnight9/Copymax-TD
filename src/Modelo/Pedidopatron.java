package Modelo;

import java.util.Date;

// PATRON BUILDER 

public class Pedidopatron {

    // Atributos (final para inmutabilidad)
    private final int numpedido;
    private final int idusuario;
    private final int idcliente;
    private final int cantidad;
    private final int numdepaginas;
    private final String Nombredeusuario;
    private final String Nombrecliennte;
    private final String Apellidoscliente;
    private final String cometarios;
    private final String Celularcliente;
    private final String Servicio;
    private final String Tipodecopia;
    private final String Tamaño;
    private final String Escala;
    private final String Status;
    private final Date fechaEmision;
    private final Date Fechaentrega;
    private final Date Horaemision;
    private final Date Horaentrega;
    private final String pastafrente;
    private final String pastatrasera;
    private final String arillo;
    private final double total;
    private final double Anticipo;
    private final double Resto;

    // Constructor privado para evitar instanciación directa
    private Pedidopatron(Builder builder) {
        this.numpedido = builder.numpedido;
        this.idusuario = builder.idusuario;
        this.idcliente = builder.idcliente;
        this.cantidad = builder.cantidad;
        this.numdepaginas = builder.numdepaginas;
        this.Nombredeusuario = builder.Nombredeusuario;
        this.Nombrecliennte = builder.Nombrecliennte;
        this.Apellidoscliente = builder.Apellidoscliente;
        this.cometarios = builder.cometarios;
        this.Celularcliente = builder.Celularcliente;
        this.Servicio = builder.Servicio;
        this.Tipodecopia = builder.Tipodecopia;
        this.Tamaño = builder.Tamaño;
        this.Escala = builder.Escala;
        this.Status = builder.Status;
        this.fechaEmision = builder.fechaEmision;
        this.Fechaentrega = builder.Fechaentrega;
        this.Horaemision = builder.Horaemision;
        this.Horaentrega = builder.Horaentrega;
        this.pastafrente = builder.pastafrente;
        this.pastatrasera = builder.pastatrasera;
        this.arillo = builder.arillo;
        this.total = builder.total;
        this.Anticipo = builder.Anticipo;
        this.Resto = builder.Resto;
    }

    // Getters (siguen siendo necesarios)
    public int getNumpedido() {
        return numpedido;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getNumdepaginas() {
        return numdepaginas;
    }

    public String getNombredeusuario() {
        return Nombredeusuario;
    }

    public String getNombrecliennte() {
        return Nombrecliennte;
    }

    public String getApellidoscliente() {
        return Apellidoscliente;
    }

    public String getCometarios() {
        return cometarios;
    }

    public String getCelularcliente() {
        return Celularcliente;
    }

    public String getServicio() {
        return Servicio;
    }

    public String getTipodecopia() {
        return Tipodecopia;
    }

    public String getTamaño() {
        return Tamaño;
    }

    public String getEscala() {
        return Escala;
    }

    public String getStatus() {
        return Status;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public Date getFechaentrega() {
        return Fechaentrega;
    }

    public Date getHoraemision() {
        return Horaemision;
    }

    public Date getHoraentrega() {
        return Horaentrega;
    }

    public String getPastafrente() {
        return pastafrente;
    }

    public String getPastatrasera() {
        return pastatrasera;
    }

    public String getArillo() {
        return arillo;
    }

    public double getTotal() {
        return total;
    }

    public double getAnticipo() {
        return Anticipo;
    }

    public double getResto() {
        return Resto;
    }

    // Clase Builder
    public static class Builder {
        // Atributos (los mismos que en Pedidoclass)
        private int numpedido;
        private int idusuario;
        private int idcliente;
        private int cantidad;
        private int numdepaginas;
        private String Nombredeusuario;
        private String Nombrecliennte;
        private String Apellidoscliente;
        private String cometarios;
        private String Celularcliente;
        private String Servicio;
        private String Tipodecopia;
        private String Tamaño;
        private String Escala;
        private String Status;
        private Date fechaEmision;
        private Date Fechaentrega;
        private Date Horaemision;
        private Date Horaentrega;
        private String pastafrente;
        private String pastatrasera;
        private String arillo;
        private double total;
        private double Anticipo;
        private double Resto;

        // Métodos para configurar los atributos
        public Builder setNumpedido(int numpedido) {
            this.numpedido = numpedido;
            return this;
        }

        public Builder setIdusuario(int idusuario) {
            this.idusuario = idusuario;
            return this;
        }

        public Builder setIdcliente(int idcliente) {
            this.idcliente = idcliente;
            return this;
        }

        public Builder setCantidad(int cantidad) {
            this.cantidad = cantidad;
            return this;
        }

        public Builder setNumdepaginas(int numdepaginas) {
            this.numdepaginas = numdepaginas;
            return this;
        }

        public Builder setNombredeusuario(String Nombredeusuario) {
            this.Nombredeusuario = Nombredeusuario;
            return this;
        }

        public Builder setNombrecliennte(String Nombrecliennte) {
            this.Nombrecliennte = Nombrecliennte;
            return this;
        }

        public Builder setApellidoscliente(String Apellidoscliente) {
            this.Apellidoscliente = Apellidoscliente;
            return this;
        }

        public Builder setCometarios(String cometarios) {
            this.cometarios = cometarios;
            return this;
        }

        public Builder setCelularcliente(String Celularcliente) {
            this.Celularcliente = Celularcliente;
            return this;
        }

        public Builder setServicio(String Servicio) {
            this.Servicio = Servicio;
            return this;
        }

        public Builder setTipodecopia(String Tipodecopia) {
            this.Tipodecopia = Tipodecopia;
            return this;
        }

        public Builder setTamaño(String Tamaño) {
            this.Tamaño = Tamaño;
            return this;
        }

        public Builder setEscala(String Escala) {
            this.Escala = Escala;
            return this;
        }

        public Builder setStatus(String Status) {
            this.Status = Status;
            return this;
        }

        public Builder setFechaEmision(Date fechaEmision) {
            this.fechaEmision = fechaEmision;
            return this;
        }

        public Builder setFechaentrega(Date Fechaentrega) {
            this.Fechaentrega = Fechaentrega;
            return this;
        }

        public Builder setHoraemision(Date Horaemision) {
            this.Horaemision = Horaemision;
            return this;
        }

        public Builder setHoraentrega(Date Horaentrega) {
            this.Horaentrega = Horaentrega;
            return this;
        }

        public Builder setPastafrente(String pastafrente) {
            this.pastafrente = pastafrente;
            return this;
        }

        public Builder setPastatrasera(String pastatrasera) {
            this.pastatrasera = pastatrasera;
            return this;
        }

        public Builder setArillo(String arillo) {
            this.arillo = arillo;
            return this;
        }

        public Builder setTotal(double total) {
            this.total = total;
            return this;
        }

        public Builder setAnticipo(double Anticipo) {
            this.Anticipo = Anticipo;
            return this;
        }

        public Builder setResto(double Resto) {
            this.Resto = Resto;
            return this;
        }

        // Método build para crear la instancia de Pedidoclass
        public Pedidopatron build() {
            return new Pedidopatron(this);
        }
    }
}
