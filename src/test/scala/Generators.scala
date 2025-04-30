package dev.kamgy

import org.scalacheck.Gen

object Generators {

  def alphaNumStrings(minLength: Int, maxLength: Int): Gen[String] = {
    for {
      length <- Gen.choose(minLength, maxLength)
      str    <- Gen.listOfN(length, Gen.alphaNumChar).map(_.mkString)
    } yield str
  }

}
