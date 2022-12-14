package modelo;

import java.util.GregorianCalendar;
//import java.text.SimpleDateFormat;

public class Cuenta {
    
    /*ATRIBUTOS*/
    //private boolean primera = true;
    private int numCuenta;
    private GregorianCalendar fecha;
    private float saldo;
    private String propietario;
    private static int numEst = 0;
    
    
    //[]->[]->[]->[]->
    
    /*Constructores*/
    
    public Cuenta(){
        
    }
    
    public Cuenta(int saldo, String propietario){
        
        this.numCuenta = 0;
        this.saldo = 0;
        this.fecha=new GregorianCalendar();
        this.propietario="";
        
    }
    
    public Cuenta(float sal, String prop){
        this();
        numEst++;
        this.propietario = prop;
        this.saldo = sal;
        this.fecha = new GregorianCalendar();
    }
    
    public Cuenta(int anio, int mes, int dia, float saldo, String prop){

        this(saldo, prop);
        setFecha(dia,mes,anio);
        setNumCuenta(numEst);
        
        
    }
    
    //Getters Setters

    public String toString() {
      String imprime = "   Cuenta: ";
      imprime += getNumCuenta();
      imprime += getFecha();
      imprime += "\n\tSaldo: " + getSaldo();
      imprime += "\n\tPropietario: " + getPropietario();
      return imprime;
   }
    
    public void nuevaCuenta(){
        new Cuenta();
    }

    /**
     * @return the numCuenta
     */
    public int getNumCuenta() {
        return numCuenta;
    }

    /**
     * @param numCuenta the numCuenta to set
     */
    public void setNumCuenta(int numCuenta) {
        this.numCuenta = numCuenta;
    }

    /**
     * @return the saldo
     */
    public float getSaldo() {
        return saldo;
    }

    /**
     * @param saldo the saldo to set
     */
    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    /**
     * @return the propietario
     */
    public String getPropietario() {
        return propietario;
    }

    /**
     * @param propietario the propietario to set
     */
    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    /**
     * @return the fecha
     */
    public GregorianCalendar getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(int anio, int mes, int dia) {
        this.fecha = new GregorianCalendar(dia,mes,anio);
    }
}
