package com {
  // Exercise 1
  object ComObject {
    var comVar = 1
  }

  package horstmann {

    package impatient {

      class Chapter7Ex12 {
        var ex1Var = ComObject.comVar
        private[com] def giveRaise(rate: Double) = rate
      }

    }
  }
}