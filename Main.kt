open class Flower {
    open fun getName(): String {
        return "Unknown"
    }

    open fun getColor(): String {
        return "Unknown"
    }
}

class Tulip : Flower() {
    override fun getName(): String {
        return "Tulip"
    }

    override fun getColor(): String {
        return "Multicolor"
    }
}

class Rose : Flower() {
    override fun getName(): String {
        return "Rose"
    }

    override fun getColor(): String {
        return "Red, white, pink, yellow"
    }
}

class Lily : Flower() {
    override fun getName(): String {
        return "Lily"
    }

    override fun getColor(): String {
        return "White, yellow, orange, pink"
    }
}

fun main() {
    val tulip = Tulip()
    val rose = Rose()
    val lily = Lily()

    println("tulip name: ${tulip.getName()}")
    println("tulip color: ${tulip.getColor()}")

    println("rose name: ${rose.getName()}")
    println("rose color: ${rose.getColor()}")

    println("lily name: ${lily.getName()}")
    println("lily color: ${lily.getColor()}")
}
