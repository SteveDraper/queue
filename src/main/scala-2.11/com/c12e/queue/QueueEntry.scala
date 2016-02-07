package com.c12e.queue

//  Queue entries are typed and sequenced
final class QueueEntry[A] private (index: QueueSequence, data: A)

object QueueEntry {
  private[queue] def apply[A](index: QueueSequence, data: A) = new QueueEntry(index, data)
}
