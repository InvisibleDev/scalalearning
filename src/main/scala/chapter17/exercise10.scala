package chapter17

import java.net.URL

import org.htmlcleaner.{HtmlCleaner, TagNode}

import scala.collection.concurrent.TrieMap
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.concurrent.{Await, Future, blocking}

/*
One can use http://google.com or http://msn.com as an example input
 */
object exercise10 extends App{
  val HyperLinkAttribute = "href"
  val HtmlCleaner = new HtmlCleaner()
  val HyperLinkPrefixes = Seq("http", "https")
  val HeadersCount = TrieMap[String, Int]()

  def enterUrl() = Future(io.StdIn.readLine("Enter URL:\n"))

  def readAndParseUrl(urlPath: String) = Future(HtmlCleaner.clean(new URL(urlPath)))

  def extractHyperlinks(root: TagNode) =
    Future(
      root.getElementsHavingAttribute(HyperLinkAttribute, true)
        .map(_.getAttributeByName(HyperLinkAttribute))
        .filter(link => HyperLinkPrefixes.exists(link.startsWith))
        .toSeq
    )

  def getServerHeader(uri: String) =Future {
    val header = new URL(uri).openConnection().getHeaderField("Server")
    blocking { // result is the same without it
      val headerCount = HeadersCount.getOrElseUpdate(header, 0)
      HeadersCount.update(header, headerCount + 1)
    }
    header
  }

  def getServerHeaders(headers: Seq[String]) = headers.map(getServerHeader)

  val res = Await.result(
    enterUrl().flatMap(readAndParseUrl)
      .flatMap(extractHyperlinks)
      .flatMap(h => Future.sequence(h.map(getServerHeader))),
    30.seconds)
  println("Entered URL contains links to the following (server, count):")
  HeadersCount.foreach(println)
}
