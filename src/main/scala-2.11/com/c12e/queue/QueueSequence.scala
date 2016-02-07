package com.c12e.queue

import scalaz.Order
import scalaz.std.anyVal.longInstance

//  For now we implement sequencing with a Long, but abstract this and do not expose
//  the choice to API consumers
final class QueueSequence private (private[QueueSequence] val value: Long) extends AnyVal

object QueueSequence {
  val minValue = apply(Long.MinValue)
  val maxValue = apply(Long.MaxValue)

  private[queue] def apply(value: Long): QueueSequence = new QueueSequence(value)

  implicit val order: Order[QueueSequence] =
    Order.orderBy[QueueSequence, Long] { _.value }
}