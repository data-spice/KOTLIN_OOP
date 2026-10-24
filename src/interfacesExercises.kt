

interface Connectable{
    val isConnected: Boolean
    fun connect()
    fun disconnect()
    fun showConnectionStatus(){
        println("Current connection status: ${if (isConnected) "Connected" else "Disconnected"}")
    }
}


interface Monitorable{
    fun readData():String
    fun generateReport(){
        println("""
            =======================
                    REPORT
            =======================
            ${readData()}
        """.trimIndent())
    }
}

interface Maintainable{
    val maintenanceRequired: Boolean
    fun performMaintenance()
}

abstract class MedicalDevice(
    val deviceId: String,
    val deviceName:String
){
    init{
        require(deviceId.isNotBlank()){
            "Device id cannot be blank"
        }
        require(deviceName.isNotBlank()){
            "Device name cannot be blank"
        }

    }
    var isOperational: Boolean=false
        protected set

    fun displayDetails() {
        println(
            """
            =============================
            Device ID: $deviceId
            Device Name: $deviceName
            Operational: $isOperational
            =============================
            """.trimIndent()
        )
    }

    abstract fun performSelfTest():Boolean

}

/*
Member	Required implementation
isConnected	Property
connect()	Function
disconnect()	Function
readData(): String	Function returning a string
maintenanceRequired	Property
performMaintenance()	Function
performSelfTest(): Boolean	Function
 */

class HeartRateMonitor(
    deviceId: String,
    deviceName: String,
    bpm: Int
):MedicalDevice(deviceId , deviceName ),Connectable,Monitorable,Maintainable{
//You must implement the required members from the interfaces and the abstract classes
    override var isConnected: Boolean= false
    override var maintenanceRequired: Boolean =true
    var sensorFaulty:Boolean=true
    var bpm: Int = bpm
        set(value) {
            require(value in 1..300) {
                "Heart rate must be between 1 and 300 BPM."
            }
            require(bpm in 1..300) {
                "Heart rate must be between 1 and 300 BPM."
            }
            field = value
        }



    override fun connect() {
        if (isConnected) {
            println("$deviceName is already connected.")
            return
        }

        if (maintenanceRequired) {
            println("$deviceName needs maintenance before it can connect.")
            return
        }

        if (!isOperational) {
            println("$deviceName is not operational. Perform a self-test first.")
            return
        }

        isConnected = true
        println("$deviceName connected successfully.")
    }

    override fun disconnect(){
        if (isConnected){
            println("$deviceName disconnected successfully.")
            isConnected=false
        }else{
            println("$deviceName is already disconnected.")
        }
    }

    override fun readData(): String{
        return "Heart Rate $bpm BPM"
    }


    override fun performMaintenance(){
        if (isConnected) {
            println("Disconnect $deviceName before maintenance.")
            return
        }
        if(maintenanceRequired){
            println("Performing maintenance on $deviceName")
            for (i in 1..5){
                print("-")
                Thread.sleep(1000)
            }
            println()
            println("========================================\n"+"Maintenance on $deviceName done successfully.")
            maintenanceRequired=false
            sensorFaulty=false
        }else{
            println("$deviceName is already in good condition.")
        }
    }

    override fun performSelfTest():Boolean {
        var value: Boolean= false
        if (!maintenanceRequired) {
            println("Beginning operability checks ")

                    for (i in 1..5) {
                        print("-")
                        Thread.sleep(500)
                    }
                    if(sensorFaulty){
                        println()
                        println("Faulty sensor detected kindly do some maintenance")
                        isOperational=false
                        return false
                    }

                    println()
                    isOperational = true
                    println("$deviceName is now operational")
                   value= true

        } else if (maintenanceRequired) {
            println("$deviceName needs maintenance.")
            value= false
        }
        return value



    }
}

fun main() {
    val monitor = HeartRateMonitor(
        "HR001",
        "Heart Rate Monitor",
        75
    )

    monitor.connect()
    monitor.performMaintenance()
    monitor.performSelfTest()
    monitor.connect()
    monitor.generateReport()
    monitor.disconnect()
    monitor.displayDetails()
}