package adventcode2016

import java.security.MessageDigest

object Day5 extends App {
	val input = "ugkcyxxp"

	def md5(s: String): String = // returns the md5 hex string
		MessageDigest.getInstance("MD5").digest(s.getBytes).map("%02X".format(_)).mkString

	def getId1(key: String, pad: Int, id: List[Char]): String =
		if (id.length == 8) id.reverse.mkString.toLowerCase
		else {
			val hash = md5(key + pad)
			if (hash.startsWith("00000")) getId1(key, pad + 1, hash(5) :: id)
			else getId1(key, pad + 1, id)
		}

	def getId2(key: String, pad: Int, id: Map[Int, Char]): String =
		if (id.size == 8) id.toList.sortBy(_._1).map(_._2).mkString.toLowerCase
		else {
			val hash = md5(key + pad)
			val pos = hash(5).asDigit
			if (hash.startsWith("00000") && pos < 8 && !id.contains(pos))
				getId2(key, pad + 1, id + (pos -> hash(6)))
			else getId2(key, pad + 1, id)
		}

	println(getId1(input, 0, Nil) + "\n" + getId2(input, 0, Map()))
}