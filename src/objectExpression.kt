/*
==================================================================================================
        --- USES OF OBJECTS AND THE KEYWORD OBJECT ---
==================================================================================================
--> Definition:
                An object is something created from a class that holds data(properties) and can
                perform functions.

1) Objects can be created from named classes (normal creation)
i.e.

           class Inspector {
    fun inspect() {
        println("Inspection completed")
              }
        }
        val inspector = Inspector()


2) Objects can be creates from unnamed classes as illustrated in the code below.
   Note: In the unnamed classes there is an anonymous class that kotlin auto creates for you
   i.e.
           val inspector = object {
            fun inspect() {
                println("Inspection completed")
            }
        }

        inspector.inspect()

 */


interface Alarm{
    fun sound()
}
interface Auditor{
    fun audit(passed: Boolean)
}
val emergencyAlarm= object : Alarm{
    override fun sound(){
        println("Emergency tend to this one with urgency.")
    }
}

var failedAudits=0

val auditor1= object: Auditor{
    override fun audit(passed:Boolean){
        if (!passed){
            failedAudits++
        }
    }
}

fun main() {
    emergencyAlarm.sound()
    repeat(4){
        auditor1.audit(false)
    }
    println(failedAudits)
}
/*
==================================================================================================
        --- TYPES ---
==================================================================================================
-- A type tells kotlin what kind of variable holds and which operations you can perform on the value
    i.e.  val age Int= 20 therefore integer operations can be applied here

-- Now considering a custom class:
        i.e.
                    class Inspector {
                fun inspect() {
                    println("Inspection completed")
                }
            }

            val inspector = Inspector()
            inspector.inspect()

  Kotlin knows that inspector has type Inspector.Therefore it knows that  inspector.inspect() is valid

-- Now what is Any?
        any is the common superclass of all non-null kotlin types
        i.e. val age: Any=21,val name: Any = "Victor",val passed: Any = true

        But there is a catch i.e.
                                val inspector: Any = Inspector()
                                inspector.inspect() // Compilation error

        Reason:
                Because Any does not declare an inspect() function. Although the actual object is an Inspector,
                the variable is declared as Any, so Kotlin only allows you to access members available on Any.

       In short:
                --> The actual object may have many abilities.
                --> The variable's declared type determines which abilities Kotlin allows you to access directly.

======================================================================================================================
                                        var failedAudits=0

                                        val auditor= object{
                                            fun audit(passed:Boolean){
                                                if (!passed){
                                                    failedAudits++
                                                }
                                            }
                                        }

                                        fun main() {
                                            emergencyAlarm.sound()
                                            repeat(4){
                                                auditor.audit(false)
                                            }
                                            println(failedAudits)
                                        }
======================================================================================================================
                            -- BASED ON THE ERROR ENCOUNTERED ABOVE ---
--Case A: Inside the function
     fun main() {
        val auditor = object {
         fun audit(passed: Boolean) {
                println(passed)
         }
        }

        auditor.audit(false)
    }

   > This one works, because the auditor is a local variable to the main function.Thus Kotlin can infer the anonymous
     object's specific type , including its audit() function.

--Case B: At the top level of a file i.e.
                        val auditor = object {
                fun audit(passed: Boolean) {
                    println(passed)
                }
            }

            fun main() {
                auditor.audit(false) // Compilation error
            }
   --Here, auditor is a top level property: It is declared outside any class or function.

   -- For a top-level anonymous object expression,Kotlin exposes the property's type as Any. The property's
      public type therefore doesn't expose the anonymous object's unique audit() function.That is why the auditor.audit(false)
      fails to compile in this example.

        THE FIX IF IT MUST BE A TOP LEVEL THING IS TO USE AN INTERFACE TO GIVE THE OBJECT A NAMED TYPE THAT EXPOSES THE REQUIRED
        FUNCTION.
                I.E.
                                interface Auditor {
                                    fun audit(passed: Boolean)
                                }

                                val auditor = object : Auditor {
                                    override fun audit(passed: Boolean) {
                                        println("Audit passed: $passed")
                                    }
                                }

                                fun main() {
                                    auditor.audit(false)
                                }

    Notice the difference:
- object { ... } creates an anonymous object without an explicitly declared supertype.
- object : Auditor { ... } creates an anonymous object that implements Auditor.


 */
