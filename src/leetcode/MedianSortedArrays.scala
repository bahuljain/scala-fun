package leetcode

object MedianSortedArrays extends App {
	val arr1 = Array(1, 3, 5, 7, 9, 11, 13)
	val arr2 = Array(2, 4, 6, 8, 10, 12)

	def median(arr1: Array[Int]) = {
		val l = arr1.length
		if (l == 0) -1.0
		else if (l % 2 == 0) (arr1(l / 2) + arr1(l / 2 - 1)) / 2.0
		else arr1(l / 2)
	}

	//	I hope this is correct
	def median2(A: Array[Int], B: Array[Int]): Double = (A.length, B.length) match {
		// the smaller array has to remain on the left
		case (x, y) if x > y => median2(B, A)
		// henceforth A -> smaller array and B -> larger array

		// if A is empty then return median of B
		case (0, _) => median(B)

		// if both arrays have single elements then return average of the two.
		case (1, 1) => (A(0) + B(0)) / 2.0

		// A has 1 element and B has even number of elements, then return median of A[0] and middle
		// 3 elements of B.
		case (1, x) if x % 2 == 0 => median(Array(A(0), B(x / 2), B(x / 2 - 1)) sorted)

		// A has 1 element and B has odd number of elements
		case (1, x) => median((A ++ B.slice(x / 2 - 1, x / 2 + 2)) sorted)

		case (2, 2) => median((A ++ B) sorted)

		// A has 1 element and B has even number of elements.
		case (2, x) if x % 2 == 0 =>
			median(Array(B(x / 2), B(x / 2 - 1), A(0) max B(x / 2 - 2), A(1) min B(x / 2 + 1)) sorted)

		// A has 1 element and B has odd number of elements
		case (2, x) =>
			median(Array(B(x / 2), A(0) max B(x / 2 - 1), A(1) min B(x / 2 + 1)) sorted)

		// A has more than 2 elements
		case _ => {
			// find the median of the two arrays
			val (m1, m2) = (median(A), median(B))

			// return one of them if they are the same
			if (m1 == m2) m1

			// if m1 > m2 then mean lies to the left of m1 in A or to the right of m2 in B
			else if (m1 > m2)
				median2(A takeWhile { _ <= m1 }, B dropWhile { _ < m2 })

			// if m1 < m2 then mean lies to the right of m1 in A or to the left of m2 in B
			else
				median2(A dropWhile { _ < m1 }, B takeWhile { _ <= m2 })
		}
	}
	println(median2(arr1, arr2))
}