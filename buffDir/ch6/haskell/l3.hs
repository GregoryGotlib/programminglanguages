-- cool: http://www.haskell.org/haskellwiki/Haskell_Tutorial_for_C_Programmers
-- http://www.haskell.org/haskellwiki/State_Monad
-- http://www.engr.mun.ca/~theo/Misc/haskell_and_monads.htm

-- ghc -o label label.hs && ./label

import Control.Monad.State

valFromState :: Int -> Int
valFromState s = -s

nextState :: Int -> Int
nextState x = 1+x
 
type Label = State Int Int
 
newLabel :: Int -> Label
newLabel i = state (\st -> (i,i)) -- why two?

incLabel :: Label
incLabel = state (\st -> let st' = nextState(st) in (valFromState(st'),st'))

getLabel :: Label -> (Int,Label)
getLabel lab = ((fst (runState lab 9)),
                (do
                        i<-get
                        put (i+1)
                        return i
                )
               )

doit :: Int -> Label -> String
doit cnt old = case cnt of
    0 -> ""
    cnt -> let
                (lab,new)=getLabel old
           in
                show lab ++ " " ++ doit (cnt-1) new

main = print (doit 5 (newLabel 0))
