(defrule start
    (block A on table)
    (block B on table)
    (block C on table)
    (block D on table)
    ?s <- (robotic-arm holding empty)
    =>
    (retract ?s)
    (printout t "Robotic-arm is empty and the blocks are on the table" crlf))

(defrule pickUp-A
    ?a <- (block A on table)
    =>
    (retract ?a)
    (assert (robotic-arm holding A))
    (printout t "Robotic arm pick up block A." crlf))

(defrule move-A
    (robotic-arm holding A)
    ?s <- (robotic-arm onMove no)
    =>
    (retract ?s)
    (assert (robotic-arm onMove yes))
    (printout t "Robotic arm is moving block A." crlf))

(defrule putDown-A
    ?a <- (robotic-arm holding A)
    (robotic-arm onMove yes)
    =>
    (retract ?a)
    (assert (block A on B))
    (assert (robotic-arm holding empty))
    (printout t "Robotic arm leaves the A on B." crlf))

(defrule pickUp-B
    ?b <- (block B on table)
    =>
    (retract ?b)
    (assert (robotic-arm holding B))
    (printout t "Robotic arm pick up block B." crlf))

(defrule move-B
    (robotic-arm holding B)
    ?s <- (robotic-arm onMove no)
    =>
    (retract ?s)
    (assert (robotic-arm onMove yes))
    (printout t "Robotic arm is moving block B" crlf))

(defrule putDown-B
    ?b <- (robotic-arm holding B)
    (robotic-arm onMove yes)
    =>
    (retract ?b)
    (assert (block B on C))
    (assert (robotic-arm holding empty))
    (printout t "Robotic arm leaves the block B on C." crlf))

(defrule pickUp-C  
    ?c <- (block C on table)
    =>
    (retract ?c)
    (assert (robotic-arm holding C))
    (printout t "Robotic arm pick up block C." crlf))

(defrule move-C
    (robotic-arm holding C)
    =>
    (assert (robotic-arm onMove yes))
    (printout t "Robotic arm is moving block C." crlf))

(defrule putDown-C
    ?s <- (robotic-arm holding C)
    (robotic-arm onMove yes)
    =>
    (retract ?s)
    (assert (block C on D))
    (assert (robotic-arm holding empty))
    (printout t "Robotic arm leaves the block C on D." crlf))

(defrule move
    ?s <- (robotic-arm holding empty)
    =>
    (assert (robotic-arm onMove no))
    (retract ?s)
    (printout t "Robotic arm is moving original position." crlf))

(defrule final
    (block A on B)
    (block B on C)
    (block C on D)
    ?s <- (robotic-arm onMove yes)
    =>
    (retract ?s)
    (printout t "The blocks are sorted!" crlf))
