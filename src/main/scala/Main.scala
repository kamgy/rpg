package dev.kamgy

import scala.concurrent.duration.DurationInt

import cats.effect.{IO, IOApp}

object Main extends IOApp.Simple {
  override val run: IO[Unit] =
    for {
      _ <- IO.println("Creating resources...")
      _ <- IO.sleep(500.millis)
      _ <- IO.println("Resources created successfully!")
      _ <- IO.println("Starting the application...")
      _ <- IO.sleep(500.millis)
      _ <- IO.println("Application started successfully!")
    } yield ()
}
