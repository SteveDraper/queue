package com.c12e.queue

//  Queues are currently identified by a single string, but this is abstracted
//  in case more flexibility is required later
final class QueueIdentifier private(_name: String) {
  val name = _name
}

object QueueIdentifier {
  private[queue] def apply(name: String) = new QueueIdentifier(name)
}