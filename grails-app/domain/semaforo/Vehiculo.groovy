package semaforo
import groovy.json.*
class Vehiculo {
	
	String placa
	int modelo
	String color
	String marca
	
    static constraints = {
		placa unique: true, blank: false, nullable: false
		modelo blank: false, nullable: false //falta validar que sea una fecha anterior o igual a la actual
		color blank: false, nullable: false
		marca blank: false, nullable: false
    }
	String toString() {
		return "Placa: " + placa +", Modelo: " + modelo +", Color: " + color +", Marca: " + marca
	}
}