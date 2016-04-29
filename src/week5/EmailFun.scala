package week5

object EmailFun extends App {
	case class Email(
		subject: String,
		text: String,
		sender: String,
		recipient: String)

	val mails = Email(
		subject = "It's me again, your stalker friend!",
		text = "Hello my friend! How are you?",
		sender = "johndoe@example.com",
		recipient = "me@example.com") :: Nil

	type EmailFilter = Email => Boolean

	def mailsForUser(mails: Seq[Email], f: EmailFilter) = mails filter f

	val sentByOneOf: Set[String] => EmailFilter =
		senders => email => senders contains (email sender)

	val notSentByAnyOf: Set[String] => EmailFilter =
		senders => email => !(senders contains (email sender))

	// Still a little bit of redundancy here
	val minTextSize: Int => EmailFilter =
		minSize => email => email.text.size >= minSize

	val maxTextSize: Int => EmailFilter =
		maxSize => email => email.text.size <= maxSize

	// Improving
	type SizeChecker = Int => Boolean

	val sizeConstraint: SizeChecker => EmailFilter =
		checkerFunction => email => checkerFunction(email.text.size)

	val new_minTextSize: Int => EmailFilter = minSize => sizeConstraint(_ >= minSize)
	val new_maxTextSize: Int => EmailFilter = maxSize => sizeConstraint(_ <= maxSize)

	def complement[T](predicate: T => Boolean) = (arg: T) => !predicate(arg)

	val new_notSentByAnyOf: Set[String] => EmailFilter =
		sentByOneOf andThen complement

	def any[T](predicates: (T => Boolean)*): T => Boolean =
		(arg: T) => predicates exists { _(arg) }

	def none[T](predicates: (T => Boolean)*): T => Boolean =
		complement(any(predicates: _*))

	def every[T](predicates: (T => Boolean)*): T => Boolean =
		(arg: T) => predicates forall { _(arg) }

	val filter: EmailFilter = every(
		notSentByAnyOf(Set("johndoe@example.com")),
		new_minTextSize(100),
		new_maxTextSize(10000))

	println(mailsForUser(mails, filter))

	val addMissingSubject = (email: Email) =>
		if (email.subject.isEmpty) email.copy(subject = "No subject")
		else email
	val checkSpelling = (email: Email) =>
		email.copy(text = email.text.replaceAll("your", "you're"))
	val removeInappropriateLanguage = (email: Email) =>
		email.copy(text = email.text.replaceAll("dynamic typing", "**CENSORED**"))
	val addAdvertismentToFooter = (email: Email) =>
		email.copy(text = email.text + "\nThis mail sent via Super Awesome Free Mail")

	val pipeline: Email => Email = Function.chain(Seq(
		addMissingSubject,
		checkSpelling,
		removeInappropriateLanguage,
		addAdvertismentToFooter))

}