/*
==================================================================================================
                                --- DELEGATION ---
==================================================================================================
 -- Delegation means asking another object to do a task on your behalf.
 -- Delegation without kotlin syntax:

 ```
                    class Printer {
                        fun printDocument() {
                            println("Printing document...")
                        }
                    }

                    class Office {
                        private val printer = Printer()

                        fun print() {
                            printer.printDocument()
                        }
                    }
                    fun main() {
                        val office = Office()
                        office.print()
                    }
 ```

                Follow the process:
               -> You call office.print()

                ->Office calls printer.printDocument()

                ->Printer performs the task

 -- Why delegation is needed?
        -> Consider these two classes:

        ```
                        open class NetworkDevice {
                            fun connect() {
                                println("Connecting to network...")
                            }
                        }

                        open class SafetyDevice {
                            fun runSafetyCheck() {
                                println("Running safety check...")
                            }
                        }
         ```

 -- Now suppose that you want a medical monitor to have both capabilities:
         i.e.
               -> class HeartRateMonitor : NetworkDevice(), SafetyDevice()
        But this is invalid Kotlin. A class can only inherit from one other class
        and multiple interfaces.However, you can use both capabilities without
        inheriting from both classes.

//MANUAL DELEGATION EXAMPLE:
```
            class HeartRateMonitor {
                private val network = NetworkDevice() //Delegation
                private val safety = SafetyDevice()     //Delegation

                fun connect() {
                    network.connect()
                }

                fun runSafetyCheck() {
                    safety.runSafetyCheck()
                }
            }
```

 -- Kotlin has special delegation syntax:

 //FIRST CREATE AN INTERFACE
 ```
     interface Connectable {
        fun connect()
        fun disconnect()
    }
```


//NOW CREATE A CLASS THAT IMPLEMENTS THE INTERFACE
```
    class NetworkConnection : Connectable {

        override fun connect() {
            println("Connected to network.")
        }

        override fun disconnect() {
            println("Disconnected from network.")
        }
    }
```

//DELEGATION
```
    class HeartRateMonitor(
        private val connection: Connectable         //The monitor receives and stores an object that implements Connectable
        ): Connectable by connection                // The heartrate monitor promises to implement the Connectable interface
                                                    /-> The by connection part means that Kotlin auto forwards the interface's implementations
                                                    to the stored object.
                                                    In short it is saying that make the HeartRateMonitor implement Connection by forwarding the
                                                    interface to the connection object

                                                    ->/

 //FUN MAIN
 ```
    fun main(){
        val network = NetworkConnection()            //Provides the actual connection functionality that the monitor will use through delegation
        val monitor = HeartRateMonitor(network)

        monitor.connect()
        monitor.disconnect()
    }
```


-- Notice that we did not write the connect & the disconnect functions in the HeartRateMonitor. Kotlin generated implementations
   that forward those calls to the connection object.
   When you call the monitor.connect() the call is delegated to connection.connect()

//SUPPOSE THE MONITOR NEEDS ITS OWN BEHAVIOUR
```
   class HeartRateMonitor(
        private val connection: Connectable
        ): Connectable by connection{

            override fun connect(){
                println("Preparing heart rate monitor")
                connection.connect()                            //Explicitly invokes the delegated object
               }
            }
 */


interface Reading{
    fun read()
}

class Book(val bookName: String):Reading{
    override fun read(){
        println("I am reading $bookName")
    }
}

class Chapter(val reader: Reading ):Reading by reader

fun main(){
    val book1=Book("The Witcher")
    val chapter1=Chapter(book1)

    chapter1.read()
}