package adventcode2016

object Day7 extends App {
	val filename = "src/adventcode2016/day7_input.txt"
	val lines = scala.io.Source.fromFile(filename).getLines.toList
	val hypernet = """\[(\w+)\]""".r

	def containsABBA(ip: String) = ip.sliding(4) exists { seq =>
		seq(0) == seq(3) && seq(1) == seq(2) && seq(0) != seq(1)
	}

	val ips = lines.map(_.toLowerCase) map {
		case ip =>
			val hypernets = hypernet.findAllMatchIn(ip).map(_.toString.tail.dropRight(1))
			val supernets = ip.split("""\[\w+\]""")
			(hypernets toList, supernets toList)
	}

	val TLSSupport = ips count {
		case (hypernets, supernets) =>
			!hypernets.exists(containsABBA) && supernets.exists(containsABBA)
	}

	val SSLSupport = ips count {
		case (hypernets, supernets) =>
			supernets exists { supernet =>
				supernet.sliding(3) exists { seq =>
					val bab = "" + seq(1) + seq(0) + seq(1)
					seq(0) == seq(2) && seq(0) != seq(1) &&
						hypernets.exists(_.indexOf(bab) != -1)
				}
			}
	}

	println(TLSSupport, SSLSupport)
}