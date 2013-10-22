-- ghc -o l1 l1.hs && ./l1

import Control.Monad.State
 
test1 = do
            modify (+1)
            modify (+1)
            b <- get
            return b

x=evalState test1

main = do
    print (x 0)
    print (x 0)

