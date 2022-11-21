public interface ASTVisitor<T> {
    T visit(Id id);
    T visit(Int intt);
    T visit(If iff);
    T visit(Float floatt);
    T visit(Bool bool);
    T visit(UnaryMinus unaryMinus);
    T visit(Assign assign);
    T visit(PlusMinus plusMinus);
    T visit(MultDiv multDiv);
    T visit(Call calll);
    T visit(Relational rell);
    T visit(VarDef vardef);

    // TODO 2: Adăugați metode pentru fiecare clasă definită anterior
}
