import scala.collection.immutable.Range

Range(1, 10).foreach(print)

Specializable
// foreach takes @specialized input of primitive types and output is void or Unit and therefore @specialized(Unit)
// by default @specialized comes with all types defined in Specializable trait