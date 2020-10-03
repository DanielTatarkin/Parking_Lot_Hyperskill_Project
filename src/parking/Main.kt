package parking

import java.util.*

const val PARK_CMD = "park"
const val LEAVE_CMD = "leave"

fun main() {
    val scanner = Scanner(System.`in`)
    val cmd = scanner.next()

    val parkingLot = ParkingLot(2)
    parkingLot.spaces[0] = Spot(TAKEN, "plate", "car color") // Required as per Challenge
    runCmd(cmd, parkingLot, scanner)
}

fun runCmd(cmd: String, pLot: ParkingLot, scanner: Scanner) {
    when (cmd) {
        PARK_CMD -> {
            val plate = scanner.next()
            val carColor = scanner.next()
            pLot.park(plate, carColor)
        }
        LEAVE_CMD -> {
            val spotNumber = scanner.nextInt()
            pLot.leaveSpot(spotNumber)
        }
        else -> {
            println("Unknown command.")
        }
    }
}