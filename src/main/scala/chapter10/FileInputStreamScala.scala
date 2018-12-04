package chapter10

import java.io.FileInputStream

class FileInputStreamScala(fileName: String) extends BufferedInputStreamScala{
  val inputStream = new FileInputStream(fileName)
  private val BufferSize = 8192

  def read(): Iterator[Array[Byte]] = {
    val buffered = new Array[Byte](BufferSize)
    var readBytes = 0

    Iterator.continually{
      readBytes = read(buffered, readBytes, BufferSize)
      buffered
    }.takeWhile(_ => readBytes != -1)
  }
}

//TODO continue later