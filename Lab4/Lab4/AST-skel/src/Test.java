import java.io.IOException;
import java.util.*;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTreeWalker;


public class Test {

    public static void main(String[] args) throws IOException {
        var input = CharStreams.fromFileName("if.txt");

        var lexer = new CPLangLexer(input);
        var tokenStream = new CommonTokenStream(lexer);

        /*
        tokenStream.fill();
        List<Token> tokens = tokenStream.getTokens();
        for (var token : tokens) {
            var text = token.getText();
            var type = CPLangLexer.VOCABULARY.getSymbolicName(token.getType());

            System.out.println(text + " : " + type);
        }
        */

        var parser = new CPLangParser(tokenStream);
        var tree = parser.expr();
        System.out.println(tree.toStringTree(parser));

        // Visitor-ul de mai jos parcurge arborele de derivare și construiește
        // un arbore de sintaxă abstractă (AST).
        var astConstructionVisitor = new CPLangParserBaseVisitor<ASTNode>() {
            @Override
            public ASTNode visitId(CPLangParser.IdContext ctx) {
                return new Id(ctx.ID().getSymbol());
            }

            @Override
            public ASTNode visitInt(CPLangParser.IntContext ctx) {
                return new Int(ctx.INT().getSymbol());
            }

            @Override
            public ASTNode visitIf(CPLangParser.IfContext ctx) {
                return new If((Expression)visit(ctx.cond),
                              (Expression)visit(ctx.thenBranch),
                              (Expression)visit(ctx.elseBranch),
                              ctx.start);
            }

            @Override
            public ASTNode visitFloat(CPLangParser.FloatContext ctx) {
                return new Float(ctx.FLOAT().getSymbol());
            }

            @Override
            public ASTNode visitBool(CPLangParser.BoolContext ctx) {
                return new Bool(ctx.BOOL().getSymbol());
            }

            @Override
            public ASTNode visitUnaryMinus(CPLangParser.UnaryMinusContext ctx) {
                return new UnaryMinus((Expression)visit(ctx.expr()), ctx.start);
            }

            @Override
            public ASTNode visitAssign(CPLangParser.AssignContext ctx) {
                return new Assign(new Id(ctx.ID().getSymbol()), (Expression)visit(ctx.expr()), ctx.start);
            }

            @Override
            public ASTNode visitPlusMinus(CPLangParser.PlusMinusContext ctx) {
                if (ctx.PLUS() != null) {
                    return new PlusMinus((Expression)visit(ctx.left), (Expression)visit(ctx.right), ctx.PLUS().getSymbol(), ctx.start);
                } else {
                    return new PlusMinus((Expression)visit(ctx.left), (Expression)visit(ctx.right), ctx.MINUS().getSymbol(), ctx.start);
                }
            }

            @Override
            public ASTNode visitMultDiv(CPLangParser.MultDivContext ctx) {
                if (ctx.MULT() != null) {
                    return new MultDiv((Expression)visit(ctx.left), (Expression)visit(ctx.right), ctx.MULT().getSymbol(), ctx.start);
                } else {
                    return new MultDiv((Expression)visit(ctx.left), (Expression)visit(ctx.right), ctx.DIV().getSymbol(), ctx.start);
                }
            }

            @Override
            public ASTNode visitRelational(CPLangParser.RelationalContext ctx) {
                if (ctx.EQUAL() != null) {
                    return new Relational((Expression)visit(ctx.left), (Expression)visit(ctx.right), ctx.EQUAL().getSymbol(), ctx.start);
                } else if (ctx.LE() != null) {
                    return new Relational((Expression)visit(ctx.left), (Expression)visit(ctx.right), ctx.LE().getSymbol(), ctx.start);
                } else
                    return new Relational((Expression)visit(ctx.left), (Expression)visit(ctx.right), ctx.LT().getSymbol(), ctx.start);
            }

            @Override
            public ASTNode visitCall(CPLangParser.CallContext ctx) {
                var args = new ArrayList<Expression>();
                for (var arg : ctx.expr()) {
                    args.add((Expression)visit(arg));
                }
                return new Call(new Id(ctx.ID().getSymbol()), args, ctx.start);
            }

            @Override
            public ASTNode visitVarDef(CPLangParser.VarDefContext ctx) {
                return new VarDef(new Id(ctx.ID().getSymbol()), (Expression)visit(ctx.expr()), ctx.start);
            }


            // TODO 3: Completati cu alte metode pentru a trece din arborele
            // generat automat in reprezentarea AST-ului dorit

        };

        // ast este AST-ul proaspăt construit pe baza arborelui de derivare.
        var ast = astConstructionVisitor.visit(tree);

        // Acest visitor parcurge AST-ul generat mai sus.
        // ATENȚIE! Avem de-a face cu două categorii de visitori:
        // (1) Cei pentru arborele de derivare, care extind
        //     CPLangParserBaseVisitor<T> și
        // (2) Cei pentru AST, care extind ASTVisitor<T>.
        // Aveți grijă să nu îi confundați!
        var printVisitor = new ASTVisitor<Void>() {
            int indent = 0;

            @Override
            public Void visit(Id id) {
                printIndent("ID " + id.token.getText());
                return null;
            }

            @Override
            public Void visit(Int intt) {
                printIndent("INT " + intt.token.getText());
                return null;
            }

            @Override
            public Void visit(If iff) {
                printIndent("IF");
                indent++;
                iff.cond.accept(this);
                iff.thenBranch.accept(this);
                iff.elseBranch.accept(this);
                indent--;
                return null;
            }

            @Override
            public Void visit(Float floatt) {
                printIndent("FLOAT " + floatt.token.getText());
                return null;
            }

            @Override
            public Void visit(Bool booll){
                printIndent("BOOL " + booll.token.getText());
                        return null;
            }

            @Override
            public Void visit(UnaryMinus unaryMinus) {
                printIndent("- ");
                indent++;
                unaryMinus.expr.accept(this);
                indent--;
                return null;
            }

            @Override
            public Void visit(Assign assign) {
                printIndent("ASSIGN");
                indent++;
                assign.id.accept(this);
                assign.expr.accept(this);
                indent--;
                return null;
            }
            @Override
            public Void visit(PlusMinus plusMinus) {
                if (plusMinus.op.getText().equals("+")) {
                    printIndent("+ ");
                } else {
                    printIndent("- ");
                }
                indent++;
                plusMinus.left.accept(this);
                plusMinus.right.accept(this);
                indent--;
                return null;
            }

            @Override
            public Void visit(MultDiv multDiv) {
                if (multDiv.op.getText().equals("*")) {
                    printIndent("* ");
                } else {
                    printIndent("/ ");
                }
                indent++;
                multDiv.left.accept(this);
                multDiv.right.accept(this);
                indent--;
                return null;
            }

            @Override
            public Void visit(Relational rell) {
                printIndent(rell.op.getText());
                indent++;
                rell.left.accept(this);
                rell.right.accept(this);
                indent--;
                return null;
            }

            @Override
            public Void visit(Call call) {
                printIndent("CALL " + call.id.token.getText());
                indent++;
                for (var arg : call.args) {
                    arg.accept(this);
                }
                indent--;
                return null;
            }

            @Override
            public Void visit(VarDef varDef) {
                printIndent("VARDEF " + varDef.id.token.getText());
                indent++;
                varDef.expr.accept(this);
                indent--;
                return null;
            }
            // TODO 4: Afisati fiecare nod astfel incat nivelul pe care acesta
            // se afla in AST sa fie reprezentat de numarul de tab-uri.
            // Folositi functia de mai jos 'printIndent' si incrementati /
            // decrementati corespunzator numarul de tab-uri

            void printIndent(String str) {
                for (int i = 0; i < indent; i++)
                    System.out.print("\t");
                System.out.println(str);
            }
        };

        // TODO 5: Creati un program CPLang care sa cuprinda cat mai multe
        // constructii definite in laboratorul de astazi. Scrieti codul CPLang
        // intr-un fisier txt si modificati fisierul de input de la inceputul
        // metodei 'main'	

        System.out.println("The AST is");
        ast.accept(printVisitor);
    }


}
