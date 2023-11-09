package arquitecturas.integrador3.dtos;

public class ReporteCarreraDTO {

    private String carrera;

    private int anio;
    private int cantidadInscriptos;

    private int cantidadEgresados;

    public ReporteCarreraDTO(String carrra, int anio, int inscriptos, int egresados){
        this.cantidadEgresados = egresados;
        this.cantidadInscriptos = inscriptos;
        this.anio = anio;
        this.carrera= carrera;
    }

}
