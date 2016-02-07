package com.c12e.queue

import scala.concurrent.duration.Duration

//  Bound instance of a queue holding records wih data of type A
class Queue[A] {
  def getLast: QueueF[QueueSequence] = getLastInQueue(this)

  def getFirst: QueueF[QueueSequence] = getFirstInQueue(this)

  def getCursor: QueueF[QueueSequence] = getCursorInQueue(this)

  def setCursor(cursor: QueueSequence): QueueF[Unit] = setCursorInQueue(this, cursor)

  def read(timeout: Duration): QueueF[QueueEntry[A]] = readInQueue(this, timeout)
}
