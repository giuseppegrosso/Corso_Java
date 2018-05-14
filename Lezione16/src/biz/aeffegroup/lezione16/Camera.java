package biz.aeffegroup.lezione16;

public class Camera {

	private Integer piano;
	private Integer numero;
	private String vista;
	private Integer capienza;
	private double costo;
	private String tipo;// singola/doppia/tripla

	public Camera() {
	}

	public Camera(Integer piano, Integer numero, String vista, Integer capienza, double costo, String tipo) {
		this.piano = piano;
		this.numero = numero;
		this.vista = vista;
		this.capienza = capienza;
		this.costo = costo;
		this.tipo = tipo;
	}

	public Camera getCameraSingola(Integer piano, Integer numero, String vista) {
		return new Camera(piano, numero, vista, 1, 50, "singola");
	}

	public Camera getCameraSingolaMare(Integer piano, Integer numero) {
		return getCameraSingola(piano, numero, "mare");
	}

	public Camera getCameraSingolaMontagna(Integer piano, Integer numero) {
		return getCameraSingola(piano, numero, "montagna");
	}

	public Camera getCameraDoppia(Integer piano, Integer numero, String vista) {
		return new Camera(piano, numero, vista, 2, 80d, "doppia");
	}

	public Camera getCameraDoppiaMare(Integer piano, Integer numero) {
		return getCameraDoppia(piano, numero, "mare");
	}

	public Camera getCameraDoppiaMontagna(Integer piano, Integer numero) {
		return getCameraDoppia(piano, numero, "montagna");
	}

	public Camera getCameraTripla(Integer piano, Integer numero, String vista) {
		return new Camera(piano, numero, vista, 3, 120d, "tripla");
	}

	public Camera getCameraTriplaMare(Integer piano, Integer numero) {
		return getCameraTripla(piano, numero, "mare");
	}

	public Camera getCameraTriplaMontagna(Integer piano, Integer numero) {
		return getCameraTripla(piano, numero, "montagna");
	}

	public Integer getPiano() {
		return piano;
	}

	public void setPiano(Integer piano) {
		this.piano = piano;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getVista() {
		return vista;
	}

	public void setVista(String vista) {
		this.vista = vista;
	}

	public Integer getCapienza() {
		return capienza;
	}

	public void setCapienza(Integer capienza) {
		this.capienza = capienza;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String toString() {
		return "Piano: " + this.piano + " Numero: " + this.numero + " Vista: " + this.vista + " Capienza: " + this.capienza + " Costo: " + this.costo + " tipo: "
				+ this.tipo;
	}

}
