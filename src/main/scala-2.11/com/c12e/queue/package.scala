package com.c12e

import _root_.scalaz.{Coyoneda, Monad, Free}

package object queue extends QueueFunctions {

  type QueueF[A]  = Free.FreeC[QueueOp, A]

  implicit val queueMonad: Monad[QueueF] = Free.freeMonad[Coyoneda[QueueOp, ?]]

}
