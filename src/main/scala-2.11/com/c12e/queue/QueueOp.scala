package com.c12e.queue

import scala.concurrent.duration.Duration

//  Grammar of operations on a queue
sealed trait QueueOp[A]

private final case class GetLast[B](queue: Queue[B]) extends QueueOp[QueueSequence]
private final case class GetFirst[B](queue: Queue[B]) extends QueueOp[QueueSequence]
private final case class GetCursor[B](queue: Queue[B]) extends QueueOp[QueueSequence]
private final case class SetCursor[B](queue: Queue[B], cursor: QueueSequence) extends QueueOp[Unit]
private final case class Read[B](queue: Queue[B], timeout: Duration) extends QueueOp[QueueEntry[B]]