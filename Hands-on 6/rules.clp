(defrule init
   ?q <- (State (state-monkey hungry) (state-chair on-chair) (state-desk on-desk) (state-banana on-banana))
   =>
   (retract ?q)
   (printout t "Starting...:" crlf)
   (printout t "  Monkey: hungry" crlf)
   (printout t "  Chair: on-floor" crlf)
   (printout t "  Desk: on-floor" crlf)
   (printout t "  Banana: on-ceiling" crlf)
   (assert (Action (action "Move chair") (obj1 "Monkey") (obj2 "Chair")))
   (assert (State (state-monkey hungry) (state-chair on-floor) (state-desk on-floor) (state-banana on-ceiling))))



(defrule chair-to-desk
   ?q <- (State (state-monkey hungry) (state-chair on-floor) (state-desk on-floor) (state-banana on-ceiling))
   =>
   (retract ?q)
   (assert (Action (action "put chair on desk") (obj1 "Monkey") (obj2 "Desk")))
   (assert (State (state-monkey hungry) (state-chair on-desk) (state-desk on-floor) (state-banana on-ceiling)))
   (printout t "Chair is on desk" crlf))

(defrule get-banana
   ?q <- (State (state-monkey hungry) (state-chair on-desk) (state-desk on-floor) (state-banana on-ceiling))
   =>
   (retract ?q)
   (assert (Action (action "get banana") (obj1 "Monkey") (obj2 "Banana")))
   (assert (State (state-monkey hungry) (state-chair on-desk) (state-desk on-floor) (state-banana with-monkey)))
   (printout t "  Monkey get babanas" crlf))

(defrule final
   ?q <- (State (state-monkey hungry) (state-chair on-desk) (state-desk on-floor) (state-banana with-monkey))
   =>
   (retract ?q)
   (assert (State (state-monkey happy) (state-chair on-desk) (state-desk on-floor) (state-banana with-monkey))))
      
(defrule m-ends
   ?q <- (State (state-monkey happy) (state-chair on-desk) (state-desk on-floor) (state-banana with-monkey))
   =>
   (printout t "state final:" crlf)
   (printout t "  Monkey: happy" crlf)
   (printout t "  Chair: on-desk" crlf)
   (printout t "  Desk: on-floor" crlf)
   (printout t "  Banana: with-monkey" crlf))
