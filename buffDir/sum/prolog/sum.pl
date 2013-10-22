% Prolog sum program

sum(0, []).
sum(S, [H | T]) :- sum(R, T), S is H+R.

main :- sum(S, [5, 6, 1, 8, 3, 7]), write(S), nl, halt.

:- initialization(main).
