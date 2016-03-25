package week6

import scala.collection.immutable.Queue

object Queues extends App {
	val queue = Queue[Int](1, 2, 3, 4, 5)
	println(queue)
	println(queue.dequeue)
	println(queue.enqueue(List(6, 7)))

	val emptyQ = Queue[Int]()
	println(emptyQ.dequeueOption)
}