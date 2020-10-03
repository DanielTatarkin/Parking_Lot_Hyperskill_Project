package parking

const val TAKEN = true
const val NOT_TAKEN = false

class ParkingLot(totalSpaces: Int) {
    private var emptySpaces = totalSpaces
    val spaces = Array(totalSpaces) { Spot() }

    fun park(plate: String, carColor: String) {
        if (emptySpaces > 0) {
            spaces.forEachIndexed { index, spot ->
                if (spot.status == NOT_TAKEN) {
                    spaces[index].status = TAKEN
                    spaces[index].plate = plate
                    spaces[index].carColor = carColor
                    emptySpaces--
                    println("$carColor car parked in spot ${index + 1}.")
                }
            }
        } else println("No empty spaces available.")
    }

    fun leaveSpot(spotNumber: Int) {
        if (spaces[spotNumber - 1].status == TAKEN) {
            spaces[spotNumber - 1].freeSpot()
            println("Spot $spotNumber is free.")
        } else println("There is no car in spot $spotNumber.")
    }
}

data class Spot(var status: Boolean = NOT_TAKEN, var plate: String? = null, var carColor: String? = null) {
    fun freeSpot() {
        status = NOT_TAKEN
        this.plate = null
        this.carColor = null
    }
}