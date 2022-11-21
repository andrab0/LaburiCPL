(*
    Laborator COOL.
*)

(*
    Exercițiul 1.

    Implementați funcția fibonacci, utilizând atât varianta recursivă,
    cât și cea iterativă.
*)
class Fibo {
    fibo_rec(n : Int) : Int {
        if n < 2 then n
        else fibo_rec(n - 1) + fibo_rec(n - 2)
        fi
    };

    fibo_iter(n : Int) : Int {
            let res : Int <- 0, 
                first : Int <- 0,
                second : Int <-1 in
                {
                    while 0 < n loop
                        {
                            first <- second;
                            second <- res;
                            res <- first + second;
                            n <- n - 1;
                        }
                pool;
                res;
            }
    };
};
    
(*
    Exercițiul 2.

    Pornind de la ierarhia de clase implementată la curs, aferentă listelor
    (găsiți clasele List și Cons mai jos), implementați următoarele funcții
    și testați-le. Este necesară definirea lor în clasa List și supradefinirea
    în clasa Cons.

    * append: întoarce o nouă listă rezultată prin concatenarea listei curente
        (self) cu lista dată ca parametru;
    * reverse: întoarce o nouă listă cu elementele în ordine inversă.
*)

(*
    Listă omogenă cu elemente de tip Int. Clasa List constituie rădăcina
    ierarhiei de clase reprezentând liste, codificând în același timp
    o listă vidă.

    Adaptare după arhiva oficială de exemple a limbajului COOL.
*)
class List inherits IO {
    isEmpty() : Bool { true };

    -- 0, deși cod mort, este necesar pentru verificarea tipurilor
    hd() : Int { { abort(); 0; } };

    -- Similar pentru self
    tl() : List { { abort(); self; } };

     -- Get the length of the list
    length() : Int { {abort(); 0;} };

    cons(h : Int) : Cons {
        new Cons.init(h, self)
    };

    print() : IO { out_string("\n") };

    append(l : List) : List {
        l
    };

   

    reverse() : List {
        self
    };

    filterBy(f : Filter): List
    {
        self
    };

    sortBy(c : Comparator) : List
    {
        self
    };

    printLen() : IO{
        out_int(0)
    };
};

(*
    În privința vizibilității, atributele sunt implicit protejate, iar metodele,
    publice.

    Atributele și metodele utilizează spații de nume diferite, motiv pentru care
    hd și tl reprezintă nume atât de atribute, cât și de metode.
*)
class Cons inherits List {
    hd : Int;
    tl : List;

    init(h : Int, t : List) : Cons {
        {
            hd <- h;
            tl <- t;
            self;
        }
    };

    -- Supradefinirea funcțiilor din clasa List
    isEmpty() : Bool { false };

    hd() : Int { hd };

    tl() : List { tl };

     -- Get the length of the list
     length() : Int { 1 + tl().length() };

    print() : IO {
        {
            out_int(hd);
            out_string(" ");
            -- Mecanismul de dynamic dispatch asigură alegerea implementării
            -- corecte a metodei print.
            tl.print();
        }
    };

    append(l : List) : List {
        if l.isEmpty() then self
        else 
        let list : List <- new List in
            list <- tl().append(l).cons(hd())
        fi
    };

    reverse() : List {
        if isEmpty() then self
        else
        let list : List <- new List in
            list <- tl().reverse().append(list.cons(hd()))
        fi
    };

    filterBy(f : Filter): List {
        if isEmpty() then self
        else
            let list: List <- new List in
                if f.filter(hd()) then
                    list <- tl().filterBy(f).cons(hd())
                else
                    list <- tl().filterBy(f)
                fi
            fi
    };

    printLen() : IO {
        {out_string("Length: ");
        out_int(length());}
    };
    -- sortBy a given comparator

    
};

class Comparator {
    compareTo(o1 : Int, o2 : Int):Int {0};
};

class IntComparator inherits Comparator {
    compareTo(o1 : Int, o2 : Int):Int {
        if o1 < o2 then 0-1
        else if o2 < o1 then 1
        else 0
        fi fi
    };
};

class Filter {
    filter(o : Int):Bool {true};
};

class LessThanFilter inherits Filter {
    -- filter(o : Int):Bool {
    --     case o of
    --         o : Int => true;
    --         o : Object => false;
    --     esac
    -- };

    filter(o : Int):Bool {
        if o < 4 then true
        else false
        fi
    };
};


class Product {
    name : String;
    model : String;
    price : Int;

    init(n : String, m: String, p : Int):SELF_TYPE {{
        name <- n;
        model <- m;
        price <- p;
        self;
    }};

    getprice():Int{ price * 119 / 100 };

    toString():String {
        "TODO: implement me"
    };
};

(*
    Exercițiul 3.

    Scopul este implementarea unor mecanisme similare funcționalelor
    map și filter din limbajele funcționale. map aplică o funcție pe fiecare
    element, iar filter reține doar elementele care satisfac o anumită condiție.
    Ambele întorc o nouă listă.

    Definiți clasele schelet Map, respectiv Filter, care vor include unica
    metodă apply, având tipul potrivit în fiecare clasă, și implementare
    de formă.

    Pentru a defini o funcție utilă, care adună 1 la fiecare element al listei,
    definiți o subclasă a lui Map, cu implementarea corectă a metodei apply.

    În final, definiți în cadrul ierarhiei List-Cons o metodă map, care primește
    un parametru de tipul Map.

    Definiți o subclasă a subclasei de mai sus, care, pe lângă funcționalitatea
    existentă, de incrementare cu 1 a fiecărui element, contorizează intern
    și numărul de elemente prelucrate. Utilizați static dispatch pentru apelarea
    metodei de incrementare, deja definită.

    Repetați pentru clasa Filter, cu o implementare la alegere a metodei apply.
*)

-- Testați în main.
class Main inherits IO {
    -- main() : Object {
    --     let list : List <- new List.cons(1).cons(2).cons(3),
    --         temp : List <- list
    --     in
    --         {
    --             -- Afișare utilizând o buclă while. Mecanismul de dynamic
    --             -- dispatch asigură alegerea implementării corecte a metodei
    --             -- isEmpty, din clasele List, respectiv Cons.
    --             while (not temp.isEmpty()) loop
    --                 {
    --                     out_int(temp.hd());
    --                     out_string(" ");
    --                     temp <- temp.tl();
    --                 }
    --             pool;

    --             out_string("\n");

    --             -- Afișare utilizând metoda din clasele pe liste.
    --             list.print();

    --             list.append(temp).print();
    --         }
    -- };

    main() :  Object {
        let list : List <-  new List.cons(1).cons(2).cons(3),

        copy : List,
        copy1 : List,
        cons1 : Cons
        in
        {

            copy <- list.append(new List.cons(5).cons(6));

            out_string("Initial list after append: ");

            list.print();

            out_string("Append [6,5] to list: ");

            copy.print();
            list.print();

            copy1 <- list.reverse();
            copy1.print();
            list.print();

            -- filter the list using lessthanfilter
            out_string("Filter the list using lessthanfilter: ");
            copy.filterBy(new LessThanFilter).print();
            out_string("sort the list using intcomparator: ");
            copy.sortBy(new IntComparator).print();
            cons1.init(1, list).print();
            
        }
        -- let list1 : List <- new List.cons(1).cons(2).cons(3).cons(4).cons(5).cons(6).cons(7).cons(8).cons(9).cons(10),
        --     list2 : List <- new List.cons(4).cons(5).cons(6) in
        --     {
        --         list1.print();
        --         out_string("\n");
        --         list2.print();
        --         out_string("\n");
        --         list1.append(list2);
        --         list1.print();
        --         list1.reverse().print();
        --     }    
    };
    
    -- fibo1 : Fibo <- new Fibo;

    -- main() : Object {
    --     {
    --         out_string("fibo rec: ");
    --         out_int(fibo1.fibo_rec(in_int()));
    --         out_string("\nfibo iter: ");
    --         out_int(fibo1.fibo_iter(in_int()));
    --         out_string("\n");
    --     }   
    -- };
};