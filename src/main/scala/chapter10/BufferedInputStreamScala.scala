package chapter10

import java.io.{BufferedInputStream, InputStream}

trait BufferedInputStreamScala {
  val inputStream: InputStream
  val bisInstance = new BufferedInputStream(inputStream)

  def read(b: Array[Byte], off: Int, len: Int) = bisInstance.read(b, off, len)

  def skip(n: Long) = bisInstance.skip(n)

  def available() = bisInstance.available()

  def mark(readlimit: Int) = bisInstance.mark(readlimit)

  def reset() = bisInstance.reset()

  def markSupported() = bisInstance.markSupported()

  def close() = bisInstance.close()
}
