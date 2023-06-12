package com.github.windymelt.lambdascala3test

import com.amazonaws.services.lambda.runtime.Context
import org.apache.logging.log4j.LogManager

import java.io.InputStream
import java.io.OutputStream
import scala.io.Source

case class Input(key1: String, key2: String, key3: String)

// Main object. java runtime need entrypoint identifier e.g. foo.bar::hogehoge
object Main:
  import io.circe._, io.circe.generic.auto._, io.circe.parser._

  val logger = LogManager.getLogger(this.getClass())

  def handler(in: InputStream, out: OutputStream, ctx: Context): Unit =
    logger.info("lambda handler started")
    val jsonString = Source.fromInputStream(in).mkString
    val parsedInput: Either[io.circe.Error, Input] = decode[Input](jsonString)
    parsedInput match
      case Left(err) =>
        logger.error(err.getMessage()) // LoggerはデフォルトではErrorレベルに設定されている?
      case Right(input) =>
        out.write(s"key2 of input is ${input.key2}".getBytes())
    logger.info("lambda handler closing")
    in.close()
    out.flush()
    out.close()
