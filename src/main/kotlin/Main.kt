interface Dispara {

    var nombre: String
    var municion: Int
    var restar: Int
    var tipoMunicion: String
    var danyo: Int
    var radio: String

    open fun recarga(): Int = municion
    open fun dispara(): Int = restar
}


abstract class ArmaFuego(
    override var nombre: String,
    override var municion: Int,
    override var restar: Int,
    override var tipoMunicion: String,
    override var danyo: Int,
    override var radio: String
) : Dispara {

    override fun toString(): String {
        return "nombre $nombre, munición $municion, $tipoMunicion, $danyo,radio $radio"
    }
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

class Casa (
    override var nombre: String,
    override var municion: Int,
    override var restar: Int,
    override var tipoMunicion: String,
    override var danyo: Int,
    override var radio: String
):Dispara{
    override fun toString(): String {
        return "nombre $nombre, munición $municion, $tipoMunicion, $danyo,radio $radio"
    }

    override fun dispara(): Int {
        municion -= restar * 5
        return municion
}

}
class Bocadillo (
    override var nombre: String,
    override var municion: Int,
    override var restar: Int,
    override var tipoMunicion: String,
    override var danyo: Int,
    override var radio: String
):Dispara {
    override fun toString(): String {
        return "nombre $nombre, munición $municion, $tipoMunicion, $danyo,radio $radio"
    }

    override fun dispara(): Int {
        municion -= restar * 4
        return municion
    }
}
    class Batmóvil(
        override var nombre: String,
        override var municion: Int,
        override var restar: Int,
        override var tipoMunicion: String,
        override var danyo: Int,
        override var radio: String
    ):Dispara {
        override fun toString(): String {
            return "nombre $nombre, munición $municion, $tipoMunicion, $danyo,radio $radio"
        }
        override fun dispara(): Int {
            municion -= restar * 7
            return municion
        }
    }
fun main() {
    // funciona la instancia de los tres objetos
    var p1: Pistola = Pistola("magnun", 18, 1, "44mm", 50, "pequeño")

    var p2: Rifle = Rifle("remington", 15, 1, "shoot", 18, "grande")

    var p3: Bazooka = Bazooka("falcon", 11, 1, "granada", 100, "grande")

    var p4:Casa = Casa("Domus Aurea",50,1,"ladrillos",20,"grande")
    var p5:Bocadillo = Bocadillo("mara",20,1,"filetes",5,"pequeño")
    var p6:Batmóvil = Batmóvil("Batmóvil",100,1,"44mm",10,"grande")

    var lista = listOf<Dispara>(p1, p2, p3,p4,p5,p6)

    var disparos = mapOf(
        1 to lista[(0..5).random()],
        2 to lista[(0..5).random()],
        3 to lista[(0..5).random()],
        4 to lista[(0..5).random()],
        5 to lista[(0..5).random()],
        6 to lista[(0..5).random()]
    )

    var cont = 1
    while (cont <= 6) {
        disparos.get(cont)?.dispara()
        println(disparos.get(cont))
        cont++
    }
}
