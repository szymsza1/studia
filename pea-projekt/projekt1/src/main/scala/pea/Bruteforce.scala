package pea

object Bruteforce extends Alg with Common {
    def apply(tasks: TaskList) = permutations(tasks.list) map TaskList min

    def permutations[A](list: List[A]): List[List[A]] = list match {
        case Nil => List(Nil)
        case xs => for {
            (y,ys) <- selections(xs)
            ps <- permutations(ys)
        } yield y :: ps
    }
}
