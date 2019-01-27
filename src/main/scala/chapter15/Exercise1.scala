package chapter15

import org.junit.Assert.assertEquals
import org.junit.Test

class Exercise1 {
  def sum(x: Int, y: Int) = x + y

  @Test
  def testSum() = {
    assertEquals(sum(1,2), 3)
  }

  @Test(timeout = 10)
  def testDelayedSum() = {
    //Thread.sleep(11)
    assertEquals(sum(Int.MaxValue, -Int.MinValue), -1)
  }

  @Test(expected = classOf[AssertionError])
  def testExpectedSum() = {
    assertEquals(sum(2, 3), 4)
  }

  @Test(timeout = 10, expected = classOf[IndexOutOfBoundsException])
  def testBothSum() = {
    val arr = Array(2)
    assertEquals(sum(arr(1), 3), 10)
  }
}
