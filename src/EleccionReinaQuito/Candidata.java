package EleccionReinaQuito;

public abstract class Candidata {
    protected int id;
    protected String nombre;
    protected int edad;
    protected String distrito;
    protected double puntajeJurado;

    public Candidata(int id, String nombre, int edad, String distrito, double puntajeJurado) throws DatoInvalidoException{
        this.id = id;
        setNombre(nombre);
        setEdad(edad);
        setDistrito(distrito);
        setPuntajeJurado(puntajeJurado);
    }

    public abstract void mostrarDetalles() ;

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws DatoInvalidoException{
        if(nombre == null || nombre.trim().isEmpty())
            throw new DatoInvalidoException("El nombre es obligatorio");

        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) throws DatoInvalidoException{
        if(edad < 16)
            throw new DatoInvalidoException("El edad minima es 16 años");
        this.edad = edad;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) throws DatoInvalidoException{
        if(distrito == null || distrito.trim().isEmpty())
            throw new DatoInvalidoException("El distrito es obligatorio");
        this.distrito = distrito;
    }

    public double getPuntajeJurado() {
        return puntajeJurado;
    }

    public void setPuntajeJurado(double puntajeJurado) throws DatoInvalidoException{
        if (puntajeJurado < 0 || puntajeJurado > 100)
            throw new DatoInvalidoException("El puntaje debe estar entre 0 y 100");
        this.puntajeJurado = puntajeJurado;
    }
}