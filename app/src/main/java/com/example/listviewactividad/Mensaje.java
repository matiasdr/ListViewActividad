package com.example.listviewactividad;

public class Mensaje {

    private Contacto contacto;
    private String asunto;
    private String cuerpo;
    private String color;

    public Mensaje(Contacto contacto, String asunto, String cuerpo, String color) {
        this.contacto = contacto;
        this.asunto = asunto;
        this.cuerpo = cuerpo;
        this.color = color;
    }

    public Contacto getContacto() {
        return contacto;
    }

    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


}
