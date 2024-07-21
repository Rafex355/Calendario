package ec.uce.edu.calendarioeventos.dominio;

import ec.uce.edu.calendarioeventos.util.Validacion;

/**
 *
 * @author Bryan Perez
 */
public class Persona {

    protected String nombre;
    protected String correoElectronico;
    protected String clave;
    protected String apellido;

    public Persona() {
        this.nombre = "Daniel";
        this.apellido = "Perez";
        this.correoElectronico = "danny07@yahoo.com";
        this.clave = "Junta76";
    }

    public Persona(String nombre, String apellido, String correoElectronico, String clave) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correoElectronico = correoElectronico;
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public String getClave() {
        return clave;
    }

    public String getApellido() {
        return apellido;
    }

    public void setNombre(String nombre) {
        if (Validacion.validarNombre(nombre)) {
            this.nombre = nombre;
        } else {
            System.out.println("El nombre ingresado es incorrecto");
        }
    }

    public void setCorreoElectronico(String correoElectronico) {
        if (Validacion.validarCorreoElectronico(correoElectronico)) {
            this.correoElectronico = correoElectronico;
        } else {
            System.out.println("El correo ingresado es incorrecto");
        }
    }

    public void setClave(String clave) {
        if (Validacion.validarClave(clave)) {
            this.clave = clave;
        } else {
            System.out.println("La clave ingresada no es valida");
        }
    }

    public void setApellido(String apellido) {
        if (Validacion.validarApellido(apellido)) {
            this.apellido = apellido;
        } else {
            System.out.println("El apellido ingresado no es valido");
        }
    }
    
    /**
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        boolean resp = false;
        
        if (o != null && o instanceof Persona) {
            Persona aux = (Persona) o;
            if (this.nombre.equals(aux.nombre) &&
                this.apellido.equals(aux.apellido) &&
                this.correoElectronico.equals(aux.correoElectronico)) {
                resp = true;
            }
        }
        return resp;
    }    
    

    @Override
       public String toString() {
        return  "\nNombre=" + nombre +
                "\nApellido=" + apellido +
                "\nCorreoElectronico=" + correoElectronico +
                "\nClave=" + clave;
    }
    
}
