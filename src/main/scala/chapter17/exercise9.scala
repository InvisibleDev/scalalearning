package chapter17

import java.net.URL

import org.htmlcleaner.{HtmlCleaner, TagNode}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.concurrent.{Await, Future}

/*
One can use http://google.com or http://msn.com as an example input
 */
object exercise9 extends App{
  val HyperLinkAttribute = "href"
  val HtmlCleaner = new HtmlCleaner()
  val HyperLinkPrefixes = Seq("http", "https")

  def enterUrl() = Future(io.StdIn.readLine("Enter URL:\n"))

  def readAndParseUrl(urlPath: String) = Future(HtmlCleaner.clean(new URL(urlPath)))

  def extractHyperlinks(root: TagNode) =
    Future(
      root.getElementsHavingAttribute(HyperLinkAttribute, true)
        .map(_.getAttributeByName(HyperLinkAttribute))
        .filter(link => HyperLinkPrefixes.exists(link.startsWith))
        .toSeq
    )

  def getServerHeader(uri: String) =Future(new URL(uri).openConnection().getHeaderField("Server"))

  def getServerHeaders(headers: Seq[String]) = headers.map(getServerHeader)

  def countHeaderFrequency(arr: Seq[String]) = Future(arr.groupBy(identity).mapValues(_.size))

  val res = Await.result(
    enterUrl().flatMap(readAndParseUrl)
      .flatMap(extractHyperlinks)
      .flatMap(h => Future.sequence(h.map(getServerHeader)))
      .flatMap(countHeaderFrequency),
     30.seconds)
  println("Entered URL contains links to the following (server, count):")
  res.foreach(println)
}
