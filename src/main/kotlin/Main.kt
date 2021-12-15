import java.lang.Math.random
import java.util.*

open class ArmaFuego(
    private var nombre: String = "",
    protected var municion: Int = 0,
    protected var restar: Int = 1,
    private var tipoMunicion: String = "",
    private var danyo: Int = 0,
    private var radio: String = "pequeño"
) {


    override fun toString(): String {
        return "nombre $nombre, munición $municion, $tipoMunicion, $danyo,radio $radio"
    }

    open fun recarga(): Int = municion
    open fun dispara(): Int = restar
}

class Pistola(nombre: String, municion: Int, restar: Int, tipoMunicion: String, danyo: Int, radio: String) :
    ArmaFuego(nombre, municion, restar, tipoMunicion, danyo, radio) {

    override fun dispara(): Int {
        municion -= restar * 1
        return municion
    }

}

class Rifle(nombre: String, municion: Int, restar: Int, tipoMunicion: String, danyo: Int, radio: String) :
    ArmaFuego(nombre, municion, restar, tipoMunicion, danyo, radio) {

    override fun dispara(): Int {
        municion -= restar * 2
        return municion
    }
}

class Bazooka(nombre: String, municion: Int, restar: Int, tipoMunicion: String, danyo: Int, radio: String) :
    ArmaFuego(nombre, municion, restar, tipoMunicion, danyo, radio) {

    override fun dispara(): Int {
        municion -= restar * 3
        return municion
    }
}

fun main() {
    // funciona la instancia de los tres objetos
    var p1: Pistola = Pistola("magnun", 18, 1, "44mm", 50, "pequeño")

    var p2: Rifle = Rifle("remington", 15, 1, "shoot", 18, "grande")

    var p3: Bazooka = Bazooka("falcon", 11, 1, "granada", 100, "grande")

    var lista = listOf<ArmaFuego>(p1, p2, p3)

    var disparos = mapOf(
        1 to lista[(0..2).random()],
        2 to lista[(0..2).random()],
        3 to lista[(0..2).random()],
        4 to lista[(0..2).random()],
        5 to lista[(0..2).random()],
        6 to lista[(0..2).random()]
    )

    var cont = 1
    while (cont <= 6) {
        disparos.get(cont)?.dispara()
        println(disparos.get(cont))
        cont++
    }
}