import org.antlr.v4.runtime.Token;
import java.util.*;

// Rădăcina ierarhiei de clase reprezentând nodurile arborelui de sintaxă
// abstractă (AST). Singura metodă permite primirea unui visitor.
public abstract class ASTNode {
    // Reținem un token descriptiv, pentru a putea afișa ulterior
    // informații legate de linia și coloana eventualelor erori semantice.
    Token token;

    ASTNode(Token token) {
        this.token = token;
    }

    public <T> T accept(ASTVisitor<T> visitor) {
        return null;
    }
}

// Orice expresie.
abstract class Expression extends ASTNode {
    Expression(Token token) {
        super(token);
    }
}

abstract class Definition extends ASTNode{
    Definition(Token token) {
        super(token);
    }
}

// Identificatori
class Id extends Expression {
    Id(Token token) {
        super(token);
    }

    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

// Literali întregi
class Int extends Expression {
    Int(Token token) {
        super(token);
    }

    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

// Construcția if.
class If extends Expression {
    // Sunt necesare trei câmpuri pentru cele trei componente ale expresiei.
    Expression cond;
    Expression thenBranch;
    Expression elseBranch;

    If(Expression cond,
       Expression thenBranch,
       Expression elseBranch,
       Token start) {
        super(start);
        this.cond = cond;
        this.thenBranch = thenBranch;
        this.elseBranch = elseBranch;
    }

    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

class Float extends Expression {
    Float(Token token) {
        super(token);
    }

    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

class Bool extends Expression {
    Bool(Token token) {
        super(token);
    }

    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

class UnaryMinus extends Expression {
    Expression expr;

    UnaryMinus(Expression expr, Token start) {
        super(start);
        this.expr = expr;
    }

    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

class Assign extends Expression {
    Id id;
    Expression expr;

    Assign(Id id, Expression expr, Token start) {
        super(start);
        this.id = id;
        this.expr = expr;
    }

    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

class PlusMinus extends Expression {
    Expression left;
    Expression right;
    Token op;

    PlusMinus(Expression left, Expression right, Token op, Token start) {
        super(start);
        this.left = left;
        this.right = right;
        this.op = op;
    }

    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

class MultDiv extends Expression {
    Expression left;
    Expression right;
    Token op;

    MultDiv(Expression left, Expression right, Token op, Token start) {
        super(start);
        this.left = left;
        this.right = right;
        this.op = op;
    }

    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

class Call extends Expression {
    Id id;
    List<Expression> args;

    Call(Id id, List<Expression> args, Token start) {
        super(start);
        this.id = id;
        this.args = args;
    }

    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

class Relational extends Expression {
    Expression left;
    Expression right;
    Token op;

    Relational(Expression left, Expression right, Token op, Token start) {
        super(start);
        this.left = left;
        this.right = right;
        this.op = op;
    }

    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

class VarDef extends Definition{
    Id id;
    Expression expr;

    VarDef(Id id, Expression expr, Token start) {
        super(start);
        this.id = id;
        this.expr = expr;
    }

    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}


// TODO 1: Definiți restul claselor de care ați avea nevoie. Asigurați-vă
// că moșteniți mereu nodul de bază ASTNode
