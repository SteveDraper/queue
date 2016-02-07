package com.c12e.queue

import scala.concurrent.duration.Duration
import scalaz.Free.{ liftFC }

trait QueueFunctions {
  def getLastInQueue[A](q: Queue[A]): QueueF[QueueSequence] =
    liftFC[QueueOp,QueueSequence](GetLast(q))

  def getFirstInQueue[A](q: Queue[A]): QueueF[QueueSequence] =
    liftFC[QueueOp,QueueSequence](GetFirst(q))

  def getCursorInQueue[A](q: Queue[A]): QueueF[QueueSequence] =
    liftFC[QueueOp,QueueSequence](GetCursor(q))

  def setCursorInQueue[A](q: Queue[A], cursor: QueueSequence): QueueF[Unit] =
    liftFC[QueueOp,Unit](SetCursor(q, cursor))

  def readInQueue[A](q: Queue[A], timeout: Duration): QueueF[QueueEntry[A]] =
    liftFC[QueueOp,QueueEntry[A]](Read(q, timeout))
}

object QueueFunctions extends QueueFunctions
